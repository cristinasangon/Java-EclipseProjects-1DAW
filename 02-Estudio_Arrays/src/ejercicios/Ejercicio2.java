package ejercicios;

import java.util.Arrays;

public class Ejercicio2 {

	public Ejercicio2() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 2 - - - - - - - - -");
		// 2.- Diseñar un programa que me permita almacenar 10 boletos de primitiva, luego genere un sorteo y me diga cuantos aciertos tiene
		// cada boleto.
		
		int [][] boletos = new int [10][6];
		int [] sorteo = generaAleatorios(1, 49, 6);
		int cont = 0;
		
		System.out.printf("%n - - - - - SORTEO - - - - - %n %s %n - - - - - - - - - - - - - %n %n", Arrays.toString(sorteo));
		
		for (int x = 0; x < boletos.length; x++) {
			boletos [x] = generaAleatorios(1, 49, 6);
			for (int y = 0; y < 6; y++) {
				for (int i = 0; i < 6; i++) {
					if(boletos[x][y] == sorteo [i]) {
						cont ++;
					}
				}
			}
			System.out.printf("BOLETO %-1d: %-25s %3d aciertos %n", (x + 1), Arrays.toString(boletos[x]), cont);
			cont = 0;
		}
		
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
