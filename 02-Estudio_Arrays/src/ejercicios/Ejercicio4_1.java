package ejercicios;

public class Ejercicio4_1 {

	public Ejercicio4_1() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 4.1 - - - - - - - - -");
		// Diseñar un programa que reparta cuatro cartas de la baraja española a cuatro jugadores.
		
		String [] baraja = {"1 Oro", "2 Oro", "3 Oro", "4 Oro", "5 Oro", "6 Oro", "7 Oro", "Sota Oro", "Caballo Oro", "Rey Oro",
							"1 Copa", "2 Copa", "3 Copa", "4 Copa", "5 Copa", "6 Copa", "7 Copa", "Sota Copa", "Caballo Copa", "Rey Copa",
							"1 Basto", "2 Basto", "3 Basto", "4 Basto", "5 Basto", "6 Basto", "7 Basto", "Sota Basto", "Caballo Basto", "Rey Basto",
							"1 Espada", "2 Espada", "3 Espada", "4 Espada", "5 Espada", "6 Espada", "7 Espada", "Sota Espada", "Caballo Espada", "Rey Espada",}; 
	
		int [] jugada = generaAleatorios(0,39,16);
		int cont = 0;
		
		for (int x = 1; x < 5; x++) {
			System.out.println("");
			System.out.println("CARTAS DEL JUGADOR " + x);
			for (int y = 0; y < 4; y++) {
				System.out.println(baraja[jugada[cont]]);
				cont++;
			}
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
