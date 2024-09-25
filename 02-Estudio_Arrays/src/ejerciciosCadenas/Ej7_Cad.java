package ejerciciosCadenas;

import java.util.Arrays;

public class Ej7_Cad {

	public Ej7_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 7 == == == ==");
		// Rellenar un array con números aleatorios sin repetición, donde pide por 
		// teclado los límites entre los que genera números aleatorios y la cantidad 
		// de números que va a generar. Debe recorrer el array y si el número es 
		// múltiplo de 5, se queda igual y, si no, poner el  múltiplo de 5 
		// inmediatamente a ese número.
		
		int[] array = generaAleatorios(10, 50, 5);
		System.out.println(Arrays.toString(array));
		
		array = cambiarMultiplos(array, 5);
		System.out.println(Arrays.toString(array));
		
	}
	public static int[] generaAleatorios(int menor, int mayor, int cant) {
		int[] aleatorios = new int[cant];
		int rand = 0, x = 0;
		boolean esDif = true;
		
		while(x < aleatorios.length) {
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			int y = 0;
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
			esDif = true;
		}
		return aleatorios;
	}
	
	public static int[] cambiarMultiplos (int[] array, int multiplo) {
		for(int x = 0; x < array.length; x++) {
			if((array[x] % multiplo) != 0) {
				while((array[x] % multiplo) != 0) {
					array[x]++;
				}
			}
		}
		return array;
	}

}
