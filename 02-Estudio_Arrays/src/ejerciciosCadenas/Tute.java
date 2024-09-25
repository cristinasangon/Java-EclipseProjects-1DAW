package ejerciciosCadenas;

import java.util.Arrays;

public class Tute {

	public Tute() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO TUTE == == == ==");
		// Programa que simule juego del tute segun enunciado classroom
		String[] cartas = {"1O","2O","3O","4O","5O","6O","7O","10O","11O","12O", 
						   "1B","2B","3B","4B","5B","6B","7B","10B","11B","12B",
						   "1C","2C","3C","4C","5C","6C","7C","10C","11C","12C",
						   "1E","2E","3E","4E","5E","6E","7E","10E","11E","12E",};
		String[] palos = {"Oro", "Basto", "Copas", "Espadas"};
		int[] jugada = new int[40];
		String[][] jugadas = new String[3][4];
		int z = 0;
		
		int[] ganador = reparteCartas(0, 39, 1);
		int paloGanador = ganador[0];
		
		for(int x = 0; x < jugadas.length; x++) {
			jugada = reparteCartas(0, 39, 40);
			for(int y = 0; y < jugadas[x].length; y++) {
				jugadas[x][y] = "";
				for(int i = 0; i < 10; i++) {
					jugadas[x][y] += cartas[jugada[z]];
					
					z++;
				}
			}
			System.out.println(Arrays.toString(jugadas[x]));
			z = 0;
		}
		
		int cantar = 0;
		boolean nadieCanta = true;
		for(int x = 0; x < jugadas.length; x++) {
			System.out.println();
			System.out.println("==  ==  ==  JUGADA " + (x + 1) + " ==  ==  ==");
			for(int y = 0; y < jugadas[x].length; y++) {
				int cante[] = canta(jugadas[x][y]);
				for(int i = 0; i < cante.length; i++) {
					if(cante[i] == 2) {
						cantar = 20;
						if(i == paloGanador){
							cantar = 40;
						}
					}
					if(cantar > 0) {
						System.out.println("El jugador " + (y + 1) + " canta " + cantar + " en " + palos[i]);
						nadieCanta = false;
					}
					cantar = 0;
				}
			}
			if(nadieCanta) {
				System.out.println("Nadie canta");
			}
			nadieCanta = true;
		}
		
		
	}
	public static int[]reparteCartas(int menor, int mayor, int cant){
		int[] cartas = new int[cant];
		int rand = 0, x = 0, y = 0;
		boolean esIgu = false;
		
		if(menor > mayor) {
			int aux = mayor;
			mayor = menor;
			menor = aux;
		}
		
		for(int z = 0; z < cartas.length; z++) {
			cartas[z] = mayor + 1;
		}
		
		while(x < cartas.length) {
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			while(esIgu == false && y < cartas.length) {
				if(rand == cartas[y]) {
					esIgu = true;
				}
				y++;
			}
			if(esIgu == false) {
				cartas[x] = rand;
				x++;
			}
			esIgu = false;
			y = 0;
		}
		return cartas;
	}
	
	public static int[] canta(String jugadas) {
		String[][] cartas = {{"11O","12O"}, {"11B","12B"}, {"11C","12C"}, {"11E","12E"}};
		int[] puntos = new int[4];
		for(int x = 0; x < cartas.length; x++) {
			for(int y = 0; y < cartas[x].length; y++) {
				if(jugadas.indexOf(cartas[x][y]) >= 0) {
					puntos[x]++;
				}
			}
		}
		return puntos;
	}
}
