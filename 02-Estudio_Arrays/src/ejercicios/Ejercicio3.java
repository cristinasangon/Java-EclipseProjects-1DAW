package ejercicios;

import java.util.Arrays;

public class Ejercicio3 {

	public Ejercicio3() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 3 - - - - - - - - -");
		// Diseñar un programa que genere un sorteo de primitiva y luego empiece a generar boletos hasta que tengamos 6 aciertos.
		
		int [] sorteo = generaAleatorios(1, 49, 6);
		System.out.printf("%n - - - - - SORTEO - - - - - %n %s %n - - - - - - - - - - - - - %n %n", Arrays.toString(sorteo));
		
		int [] boleto = new int[6];
		int cont = 0, intentos = 0;
		while(cont < 6) {
			boleto = generaAleatorios(1, 49, 6);
			intentos++;
			for(int x = 0; x < 6; x++) {
				for(int y = 0; y < 6; y++) {
					if(boleto[x] == sorteo[y]) {
						cont ++;
					}
				}
			}
			if (cont < 6) {
				cont = 0;
			}
		}
		
		System.out.printf("%n BOLETO GANADOR: %n %s %n %n", Arrays.toString(boleto));
		System.out.printf("Se han realizado %d intentos hasta dar con el ganador", intentos);
		
	}
	public static int[] generaAleatorios (int mayor, int menor, int cant) {
		int[] sorteo = new int [cant];
		boolean esDif = true;
		int rand = 0, x = 0, y = 0;
		
		while (x < sorteo.length) {
			rand = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
			while (esDif && y < sorteo.length) {
				if (rand == sorteo[y]) {
					esDif = false;
				}
				y++;
			}
			
			if (esDif) {
				sorteo[x] = rand;
				x++;
			}
			esDif = true;
			y = 0;
		}
		return sorteo;
	}
}
