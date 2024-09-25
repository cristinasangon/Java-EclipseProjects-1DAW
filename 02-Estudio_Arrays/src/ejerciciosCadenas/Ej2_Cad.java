package ejerciciosCadenas;

import java.util.Scanner;

public class Ej2_Cad {

	public Ej2_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 2 == == == ==");
		// Un programa que me pida una frase que diga si es palíndroma. Busca frases palíndromas 
		// en internet para comprobar el resultado.
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase = leer.nextLine();
		
		String fraserev = "";
		frase = frase.replace(" ", "");
		frase = frase.toLowerCase();
		for(int x = 0; x < frase.length(); x++) {
			fraserev = frase.charAt(x) + fraserev;
		}
		
		if(frase.equals(fraserev)) {
			System.out.println("Es palindroma");
		}
		else {
			System.out.println("No es palindroma");
		}
	}

}
