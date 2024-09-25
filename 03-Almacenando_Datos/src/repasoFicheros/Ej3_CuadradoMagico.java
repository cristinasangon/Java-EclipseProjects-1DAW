package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Ej3_CuadradoMagico {

	public Ej3_CuadradoMagico() throws IOException {
		File fichero = new File("FicherosRepaso//cuadradoMagico.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		int cantMatrices = Integer.parseInt(linea);
		
		for(int x = 0; x < cantMatrices; x++) {
			System.out.println("_______________________________");
			System.out.println("MATRIZ " + (x + 1));
			System.out.println();
			
			linea = br.readLine();
			int indice = Integer.parseInt(linea);
			String[][] matrizTemporal = new String[indice][indice];
			for(int y = 0; y < indice; y++) {
				linea = br.readLine();
				matrizTemporal[y] = linea.split(" ");
			}
			
			int[][] matriz = convierteArrayStringEnInt(matrizTemporal);
			mostrarMatriz(matriz);
			
			if(esMagico(matriz)) {
				System.out.println("---------------------");
				System.out.println("Es un cuadrado magico");
				System.out.println("---------------------");
			}
			else {
				System.out.println("------------------------");
				System.out.println("No es un cuadrado magico");
				System.out.println("------------------------");
			}
		
			System.out.println("_______________________________");
			System.out.println();
		}
		
		br.close();fr.close();
	}
	
	public static int[][]convierteArrayStringEnInt(String[][] array){
		int[][] arrayConvertida = new int[array.length][array.length];
		
		for(int x = 0; x < array.length; x++) {
			for(int y = 0; y < array[x].length;y++) {
				arrayConvertida[x][y] = Integer.parseInt(array[x][y]);
			}
		}
		
		return arrayConvertida;
	}
	
	public static void mostrarMatriz(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length;y++) {
				System.out.printf("%-4s", matriz[x][y]);
			}
			System.out.println();
		}
	}
	
	public static boolean esMagico(int[][] matriz) {
		int referenciaSuma = 0;
		
		for(int x = 0; x < matriz[0].length; x++) {
			referenciaSuma += matriz[0][x];
		}
		
		//COMPROBAR FILAS
		for(int x = 0; x < matriz.length; x++) {
			int suma = 0;
			for(int y = 0; y < matriz[x].length;y++) {
				suma += matriz[x][y];
			}
			if(suma != referenciaSuma) {
				return false;
			}
		}
		
		//COMPROBAR COLUMNAS
		for(int x = 0; x < matriz.length; x++) {
			int suma = 0;
			for(int y = 0; y < matriz[x].length;y++) {
				suma += matriz[y][x];
			}
			if(suma != referenciaSuma) {
				return false;
			}
		}
		
		//COMPROBAR DIAGONAL
		int x = 0, y = 0, suma = 0;
		while(x < matriz.length) {
			suma += matriz[x][y];
			x++;
			y++;
		}
		if(suma != referenciaSuma) {
			return false;
		}
		
		
		//COMPROBAR DIAGONAL INVERSA
		x = 0; y = matriz.length - 1; suma = 0;
		while(x < matriz.length) {
			suma += matriz[x][y];
			x++;
			y--;
		}
		if(suma != referenciaSuma) {
			return false;
		}
		
		return true;
	}

}
