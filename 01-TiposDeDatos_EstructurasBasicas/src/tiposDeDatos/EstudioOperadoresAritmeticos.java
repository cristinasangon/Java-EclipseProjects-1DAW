package tiposDeDatos;

public class EstudioOperadoresAritmeticos 
	{

	public EstudioOperadoresAritmeticos() 
		{
		System.out.println("___________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - OPERADORES ARITMETICOS - - - - - - -");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- SUMA");
		
		int suma, a = 5, b = 3;
		double sumaDouble, c = 5.5, d = 2.3;
		
		suma = a + b;
		System.out.println("  Suma entera -> " + a + " + " + b + " = " + suma);
		
		sumaDouble = c + d;
		System.out.println("  Suma real -> " + c + " + " + d + " = " + sumaDouble);
		
		sumaDouble = c + a;
		suma = (int) sumaDouble;
		System.out.println("  Suma entera con numero real -> " + c + " + " + a + " = " + suma);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- MULTIPLICACION");
		int multi;
		multi = a*b;
		System.out.println("  Multiplicacion entera -> " + a + " x " + b + " = " + multi);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- DIVISION");
		
		int divEntera, divisorEntero = 2, dividendo = 13;
		double divReal, divisorReal = 2;
		
		divEntera = dividendo / divisorEntero;
		System.out.println("  Division entera de numeros enteros -> " + dividendo + " : " + divisorEntero + " = " + divEntera);
		
		divReal = dividendo / divisorEntero;
		System.out.println("  Division real sin decimales de numeros enteros -> " + dividendo + " : " + divisorEntero + " = " + divReal);
		
		divReal = dividendo / divisorReal;
		System.out.println("  Division real de numeros reales -> " + dividendo + " : " + divisorReal + " = " + divReal);
		
		//Tengo dos numeros enteros y quiero hacer una division real con decimales. 
		//Para poder hacerlo, debo hacer un casting que combierta uno de los dos numeros en real.
		divReal = dividendo / (double) divisorEntero;
		System.out.println("  Division real con decimales de numeros enteros -> " + dividendo + " : " + divisorEntero + " = " + divReal);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- RESTO");
		
		int resto;
		dividendo = 13;
		divisorEntero = 3;
		resto = dividendo % divisorEntero;
		System.out.println("  Resto de " + dividendo + " y " + divisorEntero + " -> " + resto);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- CONTADOR");
		
		System.out.print("  Contador de uno en uno -> ");
		
		//Podemos expresar de diferentes formas nuestro contador
		
		int cont = 0;
		System.out.print(cont + ", ");
		
		cont = cont + 1;
		System.out.print(cont + ", ");
		
		cont++;
		System.out.print(cont + ", ");
		
		++cont;
		System.out.print(cont + ", ");
		
		int y = cont++; //Primero se hace la asignacion y luego se incrementa cont
		System.out.print(cont+ ", ");
		
		y = ++cont; //Primero se incrementa cont y luego se hace la asignacion
		System.out.println(y);
		
		System.out.print("  Contador de dos en dos -> ");
		cont = 0;
		System.out.print(cont + ", ");
		cont += 2; //Es lo mismo que poner cont = cont + 2;
		System.out.println(cont);
		
		System.out.print("  Contador que multiplica de cuatro en cuatro -> ");
		cont = 2;
		System.out.print(cont + ", ");
		cont *= 4; //Es lo mismo que poner cont = cont * 4;
		System.out.println(cont);
		
		System.out.print("  Contador que divide de dos en dos -> ");
		cont = 20;
		System.out.print(cont + ", ");
		cont /= 2; //Es lo mismo que poner cont = cont / 2;
		System.out.println(cont);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- ACUMULADOR");
		
		System.out.print("  Acumulador -> ");
		int acu = 3;
		cont = 3;
		
		acu = acu + cont;
		System.out.print(acu + ", ");
		
		acu += cont; //Es lo mismo que acu = acu + cont;
		System.out.print(acu + ", ");
		
		acu *= cont; //Es lo mismo que acu = acu * cont;
		System.out.println(acu);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- OPERADORES DE RELACION");
		int z = 3, r = 4;
		boolean sw = false;
		
		System.out.println("Mis numeros son -> " + z + " y " + r);
		
		sw = z == r;
		System.out.println("  ¿" + z + " es igual que " + r + "? -> " + sw);
		
		sw = z != r;
		System.out.println("  ¿" + z + " es distinto que " + r + "? -> " + sw);
		
		sw = z >= r;
		System.out.println("  ¿" + z + " es mayor que " + r + "? -> " + sw);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- OPERADORES LOGICOS");
		boolean sw1 = true, sw2 = false;
		
		System.out.println("  El valor de sw1 es -> " + sw1);
		System.out.println("  El valor de sw2 es -> "+ sw2);
	
		System.out.println("");
		
		System.out.print("  ¿Se cumple al menos uno de los valores? -> ");
		System.out.println(sw1 || sw2);
		
		System.out.print("  ¿Se cumplen los dos valores? -> ");
		System.out.println(sw1 && sw2);
		
		System.out.print("  ¿Se cumple solo y exclusivamente un valor? -> ");
		System.out.println(sw1 ^ sw2);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- OPERADOR TERNARIO");

		int notaExamen = 5;
		String notaCadena = notaExamen < 5 ? "suspendido" : "aprobado";
		
		System.out.println("  Has " + notaCadena + " tu examen");
		
		System.out.println("");
		boolean t = true;
		boolean f = false;
		
		System.out.println("  t = " + t);
		System.out.println("  f = " + f);
		
		System.out.println("  t && f = " + (t && f));
		System.out.println("  t || f = " + (t || f));
		
		System.out.println("  !t = " + !t);
		System.out.println("  !f = " + !f);
		
		System.out.println("  t || (6 > 10) = " +  (t || (6 > 10)));
		System.out.println("  ((4 <= 4) || f) && (!t) = " + (((4 <= 4) || f) && (!t)));
		
		
		
		
		System.out.println("");
		System.out.println("___________________________________________________");
		}
	}
