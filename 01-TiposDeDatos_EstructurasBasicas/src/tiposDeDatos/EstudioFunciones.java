package tiposDeDatos;

import java.util.Scanner;

public class EstudioFunciones { //Las funciones se declaran a nivel de clase
	
	public EstudioFunciones () {
		Scanner leer = new Scanner(System.in); 

		saludo("Cristina");
		
		// --------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("");
		int x = 7;
		double y = 3;
		double resultado = calcula(x,y);
		
		System.out.println("X en principal = " + x);
		System.out.printf("%d / %.0f = %.2f %n", x, y, resultado);
		
		// --------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("");
		String frase = "Hola";
		System.out.println("Frase antes del cambio: " + frase);
		cambia(frase);
		System.out.println("Frase despues del cambio: " + frase);
		
		// --------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("");
		System.out.print("Introduce un numero entero positivo: ");
		int n = leer.nextInt();
		
		if (esPrimo(n)) {
			System.out.printf("El numero %d es primo. %n", n);
		}
		else {
			System.out.printf("El numero %d no es primo. %n", n);
		}

	}
	// FUNCIONES
	private static void saludo(String nom){
		System.out.println("Hola " + nom);
	}
	
	private static double calcula (int x, double y) {
		double div = x / y;
		x = 10;
		System.out.println("X en metodo = " + x);
		return div;
	}
	
	public static void cambia (String frase) {
		frase = "Adios";
	}
	
	public static boolean esPrimo(int x) {
		for (int i = 2; i < x; i++) {
			if ((x % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
