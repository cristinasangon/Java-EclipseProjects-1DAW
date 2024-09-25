package ejercicios;

public class Ejercicio4_3 {

	public Ejercicio4_3() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 4.3 - - - - - - - - -");
		// Diseñar un programa que reparta cuatro cartas de la baraja española a cuatro jugadores en 10 jugadas diferentes y al final 
		// mostrar todas las jugadas de todos los jugadores. Genera una carta ganadora y muestra cuantas veces han sacado la carta
		// cada jugador. Al final, dice quien o quienes han ganado.
		String [] baraja = {"1 Oro", "2 Oro", "3 Oro", "4 Oro", "5 Oro", "6 Oro", "7 Oro", "Sota Oro", "Caballo Oro", "Rey Oro",
				"1 Copa", "2 Copa", "3 Copa", "4 Copa", "5 Copa", "6 Copa", "7 Copa", "Sota Copa", "Caballo Copa", "Rey Copa",
				"1 Basto", "2 Basto", "3 Basto", "4 Basto", "5 Basto", "6 Basto", "7 Basto", "Sota Basto", "Caballo Basto", "Rey Basto",
				"1 Espada", "2 Espada", "3 Espada", "4 Espada", "5 Espada", "6 Espada", "7 Espada", "Sota Espada", "Caballo Espada", "Rey Espada",}; 

		int [][] jugadas = new int [10][16];
		int lim = 3, y = 0, v = 0, cont = 0, ganador = 0;
		int [] cartaGanadora = generaAleatorios(0, 39, 1);
		int [] aciertos = new int [4];
		boolean [] ganadores = new boolean [4];
		
		for (int x = 0; x < jugadas.length; x++) {
		jugadas[x] = generaAleatorios(0,39,16);
		}
		for(int j = 1; j <= 4; j++) {
			System.err.println();
			System.out.println("- - - - - - - - - - - - - - JUGADOR " + j + " - - - - - - - - - - - - - -");
			for(int x = 0; x < jugadas.length; x++) {
				System.out.println("- - - - JUGADA " + (x + 1));
				while(y <= lim) {
					System.out.print(baraja[jugadas[x][y]] + ", ");
					if(jugadas[x][y] == cartaGanadora [0]) {
						cont ++;
					}
					y++;
				}
				System.out.println();
				y = v;
			}
			aciertos[(j - 1)] = cont;
			cont = 0;
			v = lim;
			lim += 4;
			y = v;
		}
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - CARTA GANADORA: " + baraja[cartaGanadora[0]] + " - - - - - - - - - - - - - -");
		for(int x = 0; x < aciertos.length; x++) {
			System.out.println("El jugador " + (x + 1) + " ha tenido " + aciertos[x] + " aciertos en total");
			if(aciertos[x] > ganador) {
				ganador = aciertos[x];
			}
		}
		
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - GANADORES - - - - - - - - - - - - - -");
		for (int x = 0; x < 4; x++) {
			if (aciertos[x] == ganador) {
				System.out.println("- Jugador " + (x + 1));
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
