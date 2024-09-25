package ejerciciosExamen;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1_Ej3 {

	public Ex1_Ej3() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 1 - EJERCICIO 3 == == == ==");
		// 
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Indica el indice para la matriz: ");
		int indice = leer.nextInt();
		
		int[][] matriz = new int [indice][indice];
		int[] aleatorios = generaAleatorios(indice);
		
		int z = 0;
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				matriz[x][y] = aleatorios[z];
				z++;
			}
			System.out.println(Arrays.toString(matriz[x]));
		}
		
		int x = 0, y = 0, suma = 0;
		for(z = 0; z < indice; z++) {
			suma = calculaSuma(matriz[x][y]);
			System.out.printf("%d ...sum = %d", matriz[x][y], suma);
			x ++;
			y ++;
			if(primo(suma) == true) {
				System.out.printf("...PRIMO");
			}
			System.out.printf(" %n");
		}
		
	}
	public static int[] generaAleatorios(int indice) {
		int[] aleatorios = new int[indice * indice];
		int rand = 0, menor = 1, mayor = (indice * indice), x = 0;
		
		while(x < aleatorios.length) {
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			int y = 0;
			boolean esDif = true;
			while(esDif == true && y < aleatorios.length) {
				if(rand == aleatorios[y]) {
					esDif = false;
				}
				y++;
			}
			if(esDif == true) {
				aleatorios[x] = rand;
				x++;
			}
		}
		return aleatorios;
	}
	
	public static int calculaSuma(int num) {
		int suma = 0;
		while(num > 0) {
			int digito = num % 10;
			suma += digito;
			num /= 10;
		}
		return suma;
	}
	
	public static boolean primo(int suma) {
		boolean esPrimo = true;
		int x = 2;
		
		if(suma == 1) {
			esPrimo = false;
		}
		while(esPrimo == true && x < suma) {
			if((suma % x) == 0) {
				esPrimo = false;
			}
			x++;
		}
		return esPrimo;
	}
}
