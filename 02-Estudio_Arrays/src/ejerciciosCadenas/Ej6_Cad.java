package ejerciciosCadenas;

import java.util.Arrays;

public class Ej6_Cad {

	public Ej6_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 6 == == == ==");
		// Programa que encripta un mensaje mediante la encriptación por transposición. 
		// El programa debe tener lo siguiente: 
		// - Función para encriptar el mensaje que devuelva valor String llamada 
		//   encripta(mensaje)
		// - Función para desencriptar el mensaje que devuelva valor String llamada 
		//   desencripta(mensaje)
		// - La variable para el mensaje debe llamarse mensaje y tendrá el valor 
		//   “Atacaremos al amanecer de la mañana”
		// - La variable para el mensaje encriptado debe llamarse mensajeEncriptado 
		// - El array que contiene los números de encriptar debe ser 
		//   int[] encriptación = {6, 5, 0, 3, 1 , 4, 8, 7, 2}

		int[] encriptacion = {6, 5, 0, 3, 1, 4, 8, 7, 2};
		String mensaje = "Atacaremos al amanecer";
		
		// BUCLE PARA SABER CUANTOS CARACTERES HAY QUE AÑADIR
		int cantCar = mensaje.length();
		int cont  = 0;
		while(cantCar > 0) {
			cantCar -= encriptacion.length;
			cont++;
		}
		cantCar*=-1;
		
		// BUCLE PARA AÑADIR LOS CARACTERES
		for(int x = 0; x < cantCar; x++) {
			mensaje = mensaje + "-";
		}
		
		// BUCLE PARA PASAR NUESTRO MENSAJE A UN ARRAY
		int z = 0;
		String[][]mensajeDiv = new String [cont][encriptacion.length];
		for(int x = 0; x < mensajeDiv.length; x++) {
			for(int y = 0; y < mensajeDiv[x].length; y++) {
				mensajeDiv[x][y] = Character.toString(mensaje.charAt(z));
				z++;
			}
		}
		
		// USAR FUNCION PARA ENCRIPTAR Y MOSTRAR MENSAJE ENCRIPTADO
		String [][] mensajeEncriptado = encripta(mensajeDiv, encriptacion);
		System.out.println("MENSAJE ENCRIPTADO:");
		mostrarArrayBi(mensajeEncriptado);
		
		System.out.println();
		System.out.println();
		
		// USAR FUNCION PARA ENCRIPTAR Y MOSTRAR MENSAJE DESENCRIPTADO
		String [][] mensajeDesencriptado = desencripta(mensajeDiv, encriptacion);
		System.out.println("MENSAJE DESENCRIPTADO:");
		mostrarArrayBi(mensajeDesencriptado);
	}
	public static String[][] encripta(String[][] mensaje, int[] encriptacion){
		String[][] encriptado = new String [mensaje.length][mensaje[0].length];
		for(int x = 0; x < mensaje.length; x++) {
			for(int y = 0; y < mensaje[x].length; y++) {
				encriptado[x][encriptacion[y]] = mensaje[x][y];
			}
		}
		return encriptado;
	}
	
	public static String[][] desencripta(String[][] mensaje, int[] encriptacion){
		String[][] desencriptado = new String [mensaje.length][mensaje[0].length];
		for(int x = 0; x < mensaje.length; x++) {
			for(int y = 0; y < mensaje[x].length; y++) {
				desencriptado[x][encriptacion[y]] = mensaje[x][encriptacion[y]];
			}
		}
		return desencriptado;
	}
	
	public static void mostrarArrayBi (String[][] array) {
		for(int x = 0; x < array.length; x++) {
			for(int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y]);
			}
		}
	}

}
