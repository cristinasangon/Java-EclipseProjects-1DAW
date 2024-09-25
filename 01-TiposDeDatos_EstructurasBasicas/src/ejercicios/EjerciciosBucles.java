package ejercicios;

import java.util.Scanner;

public class EjerciciosBucles 
	{

	public EjerciciosBucles() 
		{
		Scanner leer = new Scanner(System.in);

/*

		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 1 - - - - - - - - -");
		// Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle for.,while y do while
		
		//SOLUCION CON BUCLE FOR
		int cont = 0;
		
		System.out.println("");
		for (int x = 1; x < 101; x ++)
			{
			cont = x;
			cont %= 10;
			if (cont == 0 || cont == 5)
				{
				System.out.print(x + ", ");
				}
			}
		
		//SOLUCION CON BUCLE WHILE
		cont = 0;
		int x = 1;
		
		System.out.println("");
		System.out.println("");
		while (x < 101)
			{
			cont = x;
			cont %= 10;
			if (cont == 0 || cont == 5)
				{
				System.out.print(x + ", ");
				}
			x++;
			}
		
		//SOLUCION CON BUCLE DO WHILE
		cont = 0;
		x = 1;
		
		System.out.println("");
		System.out.println("");
		do
			{
			cont = x;
			cont %= 10;
			if (cont == 0 || cont == 5)
				{
				System.out.print(x + ", ");
				}
			x++;
			}
		while (x < 101);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 2 - - - - - - - - -");
		// Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás utilizando un bucle while.
		
		int num = 320;
		
		System.out.println("");
		while (num <= 320 && num >= 160)
			{
			System.out.print(num + ", ");
			num -=20;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 3 - - - - - - - - -");
		// Realiza el control de acceso a una caja fuerte. La combinación será un número de 4 cifras. El programa nos pedirá la combinación 
		// para abrirla. Si no acertamos, se nos mostrará el mensaje “Lo siento, esa no es la combinación”y si acertamos se nos dirá 
		// “La caja fuerte se ha abierto satisfactoriamente”.Tendremos cuatro oportunidades para abrir la caja fuerte.
		
		int intentos = 3, comb = 0, combReal = 1111; 
		
		System.out.println("");
		System.out.print("Introduce la combinacion: ");
		comb = leer.nextInt();
		
		if (combReal == comb) 
			{
			System.out.println("");
			System.out.println("La caja fuerte se ha abierto satisfactoriamente");
			}
		
		else
			{
			while (combReal != comb)
				{
				System.out.println("Intento fallido, te quedan " + intentos + " intentos");
				System.out.print("Introduce la combinacion: ");
				comb = leer.nextInt();
				intentos --;
				}
			}
		
		if (intentos == 0)
			{
			System.out.println("");
			System.out.println("Intentos agotados, la caja se ha bloqueado");
			}
		else
			{
			System.out.println("");
			System.out.println("La caja fuerte se ha abierto satisfactoriamente");
			}

*/
	
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 4 - - - - - - - - -");
		// Realiza un programa que nos diga cuántos dígitos tiene un número introducido por teclado. Este ejercicio es equivalente a otro realizado 
		// anteriormente, con la salvedad de que el anterior estaba limitado a números de 5 dígitos como máximo. En esta ocasión, hay que realizar 
		// el ejercicio utilizando bucles; de esta manera, la única limitación en el número de dígitos la establece el tipo de dato que se 
		// utilice (int o long.
		
		int num = 0, cont = 1;
		
		System.out.println("");
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		while (num <= -10 || num >= 10)
			{
			num /= 10;
			cont ++;
			}
		
		System.out.println("");
		System.out.println("El numero que has introducido tiene " + cont + " digitos");
		
*/	

/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 5 - - - - - - - - -");
		// Escribe un programa que calcule la media de un conjunto de números positivos introducidos por teclado. A priori, el programa no sabe 
		// cuántos números se introducirán. El usuario indicará que ha terminado de introducir los datos cuando meta un número negativo.
		
		int num = 0, cont = 0, suma = 0;
		
		System.out.println("");
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		if (num >= 0)
			{
			while (num >= 0)
				{
				suma += num;
				cont ++;
				System.out.print("Introduce otro numero: ");
				num = leer.nextInt();
				}
			
			suma /= cont;
			System.out.println("La media de tus numeros es: " + suma);
			}
		
		else
			{
			suma = 0;
			System.out.println("ERROR: El primer numero debe ser positivo");
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 6 - - - - - - - - -");
		// Escribe un programa que muestre los n primeros términos de la serie de Fibonacci. El primer término de la serie de Fibonacci es 0, el 
		// segundo es 1 y el resto se calcula sumando los dos anteriores, por lo que tendríamos que los términos son 0, 1, 1, 2, 3, 5, 8, 13, 
		// 21, 34, 55, 89, 144... El número n se debe introducir por teclado.
		
		int cant = 0, fibo = 0, ant = 0, sig = 1;
		
		System.out.println("");
		System.out.print("Dime la cantidad de numeros fibonacci que quieres mostrar: ");
		cant = leer.nextInt();
		
		System.out.print(fibo + ", ");
		cant--;
		
		while (cant > 0)
			{
			fibo = ant + sig;
			System.out.print(fibo + ", ");
			
			sig = ant;
			ant = fibo;
			fibo = 0;
			cant --;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 7 - - - - - - - - -");
		// Escribe un programa que diga si un número introducido por teclado es o no primo. Un número primo es aquel que sólo es divisible 
		// entre él mismo y la unidad.
		
		int divid = 0, divis = 0, resto = 0;
		boolean esPrimo = true;
		
		System.out.println("");
		System.out.print("Dime un numero: ");
		divid = leer.nextInt();
		
		for(divis = 2; divis < divid; divis ++)
			{
			resto = divid % divis;
			
			if (resto == 0)
				{
				esPrimo = false;
				}
			}
		
		System.out.println("");
		if(esPrimo = true)
			{
			System.out.println(divid + " es un numero primo");
			}
		else
			{
			System.out.println(divid + " no es un numero primo");	
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 8 - - - - - - - - -");
		// Escribe un programa que diga si un número introducido por teclado es o no primo. Un número primo es aquel que sólo es divisible 
		// entre él mismo y la unidad.
		
		int num1 = 0, num2 = 0, x = 0, rango = 0;
		
		
		System.out.println("");
		System.out.print("Dime el primer numero: ");
		num1 = leer.nextInt();
		
		System.out.print("Dime el segundo numero: ");
		num2 = leer.nextInt();
		
		if (num1 != num2)
			{
			if (num2 < num1)
				{
				x = num1;
				num1 = num2;
				num2 = x;
				}
			else 
				{
				//No hace nada
				}
			rango = num1;
			
			while (rango >= num1 && rango <= num2)
				{
				System.out.println("");
				System.out.print(rango + ", ");
				rango += 7;
				}
			}
		
		else
			{
			System.out.println("");
			System.out.println("ERROR: Has introducido dos numeros iguales.");
			}
			
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 9 - - - - - - - - -");
		// Realiza un programa que vaya pidiendo números hasta que se introduzca un numero negativo y nos diga cuantos números se han introducido, 
		// la media de los impares y el mayor de los pares. El número negativo sólo se utiliza para indicar el final de la introducción de datos 
		// pero no se incluye en el cómputo.
		
		int num = 0, cont = 0, mod = 0, mayorPar = 0, sumaImpar = 0, contImpar = 0;
		
		System.out.println("");
		System.out.print("Dime un numero: ");
		num = leer.nextInt();
		
		while (num >= 0)
			{
			cont ++;
			mod = num % 2;
			
			if (mod == 0)
				{
				if (num > mayorPar)
					{
					mayorPar = num;
					}
				else 
					{
					//No hace nada
					}
				}
			
			else
				{
				contImpar ++;
				sumaImpar += num;
				}
			
			System.out.print("Dime otro numero: ");
			num = leer.nextInt();
			}
		
		System.out.println("");
		System.out.println("Total de numeros: " + cont);
		System.out.println("Media de numeros impares: " + (sumaImpar / contImpar));
		System.out.println("Mayor de numeros pares: " + mayorPar);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 10 - - - - - - - - -");
		// Realiza un programa que pida un número por teclado y que luego muestre ese número al revés.
		int num = 0, resto = 0, rev = 0;
		
		System.out.println("");
		System.out.print("Dime un numero: ");
		num = leer.nextInt();
		
		while (num > 0)
			{
			resto = num %10;
			rev = (rev * 10) + resto;
			num /= 10;
			}
		
		System.out.println(rev);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 11 - - - - - - - - -");
		// Realiza un programa que pida primero un número y a continuación un dígito. El programa nos debe dar la posición (o posiciones) contando 
		// de izquierda a derecha que ocupa ese dígito en el número introducido.
		
		int num = 0, digito = 0, cont = 1, cifras = 0, vuelta = 0, ultimo = 0;
		
		System.out.println("");
		System.out.print("Dime un numero: ");
		num = leer.nextInt();
		
		System.out.println("");
		System.out.print("Dime un digito de es numero: ");
		digito = leer.nextInt();
		
		cifras = num;
		
		while (cifras > 0)
			{
			cifras /= 10;
			cont ++;
			}
		
		cifras = cont;
		
		for (cont = cont; cont > 0; cont--)
			{
			vuelta ++;
			ultimo = num % 10;
			num /= 10;
			
			if (ultimo == digito)
				{
				System.out.println("Tu digito está en la posicion nº " + (cifras - vuelta));
				}
			else
				{
				//No hace nada
				}
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 12 - - - - - - - - -");
		// Escribe un programa que calcule el factorial de un número entero leído por teclado.	
		
		int num = 0, cont = 1, cant = 0, factorial = 1;
		
		System.out.println("");
		System.out.print("Dime un numero: ");
		num = leer.nextInt();
		
		for (cant = num; cant > 0; cant--)
			{
			factorial *= cont;
			cont ++;
			}
		
		System.out.println("El factorial de " + num + " es " + factorial);
		
*/
		
		}

	}
