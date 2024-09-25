package herencia;

public class Consultor extends Trabajador{

	//ATRIBUTOS
	private int horas;
	private double tarifa;
	
	//CONSTRUCTORES
	public Consultor(String nombre, String puesto, String direccion, String teléfono, String nSS, int horas, double tarifa) {
		super(nombre, puesto, direccion, teléfono, nSS);
		this.horas = horas;
		this.tarifa = tarifa;
	}

	//GETTERS Y SETTERS
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	//FUNCIONES
	public double calcularPaga() {
		return horas*tarifa;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Consultor [horas=" + horas + ", tarifa=" + tarifa + ", getNombre()=" + getNombre() + ", getPuesto()="
				+ getPuesto() + ", getDireccion()=" + getDireccion() + ", getTeléfono()=" + getTeléfono()
				+ ", getnSS()=" + getnSS() + "]";
	}
	
	
	
	

}
