package rapasoExamen;

public class Repaso14 {

	public Repaso14() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 14  =  ==  =  ==  =  ==  ");
		
		String isbn = "978-84-415-2682-2";
		String isbn1 = "978-84-8130-252-3";
		String isbn2 = "978-84-8450-382-8";
		String isbn3 = "978-84-204-4290-7";
		String isbn4 = "978-84-95354-15-0";
		
		System.out.println(isbn + " is " + compruebaISBN(isbn));
		System.out.println(isbn1 + " is " + compruebaISBN(isbn1));
		System.out.println(isbn2 + " is " + compruebaISBN(isbn2));
		System.out.println(isbn3 + " is " + compruebaISBN(isbn3));
		System.out.println(isbn4 + " is " + compruebaISBN(isbn4));
		
	}
	public static boolean compruebaISBN(String isbn) {
		isbn = isbn.replace("-", "");
		int digControl = Integer.parseInt(Character.toString(isbn.charAt(isbn.length()-1)));
		
		String numeros = isbn.substring(0, isbn.length()-1);
		
		int digito = 0, suma = 0;
		for(int x = 0; x < numeros.length(); x++) {
			digito = Integer.parseInt(Character.toString(numeros.charAt(x)));
			if((x%2) == 0) {
				digito *= 3;
			}
			suma += digito;
		}
		suma %= 10;
		suma = 10 - suma;
		
		if(suma == digControl) {
			return true;
		}
		else {
			return false;
		}
	}
}
