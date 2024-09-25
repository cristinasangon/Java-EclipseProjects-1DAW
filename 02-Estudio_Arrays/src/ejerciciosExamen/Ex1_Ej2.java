package ejerciciosExamen;

import java.util.Arrays;

public class Ex1_Ej2 {

	public Ex1_Ej2() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 1 - EJERCICIO 2 == == == ==");
		// 
		int[] clave = {3, 4, 9, 6, 1, 7, 0, 8, 5, 2};
		String mensaje = "easAtocrmaa-r-cpnl-olaaimnr-uee-d-d-lmseor&e-&az&m";

		String mensajeDesencriptado = desencripta(clave, mensaje);
		System.out.println(mensajeDesencriptado);
	}
	public static String desencripta(int[] clave, String mensaje) {
		String[][] mensajeDiv = new String [(mensaje.length()/clave.length)][clave.length];
		String[][] mensajeBueno = new String [(mensaje.length()/clave.length)][clave.length];
		
		int z = 0;
		for(int x = 0; x < mensajeDiv.length; x++) {
			for(int y = 0; y < mensajeDiv[x].length; y++) {
				mensajeDiv[x][y] = Character.toString(mensaje.charAt(z));
				z++;
			}
		}
		
		for(int x = 0; x < mensajeDiv.length; x++) {
			for(int y = 0; y < mensajeDiv[x].length; y++) {
				mensajeBueno[x][y] = mensajeDiv[x][clave[y]];
			}
		}
		
		String desencriptado = "";
		for(int x = 0; x < mensajeBueno.length; x++) {
			for(int y = 0; y < mensajeBueno[x].length; y++) {
				desencriptado += mensajeBueno[x][y];
			}
		}
		return desencriptado;
	}
}
