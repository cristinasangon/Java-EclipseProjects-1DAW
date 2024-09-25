package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CuadradoMagico {

	public CuadradoMagico() throws IOException {
		File fichero = new File("Ficheros//cuadradoMagico.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		int cantidadMatrices = Integer.parseInt(br.readLine());
		
		for(int x = 0; x < cantidadMatrices; x++) {
			System.out.println("= == = == MATRIZ " + (x + 1) + " == = == =");
			int indice = Integer.parseInt(br.readLine());
			String[][]matriz = new String[indice][indice];
			for(int y = 0; y < indice; y++) {
				String linea = br.readLine();
				matriz[y] = linea.split(" ");
			}
			int[][] matrizNumerica = convertirMatrizStringEnInt(matriz);
			mostrarMatriz(matrizNumerica);
			if(esCuadradoMagico(matrizNumerica)) {
				System.out.println("Es un cuadrado magico");
			}
			else{
				System.out.println("No es un cuadrado magico");
			}
			System.out.println("== = == = == = == = == = ==");
			System.out.println();
		}
	}
	public static int[][]convertirMatrizStringEnInt(String[][]matriz){
		int[][] matrizConvertida = new int[matriz.length][matriz.length];
		
		for(int x = 0; x < matrizConvertida.length; x++) {
			for(int y = 0; y < matrizConvertida.length; y++) {
				matrizConvertida[x][y] = Integer.parseInt(matriz[x][y]);
			}
		}
		return matrizConvertida;
	}
	
	public static void mostrarMatriz(int[][]matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.printf("%-5s", matriz[x][y]);
			}
			System.out.println();
		}
	}
	
	public static boolean esCuadradoMagico(int[][] matriz) {
		boolean esMagico = true;
		int suma = 0;
		for(int z = 0; z < matriz.length; z++) {
			suma += matriz[0][z];
		}
		
		//hago la suma de todas las filas y las voy comprobando con suma(la primera fila)
		int x = 0;
		while(esMagico && x < matriz.length) {
			int sumaFilas = 0;
			for(int y = 0; y < matriz.length; y++) {
				sumaFilas += matriz[x][y];
			}
			if(suma != sumaFilas) {
				esMagico = false;
			}
			x++;
		}
		
		if(esMagico) {
		//hago la suma de todas las columnas y las voy comprobando con suma(la primera fila)
			x = 0;
			while(esMagico && x < matriz.length) {
				int sumaColumnas = 0;
				for(int y = 0; y < matriz.length; y++) {
					sumaColumnas += matriz[y][x];
				}
				if(suma != sumaColumnas) {
					esMagico = false;
				}
				x++;
			}
		}
		
		if(esMagico) {
		//hago la suma de las 2 diagonales y las compruebo con suma(la primera fila)
			
			//Diagonal
			x = 0; int y = 0; int sumaDiagonal = 0;
			
			while(x < matriz.length) {
				sumaDiagonal += matriz[y][x];
				x++;
				y++;
			}
			if(suma != sumaDiagonal) {
				esMagico = false;
			}
			
			//Diagonal inversa
			x = 0; y = matriz.length - 1; sumaDiagonal = 0;
			
			while(x < matriz.length) {
				sumaDiagonal += matriz[y][x];
				x++;
				y--;
			}
			if(suma != sumaDiagonal) {
				esMagico = false;
			}
		}
		
		return esMagico;
	}
}
