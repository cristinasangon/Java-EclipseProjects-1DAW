package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej2_MensajeSecreto {

	public Ej2_MensajeSecreto() throws IOException {
		File fichero = new File("FicherosRepaso//mensajeSecreto.txt");
		if(!fichero.exists());{
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String mensaje = "";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		
		int cantPalabras = Integer.parseInt(br.readLine());
		for(int x = 0; x < cantPalabras; x++) {
			int cantLetras = Integer.parseInt(br.readLine());
			for(int y = 0; y < cantLetras; y++) {
				int posicion = Integer.parseInt(br.readLine());
				int direccion =  Integer.parseInt(br.readLine());
				if(direccion%2 != 0) {
					posicion = 26 - posicion;
				}
				else {
					posicion--;
				}
				mensaje += Character.toString(letras.charAt(posicion));
			}
			mensaje += " "; 
		}
		
		br.close(); fr.close();
		
		System.out.println(mensaje);
	}

}
