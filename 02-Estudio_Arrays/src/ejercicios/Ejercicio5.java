package ejercicios;

import java.util.Arrays;

public class Ejercicio5 {

	public Ejercicio5() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 5 - - - - - - - - -");
		// Crear una matriz de 5x5 con todos los números enteros comprendidos entre 1 y 25 
		// de forma que coincida la suma de los elementos de cada fila, de cada columna o 
		// de las diagonales principales. A este tipo de matriz se le denomina CUADRADO MÁGICO:
		
		// 17|24| 1| 8|15
		// 23| 5| 7|14|16
		//  4| 6|13|20|22
		// 10|12|19|21| 3
		// 11|18|25| 2| 9
		
		// La construcción de esta matriz se realiza de la siguiente forma: El número 1 se 
		// coloca en la primera fila, columna central. Cada número que le sigue (2, 3, …) 
		// se coloca en la fila anterior, columna posterior. Si el número a colocar sigue a 
		// un múltiplo de 5, se colocará en la misma columna, pero en la fila posterior.
		// NOTA: la fila anterior a la primera será la última y la columna posterior a 
		// la última será la primera.
		
		int x = 1, y = 1; 
		int cuadMag[][] = new int [5][5];
		
		for(int v = 1; v <= 25; v++) {
			if(v != 1 && ((v - 1) % 5) == 0) {
				x++;
				if(x == 5) {
					x = 0;
				}
			}
			else {
				x--;
				y++;
				if(x == -1) {
					x = 4;
				}
				if(y == 5) {
					y = 0;
				}
			}
			cuadMag[x][y] = v;
		}
		
		for(x = 0; x < 5; x++) {
			for(y = 0; y < 5; y++) {
				System.out.printf("| %2d ", cuadMag[x][y]);
			}
			System.out.print("|");
			System.out.println();
		}
		
		
		
	}

}
