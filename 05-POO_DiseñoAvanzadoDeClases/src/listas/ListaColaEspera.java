package listas;

import java.util.NoSuchElementException;
import java.util.Scanner;

import modelo.Cliente;
import modelo.ColaEspera;

public class ListaColaEspera {

	public ListaColaEspera() throws InterruptedException {
		Scanner leer = new Scanner(System.in);
		
		boolean seguirAñadiendo = true;
		ColaEspera cola = new ColaEspera();
		Cliente cliente;
		
		System.out.println("AÑADE NUEVOS CLIENTES A LA COLA");
		System.out.println("Para dejar de añadir clientes, escriba 1");
		System.out.println("-----------------------------------------------");
		while(seguirAñadiendo) {
			System.out.println("Introduce el nombre del cliente: ");
			String nombreCliente = leer.nextLine();
			
			if(nombreCliente.equals("1")) {
				seguirAñadiendo = false;
			}
			else {
				cliente = new Cliente(nombreCliente);
				cola.nuevoCliente(cliente);
				System.out.println(cliente + " espere en la cola");
				cliente = null;
				Thread.sleep(1000);
			}
		}
		
		boolean hayClientesEnCola = true;
		
		System.out.println("ATENCION...................");
		while(hayClientesEnCola) {
			try {
				cliente = cola.atenderCliente();
				System.out.println(cliente.toString());
				Thread.sleep(1000);
			} catch (NoSuchElementException e) {
				hayClientesEnCola = false;
			}
		}
		
		System.out.println("");
		System.out.println("Tiempo en ser atendidos: " + cola.tiempoEsperaAtendidos());
		
	
		
		
		
		
	}

}
