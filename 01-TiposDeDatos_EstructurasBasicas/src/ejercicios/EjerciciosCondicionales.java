package ejercicios;

import java.util.Scanner;

public class EjerciciosCondicionales 
	{

	public EjerciciosCondicionales() 
		{
		Scanner leer = new Scanner(System.in);	
		
/*
 		
 		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 1 - - - - - - - - -");
		// Programa que pida por teclado un di de la semana y diga que asignatura toca a primera hora ese dia
		
		int num = 0;
		
		System.out.println("");
		System.out.println(" -------------------------------");
		System.out.println(" |  Elige una opcion  (1 - 5)  |");
		System.out.println(" -------------------------------");
		System.out.println(" | 1 - Lunes                   |");
		System.out.println(" | 2 - Martes                  |");
		System.out.println(" | 3 - Miercoles               |");
		System.out.println(" | 4 - Jueves                  |");
		System.out.println(" | 5 - Viernes                 |");
		System.out.println(" -------------------------------");
		
		num = leer.nextInt();
		
		switch (num)
			{
			case 1:
				System.out.println("");
				System.out.println("La asignatura que toca a primera hora el lunes es Programacion");
				break;
			case 2:
				System.out.println("");
				System.out.println("La asignatura que toca a primera hora el Martes es Lenguaje de marcas");
				break;
			case 3:
				System.out.println("");
				System.out.println("La asignatura que toca a primera hora el Miercoles es Base de datos");
				break;
			case 4:
				System.out.println("");
				System.out.println("La asignatura que toca a primera hora el Jueves es Sistemas Informaticos");
				break;
			case 5:
				System.out.println("");
				System.out.println("La asignatura que toca a primera hora el Viernes es Programacion");
				break;
			default:
				System.out.println("");
				System.out.println("Has introducido un dato no valido");
			}
			
*/

/*

		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 2 - - - - - - - - -");
		// Realiza un programa que pida una hora por teclado y que muestre luego buenos días, buenas tardes o buenas noches según la hora. 
		// Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5 respectivamente. Sólo se tienen encuenta las horas, los minutos no se 
		// deben introducir por teclado.
		
		int hora = 0;
		
		System.out.print("¿Que hora es? ");
		hora = leer.nextInt();
		
		if (hora >= 6 && hora <= 12)
			{
			System.out.println("Buenos dias");
			}
		else if (hora >= 13 && hora <= 20)
			{
			System.out.println("Buenas tardes");
			}
		else if (hora >= 21 && hora <= 23 || hora >= 0 && hora <= 5)
			{
			System.out.println("Buenas noches");
			}
		else
			{
			System.out.println("Has introducido una hora no válida. Las horas deben estar entre 0 y 23");
			}
		
*/

/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 3 - - - - - - - - -");
		// Escribe un programa que calcule el salario semanal de un trabajador teniendo en cuenta que las horas ordinarias 
		// (40 primeras horas de trabajo) se pagan a 12 euros la hora. A partir de la hora 41, se pagan a 16 euros la hora.
		
		int horas = 0, sal = 0;
		
		System.out.print("¿Cuantas horas has trabajado esta semana?");
		horas =leer.nextInt();
		
		if (horas <= 40)
			{
			sal = horas *12;
			System.out.println("");
			System.out.println("Tu salario semanal es " + sal);
			}
		else if (horas > 40 && horas <= 168)
			{
			horas -= 40;
			sal = (40 * 12) + (horas * 16);
			System.out.println("Tu salario semanal es " + sal);
			}
		else
			{
			System.out.println("");
			System.out.println("Has introducido un numero no valido de horas. La semana solo tiene 168 horas.");
			System.out.println("Es imposible que hayas trabajado " + horas + " horas");
			}
		
*/
		
/*		
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 4 - - - - - - - - -");
		// Escribe un programa que nos diga el horóscopo a partir del día y el mes de nacimiento.
		
		int dia = 0, mes = 0;
		
		System.out.print("¿Que dia naciste? ");
		dia = leer.nextInt();
		
		System.out.print("¿Y en que mes (1-12)? ");
		mes = leer.nextInt();
		
		switch (mes)
			{
			case 1:
				if (dia >= 1 && dia <= 19)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Capricornio");
					}
				else if (dia >= 20 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Acuario");
					}
				else
					{
					System.out.println("");
					System.out.println("Enero no tiene " + dia + " dias");
					}
				break;
				
			case 2:
				if (dia >= 1 && dia <= 18)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Acuario");
					}
				else if (dia >= 19 && dia <= 29)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Piscis");
					}
				else
					{
					System.out.println("");
					System.out.println("Febrero no tiene " + dia + " dias");
					}
				break;
				
			case 3:
				if (dia >= 1 && dia <= 20)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Piscis");
					}
				else if (dia >= 21 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Aries");
					}
				else
					{
					System.out.println("");
					System.out.println("Marzo no tiene " + dia + " dias");
					}
				break;
				
			case 4:
				if (dia >= 1 && dia <= 19)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Aries");
					}
				else if (dia >= 20 && dia <= 30)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Tauro");
					}
				else
					{
					System.out.println("");
					System.out.println("Abril no tiene " + dia + " dias");
					}
				break;
				
			case 5:
				if (dia >= 1 && dia <= 20)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Tauro");
					}
				else if (dia >= 21 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Géminis");
					}
				else
					{
					System.out.println("");
					System.out.println("Mayo no tiene " + dia + " dias");
					}
				break;
				
			case 6:
				if (dia >= 1 && dia <= 20)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Géminis");
					}
				else if (dia >= 21 && dia <= 30)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Cáncer");
					}
				else
					{
					System.out.println("");
					System.out.println("Junio no tiene " + dia + " dias");
					}
				break;
				
			case 7:
				if (dia >= 1 && dia <= 22)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Cáncer");
					}
				else if (dia >= 23 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Leo");
					}
				else
					{
					System.out.println("");
					System.out.println("Julio no tiene " + dia + " dias");
					}
				break;
				
			case 8:
				if (dia >= 1 && dia <= 22)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Leo");
					}
				else if (dia >= 23 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Virgo");
					}
				else
					{
					System.out.println("");
					System.out.println("Agosto no tiene " + dia + " dias");
					}
				break;
				
			case 9:
				if (dia >= 1 && dia <= 22)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Virgo");
					}
				else if (dia >= 23 && dia <= 30)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Libra");
					}
				else
					{
					System.out.println("");
					System.out.println("Septiembre no tiene " + dia + " dias");
					}
				break;
				
			case 10:
				if (dia >= 1 && dia <= 22)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Libra");
					}
				else if (dia >= 23 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Escorpio");
					}
				else
					{
					System.out.println("");
					System.out.println("Octubre no tiene " + dia + " dias");
					}
				break;
				
			case 11:
				if (dia >= 1 && dia <= 21)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Escorpio");
					}
				else if (dia >= 22 && dia <= 30)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Sagitario");
					}
				else
					{
					System.out.println("");
					System.out.println("Noviembre no tiene " + dia + " dias");
					}
				break;
				
			case 12:
				if (dia >= 1 && dia <= 21)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Sagitario");
					}
				else if (dia >= 22 && dia <= 31)
					{
					System.out.println("");
					System.out.println("Tu signo del zodiaco es Capricornio");
					}
				else
					{
					System.out.println("");
					System.out.println("Noviembre no tiene " + dia + " dias");
					}
				break;
				
			default:
				System.out.println("El mes con nº " + mes + " no existe");
				break;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 5 - - - - - - - - -");
		// Escribe un programa que dada una hora determinada (horas y minutos), calcule los segundos que faltan para llegar a la medianoche.
		
		int hora = 0, mins = 0, medNoche = 0;
		
		System.out.println("CUANTOS MINUTOS QUEDAN PARA MEDIA NOCHE (00:00)");
		System.out.println("Basandonos en un sistema horario de 24 horas donde las horas pueden ser 0-23 y los minutos 0-59, introduce:");
		System.out.println("");
		
		System.out.print("- Hora:");
		hora = leer.nextInt();
		
		System.out.print("- Minutos:");
		mins = leer.nextInt();
		
		if (mins >= 0 && mins <= 59) //Hace acciones, una vez se comprueban los minutos
			{
			if (hora >= 1 && hora <= 23)//Hace acciones, una vez se comprueban las horas
				{
				if (mins == 0)
					{
					medNoche = 24 - hora;
					medNoche *= 3600;
					System.out.println("Quedan " + medNoche + " segundos para medianoche");
					}
				else
					{
					hora ++;
					hora = 24 - hora;
					hora *= 3600;
					
					mins = 60 - mins;
					mins *= 60;
					
					medNoche = hora + mins;
					
					System.out.println("Quedan " + medNoche + " segundos para medianoche");
					}
				}
			else if (hora == 0 && mins == 0)//Comprueba si la hora introducida es medianoche
				{
				System.out.println("Ya es media noche");
				}
			else
				{
				System.out.println("Has introducido un numero correcto de minutos pero invalido de horas");
				}
			}
		
		else //Comprueba y manda un mensaje si has introducido un numero incorrecto
			{
			if (hora >= 24 || hora < 0)
				{
				System.out.println("Has introducido un numero invalido de horas y minutos");
				}
			else
				{
				System.out.println("Has introducido un numero correcto de horas pero invalido de minutos");
				}
			}
		
*/		
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 6 - - - - - - - - -");
		// Escribe un programa que ordene tres números enteros introducidos por teclado.
		
		int num1 = 0, num2 = 0, num3 = 0, opcion = 0, primero = 0, segundo = 0, tercero = 0;
		
		System.out.println("");
		
		System.out.print("Introduce el primer numero: ");
		num1 = leer.nextInt();
		
		System.out.print("Introduce el segundo numero: ");
		num2 = leer.nextInt();
		
		System.out.print("Introduce el tercer numero: ");
		num3 = leer.nextInt();

		
		if (num1 > num2 && num1 > num3)
	 			{
	 			tercero = num1;
		 			
		 		if (num2 > num3)
		 			{
		 			primero = num3;
					segundo = num2;
	 				}
	 			else 
	 				{
	 				primero = num2;
	 				segundo = num3;
	 				}
	 			}
		 		
	 		else if (num1 < num2 && num1 < num3)
	 			{
	 			primero = num1;
		 			
	 			if (num2 < num3)
	 				{
	 				segundo = num2;
	 				tercero = num3;
	 				}
	 			else 
	 				{
	 				segundo = num3;
	 				tercero = num2;
	 				}
	 			}
		 		
	 		else if (num1 > num2 && num1 < num3)
				{
	 			primero = num2;
	 			segundo = num1;
	 			tercero = num3;
				}
		
	 		else if (num1 < num2 && num1 > num3)
				{
	 			primero = num3;
	 			segundo = num1;
	 			tercero = num2;
				}
		
	 		else //Algun numero es igual que otro o todos son iguales
	 			{
	 			if (num1 == num2)
	 				{
	 				if (num1 > num3)
	 					{
	 					primero = num3;
	 					segundo = num1;
	 					tercero = num2;
	 					}
	 				else
	 					{
	 					primero = num1;
	 					segundo = num2;
	 					tercero = num3;
	 					}
	 				}
	 			
	 			else if (num1 == num3)
 					{
	 				if (num1 > num2)
	 					{
	 					primero = num2;
	 					segundo = num1;
	 					tercero = num3;
	 					}
	 				else
	 					{
	 					primero = num1;
	 					segundo = num3;
	 					tercero = num2;
	 					}
 					}
	 			
	 			else if (num2 == num3)
					{
	 				if (num2 > num3)
	 					{
	 					primero = num1;
	 					segundo = num2;
	 					tercero = num3;
	 					}
	 				else
	 					{
	 					primero = num2;
	 					segundo = num3;
	 					tercero = num1;
	 					}
					}
	 			else
	 				{
	 				primero = num1;
	 				segundo = num2;
	 				tercero = num3;
	 				}
 				}
	 			
		 		
	 		System.out.println(primero + ", " + segundo + ", " + tercero);
	
*/

/*
		//Forma mas optima de ordenar

		int a = 0, b = 0, c = 0, aux = 0;
		
		System.out.print("Introduce un valor para a: ");
		a = leer.nextInt();
		
		System.out.print("Introduce un valor para b: ");
		b = leer.nextInt();
		
		System.out.print("Introduce un valor para c: ");
		c = leer.nextInt();
		
		if (a > b)
			{
			aux = a;
			a = b;
			b = aux;
			}
		
		if (b > c)
			{
			aux = b;
			b = c;
			c = aux;
			}
		
		if (a > b)
			{
			aux = a;
			a = b;
			b = aux;
			}
		
		System.out.println(a + ", " + b + ", " +c);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 7 - - - - - - - - -");
		// Escribe un programa que diga cuál es la última cifra de un número entero introducido por teclado.
		
		int num = 0, resto = 0;
		
		System.out.println("Dime un numero: ");
		num = leer.nextInt();
		
		resto = num % 10;

		System.out.println("La ultima cifra de " + num + " es: " + resto);
		
*/
		
/*		
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 8 - - - - - - - - -");
		// Escribe un programa que diga cuál es la primera cifra de un número entero introducido por teclado. Se permiten números de hasta 5 cifras.
		
		int num = 0, div = 0;
		
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		if (num < 100000 && num >= 0)
			{
			if (num < 10)
				{
				div = num;
				}
			else if (num >= 10 && num < 100)
				{
				div = num / 10;
				}
			else if (num >= 100 && num < 1000)
				{
				div = num / 100;
				}
			else if (num >= 1000 && num < 10000)
				{
				div = num / 1000;
				}
			else
				{
				div = num / 10000;
				}
			
			System.out.println("El primer digito de " + num + " es " + div);
			}
		else
			{
			System.out.println("Has introducido un numero incorrecto, no puede tener mas de 5 digitos ni ser negativo");
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 9 - - - - - - - - -");
		// Realiza un programa que nos diga cuántos dígitos tiene un número entero que puede ser positivo o negativo. 
		// Se permiten números de hasta 5 dígitos.

		// SOLUCION CON BUCLES
		int num1 = 0, cont = 1;
		
		System.out.print("Introduce un numero: ");
		num1 = leer.nextInt();
		
		if (num1 > -100000 && num1 < 100000)
			{
			
			while(num1 >= 10 || num1 <= -10)
				{
				cont ++;
				num1 /= 10;
				}
			
			System.out.println("El numero que has introducido tiene " + cont + " cifras");
			}
			
		else
			{
			System.out.println("Has introducido un numero de mas de 5 cifras");
		 	}
			
		
		
		// SOLUCION SIN BUCLES
		int num = 0, digitos = 0;
		
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		if (num < 0)
			{
			num *= -1;
			}
		else
			{
			}
		
		
		if (num < 100000)
			{
			if (num < 10 && num > -10)
				{
				digitos = 1;
				}
			
			else if (num >= 10 && num < 100)
				{
				digitos = 2;
				}

			else if (num >= 100 && num < 1000)
				{
				digitos = 3;
				}
		
			else if (num >= 1000 && num < 10000)
				{
				digitos = 4;
				}
			
			else if (num >= 10000 && num < 100000)
				{
				digitos = 5;
				}
			
			System.out.println("El numero introducido tiene " + digitos + " cifras");
			}
		
		else
			{
			System.out.println("Has introducido un numero de mas de 5 cifras");
		 	}
		
*/		
		
/*		
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 10 - - - - - - - - -");
		// Realiza un programa que diga si un número entero positivo introducido por teclado es capicúa. Se permiten números de hasta 5 cifras.
		
		int num = 0, cif1 = 0, cif2 = 0, cif3 = 0, cif4 = 0;
		boolean esCapicuo = true;
		
		System.out.print("Dime un numero: ");
		num = leer.nextInt();
		
		if (num>= 0 && num < 100000)
			{
			if(num < 10)
				{
				esCapicuo = true;
				}
			
			else if (num >= 10 && num < 100)
				{
				cif1 = num / 10;
				cif2 = num % 10;
				esCapicuo = cif1 == cif2;
				}
			
			else if (num >= 100 && num < 1000)
				{
				cif1 = num / 100;
				cif2 = num % 10;
				esCapicuo = cif1 == cif2;
				}
			
			else if (num >= 1000 && num < 10000)
				{
				cif3 = num % 100;
				cif4 = cif3 %10;
				cif3 /=10;
				
				cif2 = num / 100;
				cif1 = cif2 / 10;
				cif2 %= 10;
				}
			
			else if (num >= 10000 && num < 100000)
				{
				cif3 = num % 100;
				cif4 = cif3 %10;
				cif3 /=10;
				
				cif2 = num / 1000;
				cif1 = cif2 / 10;
				cif2 %= 10;
				}
			
			//------ Mostrar resultados
			
			if (esCapicuo)
				{
				System.out.println("El numero es capicuo");
				}
			else 
				{
				System.out.println("El numero no es capicuo");
				}
			
			}
		
		else
			{
			System.out.println("El numero que has introducido no es valido");
			}
		
*/
		
/*

		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 11 - - - - - - - - -");
		// Escribe un programa que calcule el precio final de un producto según su base imponible (precio antes de impuestos), el tipo de 
		// IVA aplicado (general, reducido o superreducido) y el código promocional. Los tipos de IVA general, reducido y superreducido son 
		// del 21%, 10% y 4% respectivamente. Los códigos promocionales pueden ser nopro, mitad, meno5 o 5porc que significan respectivamente 
		// que no se aplica promoción, el precio se reduce a la mitad, se descuentan 5 euros o se descuenta el 5%. El ejercicio se da por bueno 
		// si se muestran los valores correctos, aunque los números no estén tabulados.
		
		int opIva = 0, opCodProm = 0;
		double iva = 0, prom = 0, base = 0, precio = 0;
		String cod = "";
		
		System.out.print("Introduce la base imponible (precio del producto antes de impuestos): ");
		base = leer.nextDouble();
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                 ELIGE TASA DE IVA (1 - 3)                  |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("| 1 - General                                                |");
		System.out.println("| 2 - Reducido                                               |");
		System.out.println("| 3 - Superreducido                                          |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("");
		
		opIva = leer.nextInt();
		
		switch (opIva)
			{
			case 1:
				iva = 0.21;
				break;
				
			case 2:
				iva = 0.10;
				break;
				
			case 3:
				iva = 0.04;
				break;
			}
		
		precio = base + (base * iva);
				
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                 ELIGE UN DESCUENTO (1 - 4)                 |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("| 1 - nopro                                                  |");
		System.out.println("| 2 - mitad                                                  |");
		System.out.println("| 3 - meno5                                                  |");
		System.out.println("| 4 - 5porc                                                  |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("");
		
		opCodProm = leer.nextInt();
		
		switch (opCodProm)
		{
		case 1:
			cod = "nopro";
			break;
			
		case 2:
			prom = precio / 2;
			cod = "mitad";
			break;
			
		case 3:
			prom = precio - 5;
			cod = "meno5";
			break;
			
		case 4:
			prom = precio * 0.95;
			cod = "5porc";
			break;
		}
		
		precio -= prom;
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                        RESULTADOS                          |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("| Base Imponible = " + base + "€");
		System.out.println("| IVA (" + (iva * 100) + "%) = " + (base * iva) + "€");
		System.out.println("| Precio con IVA = " + (base + (base * iva)) + "€");
		System.out.println("| Codigo promocional (" + cod + ") = - " + prom + "€");
		System.out.println("|");
		System.out.println("| TOTAL = " + precio + "€");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 12 - - - - - - - - -");
		// Escribe un programa que genere la nómina (bien desglosada) de un empleado según las siguientes condiciones:
		// • Se pregunta el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 – Jefe de proyecto), los días que ha estado de
		//   viaje visitando clientes durante el mes y su estado civil (1 - Soltero, 2 - Casado).
		// • El sueldo base según el cargo es de 950, 1200 y 1600 euros según si se trata d e un prog. junior, un prog. senior o un
		//   jefe de proyecto respectivamente.
		// • Por cada día de viaje visitando clientes se pagan 30 euros extra en concepto de dietas. Al sueldo neto hay que restarle
		//   el IRPF, que será deun 25% en caso de estar soltero y un 20% en caso de estar casado.
		
		int cargoEmp = 0, estadoCivil = 0;
		double salBase = 0, salBruto = 0, salNeto = 0;
		double diaExtr = 0, dietas = 0;
		double irpf = 0, retenIrpf = 0;
	
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                   ELIGE TU CARGO (1 - 3)                   |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("| 1 - Programador Jr.                                        |");
		System.out.println("| 2 - Programador Senior                                     |");
		System.out.println("| 3 - Jefe de proyecto                                       |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("");
		
		cargoEmp = leer.nextInt();
		
		switch (cargoEmp)
			{
			case 1:
				salBase = 950;
				break;
				
			case 2:
				salBase = 1200;
				break;
				
			case 3:
				salBase = 1600;
				break;
			}
		
		System.out.println("¿Cuantos dias has estado visitando a clientes? ");
		diaExtr = leer.nextDouble();
		
		dietas = diaExtr * 30;
		salBruto = salBase + dietas;
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                ELIGE TU ESTADO CIVIL (1 - 2)               |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("| 1 - Soltero                                                |");
		System.out.println("| 2 - Casado                                                 |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("");
		
		cargoEmp = leer.nextInt();
		
		switch (cargoEmp)
			{
			case 1:
				irpf = 0.25;
				break;
				
			case 2:
				irpf = 0.2;
				break;
			}
		
		retenIrpf = salBruto * irpf;
		salNeto = salBruto - retenIrpf;
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("|                           NOMINA                           |");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("______________________________________________________________");
		System.out.println("                                                  GANANCIAS");
		System.out.println("");
		System.out.println(" Salario base ___________________________________ " + salBase + "€");
		System.out.println(" Dietas _________________________________________ " + dietas + "€");
		System.out.println("");
		System.out.println("                             Salario bruto ______ " + salBruto + "€");
		System.out.println("______________________________________________________________");
		System.out.println("                                                  DEDUCCIONES");
		System.out.println("");
		System.out.println(" IRPF (" + (irpf * 100) + "%) ___________________________________ " + retenIrpf + "€");
		System.out.println("");
		System.out.println("                         Total deducciones ______ " + retenIrpf + "€");
		System.out.println("______________________________________________________________");
		System.out.println("                                                  SALARIO NETO");
		System.out.println("");
		System.out.println("                                                  " + salNeto + "€");
		
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}
