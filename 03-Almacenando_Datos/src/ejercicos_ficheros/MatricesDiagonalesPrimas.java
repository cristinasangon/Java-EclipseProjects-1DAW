package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MatricesDiagonalesPrimas {

	public MatricesDiagonalesPrimas() throws IOException, NumberFormatException {
		//Inicio del programa
		
		//Creo el fichero (solo si no existe)
		File fichero = new File("Ficheros//matricesDiagonalesPrimas.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		//fr y br para poder leer el fichero
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		//Saco la primera linea (me dice la cantidad de matrices que hay en el fichero)
		int cantidadMatrices = Integer.parseInt(br.readLine());

		//Bucle para que recorra esas tres matrices
		for(int x = 0; x < cantidadMatrices; x++) {
			int indice = Integer.parseInt(br.readLine());
			System.out.println("=============================================");
			System.out.println("Indice: " + indice);
			String[][] matriz = new String[indice][indice];
			//Bucle para rellenar el array
			for(int y = 0; y < indice; y++) {
				String linea = br.readLine();
				matriz[y] = linea.split(",");
				//Bucle para mostrar la matriz
				for(int z = 0; z < indice; z++) {
					System.out.printf("%s  ", matriz[y][z]);
				}
				System.out.println();
			}
			int[][] matrizEntera = convierteMatrizStringToInt(matriz);
			int[] diagonalInversa = devuelveDiagonalnversa(matrizEntera);
			
			System.out.println("-------------");
			//Bucle para recorrer la diagonal inversa
			for(int z = 0; z < diagonalInversa.length; z++) {
				
				int num = diagonalInversa[z];
				System.out.print(num + "...");
				
				int suma = sumaDigitos(diagonalInversa[z]);
				System.out.print(suma);
				
				if(esPrimo(suma)) {
					System.out.print("...PRIMO");
				}
				
				System.out.println();
			}
		}	
	}
	public static int[][] convierteMatrizStringToInt (String[][] matrizString) throws NumberFormatException{
		int[][] matrizInt = new int[matrizString.length][matrizString.length];
		
		for(int x = 0; x < matrizString.length; x++) {
			for(int y = 0; y < matrizString.length; y++) {
				matrizInt[x][y] = Integer.parseInt(matrizString[x][y]);
			}
		}
		
		return matrizInt;
	}
	
	public static int[] devuelveDiagonalnversa (int[][] matriz) {
		int[] matrizInversa = new int[matriz.length];
		int x = 0, y = matriz.length - 1;
		
		for(int z = 0; z < matriz.length; z++) {
			matrizInversa[z] = matriz[x][y];
			x++;
			y--;
		}
		
		return matrizInversa;
	}
	
	public static int sumaDigitos(int dig) {
		int sumaDig = 0;
		
		while(dig%10 > 0) {
			sumaDig += dig%10;
			dig/=10;
		}
		
		return sumaDig;
	}
	
	public static boolean esPrimo(int num) {
		boolean esPrimo = true;
		int x = 2;
		
		while(x < num && esPrimo) {
			if(num % x == 0) {
				esPrimo = false;
			}
			x++;
		}
		
		return esPrimo;
	}
}
