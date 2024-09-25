package ejerciciosCadenas;

import java.util.Scanner;

public class Ej3_Cad {

	public Ej3_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 3 == == == ==");
		// Crea un programa que compruebe si un dni es correcto (8 números y una letra) 
		// Recordad que la letra se calcula dividiendo el número entre 23 y mirando el resto 
		// (Mirad en internet la letra con que se corresponde)
		
		Scanner leer = new Scanner(System.in);
		String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		
		System.out.print("Introduce el DNI: ");
		String DNI = leer.nextLine();
		// Pongo la letra en mayuscula por si acaso
		DNI = DNI.toUpperCase();
		
		// Elimino el ultimo caracter(la letra) y lo paso a entero
		String num = DNI.substring(0, (DNI.length() - 1));
		System.out.println(num);
		int numeros = Integer.parseInt(num);
		
		// Saco la letra en una variable
		String letra = Character.toString(DNI.charAt(8));
		
		// Comparo la letra con el array de letras correspondiantes al resto
		if(letra.equals(letras[numeros%23])) {
			System.out.println("El DNI " + DNI + " es correcto");
		}
		else {
			System.out.println("El DNI " + DNI + " es incorrecto");
		}
		
	}

}
