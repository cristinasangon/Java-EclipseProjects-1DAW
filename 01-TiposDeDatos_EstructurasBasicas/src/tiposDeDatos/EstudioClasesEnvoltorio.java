package tiposDeDatos;

public class EstudioClasesEnvoltorio 
	{

	public EstudioClasesEnvoltorio() 
		{
		System.out.println("______________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - - - CLASES ENVOLTORIO - - - - - - - - -");
		
		String n = "123";
		int x = 123, num;
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Convierte la cadena \"12345\" en un numero entero 12345");
		
		num = Integer.parseInt("12345"); 
		System.out.println("  " + num);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Convierte un numero entero 123 a cadena \"123\"");
		
		String numString = Integer.toString(x);
		System.out.println("  Numero " + x + " como cadena: " + numString);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Convierte un numero binario 1101 a su decimal");
		
		System.out.println("  1101 en base 2: " + Integer.parseInt("1101",2));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Convierte un numero decimal 123456 a su hexadecimal");
		
		System.out.println("  123456 en hexadecimal es " + Integer.toHexString(123456));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Convierte un numero decimal 131203 a su binario");
				
		System.out.println("  131203 en binario es " + Integer.toBinaryString(135));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Saber sobre caracteres"); //Character devuelve los valores como boolean
		
		char c = '9';
		
		System.out.println("  El caracter es una letra? " + Character.isLetter(c));
		System.out.println("  El caracter es un digito? " + Character.isDigit(c));
		System.out.println("  El caracter es mayuscula? " + Character.isUpperCase(c));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Pasar de cadena a double");
		
		String numDoble = "53.725538";
		double d = Double.parseDouble(numDoble);
		
		System.out.printf("  La cadena %s es el numero %.3f %n", numDoble, d);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("");
		System.out.println("______________________________________________________");
		}

	}
