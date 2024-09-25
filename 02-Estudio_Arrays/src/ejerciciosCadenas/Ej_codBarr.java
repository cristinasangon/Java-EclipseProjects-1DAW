package ejerciciosCadenas;

public class Ej_codBarr {

	public Ej_codBarr() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO CODIGO DE BARRAS == == == ==");
		// Para calcular el algoritmo de cálculo del dígito de control pongamos como 
		// ejemplo el siguiente código, 84 12345 67890 ?, conocemos que el 84 
		// identifica al país, los siguientes 5 dígitos de la empresa y los últimos 
		// 5 dígitos con el artículo/producto.
		// El proceso a seguir es:
		//    1 - Multiplicamos por 1 las posiciones impares y por 3 las posiciones 
		//        pares del código, empezando de izquierda a derecha.
        //	  2 - Sumamos los valores resultantes. 8 + 12 + 1 + 6 + 3 + 12 + 5 + 18 + 7 + 24 + 9 + 0 = 105
        //	  3 - Restamos de la decena superior el valor de la suma de los valores 
        //      resultantes. El resultado de esta operación es el valor del código 
		//      de control (primera posición de la derecha del código de barras). 
		//      Si el resultado es 0 el dígito de control será 0.
		// En nuestro ejemplo la decena superior a 105 es 110, por tanto:
		// 110 105 = 5 ==> 5 es el valor del código de control.

		
	String[] codBarras = {"84 12345 67890", "84 45612 37890", "84 45612 37891", "84 21345 67890", "84 56412 37890"};

	System.out.println("CODIGO DE BARRAS   DIGITO DE CONTROL");
	System.out.println("====================================");
	for(int x = 0; x < codBarras.length; x++) {	
		System.out.printf(" %s %13s", codBarras[x], calcularDigControl(codBarras[x]));
		System.out.println();
	}
	
	}
	public static int calcularDigControl(String codBarras) {
		codBarras = codBarras.replace(" ", "");
		int digito = 0, suma = 0, digControl = 0;
		String sumaCad = "";
		for(int x = 0; x < codBarras.length(); x++) {
			digito = Integer.parseInt(Character.toString(codBarras.charAt(x)));
			if((x + 1) % 2 == 0) {
				digito *= 3;
			}
			suma += digito;
		}
		sumaCad += suma;
		digito = Integer.parseInt(Character.toString(sumaCad.charAt(sumaCad.length()-1)));
		while(digito < 10) {
			digControl++;
			digito++;
		}
		return digControl;
	}
}
