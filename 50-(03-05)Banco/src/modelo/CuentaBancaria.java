package modelo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.CuentaBancariaException;

public class CuentaBancaria implements Comparable<CuentaBancaria>{

//ATRIBUTOS
	private String numCuenta; //Clave principal
	private String dni;
	private String titular;
	private double saldo;
	private LocalDate fechaAlta;
	private boolean bloqueada;

//CONSTRUCTORES
	//VACIO
	public CuentaBancaria() {
		// TODO Auto-generated constructor stub
	}
	
	//COMPLETO
	public CuentaBancaria(String numCuenta, String dni, String titular, String saldo, String fechaAlta, String bloqueada) throws CuentaBancariaException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setNumCuenta(numCuenta);
		setDni(dni);
		setTitular(titular);
		setSaldo(saldo);
		setFechaAlta(fechaAlta);
		setBloqueada(bloqueada);
	}
	
	//SIN BLOQUEAR
	public CuentaBancaria(String numCuenta, String dni, String titular, String saldo, String fechaAlta) throws CuentaBancariaException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setNumCuenta(numCuenta);
		setDni(dni);
		setTitular(titular);
		setSaldo(saldo);
		setFechaAlta(fechaAlta);
		this.bloqueada = false;
	}

	//SIN DAR DE ALTA
	public CuentaBancaria(String numCuenta, String dni, String titular, String saldo) throws CuentaBancariaException, CamposVaciosException, NumberFormatException {
		super();
		setNumCuenta(numCuenta);
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
		numCuenta = numCuenta.replace(" ", "");
		if(!compruebaCuentaBancaria(numCuenta)) {
			throw new CuentaBancariaException();
		}else {
			this.numCuenta = numCuenta;
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
		if(dni.equals("")) {
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
		this.fechaAlta = LocalDate.parse(fechaAlta);
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public void setBloqueada(String bloqueada) {
		this.bloqueada = Boolean.parseBoolean(bloqueada);
	}

//FUNCIONES
	public static boolean compruebaCuentaBancaria(String numCuenta) {
		try {
			String eeeeSSSS = numCuenta.substring(0,8);
			int d = Integer.parseInt(numCuenta.substring(8,9));
			int c = Integer.parseInt(numCuenta.substring(9,10));
			String numeros = numCuenta.substring(10,20);
			
			eeeeSSSS = "00" + eeeeSSSS;
			int[] multiplicador = {1,2,4,8,5,10,9,7,3,6};
			
			int acuD = 0, acuC = 0;
			for(int x = 0; x < multiplicador.length; x++) {
				acuD += ((multiplicador[x]) * (Integer.parseInt(Character.toString(eeeeSSSS.charAt(x)))));
				acuC += ((multiplicador[x]) * (Integer.parseInt(Character.toString(numeros.charAt(x)))));
			}
			acuD = 11-(acuD%11);
			if(acuD == 10) {acuD = 1;}else if(acuD == 11) {acuD = 0;}
			if(d != acuD) {
				return false;
			}
			
			acuC = 11-(acuC%11);
			if(acuC == 10) {acuC = 1;}else if(acuC == 11) {acuC = 0;}
			if(c != acuC) {
				return false;
			}
			return true;
		} catch (StringIndexOutOfBoundsException e) {
			return false;
		}
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

//COMPARABLE
	@Override
	public int compareTo(CuentaBancaria o) {
		return Double.compare(getSaldo(), o.getSaldo());
	}
	
	
	
	

}
