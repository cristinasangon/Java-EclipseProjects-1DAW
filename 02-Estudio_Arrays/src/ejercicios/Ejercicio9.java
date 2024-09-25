package ejercicios;

import java.util.Arrays;

public class Ejercicio9 {

	public Ejercicio9() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 9 - - - - - - - - -");
		// Diseña un método al que le mandemos una matriz cuadrada y me diga si es un cuadrado mágico.
		int [][]matriz = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
			       
		int [][]matriz2 = {{17, 24, 1, 8, 15}, 
					       {23, 5, 7, 14, 16}, 
					       {4, 6, 13, 20, 22},
					       {10, 12, 19, 21, 3},
					       {11, 18, 25, 2, 9}}; 

		int[] sumaFilas = sumaFilas(matriz2);
		int[] sumaColumnas = sumaColumnas(matriz2);
		int[] sumaDiagonales = sumaDiagonales(matriz2);
		boolean esMag = true; int x = 0, y = 0;
		
		while(esMag == true && x < sumaFilas.length) {
			y = x + 1;
			if (y == sumaFilas.length) {
				y = 0;
			}
			if(sumaFilas[x] != sumaFilas[y]) {
				esMag = false;
			}
			x++;
		}
		x = 0;
		while(esMag == true && x < sumaColumnas.length) {
			y = x + 1;
			if (y == sumaColumnas.length) {
				y = 0;
			}
			if(sumaColumnas[x] != sumaColumnas[y]) {
				esMag = false;
			}
			x++;
		}
		x = 0;
		while(esMag == true && x < sumaDiagonales.length) {
			y = x + 1;
			if (y == sumaDiagonales.length) {
				y = 0;
			}
			if(sumaDiagonales[x] != sumaDiagonales[y]) {
				esMag = false;
			}
			x++;
		}
		
		if(esMag == true) {
			System.out.println("Es un cuadrado magico");
		}
		else {
			System.out.println("No es un cuadrado magico");
		}
		
	}
	public static int[] sumaFilas(int[][] matriz) {
		int[] suma = new int[matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				suma[x] += matriz[x][y];
			}
		}
		return suma;
	}
	
	public static int[] sumaColumnas(int[][] matriz) {
		int[] suma = new int[matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				suma[x] += matriz[y][x];
			}
		}
		return suma;
	}
	
	public static int[] sumaDiagonales(int[][] matriz) {
		int[] suma = new int[2];
		int x = -1, y = -1;
		for(int v = 0; v < matriz.length; v++) {
			x++;
			y++;
			suma[0] += matriz[x][y];
		}
		y = matriz.length; x = -1;
		for(int v = 0; v < matriz.length; v++) {
			x++;
			y--;
			suma[1] += matriz[x][y];
		}
		return suma;
	}
}
