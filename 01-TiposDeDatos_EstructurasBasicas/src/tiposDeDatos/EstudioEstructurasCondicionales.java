package tiposDeDatos;

import java.util.Scanner;

public class EstudioEstructurasCondicionales 
	{

	public EstudioEstructurasCondicionales() 
		{
		System.out.println("_____________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - ESTRUCTURAS CONDICIONALES - - - - - - -");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- IF ELSE");
		
		Scanner leer = new Scanner(System.in);
		
		System.out.print("  ¿Cual es la capital de España?");
		String respuesta = leer.next();
		
		if (respuesta.equals("Madrid"))
			{
			System.out.println("  La respuesta es correcta");
			}	
		else
			{
			System.out.println("  La respuesta es incorrecta");
			}
		
		System.out.print("  Dime tu edad");
		int edad = leer.nextInt();
		
		if (edad >= 18)
			{
			System.out.println("  Eres mayor de edad, puedes sacarte el carnet de conducir");
			}
		else
			{
			System.out.println("  Vaya, aun no tienes la edad para sacarte el carnet de conducir");
			}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- IF ELSE-IF ELSE");
		
		System.out.print("  Introduce la edad del jugador nº 1: ");
		int edadJ1 = leer.nextInt();
		
		System.out.print("  Introduce la edad del jugador nº 2: ");
		int edadJ2 = leer.nextInt();
		System.out.println("");
		
		if (edadJ1 >= 12 && edadJ2 >= 12)
			{
			System.out.println("  Los dos jugadores pueden jugar");
			}
		
		else if (edadJ1 < 12 && edadJ2 >= 12)
			{
			System.out.println("  El jugador nº 1 no tiene permitido jugar ya que es menor de la edad permitida");
			System.out.println("  El jugador nº 2 puede jugar sin problemas");
			}
		
		else if (edadJ1 >= 12 && edadJ2 < 12)
			{
			System.out.println("  El jugador nº 2 no tiene permitido jugar ya que es menor de la edad permitida");
			System.out.println("  El jugador nº 1 puede jugar sin problemas");
			}
		
		else
			{
			System.out.println("  Lo siento, pero ningun jugador cumple la edad minima");
			}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- SWITCH CASE");
		
		System.out.print("  Introduce un numero de mes");
		int mes = leer.nextInt();
		String nombreMes = "";
		
		switch (mes) 
			{
			case 1:
				nombreMes = "Enero";
				break;
			case 2:
				nombreMes = "Febrero";
				break;
			case 3:
				nombreMes = "Marzo";
				break;
			case 4:
				nombreMes = "Abril";
				break;
			case 5:
				nombreMes = "Mayo";
				break;
			case 6:
				nombreMes = "Junio";
				break;
			case 7:
				nombreMes = "Julio";
				break;
			case 8:
				nombreMes = "Agosto";
				break;
			case 9:
				nombreMes = "Septiembre";
				break;
			case 10:
				nombreMes = "Octubre";
				break;
			case 11:
				nombreMes = "Noviembre";
				break;
			case 12:
				nombreMes = "Diciembre";
				break;
			default:
				nombreMes = "Inexistente";
			}
		
		System.out.println("  El mes con el numero " + mes + " es " + nombreMes);
		System.out.println("");
		
		
		System.out.println("  --------------------");
		System.out.println("  | CALCULO DE ÁREAS |");
		System.out.println("  --------------------");
		System.out.println("  | 1 - Cuadrado     |");
		System.out.println("  | 2 - Rectángulo   |");
		System.out.println("  | 3 - Triángulo    |");
		System.out.println("  --------------------");
		System.out.println("");
		
		System.out.print("  Elige una opcion (1-3): ");
		int opcion = leer.nextInt();
		
		double lado;
		double base;
		double altura;
		
		switch (opcion)
			{
			case 1:
				System.out.print("  Introduce el lado del cuadrado en cm: ");
				lado = leer.nextDouble();
				System.out.println("  El área del cuadrado es " + (lado * lado) + "cm^2");
				break;
				
			case 2:
				System.out.print("  Introduce la base del rectángulo en cm: ");
				base = leer.nextDouble();
				System.out.print("  Introduce la altura del rectángulo en cm: ");
				altura = leer.nextDouble();
				System.out.println("  El área del rectángulo es " + (base * altura) + "cm^2");
				break;
				
			case 3:
				System.out.print("  Introduce la base del triángulo en cm: ");
				base = leer.nextDouble();
				System.out.print("  Introduce la altura del triángulo en cm: ");
				altura = leer.nextDouble();
				System.out.println("  El área del rectángulo es " + ((base * altura) / 2) + "cm^2");
				break;
				
			default:
				System.out.println("  Has introducido una opcion no válida");
			}
		
		
		System.out.println("");
		System.out.println("_____________________________________________________");
		}

	}
