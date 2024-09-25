package ejercicios;

public class Ejercicio1 {

	public Ejercicio1() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 1 - - - - - - - - -");
		// Diseñar una función que genere un array que simule un boleto de primitiva. (Seis números entre 1 y 49 que no se repitan).
		
		int [] boletoPrimitiva = generaAleatorios(1, 49, 6);
		int cont = 0;
		
		System.out.println("  Tu boleto de primitiva: ");
		for (int x = 0; x < boletoPrimitiva.length; x++) {
			System.out.printf("%4d", boletoPrimitiva[x]);
		}
		
	}
	public static int[] generaAleatorios (int mayor, int menor, int cant) {
		int[] sorteo = new int [cant];
		boolean esDif = true;
		int rand = 0, x = 0, y = 0;
		
		while (x < sorteo.length) {
			rand = (int) Math.floor(Math.random() * (mayor - menor + 1) + menor);
			while (esDif && y < sorteo.length) {
				if (rand == sorteo[y]) {
					esDif = false;
				}
				y++;
			}
			
			if (esDif) {
				sorteo[x] = rand;
				x++;
			}
			esDif = true;
			y = 0;
		}
		return sorteo;
	}
}
