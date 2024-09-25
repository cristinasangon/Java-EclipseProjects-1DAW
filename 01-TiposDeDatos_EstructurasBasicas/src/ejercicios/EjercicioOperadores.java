package ejercicios;

import java.util.Scanner;

public class EjercicioOperadores 
	{

	public EjercicioOperadores() 
		{
		//Realiza un programa que calcule la nota que hace falta sacar en el segundo examen de la asignatura Programacion para obtener la media deseada.
		// Hay que tener en cuenta que la nota del primer examen cuenta el 40% y la del segundo un 60%
		
		double media = 0, nota1 = 0, nota2 = 0;
		
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Dime la nota media que quieres obtener: ");
		media = leer.nextDouble();
		
		System.out.print("Dime la nota que has sacado en el primer examen: ");
		nota1 = leer.nextDouble();
		
		nota2 = (media - ( nota1 * 0.4)) / 0.6;
		
		System.out.println("");
		System.out.println("Tienes que sacar un " + nota2 + " en el proximo examen para alcanzar tu media deseada");
		
		
		
		
		
		
		
		
		}

	}
