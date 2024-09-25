package ejerciciosCadenas;

import java.util.Arrays;
import java.util.Scanner;

public class Ej1_Cad {

	public Ej1_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 1 == == == ==");
		// Rompe cadenas: Crea un programa que me pida una frase y me la rompa en palabras.
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase = leer.nextLine();
		
		String[] palabras = frase.split(" ");
		
		for(int x = 0; x < palabras.length; x++) {
			System.out.println((x + 1) + " - " + palabras[x]);
		}
	}

}
