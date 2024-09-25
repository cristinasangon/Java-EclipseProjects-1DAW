package herencia;

public class Trabajador {

	//ATRIBUTOS
	private String nombre;
	private String puesto;
	private String direccion;
	private String teléfono;
	private String nSS; //Numero de la Seguridad Social
	
	private static final double SALARIO_BASE = 30000.0;
	
	//CONSTRUCTORES
	public Trabajador(String nombre, String puesto, String direccion, String teléfono, String nSS) {
		this.nombre = nombre;
		this.puesto = puesto;
		this.direccion = direccion;
		this.teléfono = teléfono;
		this.nSS = nSS;
	}

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public String getnSS() {
		return nSS;
	}

	public void setnSS(String nSS) {
		this.nSS = nSS;
	}
	
	//FUNCIONES
	public double calcularPaga() {
		return SALARIO_BASE;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", puesto=" + puesto + ", direccion=" + direccion + ", teléfono="
				+ teléfono + ", nSS=" + nSS + "]";
	}
}
