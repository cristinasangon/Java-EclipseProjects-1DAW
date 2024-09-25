package repasoFicheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerDato {
	
	public static String cadena() throws IOException {
		String dato = "";
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		dato = br.readLine();
		
		return dato;
	}
	
	public static int entero() throws IOException, NumberFormatException {
		int datoEntero = 0;
		String dato = cadena();
		
		datoEntero = Integer.parseInt(dato);
		
		return datoEntero;
	}
}
