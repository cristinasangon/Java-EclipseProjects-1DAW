package repasoFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ej1_DesencriptarPorTransposicion {

	public Ej1_DesencriptarPorTransposicion() throws IOException {
		File fichero = new File("FicherosRepaso//desencriptarPorTransposicion.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		int[] clave = convierteClaveEnArray(linea);
		
		while((linea = br.readLine()) != null) {
			String mensaje = linea;
			String mensajeDesencriptado = desencripta(mensaje, clave);
			System.out.println(mensajeDesencriptado);
		}
		
		br.close(); fr.close();
		
	}
	public static int[] convierteClaveEnArray(String clave) {
		String[] claveArray = clave.split(",");
		int[] claveConvertida = new int[claveArray.length];
		
		for(int x = 0; x < claveConvertida.length; x++) {
			claveConvertida[x] = Integer.parseInt(claveArray[x]);
		}
		
		return claveConvertida;
	}
	
	public static String desencripta(String mensaje, int[]clave) {
		int tamX = mensaje.length() / clave.length;
		int tamY = clave.length;
		String[][] mensajeArray = new String[tamX][tamY];
		
		//Convertimos el mensaje en arrays bidimensional
		int z = 0;
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				mensajeArray[x][y] = Character.toString(mensaje.charAt(z));
				z++;
			}
		}
		
		//Pasamos el array encriptado a un array desencriptado cambiando las posiciones de las letras con la clave
		String[][] mensajeDesencriptadoArray = new String[tamX][tamY];
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				mensajeDesencriptadoArray[x][clave[y]] = mensajeArray[x][y];
			}
		}
		
		//Convertimos el array en String para devolverlo como cadena al codigo
		String mensajeDesencriptado = "";
		z = 0;
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				mensajeDesencriptado += mensajeDesencriptadoArray[x][y]; 
			}
		}
		
		//Le quitamos os asteriscos(se añaden al encriptar para poner el mismo tamaño que la clave)
		mensajeDesencriptado = mensajeDesencriptado.replace("*", "");
		
		return mensajeDesencriptado;
	}
}
