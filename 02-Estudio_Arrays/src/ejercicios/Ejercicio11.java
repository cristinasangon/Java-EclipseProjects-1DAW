package ejercicios;

import java.util.Scanner;

public class Ejercicio11 {

	public Ejercicio11() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 11 - - - - - - - - -");
		// Programa que genere una tarjeta de claves que tenga la siguiente estructura:
        //       |  1  |  2  |  3  |  4  |  5  |
		// |  A  | nnn | nnn | nnn | nnn | nnn |
		// |  B  | nnn | nnn | nnn | nnn | nnn |
		// |  C  | nnn | nnn | nnn | nnn | nnn |
		// |  D  | nnn | nnn | nnn | nnn | nnn |
		// |  E  | nnn | nnn | nnn | nnn | nnn |
		// |  F  | nnn | nnn | nnn | nnn | nnn |
		// Se deben generar los números aleatoriamente desde 100 hasta 999 sin repetición 
		// para llenar el array. El programa pedirá al usuario que introduzca el valor que 
		// se encuentre en la posición A1 por ejemplo(la posición será generada 
		// aleatoriamente). Si el usuario acierta, mostrar “Correcto” y, si no, mostrar 
		// “incorrecto”.

		Scanner leer = new Scanner(System.in);
		int[] numGenerados = generaAleatorios(100, 900, 25);
		int[][] tarjeta = new int[5][5]; 
		String[] letras = {"A","B","C","D","E","F"};
		int z = 0, posX = 0, posY = 0;
		
		for(int x = 0; x < tarjeta.length; x++) {
			for(int y = 0; y < tarjeta[x].length; y++) {
				tarjeta[x][y] = numGenerados[z];
				z++;
			}
		}
		
		mostrarArrayBi(tarjeta, letras);
		
		posX = (int) Math.floor(Math.random()*(0-5 + 1) + 5);
		posY = (int) Math.floor(Math.random()*(0-5 + 1) + 5);
		
		System.out.println();
		System.out.print("Dime la clave para " + letras[posX] + (posY + 1));
		int clave = leer.nextInt();
		
		if(clave == tarjeta[posX][posY]) {
			System.out.println("Correcto");
		}
		else {
			System.out.println("Incorrecto");
		}
		
	}
	public static int [] generaAleatorios(int menor, int mayor, int cant) {
		int[] resultado = new int[cant]; 
		int rand = 0, x = 0, y = 0;
		boolean esDif = true;
		if(menor > mayor) {
			int aux = mayor;
			mayor = menor;
			menor = aux;
		}
		while(x < resultado.length) {
			esDif = true;
			y = 0;
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			while(esDif == true && y < resultado.length) {
				if(rand == resultado[y]) {
					esDif = false;
				}
				y++;
			}
			if(esDif == true) {
				resultado[x] = rand;
				x++;
			}
		}
		return resultado;
	}
	
	public static void mostrarArrayBi(int[][] array, String[] letras){
		System.out.println();
		System.out.println("      1     2     3     4     5");
		System.out.println("     ---   ---   ---   ---   ---");
		for(int x = 0; x < array.length; x++) {
			System.out.print(" " + letras[x] + " |");
			for(int y = 0; y < array[x].length; y++) {
			System.out.printf(" %d |", array[x][y]);
			}
			System.out.println();
			System.out.println("     ---   ---   ---   ---   ---");
		}
	}
}
