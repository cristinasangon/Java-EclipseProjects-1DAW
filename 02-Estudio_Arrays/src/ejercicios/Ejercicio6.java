package ejercicios;

import java.util.Scanner;

public class Ejercicio6 {

	public Ejercicio6() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 6 - - - - - - - - -");
		// Realizar un ejercicio que me pida la posición de un caballo en el 
		// tablero de ajedrez y me muestre por pantalla las posiciones en 
		// las que se puede mover el caballo
		Scanner leer = new Scanner (System.in);
		
		//Creamos el array que ontiene el tablero y lo llenamos con espacios para que no salga null
		String tablero[][] = new String[8][8];
		llenarTablero(tablero);
		
		//Pedir la posicion del caballo con "x" e "y"
		System.out.println("Dime la posicion del caballo en el tablero: ");
		System.out.print("- x: "); int posX = leer.nextInt(); posX--;
		System.out.print("- y: "); int posY = leer.nextInt(); posY--;
		tablero[posX][posY] = "C";
		
		//Creamos array con todos los movimientos posibles para el caballo
		int[][] movimientos = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, 
				{1, 2}, {2, -1}, {2, 1}};
		
		//Vamos recorriendo el array y comprobando con movimientos
		//Filas + movimientos no debe ser menor que 0 o mayor que 8
		//Columnas + movimientos no debe ser menor que 0 o mayor que 8
		int f, c;
		for (int x = 0; x < movimientos.length; x++) {
			f = posX + movimientos[x][0];
			c = posY + movimientos[x][1];
			if ((f >= 0 && f < 8) && (c >= 0 && c < 8)) {
				tablero[f][c] = "º";
			}
		}
		//Mostrar trablero a traves de funcion
		mostrarTablero(tablero);
		
	}
	public static void mostrarTablero(String[][] tablero) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				System.out.printf("|%2s ", tablero[x][y]);
			}
			System.out.print("|");
			System.out.println();
			System.out.println();
		}
	}
	public static void llenarTablero(String[][] tablero) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				tablero[x][y] = " ";
			}
		}
	}

}
