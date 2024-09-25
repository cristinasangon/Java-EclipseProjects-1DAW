package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.DniException;
import interfaces.ComparaEnfermedad;
import interfaces.comparaFechas;
import modelo.Paciente;

public class HospitalCotroller {
	List<Paciente> pacientes;
	
	public HospitalCotroller() throws IOException, NumberFormatException, DateTimeParseException, DniException, CamposVaciosException {
		pacientes = new ArrayList<Paciente>();
		
		File fichero = new File("hospital.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		while((linea = br.readLine()) != null) {
			String[] lineaSeparada = linea.split(",");
			
			String dni = lineaSeparada[0];
			String nombre = lineaSeparada[1];
			String edad = lineaSeparada[2];
			String enfermedad = lineaSeparada[3];
			String fechaIngreso = lineaSeparada[4];
			String fechaAlta = lineaSeparada[5];
			String grave = lineaSeparada[6];
			
			Paciente paciente = new Paciente(dni, nombre, edad, enfermedad, fechaIngreso, fechaAlta, grave);
			pacientes.add(paciente);
		}
		br.close();fr.close();
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Paciente buscarPaciente(String dni) {
		Paciente paciente = null;
		for(Paciente pacienteX: pacientes) {
			if(pacienteX.getDni().equals(dni)) {
				paciente = pacienteX;
			}
		}
		return paciente;
	}
	
	public List<Paciente> mostrarPacientes(){
		List<Paciente> pacientesOrdenados = getPacientes();
		Collections.sort(pacientesOrdenados, new comparaFechas());
		return pacientesOrdenados;
	}
	
	public boolean ingresarNuevoPaciente(String dni, String nombre, String edad, String enfermedad) throws NumberFormatException, DniException, CamposVaciosException {
		Paciente paciente = new Paciente(dni, nombre, edad, enfermedad);
		if(buscarPaciente(dni) != null) {
			return false;
		}
		pacientes.add(paciente);
		return true;
	}
	
	public List<Paciente> mostrarPacientesPorEnfermedad(String enfermedad){
		List<Paciente> pacientesOrdenados = new ArrayList<Paciente>();
		for(Paciente paciente: pacientes) {
			if(paciente.getEnfermedad().equals(enfermedad)) {
				pacientesOrdenados.add(paciente);
			}
		}
		Collections.sort(pacientesOrdenados);
		return pacientesOrdenados;
	}
	
	public List<Paciente> mostrarPacientesGraves(){
		List<Paciente> pacientesOrdenados = new ArrayList<Paciente>();
		for(Paciente paciente: pacientes) {
			if(paciente.isGrave()) {
				pacientesOrdenados.add(paciente);
			}
		}
		Collections.sort(pacientesOrdenados, new ComparaEnfermedad());
		return pacientesOrdenados;
	}
	
	public boolean asignarPacienteGrave(String dni) {
		Paciente paciente = buscarPaciente(dni);
		if(paciente == null) {
			return false;
		}
		if(paciente.isGrave()) {
			return false;
		}
		paciente.setGrave("true");
		return true;
	}
	
	public boolean darAltaPaciente(String dni) {
		Paciente paciente = buscarPaciente(dni);
		if(paciente == null) {
			return false;
		}
		if(paciente.getFechaAlta() != null) {
			return false;
		}
		
		LocalDate ahora = LocalDate.now();
		String fechaAlta = ahora.toString();
		paciente.setFechaAlta(fechaAlta);
		return true;
	}
	
	public int eliminarPacientesDadosAlta() {
		List<Paciente> pacientesTemporal = new ArrayList<>(getPacientes());
		int cont = 0;
		for(Paciente paciente: pacientesTemporal) {
			if(paciente.getFechaAlta() != null) {
				pacientes.remove(paciente);
				cont++;
			}
		}
		return cont;
		
	}

	public boolean salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("hospital.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Paciente paciente: pacientes) {
			bw.write(paciente.toString());
			bw.newLine();
		}
		
		fw.flush();bw.flush();fw.flush();
		return true;
	}

}
