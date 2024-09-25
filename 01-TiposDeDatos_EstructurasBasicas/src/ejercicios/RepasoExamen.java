package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class RepasoExamen {

	public RepasoExamen() {
		Scanner leer = new Scanner (System.in);
		
/*
		System.out.printf("%n EJERCICIO 1 %n %n");
		// Programa que pida una cantidad de números. El programa debe mostrar la cantidad de números solicitada de números de la serie de 
		//    fibonacci mostrando a su lado si es primo o no. Debe decir la cantidad de números primos que hay en esos números fibonacci.

		int ant = 1, sig = 0, fibo = 0, cant = 0, x = 0, cont = 0;
		System.out.print("Dime la cantidad de numeros fibonacci que deseas generar: "); cant = leer.nextInt();
		while(x < cant) {
			System.out.printf("%-2d", fibo);
			fibo = ant + sig;
			ant = sig;
			sig = fibo;
			x++;
			if(esPrimo(fibo) == true) {
				System.out.print(" es primo");
				System.out.println();
				cont ++;
			}
			else {
				System.out.println(" no es primo");
			}
		}
		
		System.out.printf("%nDe %d numeros fibonacci, %d de ellos son primos", cant, cont);
*/

		System.out.printf("%n EJERCICIO 2 %n %n");
		// Programa que pida un número y lo muestre al revés.
		
		System.out.print("Introduce un numero: "); int num = leer.nextInt();
		System.out.print(darVuelta(num));
/*
		System.out.printf("%n EJERCICIO 3 %n %n");
		// Programa que pide un número y un dígito. Debe decir en qué posición de ese número está el dígito introducido.
		int x = 1, d = 0;
		System.out.print("Dime  un numero: "); int num = leer.nextInt();
		System.out.println("Dime un digito: "); int dig = leer.nextInt();
		num = darVuelta(num);
		while(num != 0){
			d = num % 10;
			num /= 10;
			if (d == dig) {
				System.out.printf("Posicion nº %d %n", x);
			}
			x++;
		}
*/
/*
	System.out.printf("%n EJERCICIO 4 %n %n");
	// Programa que calcule el factorial de un número introducido por teclado.
	System.out.print("Dime un numero: "); int num = leer.nextInt();
	System.out.println("Factorial de " + num + ": " + factorial(num));
*/
/*
	System.out.printf("%n EJERCICIO 7 %n %n");
	// Pedir 2 números positivos y hallar el máximo común divisor y el mínimo común múltiplo.
	System.out.println("M.C.D.: " + maxComDiv(4, 12));
	System.out.println("M.C.M: " + ((4 * 12)/maxComDiv(4, 12)));
*/
/*
	System.out.printf("%n EJERCICIO 8 %n %n");
	// Mostrar todos los números binarios representados con 4 bits junto con su valor decimal al lado.
	System.out.println(binarios4Bits(1));
*/
/*
	System.out.printf("%n EJERCICIO 9 %n %n");
	// Pedir un número entero positivo y mostrar todos los números primos entre 2 y dicho número.
	int y = 2, x = 13;
	
	while(y <= x) {
		if(esPrimo(y)) {
			System.out.print(" " + y);
		}
		y++;
	}
*/
/*
	System.out.printf("%n EJERCICIO 10 %n %n");
	// Calcula la progresión geométrica 1 + x +  x^2  + x^3 + … x^n. Siendo ‘x’ y ‘n’ valores introducidos por teclado.
	progGeom(2, 10);
*/
/*
	System.out.printf("%n EJERCICIO 11 %n %n");
	// Programa que pida límites para generar números aleatorios así como la cantidad de números que quiere generar. No se debe repetir ningún número. Almacena los datos generados en un array.
	int[] aleatorios = generaAleatorios(0, 11, 10) ;
	System.out.println(Arrays.toString(aleatorios));
*/
	}	
	//EJERCICIO 1
	public static boolean esPrimo (int num) {
		boolean esPrimo = true; int x = 2;
		if(num == 1) {
			esPrimo = false;
		}
		while(esPrimo == true && x < num) {
			if ((num % x) == 0) {
				esPrimo = false;
			}
			x++;
		}
		return esPrimo;
	}
	
	//EJERCICIO 2, 3
	public static String darVuelta(int num) {
		int dig = 0; String rev = "";
		while(num != 0) {
			dig = num % 10;
			num /= 10;
			rev += dig;
		}
		return rev;
	}
	
	// EJERCICIO 4
	public static long factorial(int num) {
		long fact = 1;
		for(int x = 1; x <= num; x++) {
			fact *= x;
		}
		return fact;
	}
	
	//EJERCICIO 7
	public static int maxComDiv (int a, int b) {
		int aux = 0;
		while(b != 0) {
			aux = b;
			b = a % b;
			a = aux;
		}
		return a;
	}
	
	// EJERCICIO 9 
	public static String binarios4Bits (int x) {
		String bin = ""; int resto = 0;
		for(int y = 0; y < 3; y++) {
			resto = x % 2;
			x /= 2;
			bin = resto + bin;
		}
		bin = x + bin;
		return bin;
	}
	
	// EJERCICIO 10
	public static void progGeom(int x,int n) {
		int acum = 1;
		for (int i = 1; i <= n; i ++) {
			acum *= x;
			System.out.printf("%d^%d = %d %n", x, i, acum);
		}
	}
	
	// EJERCICIO 11
	public static int[] generaAleatorios (int may, int men, int cant) {
		int[] aleatorios = new int[cant]; int x = 0, rand = 0, y = 0; boolean esDif = true;
		
		while(x < aleatorios.length) {
			rand = (int) Math.floor(Math.random()*(may - men + 1) + men);
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
			y = 0;
		}
		return aleatorios;
	}
	
	
	
	
}
