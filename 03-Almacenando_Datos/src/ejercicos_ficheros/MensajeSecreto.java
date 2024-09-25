package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MensajeSecreto {

	public MensajeSecreto() throws IOException {
		File fichero = new File("Ficheros//MensajeSecreto.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String mensaje = "";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		int cantidadPalabras = Integer.parseInt(br.readLine());
		
		for(int x = 0; x < cantidadPalabras; x++) {
			int cantidadLetras = Integer.parseInt(br.readLine());
			for(int y = 0; y < cantidadLetras; y++) {
				int num1 = Integer.parseInt(br.readLine());//Posicion de la letra
				int num2 = Integer.parseInt(br.readLine());//Si es par, empieza por delante y si es impar por detras
				
				if((num2%2) != 0) {
					num1 = 26 - num1;
				}
				else {
					num1--;
				}
				
				mensaje += letras.charAt(num1); 
			}
			mensaje += " ";
		}
		
		System.out.println(mensaje);
	}

}
