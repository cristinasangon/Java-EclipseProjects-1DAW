package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.CuentaBancariaException;
import excepciones.saldoInsuficienteException;
import interfaces.ComparaFechas;
import modelo.CuentaBancaria;

public class BancoController {

	ArrayList<CuentaBancaria> banco;
	
	public BancoController() throws IOException, NumberFormatException, DateTimeParseException, CuentaBancariaException, CamposVaciosException {
		banco = new ArrayList<CuentaBancaria>();
		
		File fichero = new File("banco.txt");
		if(!fichero.exists()){
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		while((linea = br.readLine()) != null) {
			String[] lineaArray = linea.split(";");
			
			String numCuenta = lineaArray[0];
			String dni = lineaArray[1];
			String titular = lineaArray[2];
			String saldo = lineaArray[3];
			String fechaAlta = lineaArray[4];
			String bloqueada = lineaArray[5];
			
			CuentaBancaria cuenta = new CuentaBancaria(numCuenta, dni, titular, saldo, fechaAlta, bloqueada);
			banco.add(cuenta);
		}
		br.close(); fr.close();
	}

	public ArrayList<CuentaBancaria> getBanco() {
		return banco;
	}

	public void setBanco(ArrayList<CuentaBancaria> banco) {
		this.banco = banco;
	}
	
	public CuentaBancaria buscarCuentaPorNumCuenta(String numCuenta) {
		CuentaBancaria cuenta = null;
		for(CuentaBancaria cuentaX: banco) {
			if(cuentaX.getNumCuenta().equals(numCuenta)) {
				cuenta = cuentaX;
			}
		}
		return cuenta;
	}
	
	public List<CuentaBancaria> ordenarCuentasPorFecha(){
		List<CuentaBancaria> cuentasOrdenadas = banco;
		Collections.sort(cuentasOrdenadas, new ComparaFechas());
		
		return cuentasOrdenadas;
	}
	
	public boolean agregarNuevaCuenta(String numCuenta, String dni, String titular, String saldo) throws NumberFormatException, CuentaBancariaException, CamposVaciosException {
		if(buscarCuentaPorNumCuenta(numCuenta) == null) {
			CuentaBancaria cuenta = new CuentaBancaria(numCuenta, dni, titular, saldo);
			banco.add(cuenta);
			return true;
		}
		return false;
	}
	
	public List<CuentaBancaria> filtrarCuentasPorCliente (String dni){
		List<CuentaBancaria> cuentasFiltradas = new ArrayList<CuentaBancaria>();
		for(CuentaBancaria cuenta: banco) {
			if(dni.equals(cuenta.getDni())) {
				cuentasFiltradas.add(cuenta);
			}
		}
		Collections.sort(cuentasFiltradas);
		return cuentasFiltradas;
	}
	
	public boolean ingresarRetirarDinero (String numCuenta, double cantidad) throws saldoInsuficienteException{
		CuentaBancaria cuenta = buscarCuentaPorNumCuenta(numCuenta);
		if(cuenta == null) {
			return false;
		}
		
		double saldoRestante = cuenta.getSaldo() + cantidad;
		if(saldoRestante >= 0) {
			cuenta.setSaldo(Double.toString(saldoRestante));
			return true;
		}else {
			throw new saldoInsuficienteException();
		}
	}
	
	public boolean bloquearCuenta(String numCuenta) {
		CuentaBancaria cuenta = buscarCuentaPorNumCuenta(numCuenta);
		if(cuenta == null) {
			return false;
		}
		
		if(cuenta.isBloqueada()) {
			return false;
		}
		
		cuenta.setBloqueada("true");
		return true;
	}
	
	public int eliminarCuentasBloqueadasCliente(String dni) {
		List<CuentaBancaria> cuentasCliente = filtrarCuentasPorCliente(dni);
		int cantidadEliminada = 0;
		
		for(CuentaBancaria cuenta: cuentasCliente) {
			if(cuenta.isBloqueada()) {
				banco.remove(cuenta);
				cantidadEliminada++;
			}
		}
		return cantidadEliminada;
	}
	
	public boolean salvarDatos() throws IOException {
		boolean salvado = false;
		
		FileWriter fw = new FileWriter("banco.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(CuentaBancaria cuenta: banco) {
			bw.write(cuenta.toString());
			bw.newLine();
		}
		
		fw.flush(); bw.close(); fw.close();
		salvado = true;
		return salvado;
	}

}
