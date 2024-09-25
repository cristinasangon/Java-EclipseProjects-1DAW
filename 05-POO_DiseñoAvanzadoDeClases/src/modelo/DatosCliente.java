package modelo;

public class DatosCliente {

	//ATRIBUTOS
	Cliente cliente;
	long entrada, salida;
	
	public DatosCliente(Cliente c) {
		this.cliente = c;
		entrada = Reloj.ahora();
	}
	
	void atiende() {
		salida = Reloj.ahora();
	}

}
