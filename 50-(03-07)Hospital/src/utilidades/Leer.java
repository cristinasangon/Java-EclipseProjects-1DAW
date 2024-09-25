package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

	public Leer() {
		// TODO Auto-generated constructor stub
	}
	
	public static String cadena() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		return br.readLine();
	}

}
