package ejercicios;

import java.util.Arrays;

public class Ejercicio10 {

	public Ejercicio10() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 10 - - - - - - - - -");
		// Diseña un método al que le mandemos una matriz y nos diga si es cuadrada o no.
		
		int filas = 0, columnas = 0;
		int [][]matriz = {{1,2,3},
				  		  {4,5,6,},
				  		  {7,8,9}};
		
		int [][]matriz2 = {{1,2,3},
		  		 		   {4,5,6},
		  		 		   {7,8,9,10}};
		
		int [][]matriz3 = {{1,2,3},
		 		   		   {4,5,6},
		 		   		   {7,8,9},
		 		   		   {10}};
		
		int[] sumaFilas = contarFilas(matriz);
		int[] sumaColumnas = contarColumnas(matriz);
		boolean esCuad = true; int x = 0, y = 0;
		
		while(esCuad == true && x < sumaFilas.length) {
			y = x + 1;
			if (y == sumaFilas.length) {
				y = 0;
			}
			if(sumaFilas[x] != sumaFilas[y]) {
				esCuad = false;
			}
			x++;
		}
		x = 0;
		
		while(esCuad == true && x < sumaColumnas.length) {
			y = x + 1;
			if (y == sumaColumnas.length) {
				y = 0;
			}
			if(sumaColumnas[x] != sumaColumnas[y]) {
				esCuad = false;
			}
			x++;
		}
		
		if(esCuad == true) {
			System.out.println("Es una matriz cuadrada");
		}
		else {
			System.out.println("No es una matriz cuadrada");
		}
		
	}
	public static int[] contarFilas(int[][] matriz) {
		int[] suma = new int[matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				suma[x] ++;;
			}
		}
		return suma;
	}
	
	public static int[] contarColumnas(int[][] matriz) {
		int[] suma = new int[matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				suma[x] ++;
			}
		}
		return suma;
	}
}
