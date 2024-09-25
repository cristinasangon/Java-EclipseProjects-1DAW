package ejercicios;

import java.util.Scanner;

public class Ejercicio1Bucles 
	{
	
	/* Bucle while que termine cuando se introduce un numero negativo. Al terminar, muestra la cantidad y suma de numeros introducidos*/

	public Ejercicio1Bucles() 
		{
		Scanner leer = new Scanner(System.in);
		int cont = 0;
		double suma = 0, num = 0;
		
		System.out.println("INTRODUCE UN NUMERO: ");
		num = leer.nextDouble();
		
		while (num >= 0)
			{
			cont++;
			suma = suma + num;
			System.out.println("INTRODUCE OTRO NUMERO: ");
			num = leer.nextDouble();
			}
		
		System.out.println("Has introducido " + cont + " numeros positivos y la suma de todos es " + suma);
		}

	}
