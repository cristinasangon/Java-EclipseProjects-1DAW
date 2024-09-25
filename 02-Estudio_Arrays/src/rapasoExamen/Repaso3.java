package rapasoExamen;

import java.util.Arrays;

public class Repaso3 {

	public Repaso3() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 3  =  ==  =  ==  =  ==  ");
		
		String [] baraja = {"1 Oro", "2 Oro", "3 Oro", "4 Oro", "5 Oro", "6 Oro", "7 Oro", "Sota Oro", "Caballo Oro", "Rey Oro",
				"1 Copa", "2 Copa", "3 Copa", "4 Copa", "5 Copa", "6 Copa", "7 Copa", "Sota Copa", "Caballo Copa", "Rey Copa",
				"1 Basto", "2 Basto", "3 Basto", "4 Basto", "5 Basto", "6 Basto", "7 Basto", "Sota Basto", "Caballo Basto", "Rey Basto",
				"1 Espada", "2 Espada", "3 Espada", "4 Espada", "5 Espada", "6 Espada", "7 Espada", "Sota Espada", "Caballo Espada", "Rey Espada",}; 
		int[] cartaGanadora = generaAleatorios(0, 39, 1);
		
		int[][] jugadas = new int[10][16];
		for(int x = 0; x < jugadas.length; x++) {
			jugadas[x] = generaAleatorios(0, 39, 40);
		}
		
		int[] aciertos = new int[4];
		int max = 4, min = 0, y = 0, acierto = 0;
		for(int j = 0; j < 4; j++) {
			System.out.println();
			System.out.println("=====================================");
			System.out.println(" JUGADOR: " + (j + 1));	
			for(int x = 0; x < jugadas.length; x++) {
				System.out.print(" - Jugada " + (x + 1) + ": ");
				while(y < max) {
					System.out.print(baraja[jugadas[x][y]] + ", ");
					if(jugadas[x][y] == cartaGanadora[0]) {
						acierto++;
					}
					y++;
				}
				y = min;
				System.out.println();
			}
			aciertos[j] = acierto;
			acierto = 0;
			y = max;
			min = max;
			max += 4;
		}
		
		System.out.println("==================================================");
		System.out.println();
		System.out.println(" CARTA GANADRA: " + baraja[cartaGanadora[0]]);
		System.out.println();		
		System.out.println("==================================================");	
		
		int mayor = 0;
		for(int x = 0; x < aciertos.length; x++) {
			System.out.println("JUGADOR " + (x + 1) + ": " + aciertos[x] + " aciertos");
			if(aciertos[x] > mayor) {
				mayor = aciertos[x];
			}
		}
		System.out.println("==================================================");	
		System.out.println();
		System.out.println(" GANADORES: ");
		for(int x = 0; x < aciertos.length; x++) {
			if(aciertos[x] == mayor) {
				System.out.println(" - Jugador " + (x + 1));
			}
		}
		
		
	}
	public static int[] generaAleatorios(int menor, int mayor, int cant) {
		int[] aleatorios = new int[cant];
		int x = 0, y = 0, rand = 0;
		boolean esDif = true;
		
		for(int i = 0; i < aleatorios.length; i++) {
			aleatorios[i] = mayor + 1;
		}
		
		while(x < aleatorios.length) {
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			y = 0;
			esDif = true;
			while(esDif == true && y < aleatorios.length) {
				if(rand == aleatorios[y]) {
					esDif = false;
				}
				y++;
			}
			if(esDif == true) {
				aleatorios[x] = rand;
				x++;
			}
		}
		return aleatorios;
	}
}
