package tiposDeDatos;

import java.util.Scanner;

public class EstudioEstructurasRepeticion 
	{

	public EstudioEstructurasRepeticion() 
		{
		System.out.println("_____________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - ESTRUCTURAS DE REPETICION - - - - - - -");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- FOR");
		
		System.out.print("  Mi bucle avanza de 1 en 1 hasta 10: ");
		for(int i = 1; i < 11; i++)
			{
			System.out.print(i + ", ");
			}
		
		System.out.println("");
		System.out.print("  Mi bucle avanza de 2 en 2 hasta 10: ");
		for(int i = 2; i < 11; i += 2)
			{
			System.out.print(i + ", ");
			}
		
		System.out.println("");
		System.out.print("  Mi bucle avanza de 10 hasta 1 de 1 en 1: ");
		for(int i = 10; i > 0; i--)
			{
			System.out.print(i + ", ");
			}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("- WHILE");
		int i = 1;
		
		System.out.print("  Mi bucle avanza de de 1 en 1 hasta 10: ");//Simula bucle for
		while (i < 11)//Simula bucle for pero while es mas potente
			{
			System.out.print(i + ", ");
			i++;
			}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("- DO WHILE");
		i = 1;
		
		System.out.print("  Mi bucle avanza de de 1 en 1 hasta 10: ");
		do
			{
			System.out.print(i + ", ");
			i++;
			}
		while (i < 11);
		
		
		
		
		System.out.println("");
		System.out.println("_____________________________________________________");
		}
	}
