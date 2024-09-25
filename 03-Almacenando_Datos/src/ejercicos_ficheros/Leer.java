package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

	public static String cadena() throws IOException {
		String dato = "";
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		dato = br.readLine();
		
		return dato;
	}
	
	public static int entero() throws NumberFormatException, IOException {
		int numero = 0;
		
		numero = Integer.parseInt(cadena());
		
		return numero;
	}
}
