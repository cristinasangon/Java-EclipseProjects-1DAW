package ejercicios;

import java.util.Scanner;

public class Ejercicio2Bucles 
	{

	public Ejercicio2Bucles() 
		{
		/* Bucle do while que termina cuando se introduce por teclado un numero impar */
		
		double num = 0, suma = 0;
		int cont = 0, resto = 0;
		Scanner leer = new Scanner(System.in);
		
		do
			{
			System.out.print("INTRODUCE UN NUMERO: ");
			num = leer.nextDouble();
			cont++;
			resto = (int) (num % 2);
			suma += num;
			}
		while (resto == 0);
		
		System.out.println("");
		if ((cont -1) > 0)
			{
			System.out.println("Has introducido " + (cont - 1) + " numeros pares");
			System.out.println("La suma de todos los numeros pares es " + (suma - num));
			}
		else
			{System.out.println("El unico numero que has introducido es impar");}
		
		
		
		}

	}
