package herencia;

public class Empleado extends Trabajador{
	
	//ATRIBUTOS
	private double sueldo;
	private double impuestos;
	
	private final int PAGAS = 14;

	//CONSTRUCTORES
	public Empleado(String nombre, String puesto, String direccion, String teléfono, String nSS, double sueldo, double impuestos) {
		super(nombre, puesto, direccion, teléfono, nSS);
		this.sueldo = sueldo;
		this.impuestos = impuestos;
	}

	//GETTERS Y SETTERS
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	//FUNCIONES
	public double calcularPaga() {
		return (sueldo - impuestos) / PAGAS;
	}

	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", impuestos=" + impuestos + ", getNombre()=" + getNombre()
				+ ", getPuesto()=" + getPuesto() + ", getDireccion()=" + getDireccion() + ", getTeléfono()="
				+ getTeléfono() + ", getnSS()=" + getnSS() + "]";
	}
	
	

}
