package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.CuentaBancariaException;

public class CuentaBancaria implements Comparable<CuentaBancaria>{
	
//ATRIBUTOS
	private String numCuenta;
	private String dni;
	private String titular;
	private double saldo;
	private LocalDate fechaAlta;
	private boolean bloqueada;
	
//CONSTRUCTORES
	public CuentaBancaria() {
		this.numCuenta = "Desconocido";
		this.dni = "Desconocido";
		this.titular = "Desconocido";
		this.saldo = 0;
		this.fechaAlta = null;
		this.bloqueada = false;
	}

	public CuentaBancaria(String numCuenta, String dni, String titular, String saldo, String fechaAlta, String bloqueada) throws CuentaBancariaException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setNumCuenta(numCuenta);
		setDni(dni);
		setTitular(titular);
		setSaldo(saldo);
		setFechaAlta(fechaAlta);
		setBloqueada(bloqueada);
	}

	public CuentaBancaria(String numCuenta, String dni, String titular, String saldo) throws CuentaBancariaException, CamposVaciosException, NumberFormatException {
		super();
		setNumCuenta(numCuenta);
		setDni(dni);
		setTitular(titular);
		setSaldo(saldo);
		this.fechaAlta = LocalDate.now();
		this.bloqueada = false;
	}

//GETTERS Y SETTERS
	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) throws CuentaBancariaException {
		if(compruebaCuentaBancaria(numCuenta)) {
			this.numCuenta = numCuenta;
		}else {
			throw new CuentaBancariaException();
		}
	}
		

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws CamposVaciosException {
		if(dni.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.dni = dni;
		}
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) throws CamposVaciosException {
		if(titular.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.titular = titular;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) throws NumberFormatException{
		this.saldo = Double.parseDouble(saldo);
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) throws DateTimeParseException{
		if(fechaAlta.equals("null")) {
			this.fechaAlta = null;
		}else {
			this.fechaAlta = LocalDate.parse(fechaAlta);
		}
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public void setBloqueada(String bloqueada) {
		this.bloqueada = Boolean.parseBoolean(bloqueada);
	}

//EQUALS Y HASCODE
	@Override
	public int hashCode() {
		return Objects.hash(numCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(numCuenta, other.numCuenta);
	}

//TO STRING
	@Override
	public String toString() {
		return numCuenta + ";" + dni + ";" + titular + ";" + saldo + ";" + fechaAlta + ";" + bloqueada;
	}
	
//FUNCIONES
	public static boolean compruebaCuentaBancaria(String numCuenta) {
		try {
			String eeeeSSSS = numCuenta.substring(0,8);
			eeeeSSSS = "00" + eeeeSSSS;
			String dc = numCuenta.substring(8,10);
			String numeros  = numCuenta.substring(10,20);
			
			int[] multiplicador = {1,2,4,8,5,10,9,7,3,6};
			int d = 0, c = 0;
			for(int x = 0; x < multiplicador.length; x++) {
				d += (Integer.parseInt(Character.toString(eeeeSSSS.charAt(x))) * multiplicador[x]);
				c += (Integer.parseInt(Character.toString(numeros.charAt(x))) * multiplicador[x]);
			}
			
			d = 11 - (d % 11);
			c = 11 - (c % 11);
			
			if(d == 10) {
				d = 1;
			}else if(d == 11) {
				d = 0;
			}
			
			if(c == 10) {
				c = 1;
			}else if(c == 11) {
				c = 0;
			}
			
			if(d == (Integer.parseInt(Character.toString(dc.charAt(0)))) && c == (Integer.parseInt(Character.toString(dc.charAt(1)))) ) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

//COMPARABLE
	@Override
	public int compareTo(CuentaBancaria o) {
		return Double.compare(getSaldo(), o.getSaldo());
	}
	
	

}
