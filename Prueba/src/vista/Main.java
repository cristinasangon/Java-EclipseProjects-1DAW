package vista;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String isbn = "‎‎‎978-84-8450-b382-8";
		System.out.println(compruebaIsbn3(isbn));
	}

	public static boolean compruebaIsbn(String isbn) {
		isbn = isbn.replace("-", "");
		//isbn = isbn.replace(" ", "");
		//isbn = isbn.replaceAll("[^0-9-]", "");
		
		try {
			int suma = 0;
			int dc = Integer.parseInt(Character.toString(isbn.charAt(isbn.length() - 1)));
			for(int x = 0; x < (isbn.length() - 1); x++) {
				int digito = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1) % 2) == 0) {
					digito *= 3;
				}
				suma += digito;
			}
			suma %= 10;
			if(suma != 0) {
				suma = 10 - suma;
			}
			if(suma == dc) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean compruebaIsbn2(String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		
		if(isbn.equals("")) {
			return false;
		}
		
		int suma = 0;
		int dc = 0;
		int dcCalculado = 0;
		try {
			dc = Integer.parseInt(Character.toString(isbn.charAt(isbn.length() - 1)));
			for(int x = 0; x < isbn.length() - 1; x++) {
				int numero = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1) % 2) == 0) {
					numero *= 3;
				}
				suma += numero;
			}
			suma %= 10;
			if(suma == 0) {
				dcCalculado = 0;
			}else {
				dcCalculado = 10 - suma;
			}
			
			if(dcCalculado == dc) {
				return true;
			}else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean compruebaIsbn3(String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		//isbn = isbn.replaceAll("[^0-9-]", "");
		System.out.println("'" + isbn + "'");
		try {
			int suma = 0;
			int dc = Integer.parseInt(Character.toString(isbn.charAt(isbn.length() - 1)));
			for(int x = 0; x < (isbn.length() - 1); x++) {
				String digito = isbn.valueOf(isbn.charAt(x));
				System.out.println("'"+digito+"'");
				/*if(((x + 1) % 2) == 0) {
					digito *= 3;
				}
				suma += digito;*/
			}
			suma %= 10;
			if(suma != 0) {
				suma = 10 - suma;
			}
			if(suma == dc) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
