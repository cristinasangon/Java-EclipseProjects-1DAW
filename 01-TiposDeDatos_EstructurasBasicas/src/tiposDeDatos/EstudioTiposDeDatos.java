package tiposDeDatos;

import java.util.Scanner;

public class EstudioTiposDeDatos 
	{
	enum Dias {Lunes, Martes, Miercoles, Jueves, Viernes, Sabbado, Domingo};
	
	public EstudioTiposDeDatos() 
		{
		System.out.println("___________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - - - TIPOS DE DATOS - - - - - - - - -");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Byte: Numero entero muy corto");
		byte tipoByte = 0;
		tipoByte = 24;
		System.out.println("  ejemplo tipoByte: " + tipoByte);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Short: Numero entero corto");
		short tipoShort = 0;
		tipoShort = 30000;
		System.out.println("  ejemplo tipoShort: " + tipoShort);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Int: Numero entero");
		int tipoInt = 0;
		tipoInt = 1000000;
		System.out.println("  ejemplo tipoInt: " + tipoInt);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Long: Numero entero largo");
		long tipoLong = 0;
		tipoLong = 36457568267644656L;
		System.out.println("  ejemplo tipoLong: " + tipoLong);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Char: Almacena carácteres");
		char letra1 = 'C';
		char letra2 = 'r';
		char letra3 = 'i';
		char letra4 = 's';
		char letra5 = 't';
		char letra6 = 'i';
		char letra7 = 'n';
		char letra8 = 'a';
		System.out.println("  letra1: " + letra1);
		System.out.println("  letra2: " + letra2);
		System.out.println("  letra3: " + letra3);
		System.out.println("  letra4: " + letra4);
		System.out.println("  letra5: " + letra5);
		System.out.println("  letra6: " + letra6);
		System.out.println("  letra7: " + letra7);
		System.out.println("  letra8: " + letra8);
		System.out.println("  todas las letras juntas: " + letra1 + letra2 + letra3 + letra4 + letra5 + letra6 + letra7 + letra8);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Int + Char: Podemos obtener el codigo Ascii");
		char c = 'A';
		int codigoAscii = c;
		System.out.println("  El codigo Ascii de la letra '" + c + "' es '" + codigoAscii + "'");
		
		codigoAscii = 90;
		c = (char) codigoAscii;
		System.out.println("  La letra con codigo Ascii '" + codigoAscii + "' es '" + c + "'");
		
		c = 77;
		codigoAscii = c;
		System.out.println("  La letra con codigo Ascii '" + codigoAscii + "' es '" + c + "'");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Float: Numero con punto flotante de precisión individual con hasta 7 dígitos significativos");
		float tipoFloat = 0F;
		tipoFloat = 13F;
		System.out.println("  ejemplo tipoFloat: " + tipoFloat);
		
		//Si queremos poner decimales, hay que hacer una conversion
		tipoFloat = (float) 13.13;
		System.out.println("  ejemplo tipoFloat con decimales: " + tipoFloat);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Double: Numero con punto flotante de precisión doble con hasta 16 dígitos significativos");
		double tipoDouble1;
		double tipoDouble2;
		tipoDouble1 = 26;
		tipoDouble2 = 2.6;
		System.out.println("  La variable tipoDouble1 tiene un valor de: " + tipoDouble1);
		System.out.println("  La variable tipoDouble2 tiene un valor de: " + tipoDouble2);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Constantes: Siempre se declaran en mayusculas y son variables que nunca cambian su valor");
		final double PI = 3.14;
		//Si intentamos cambiar su valor, nos da error
		System.out.println("  PI=  " + PI);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Conversion de casting: es transformar una variable de rango mayor a una de rango menor");
		double div;
		int dividendo, divisor;
		dividendo = 7;
		divisor = 3;
		
		//Primero realizamos la operacion sin hacer castin para comprobar que da un valor entero
		div = dividendo / divisor;
		System.out.println("  La division entera de " + dividendo + " / " + divisor + " = " + div);
		
		//Ahora vamos a hacer el casting al divisor para que nos de unn valor real
		div = dividendo / (double) divisor;
		System.out.println("  La division real de " + dividendo + " / " + divisor + " = " + div);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Bolean: variables que solo pueden tener los valores de 'true' o 'false'");
		boolean sw = false;
		System.out.println("  El valor es " + sw);
		sw = true;
		System.out.println("  Y ahora es " + sw);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- String: es una clase especial. Puedo declararla de forma similar a una variable primitiva");
		String miPalabra = "Cerveza";
		String miFrase = "¿Donde está mi cerveza?";
		
		System.out.println("  Una palabra que uso mucho es " + miPalabra);
		System.out.println("  Una frase que suelo usar es " + miFrase);

		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Scanner: sirve para pedir datos por teclado");
		Scanner leer = new Scanner(System.in);
		
		System.out.print("  Introduce tu nombre: ");
		String nombre = leer.nextLine();
		
		leer = null;
		leer = new Scanner(System.in);
		
		System.out.print("  Introduce tu edad: ");
		int edad = leer.nextInt();
		
		System.out.println("  Te llamas " + nombre + " y tienes " + edad + " años");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("- Enum: hay que declararlos a nivel de clase, sirve para guardar varios valores");
		
		Dias diaActual = Dias.Miercoles;
		Dias diaSiguiente = Dias.Jueves;
		System.out.println("  Hoy es " + diaActual + " y mañana es " + diaSiguiente);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println("");
		System.out.println("___________________________________________________");
		}

	}
