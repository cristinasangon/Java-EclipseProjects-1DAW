package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.DniException;

public class Paciente implements Comparable<Paciente>{

//ATRIBUTOS TODO 
	private String dni; //Clave principal
	private String nombre;
	private int edad;
	private String enfermedad;
	private LocalDate fechaIngreso;
	private LocalDate fechaAlta;
	private boolean grave;
	
//CONSTRUCTORES TODO 
	public Paciente() {
		
	}

	public Paciente(String dni, String nombre, String edad, String enfermedad, String fechaIngreso, String fechaAlta, String grave) throws DniException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setDni(dni);
		setNombre(nombre);
		setEdad(edad);
		setEnfermedad(enfermedad);
		setFechaIngreso(fechaIngreso);
		setFechaAlta(fechaAlta);
		setGrave(grave);
	}

	public Paciente(String dni, String nombre, String edad, String enfermedad) throws DniException, CamposVaciosException, NumberFormatException{
		super();
		setDni(dni);
		setNombre(nombre);
		setEdad(edad);
		setEnfermedad(enfermedad);
		this.fechaIngreso = LocalDate.now();
		this.fechaAlta = null;
		this.grave = false;
	}

//GETTERS Y SETTERS TODO 
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws DniException{
		if(compruebaDni(dni)) {
			this.dni = dni;
		}else {
			throw new DniException();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CamposVaciosException {
		if(nombre.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.nombre = nombre;	
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(String edad) throws NumberFormatException{
		this.edad = Integer.parseInt(edad);;	
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) throws CamposVaciosException {
		if(enfermedad.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.enfermedad = enfermedad;	
		}
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) throws DateTimeParseException{
		if(fechaIngreso.equals("null")) {
			this.fechaIngreso = null;
		}else{
			this.fechaIngreso = LocalDate.parse(fechaIngreso);	
		}
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) throws DateTimeParseException{
		if(fechaAlta.equals("null")) {
			this.fechaAlta = null;
		}else{
			this.fechaAlta = LocalDate.parse(fechaAlta);
		}
	}

	public boolean isGrave() {
		return grave;
	}

	public void setGrave(String grave) {
		this.grave = Boolean.parseBoolean(grave);
	}
	
//FUNCIONES
	public static boolean compruebaDni(String dni) {
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		try {
			int resto = Integer.parseInt(dni.substring(0,8));
			resto %= 23;
			if(letras[resto].equals(dni.substring(dni.length() - 1))) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

//TO STRING
	@Override
	public String toString() {
		return dni + "," + nombre + "," + edad + "," + enfermedad + "," + fechaIngreso + "," + fechaAlta + "," + grave;
	}

//EQUALS Y HASCODE
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni);
	}

//COMPARABLE
	@Override
	public int compareTo(Paciente o) {
		return getNombre().compareTo(o.getNombre());
	}
	
	
	

}
