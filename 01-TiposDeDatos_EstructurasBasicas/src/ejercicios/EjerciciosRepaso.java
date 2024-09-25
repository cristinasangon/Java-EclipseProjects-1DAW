package ejercicios;

import java.util.Scanner;

public class EjerciciosRepaso 
	{

	public EjerciciosRepaso() 
		{
		Scanner leer = new Scanner(System.in);
		
/*
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 1 - - - - - - - - -");
		// Introducir un número entero de dos dígitos por teclado. Si es positivo y tiene dos cifras, indicar cuánto suman sus dos dígitos; 
		// si no cumple esas condiciones, mostrar el mensaje: “No es positivo o no tiene dos cifras.”.
		
		int suma = 0, num = 0, dig1 = 0, dig2 = 0;
		
		// CON BUCLE
		System.out.println("");
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		while(num < 9 || num > 99)
			{
			System.out.println("");
			System.out.println("No es positivo o no tiene dos crifas");
			System.out.print("Introduce un numero: ");
			num = leer.nextInt();
			}
		
		dig1 = num / 10;
		dig2 = num % 10;
		suma = dig1 + dig2;
		
		System.out.println("");
		System.out.printf("El numero %d se compone de dos digios, %d y %d cuya suma es %d", num, dig1, dig2, suma);
		
		// SIN BUCLE
		System.out.println("");
		System.out.print("Introduce un numero: ");
		num = leer.nextInt();
		
		if (num > 9 && num < 100)
			{
			dig1 = num / 10;
			dig2 = num % 10;
			suma = dig1 + dig2;
			
			System.out.println("");
			System.out.printf("El numero %d se compone de dos digios, %d y %d cuya suma es %d", num, dig1, dig2, suma);
			}
		
		else
			{
			System.out.println("No es positivo o no tiene dos crifas");
			}
		
*/
		
/*
 
 		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 2 - - - - - - - - -");
		// Introducir un número entero por teclado. Si es positivo, entonces averiguad si es par o impar. 
		// Si es par, hallar si es múltiplo de 2, de 4 o de 8 y, en ese caso, mostrad el mensaje:”El número es par y múltiplo de 2 o de 4 o de 8". 
		// Si es impar, hallar si es múltiplo de 3, de 5 o de 7 y, en ese caso, mostrad el mensaje:”El número es impar y múltiplo de 3 o de 5 o de 7".
		
		int num = 0, cont = 0, mult = 0;
		
		System.out.println("Introduce un numero positivo: ");
		num = leer.nextInt();
		
		if (num >= 0)
			{
			if ((num % 2) == 0)
				{
				System.out.println("El numero " + num + " es un numero par y es múltiplo de: ");
				
				cont = 2;
				for (int x = 0; x < 3; x++)
					{
					mult = num % cont;
					if(mult == 0)
						{
						System.out.println("- " + cont);
						}
					cont *= 2;
					}
				}
			
			else
				{
				System.out.println("El numero " + num + " es un numero impar y es múltiplo de: ");
				cont = 3;
				for (int x = 0; x < 3; x++)
					{
					mult = num % cont;
					if(mult == 0)
						{
						System.out.println("- " + cont);
						}
					cont += 2;
					}
				}
			}
		
		else
			{
			System.out.println("El numero introducido no era positivo");
			}
			
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 3 - - - - - - - - -");
		// Introducir un número entero por teclado que se supone que es una hora del día. 
		// Indicar si corresponde a la mañana (entre las 6 y las 11, ambas inclusive),
		// si es una hora de la tarde (entre las 12 y las 19, ambas inclusive), 
		// si es de la noche (entre las 20 y las 23, ambas inclusive), 
		// si es de la madrugada (entre las 0 y las 5, ambas inclusive) o bien, si no puede corresponder a una hora del día.
		
		int hora = 0;
		
		System.out.print("Introduce la hora deseada (0-23): ");
		hora = leer.nextInt();
		
		System.out.println("");
		if (hora >= 6 && hora <= 11)
			{
			System.out.println("Son las " + hora + " de la mañana");
			}
		else if (hora >= 12 && hora <= 19)
			{
			System.out.println("Son las " + hora + " de la tarde");
			}
		else if (hora >= 20 && hora <= 23)
			{
			System.out.println("Son las " + hora + " de la noche");
			}
		else if (hora >= 0 && hora <= 5)
			{
			System.out.println("Son las " + hora + " de la madrugada");
			}
		else
			{
			System.out.println("Has introducido una hora que no existe");
			System.out.println("La horaintroducida debe estar entre 0 y 23");
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 4 - - - - - - - - -");
		// Introducir un número entero por teclado que se supone que es un mes del año. Si es así, indicar cuántos días tiene el mes que le antecede.
		
		int num = 0, mes = 0;
		
		String [] meses = new String [12];
		meses[0] = "Enero"; meses[1] = "Febrero"; meses[2] = "Marzo"; meses[3] = "Abril"; meses[4] = "Mayo"; meses[5] = "Junio";
		meses[6] = "Julio"; meses[7] = "Agosto"; meses[8] = "Septiembre"; meses[9] = "Octubre"; meses[10] = "Noviembre"; meses[11] = "Diciembre";
		
		String [] dias = new String [12];
		dias [0] = "31"; dias [1] = "28"; dias [2] = "31"; dias [3] = "30"; dias [4] = "31"; dias [5] = "30"; 
		dias [6] = "31"; dias [7] = "31"; dias [8] = "30"; dias [9] = "31"; dias [10] = "30"; dias [11] = "31"; 
		
		System.out.print("Introduce un numero de mes (1-12): ");
		mes = leer.nextInt();
		num = mes;
		
		System.out.println("");
		
		if(mes <= 12 && mes >= 1)
			{
			if (mes == 1)
				{
				num = 11;
				}
			else
				{
				num -= 2;
				}
			System.out.printf("El mes anterior a %s es %s y tiene %s dias", meses[mes-1], meses[num], dias[num]);
			}
		else
			{
			System.out.println("Ese mes no existe");
			}
			
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 5 - - - - - - - - -");
		// Introducir un número entero por teclado que se supone que es un año. Indicar si es bisiesto o no y por qué motivo 
		// (P.e.: “Es bisiesto por ser múltiplo de 4 y no de 100”. P.e.: “Es bisiesto por ser múltiplo de 400”. 
		// P.e.: “No es bisiesto por ser múltiplo de 100”).
		
		int año = 0, mult4= 0, mult400 = 0, mult100 = 0;
		
		System.out.print("Introduce un año: ");
		año = leer.nextInt();
		
		mult4 = año % 4;
		mult400 = año % 400;
		mult100 = año % 100;
		
		System.out.println("");
		if (mult100 == 0 && mult400 != 0)
			{
			System.out.println("No es bisiesto por ser múltiplo de 100");
			}
		else if (mult4 == 0 && mult100 != 0)
			{
			System.out.println("Es bisiesto por ser múltiplo de 4 y no de 100");
			}
		else if (mult400 == 0 && mult100 == 0)
			{
			System.out.println("Es bisiesto por ser múltiplo de 400");
			}
		else
			{
			System.out.println("No es bisiesto porque no es multiplo de 4, ni de 400 ni de 100");
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 6 - - - - - - - - -");
		// Introducir un número entero por teclado que se supone que es un mes del año. Si es así, indicar cuántos días tiene el mes que le antecede.
		
		int cont = 0, num = 0, suma = 0, x = 0;
		
		//FORMA 1
		cont = 99;
		System.out.println("");
		System.out.println("");
		for (x = 0; x < 20; x ++)
			{
			System.out.print(cont + ", ");
			suma += cont;
			cont -=2;			
			}
		System.out.println("");
		System.out.println("Total: " + suma);
		
		//FORMA 2
		cont = 99;
		suma = 0;
		x = 0;
		System.out.println("");
		System.out.println("");
		while (x < 20)
			{
			if((cont % 2) != 0)
				{
				suma += cont;
				x ++;
				System.out.print(cont + ", ");
				}
			cont--;
			}
		System.out.println("");
		System.out.println("Total: " + suma);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 7 - - - - - - - - -");
		// Introducir 20 números enteros por teclado. Indicar cuánto suman (en valor absoluto) los negativos, y cuánto los positivos.
		
		int num = 0, sumPos = 0, contPos = 0, contNeg = 0, sumNeg = 0, x = 1;
		
		while (x <= 20)
			{
			System.out.print(x + " - Introduce un numero: ");
			num = leer.nextInt();
			x++;
			if (num >= 0)
				{
				sumPos += num;
				contPos++;
				}
			else 
				{
				sumNeg += num;
				contNeg++;
				}
			}
		
		System.out.println("");
		System.out.printf("Has introducido %d numeros positivos cuya suma es %d %n", contPos, sumPos);
		System.out.printf("Has introducido %d numeros negativos cuya suma es %d %n", contNeg, sumNeg);
		
*/

/*

		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 8 - - - - - - - - -");
		// Calcular la suma : 1 + 2 + 3 +.....+ 20. Luego, la suma : 1 + 3 + 5 +.....+ 51. Y, por último, la suma : 1 - 2 + 3 -.....+ 19 - 20.
		
		int num = 0, suma = 0, resta = 0;
		
		num = 1;
		while (num <= 20)
			{
			suma += num;
			num ++;
			}
		System.out.println("Suma de numeros hasta el 20: " + suma);
		
		suma = 0;
		num = 1;
		while (num <= 51)
			{
			suma += num;
			num += 2;
			}
		System.out.println("Suma de numeros impares hasta el 51: " + suma);
		
		suma = 0;
		num = 1;
		while (num <= 20)
			{
			suma += num;
			num += 2;
			}
		
		num = 2;
		while (num <= 20)
			{
			resta += num;
			num += 2;
			}
		System.out.println("Suma y resta de numeros hasta el 20: " + (suma - resta));
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 9 - - - - - - - - -");
		// Introducir un número entero que llamaremos <dia_semana>, y comprendido entre 0 y 6,de modo que el 0 corresponderá al Domingo, 
		// el 1 al Lunes,...y así sucesivamente, hasta el 6 que señalará al Sábado. Suponed que el 1o de Enero de un año cualquiera “cae” en el
		// día que marca <dia_semana>. Tendréis que presentar en pantalla todos los días del mes de Enero, cada uno en una línea, acompañado del 
		// nombre del día de la semana que le corresponde.
		
		String [] semana = new String[7]; 
		semana[0]="Domingo";semana[1]="Lunes";semana[2]="Martes";semana[3]="Miercoles";semana[4]="Jueves";semana[5]="Viernes";semana[6]="Sabado";
		
		int dias_num = 1, dia_semana = 0;
		
		System.out.println("- - - - - - - - - - - - - -");
		System.out.println("|     ELIGE UNA OPCION    |");
		System.out.println("- - - - - - - - - - - - - -");
		System.out.println("| 0 - Domingo             |");
		System.out.println("| 1 - Lunes               |");
		System.out.println("| 2 - Martes              |");
		System.out.println("| 3 - Miercoles           |");
		System.out.println("| 4 - Jueves              |");
		System.out.println("| 5 - Viernes             |");
		System.out.println("| 6 - Sabado              |");
		System.out.println("- - - - - - - - - - - - - -");
		
		dia_semana = leer.nextInt();
		
		if(dia_semana >= 0 && dia_semana <=6)
			{
			System.out.println("- - - ENERO - - -");
			while (dias_num <= 31)
				{
				while (dia_semana <= 6 && dias_num <=31)
					{
					System.out.println(dias_num + " " + semana[dia_semana]);
					dia_semana ++;
					dias_num ++;
					}
				dia_semana = 0;
				}
			}
		else
			{
			System.out.println("Has introducido un numero no valido");
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 10 - - - - - - - - -");
		// Leer 10 datos, compuesto cada uno de ellos por un nombre de persona y su sueldo neto mensual, y obtener y visualizar el nombre y 
		// sueldo de la persona que más cobra y de la que menos. Si hay varias con el mismo sueldo (máximo o mínimo) se presentará la primera 
		// que aparezca en la secuencia de entrada.
		
		String nombre = "", nomMaxSal = "", nomMinSal = "";
		double sal = 0, maxSal = 0, minSal = Integer.MAX_VALUE;
		
		for (int x = 0; x < 10; x++){
			System.out.println("");
			System.out.print("Introduce un nombre: ");
			nombre = leer.next();
			
			System.out.print("Introduce el salario de " + nombre + ": ");
			sal = leer.nextDouble();
			while (sal < 0){
				System.out.println("El salario no puede ser negativo");
				System.out.println("Introduce el salario de " + nombre + ": ");
				sal = leer.nextDouble();
				}
			
			if (maxSal < sal){
				maxSal = sal;
				nomMaxSal = nombre;
				}
			
			if (minSal > sal){
				minSal = sal;
				nomMinSal = nombre;
				}
			
			}
		System.out.println("");
		System.out.printf("SALARIO MAYOR %n %s: %.2f€", nomMaxSal, maxSal);
		
		System.out.println("");
		System.out.printf("SALARIO MENOR %n %s: %.2f€", nomMinSal, minSal);
		
*/
		
/*	
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 11 - - - - - - - - -");
		// Calcular la suma de los números pares y, al mismo tiempo, la de los impares comprendidos entre 1 y 100, ambos inclusive.
		
		int x = 0, resto = 0, par = 0, impar = 0;
		
		for (x = 1; x <= 100; x++)
			{
			resto = x % 2;
			if (resto == 0)
				{
				par += x; 
				}
			else
				{
				impar += x; 
				}
			}
		
		System.out.println("");
		System.out.println("Suma de todos los impares: " + impar);
		System.out.println("Suma de todos los pares: " + par);
		
*/

/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 12 - - - - - - - - -");
		// Dados dos números enteros positivos, hallar el mínimo común múltiplo. Método a usar: Se van hallando los sucesivos múltiplos del 
		// mayor de ellos hasta encontrar uno que sea divisible por el más pequeño.
		
		int a = 0, mcda = 0, b = 0, mcdb = 0, aux = 0;
			
		while (a <= 0){
			System.out.println("Numero 1: ");
			a = leer.nextInt();
			}
		
		while (b <= 0){
			System.out.println("Numero 2: ");
			b = leer.nextInt();
			}
		
		mcda = a;
		mcdb = b;
		while (mcdb != 0){
			aux = mcdb;
			mcdb = mcda % mcdb;
			mcda = aux;
		  	}
		
		System.out.println("");
		System.out.println("El minimo comun multiplo de " + a + " y " + b + " es " + (a * b) / mcda);

*/
	
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 13 - - - - - - - - -");
		// Dado un número entero positivo, calcular una lista de sus divisores, incluyendo a él mismo. Al final del proceso se deberá indicar 
		// cuántos divisores son pares y cuántos impares.
		
		int num = 0, par = 0, impar = 0, div = 0;
		
		while (num <= 0)
		{
		System.out.print("Introduce un numero positivo mayor que 0: "); num = leer.nextInt();
		}
		
		System.out.printf("%n DIVISORES DE %d: %n |", num);
		for (int x = 1; x <= num; x++)
			{
			div = num % x;
			
			if (div == 0)
				{
				System.out.printf(" %d |", x);
				
				if((x % 2) == 0)
					{
					par ++;
					}
				else
					{
					impar ++;
					}
				}
			}
		
		System.out.println("");
		System.out.printf("%n CANTIDAD DE DIVISORES DE %d: %n Total: %d %n Divisores pares: %d %n Divisores impares: %d %n", num, (par + impar), par, impar);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 14 - - - - - - - - -");
		// Dado un número entero positivo hallar si es primo o no.
		
		int num = 0, prim = 0, div = 2;
		boolean esPrimo = true;
		
		while (num <= 0)
		{
		System.out.print("Introduce un numero positivo mayor que 0: "); num = leer.nextInt();
		}
		
		while (esPrimo == true && div < num)
			{
			prim = num % div;
			div ++;
			if (prim == 0)
				{
				esPrimo = false;
				}
			}
		
		System.out.println("");
		if (esPrimo == true)
			{
			System.out.printf("%d es un numero primo", num);
			}
		else
			{
			System.out.printf("%d no es un numero primo", num);
			}

*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 15 - - - - - - - - -");
		// Dado un número entero positivo, hallar los números primos comprendidos entre 2 y dicho número.
		
		int num = 0, x = 0, prim = 0, div = 2;
		boolean esPrimo = true;
		
		while (num <= 0)
		{
		System.out.print("Introduce un numero positivo mayor que 0: "); num = leer.nextInt();
		}
		
		for (x = 2; x <= num; x ++)
			{
			while (esPrimo == true && div < x)
				{
				prim = x % div;
				div ++;
				if (prim == 0)
					{
					esPrimo = false;
					}
				}
			if (esPrimo == true)
				{
				System.out.println("|" + x);
				}
			esPrimo = true;
			div = 2;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 16 - - - - - - - - -");
		// Calcular el producto de dos números enteros positivos mediante el denominado "algoritmo ruso del producto": consiste en duplicar el 
		// primer factor y dividir (cociente entero) por 2 el segundo, obteniendo un producto equivalente, salvo si el segundo es impar, en cuyo 
		// caso es necesario acumular previamente el primero en donde se va a obtener el resultado. El proceso termina cuando el segundo factor 
		// se hace 0. Por ejemplo: 25 * 6
		//
		// factor 1 | factor 2 | Acumulador
		// 25 		| 6 	   | 0
		// 50 		| 3 	   | 50
		// 100 		| 1 	   | 150
		// 200 		| 0 	   | 150
	
		int fact1 = 0, fact2 = 0, acum = 0;
		String [] texto = new String [3]; texto[0] = "Factor 1"; texto[1] = "Factor 2"; texto[2] = "Acumulador";
		
		while (fact1 <= 0){
			System.out.print("Introduce un numero positivo mayor que 0: "); fact1 = leer.nextInt();
			}
		
		while (fact2 <= 0){
			System.out.print("Introduce un numero positivo mayor que 0: "); fact2 = leer.nextInt();
			}
		
		System.out.println("");
		System.out.printf("%-5s | %-5s | %-5s %n", texto[0], texto [1], texto[2]);
		
		while (fact2 != 0){
			System.out.printf("%-8d | %-8d | %-8d %n", fact1, fact2, acum);
			if ((fact2 % 2) != 0){
				acum += fact1;
				}
			fact1 *= 2;
			fact2 /= 2;
			}
		
		System.out.printf("%-8d | %-8d | %-8d %n", fact1, fact2, acum);

*/
		
/*
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 17 - - - - - - - - -");
		// Visualizar todos los números binarios representables con 4 bits, ordenados de menor a mayor, así como su valor decimal.
		
		int x = 0, y = 0, resto = 0, divid = 0;
		String bin = "";
		
		System.out.println(" DECIMAL | BINARIO");
		for (x = 0; x < 16; x++) {
			divid = x;
			for (y = 0; y < 3; y++) {
				resto = divid % 2;
				divid /= 2;
				bin = resto + bin;
			}
			y = 0;
			bin = divid + bin;
			System.out.printf("%5d %10s %n", x, bin);
			bin = "";
		}
		
*/	
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 18 - - - - - - - - -");
		// Calcular e visualizar las potencias de 2 -el exponente variará de 0 a 10- del siguiente modo:
		// 2 elevado a 0 es 1.
		// 2 elevado a 1 es 2.
		// ................
		// 2 elevado a 10 es 1024
		// (NOTA: No usar la función de exponenciación – pow -)
		
		int x = 0, elev = 2, dos = 1;
		
		for (x = 0; x <= 10; x ++)
			{
			while (elev <= x)
				{
				dos *= 2;
				elev ++;
				}
			System.out.printf("2 elevado a %d = %d %n", x, dos);
			elev = 2;
			dos = 2;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 19 - - - - - - - - -");
		// Introducir un número y desglosarlo de forma ideal en billetes y monedas de curso legal.
		int x = 0, dinero = 0;
		double num = 0;
		double [] billetesMonedas = new double[14];
		billetesMonedas[0] = 200; billetesMonedas[1] = 100; billetesMonedas[2] = 50; billetesMonedas[3] = 20; billetesMonedas[4] = 10;
		billetesMonedas[5] = 5; billetesMonedas[6] = 2; billetesMonedas[7] = 1; billetesMonedas[8] = 0.5; billetesMonedas[9] = 0.2;
		billetesMonedas[10] = 0.1; billetesMonedas[11] = 0.05; billetesMonedas[12] = 0.02; billetesMonedas[13] = 0.01;
		
		System.out.print("Inroduce la cantidad de dinero: ");
		num = leer.nextDouble();
		
		System.out.println("");
		System.out.println(" BILLETES: ");
		for (x = 0; x < 6; x++)
			{
			while (billetesMonedas[x] <= num)
				{
				num -= billetesMonedas[x];
				dinero ++;
				}
			if (dinero > 0)	
				{
				System.out.println(" (x" + dinero + ")" + (int)billetesMonedas[x] + "€");
				}
			dinero = 0;
			}
		System.out.println("");
		System.out.println(" MONEDAS: ");
		for (x = 6; x < 14; x++)
			{
			while (billetesMonedas[x] <= num)
				{
				num -= billetesMonedas[x];
				dinero ++;
				}
			if (dinero > 0)	
				{
				System.out.println(" (x" + dinero + ")" + billetesMonedas[x] + "€");
				}
			dinero = 0;
			}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 20 - - - - - - - - -");
		// Calcula la suma de la progresión geométrica 1 + x + x^2 + x^3 + x^4 + x^n (siendo x y n	valores enteros que se introducirán desde teclado.)
		
		int num = 1, n = 0, x = 0, v = 0, elev = 2, acum = 0;
		
		System.out.println("Para 1 + x + x^2 + x^3 + x^4 + x^n");
		System.out.print("Introduce un valor para x: ");
		x = leer.nextInt(); 
		System.out.print("Introduce un valor para n: ");
		n = leer.nextInt(); 
		
		for (v = 0; v <= n; v++){
			while (elev <= v) {
				num *= x;
				elev ++;
			}
			System.out.printf("%n %d^%d = %d", x, v, num);
			acum += num;
			elev = 2;
			num = x;
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Suma de todas las potendias = " + acum);
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 21 - - - - - - - - -");
		// En la “Pensión de los números”, dirigida por el señor 0 (cero), residen desde hace meses el 8 y el 12. Una noche, cuando los tres 
		// habitantes de la casa se disponen a tomar una cena a base de “sopa de letras”, suena el timbre de la puerta. Se trata de un número
		// entero que desea alojarse en la pensión. El Sr. 0 no tarda en invitar al nuevo número a sentarse en la salita, no sin decirle que,
		//antes de admitirlo, debe comprobar que cumple una serie de requisitos. Los requisitos que, según el señor 0, debe cumplir un nuevo 
		// inquilino son los siguientes:
		// - No debe ser primo. Para el Sr. 0 los números primos son muy presuntuosos.
		// - Su factorial no puede exceder el billón, porque en caso contrario no entiende por qué no se aloja en el “Number Astoria”, el 
		//   mejor hotel de la ciudad.
		// - Y, por supuesto, no quiere que ninguno de sus inquilinos tenga actitudes “negativas” ante la vida.
		// Así pues, el Sr. 0, tras estudiar al nuevo número, decide si lo admite o no en su pensión.
		
		//Escribir un programa en C que simule lo anteriormente expuesto. Para ello se tomará desde teclado un número entero, 
		// que no podrá ser 0, ni 8, ni 12, y emitirá el mensaje “Bienvenido a la pensión” o “Lo siento, usted no cumple los requisitos”, según 
		// cumpla o no los condicionantes que el señor 0 considera imprescindibles para admitir a un nuevo huésped.
		
		int num = 0;
		boolean admitido = true;
		
		System.out.print("¿Que numero ha llamado al timbre?");
		num = leer.nextInt();
		
		while (num == 0 || num == 8 || num == 12) {
			System.out.println("");
			System.out.println(num + " no pudo haber llamado porque ya esta en la pension");
			System.out.print("¿Que numero ha llamado al timbre?");
			num = leer.nextInt();
		}
		
		
		if (num < 0) {
			admitido = false;
		}
		
		if (esPrimo(num) == true) {
			admitido = false;
		}
		
		if (factorial(num) >= 1000000000000L) {
			admitido = false;
		}
		
		if (admitido == true) {
			System.out.println(num + ", bienvenido a la pension");
		}
		else {
			System.out.println("Lo siento, nº" + num + ", no cumples con los requisitos");
		}
		
*/
		
/*
		
		System.out.println("");
		System.out.println("- - - - - - - - - EJERCICIO 22 - - - - - - - - -");
		// El doctor 0, hermano gemelo del dueño de la “Pensión de los Números”, tiene una consulta a la cual llegan los ilusionados números 
		// padres, todos ellos “enteropositivos”, para averiguar las características de sus futuros “numeritos”. En el mundo de los números, todos 
		// los hijos cumplen que son máximos comunes divisores de sus padres. Para averiguarlo, el Dr. 0 dispone de un estrafalario aparato que le
		// construyó su queridísimo amigo Euclides. El funcionamiento del aparato es el siguiente:
		
		// “Aceptará dos números enteros positivos y obtendrá el resto de la división del mayor entre el menor. Si el resto se hace 0, el m.c.d. 
		// será el menor. Si no es así se dividirá el mayor entre el resto de la última división realizada hasta que uno de los restos se haga nulo. 
		// El último divisor será el hijo de la pareja”. Escribir en C un programa que simule lo anteriormente expuesto. Para ello se tomarán
		// desde teclado el padre y la madre de la criatura, ambos positivos, y se presentará en pantalla, aplicando el algoritmo de Euclides, el 
		// valor del máximo común divisor de ambos. Finalmente, se indicará si “se parece” (es igual) al padre (primer número introducido), a la
		// madre (segundo número) o a ambos.
		
		int padre1 = 0, padre2 = 0, aux = 0;
		
		System.out.println("nº del padre 1: ");
		padre1 = leer.nextInt();
		while (padre1 <= 0) {
			System.out.println("El padre debe ser mayor que 0");
			System.out.println("nº del padre 1: ");
			padre1 = leer.nextInt();
		}
		
		System.out.println("nº del padre 2: ");
		padre2 = leer.nextInt();
		while (padre2 <= 0) {
			System.out.println("El padre debe ser mayor que 0");
			System.out.println("nº del padre 2: ");
			padre2 = leer.nextInt();
		}
		
		System.out.println("El hijo de " + padre1 + " y " + padre2 + " es " +  maximoComunDivisor(padre1, padre2));
		
*/
	
		}
	// USADAS PARA EJERCICIO 21
	public static boolean esPrimo (int num) {
		boolean esPrimo = true;
		int div = 2;
		while (esPrimo == true && div < num) {
			if ((num % div) == 0) {
				esPrimo = false;
			}
			div ++;
		}
		return esPrimo;
	}
	
	public static long factorial (int num) {
		long fact = 1;
		int x = 1;
		while (x <= num) {
			fact *= (long)x;
			x ++;
		}
		return fact;
	}
	
	// USADAS PARA EJERCICIO 22
	public static int maximoComunDivisor (int divid, int divis) {
		int resto = -1;
		while (resto != 0) {
			resto = divid % divis;
			divid = divis;
			divis = resto;
		}
		return divid;
	}
	
	
	
	
	
	}
