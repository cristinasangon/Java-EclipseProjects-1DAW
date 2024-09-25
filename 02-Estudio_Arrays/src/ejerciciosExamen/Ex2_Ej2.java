package ejerciciosExamen;

import java.util.Arrays;

import javax.sound.midi.SysexMessage;

public class Ex2_Ej2 {

	public Ex2_Ej2() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 2 - EJERCICIO 2 == == == ==");
		// 
		String[] baraja = {"1O", "2O", "3O", "4O", "5O",
		          		   "1C", "2C", "3C", "4C", "5C",
	         	           "1E", "2E", "3E", "4E", "5E",
	                       "1B", "2B", "3B", "4B", "5B"};

		int[] reparto = generaAleatoriosSinRepeticion(0, 19, 20);
		int[] cartaGanadora = generaAleatoriosSinRepeticion(0, 19, 1);
		
		System.out.println();
		System.out.println("====================================");
		System.out.println("== == == CARTA GANADORA: " + baraja[cartaGanadora[0]] + " == == ==");
		System.out.println("====================================");
		int z = 0, ganador = 0;
		for(int x = 0; x < 4; x++) {
			System.out.print("= Jugador " + (x + 1) + ": ");
			for(int y = 0; y < 5; y++) {
				if(reparto[z] == cartaGanadora[0]) {
					ganador = x + 1;
				}
				System.out.print(baraja[reparto[z]] + ", ");
				z++;
			}
			System.out.println();
		}
		System.out.println("====================================");
		System.out.println("== == == GANADOR: Jugador " + ganador + " == == ==");
		System.out.println("====================================");

	}
	public static int[] generaAleatoriosSinRepeticion(int limInferior, int limSuperior, int cant) {
		int[] reparto = new int[cant];
		
		if(limInferior > limSuperior) {
			int aux = limInferior;
			limInferior = limSuperior;
			limSuperior = aux;
		}
		
		for(int i = 0; i < reparto.length; i++) {
			reparto[i] = cant + 1;
		}
		
		int x = 0, ale = 0;
		while(x < reparto.length) {
			ale = (int)Math.floor(Math.random()*(limSuperior - limInferior + 1) + limInferior);
			int y = 0;
			boolean esDif = true;
			while(esDif == true && y < reparto.length) {
				if(ale == reparto[y]) {
					esDif = false;
				}
				y++;
			}
			if(esDif == true) {
				reparto[x] = ale;
				x++;
			}
		}
		return reparto;
	}
}
