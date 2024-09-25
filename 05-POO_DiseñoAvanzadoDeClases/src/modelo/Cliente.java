package modelo;

public class Cliente {

	//ATRIBUTOS
	private int numero;
	private String nombre;
	
	private static int cantClientes = 0;
	
	//CONSTRUCTORES
	public Cliente(String nombre) {
		this.nombre = nombre;
		this.numero = ++cantClientes;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Cliente [numero=" + numero + ", nombre=" + nombre + "]";
	}
}
