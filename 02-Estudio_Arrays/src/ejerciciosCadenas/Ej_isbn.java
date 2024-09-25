package ejerciciosCadenas;

public class Ej_isbn {

	public Ej_isbn() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO ISBN == == == ==");
		// ISBN-13: Debemos multiplicar cada número por 1 si la posición que ocupa es 
		// impar o por 3 si la posición que ocupa es par y calcular la suma de todos 
		// salvo del último que es el dígito de control. Dividimos el resultado de la suma 
		// anterior entre 10 y obtenemos el resto de la división. Restamos a 10 el resto obtenido. 
		// El isbn será válido si el valor obtenido es igual al dígito de control (último dígito del 
		// isbn). (Sí el resultado de la resta es 10 el DC será 0) Ejemplo: Comprueba la validez del 
		// siguiente isbn-13: 978-84-415-2682-2
		
		// Suma: 9*1 + 7*3 + 8*1 + 8*3 + 4*1 + 4*3 + 1*1 + 5*3 + 2*1 + 6*3 + 8*1 + 2*3= 128
		// Cálculo del dígito de control: 128 mod 10 = 8 (el resto). 10 – 8 = 2 (coincide con el dígito de control)
		//   PRUEBAS:
		//   978-84-8130-252-3 
		//   978-84-8450-382-8 
		//   978-84-204-4290-7 
		//   978-84-95354-15-0
		
		String isbn = "978-84-415-2682-2";
		if(comruebaISBN(isbn) == true) {
			System.out.println(isbn + " es correcto");
		}
		else {
			System.err.println(isbn + " es incorrecto");
		}
		
		
		
	}
	public static boolean comruebaISBN(String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		int digControl = Integer.parseInt(Character.toString(isbn.charAt(isbn.length()-1)));
		
		int numero = 0, suma = 0;
		for(int x = 0; x < (isbn.length() - 1); x++) {
			numero = Integer.parseInt(Character.toString(isbn.charAt(x)));
			if((x + 1) % 2 == 0) {
				numero *= 3;
			}
			suma += numero; 
		}
		
		if((10 - (suma % 10)) == digControl) {
			return true;
		}
		else {
			return false;
		}
	}

}
