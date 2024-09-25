package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Rep_Ej1_DesencriptadoPorTransposicion {

	public Rep_Ej1_DesencriptadoPorTransposicion() throws IOException {
		File fichero = new File("FicherosRepaso//desencriptarPorTransposicion.txt");	
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		//SACAMOS LA CLAVE
		String linea = br.readLine();
		String[] claveTemporal = linea.split(",");
		int[] clave = convierteArrayStringEnInt(claveTemporal);
		claveTemporal = null;
		
		//BUCLE PARARECORRER MENSAJES Y DESENCRIPTAR
		while((linea = br.readLine()) != null){
			String mensaje = linea;
			System.out.println(desencripta(mensaje, clave));
		}
		
		br.close();fr.close();
	}
	public static int[] convierteArrayStringEnInt(String[] array) {
		int[] arrayConvertida = new int[array.length];
		
		for(int x = 0; x < array.length; x++) {
			arrayConvertida[x] = Integer.parseInt(array[x]);
		}
		
		return arrayConvertida;
	}
	
	public static String desencripta(String mensaje, int[] clave) {
		int tamX = mensaje.length() / clave.length;
		int tamY = clave.length;
		
		//CONVERTIR MENSAJE EN ARRAY BIDIMENSIONAL
		String[][] mensajeArray = new String[tamX][tamY];
		int z = 0;
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				mensajeArray[x][y] = Character.toString(mensaje.charAt(z));
				z++;
			}
		}
		
		//DESENCRIPTAR CAMBIANDO POSICIONES
		String[][]desencriptadoArray = new String[tamX][tamY];
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				desencriptadoArray[x][clave[y]] = mensajeArray[x][y];
			}
		}
		
		//CONVERTIMOS EL MENSAJE DESENCRIPTADO(ARRAY) EN STRING
		String desencriptado = "";
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				desencriptado += desencriptadoArray[x][y];
			}
		}
		
		//QUITAR ASTERISCOSDEL MENSAJE
		desencriptado = desencriptado.replace("*", "");
		
		return desencriptado;
	}

}
