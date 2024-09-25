package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Matrices {

	public Matrices() throws IOException {
		//Creo un fichero(Si no existe)
		File fichero = new File("Ficheros//matrices.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		//Leo la primera linea (Me dice la cantidad de matrices que hay)
		int cantidadMatrices = Integer.parseInt(br.readLine());
		
		//Creo un bucle que tantas vueltas como matrices haya
		for(int x = 0; x < cantidadMatrices; x++) {
			//Leo la siguiente linea (Me dice el tamaño de la matriz cuadrada)
			int filasMatriz = Integer.parseInt(br.readLine());
			//Creo un array con el tamaño proporcionado en esa linea
			String[][] matriz = new String[filasMatriz][filasMatriz];
			
			//Hago un bucle que de tantas vueltas como filas tiene la matriz
			for(int y = 0; y < filasMatriz; y++) {
				String linea = br.readLine();
				matriz[y] = linea.split(" "); 
			}
			
			//Paso la matriz a una matriz entera por si necesito hacer algo con ella
			int[][] matrizEntera = convertirMatrizEntero(matriz);
			
			//Muestro el array con un metodo
			System.out.println();
			System.out.println("MATRIZ " + (x + 1));
			System.out.println("-- - -- - -- - -- - -- - -- - --");
			mostrarMatriz(matrizEntera);
		}
		
		br.close();
		fr.close();
	}
	public static int[][] convertirMatrizEntero(String[][] matriz){
	int[][] matrizEntera = new int[matriz.length][matriz.length];	
	
	for(int x = 0; x < matrizEntera.length; x++) {
		for(int y = 0; y < matrizEntera[x].length; y++) {
			matrizEntera[x][y] = Integer.parseInt(matriz[x][y]);
		}
	}
	
	return matrizEntera;
	}
	
	public static void mostrarMatriz(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.printf("| %2d ",matriz[x][y]);
			}
			System.out.print("|");
			System.out.println();
		}
	}

}
