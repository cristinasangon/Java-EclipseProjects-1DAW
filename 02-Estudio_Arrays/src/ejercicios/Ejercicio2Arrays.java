package ejercicios;

import java.util.Scanner;

public class Ejercicio2Arrays {

	public Ejercicio2Arrays() {
		Scanner leer = new Scanner(System.in);
		
		// Programa que pida los limites entre los que quiere generar numeros aleatorios que no se repitan y la cantidad de numeros que quiere generar.
		// Debe almacenar los datos en una array.
		
		int lim1 = 0, lim2 = 0, cant = 0, aux = 0, x = 0,y = 0, rand = 0;
		boolean esDiferente = true;
		
		System.out.println("");
		System.out.print("Introduce el limite 1: ");
		lim1 = leer.nextInt();
				
		System.out.print("Introduce el limite 2: ");
		lim2 = leer.nextInt();
		
		System.out.print("Introduce la cantidad de aleatorios que quieres generar: ");
		cant = leer.nextInt();
	
		if (lim1 > lim2) {
			aux = lim1;
			lim1 = lim2;
			lim2 = aux;
			
		}
		
		int [] aleatorios = new int [cant];
	
		while (x <= cant) {
			rand = (int)Math.floor(Math.random()*(lim2 - lim1 + 1) + lim1);
			while (esDiferente == true && y < cant) {
				if (rand == aleatorios[y]) {
					esDiferente = false;
				}
				y++;
			}
			if (esDiferente == true) {
				System.out.print(" | " + rand);
				aleatorios[x] = rand;
				x++;
			}
			
			esDiferente = true;
			y = 0;
		}
		
	}

}
