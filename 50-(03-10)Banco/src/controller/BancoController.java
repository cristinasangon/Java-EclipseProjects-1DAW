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
import excepciones.SaldoInsuficienteException;
import interfaces.comparaFechas;
import modelo.CuentaBancaria;

public class BancoController {

	List<CuentaBancaria> cuentas;
	
	public BancoController() throws IOException, NumberFormatException, DateTimeParseException, CuentaBancariaException, CamposVaciosException {
		File fichero = new File("banco.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		cuentas = new ArrayList<CuentaBancaria>();
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
			
			cuentas.add(cuenta);
		}
		br.close();fr.close();
	}

	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}
	
	public CuentaBancaria buscarCuentaBancaria(String numCuenta) {
		CuentaBancaria cuenta = null;
		for(CuentaBancaria cuentaX: cuentas) {
			if(cuentaX.getNumCuenta().equals(numCuenta)) {
				cuenta = cuentaX;
			}
		}
		return cuenta;
	}
	
	public List<CuentaBancaria> mostrarCuentas(){
		List<CuentaBancaria> todasCuentas = new ArrayList<CuentaBancaria>(cuentas);
		Collections.sort(todasCuentas, new comparaFechas());
		return todasCuentas;
	}
	
	public boolean agregarCuenta(String numCuenta,String dni, String titular, String saldo) throws NumberFormatException, CuentaBancariaException, CamposVaciosException {
		CuentaBancaria cuenta = new CuentaBancaria(numCuenta, dni, titular, saldo);
		if(buscarCuentaBancaria(numCuenta) != null) {
			return false;
		}
		cuentas.add(cuenta);
		return true;
	}

	public List<CuentaBancaria> mostrarCuentasCliente(String dni){
		List<CuentaBancaria> cuentasCliente = new ArrayList<CuentaBancaria>();
		for(CuentaBancaria cuenta: cuentas) {
			if(cuenta.getDni().equals(dni)) {
				cuentasCliente.add(cuenta);
			}
		}
		return cuentasCliente;
	}
	
	public boolean ingresarRetirarDinero(String numCuenta, double cantidad) throws SaldoInsuficienteException {
		CuentaBancaria cuenta = buscarCuentaBancaria(numCuenta);
		if(cuenta == null) {
			return false;
		}
		double cantRestante = cuenta.getSaldo() + cantidad;
		if(cantRestante < 0) {
			throw new SaldoInsuficienteException();
		}
		cuenta.setSaldo(Double.toString(cantRestante));
		return true;
	}
	
	public boolean boquearCuenta(String numCuenta) {
		CuentaBancaria cuenta = buscarCuentaBancaria(numCuenta);
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
		int cont = 0;
		List<CuentaBancaria> cuentasCliente = mostrarCuentasCliente(dni);
		for(CuentaBancaria cuenta: cuentasCliente) {
			if(cuenta.isBloqueada()) {
				cuentas.remove(cuenta);
				cont++;
			}
		}
		return cont;
	}
	
	public boolean salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("banco.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(CuentaBancaria cuenta: cuentas) {
			bw.write(cuenta.toString());
			bw.newLine();
		}
		fw.flush();bw.close();fw.close();
		return true;
	}
}
