package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class ColaEspera {

	//ATRIBUTOS
	private Queue <DatosCliente> colaEspera;
	private Queue <DatosCliente> colaAtendidos;
	
	//CONSTRUCTORES
	public ColaEspera() {
		colaEspera = new LinkedList<DatosCliente>();
		colaAtendidos = new LinkedList<DatosCliente>();
	}
	
	public void nuevoCliente(Cliente cliente) {
		DatosCliente datos = new DatosCliente(cliente);
		colaEspera.add(datos);
	}
	
	public Cliente atenderCliente() {
		DatosCliente datos = colaEspera.remove();
		datos.atiende();
		colaAtendidos.add(datos);
		
		return datos.cliente;
	}
	
	public double tiempoEsperaAtendidos() {
		long tiempo = 0;
		int num = 0;
		
		for(DatosCliente datos: colaAtendidos){
			tiempo = tiempo + datos.salida - datos.entrada;
			num++;
		}
		
		if(num == 0) {
			return 0.0;
		}
		else {
			return ((((double) tiempo) / num) / 1000.0);
		}
	}

}
