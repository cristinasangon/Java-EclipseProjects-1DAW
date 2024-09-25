package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Rep_Ej8_RepartoCartas {

	public Rep_Ej8_RepartoCartas() throws IOException {
		File fichero = new File("FicherosRepaso//repartoCartas.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		int cantJugadas = Integer.parseInt(br.readLine());
		String cartaGanadora = br.readLine();
		
		String[][] jugadas = new String[cantJugadas][4];
		for(int x = 0; x < jugadas.length; x++) {
			String linea = br.readLine();
			jugadas[x] = linea.split(",");
		}
		
		br.close(); fr.close();
		
		int[] cantidadJugadasGanadas = new int[4];
		for(int x = 0; x < jugadas.length; x++) {
			System.out.println("------------------------------");
			System.out.println("JUGADA " + (x + 1));
			System.out.println();
			for(int y = 0; y < jugadas[x].length; y++) {
				if(jugadas[x][y].indexOf(cartaGanadora) >= 0) {
					System.out.println("Gana el jugador " + (y + 1));
					cantidadJugadasGanadas[y]++;
				}
			}
			System.out.println("------------------------------");
			System.out.println();
		}
		
		System.out.println("------------------------------------------");
		System.out.println("JUGADORES CON MAS RONDAS GANADAS");
		System.out.println();
		int mayorCantidadRondasGanadas = sacarCantidadGanadaMaxima(cantidadJugadasGanadas);
		for(int x = 0; x < cantidadJugadasGanadas.length; x++) {
			if(mayorCantidadRondasGanadas == cantidadJugadasGanadas[x]) {
				System.out.println(" - Jugador " + (x + 1));
			}
		}
		System.out.println("------------------------------------------");
	}
	public static int sacarCantidadGanadaMaxima(int[] cantidadJugadasGanadas) {
		int mayorCantidad = 0;
		
			for(int x = 0; x < cantidadJugadasGanadas.length; x++) {
				if(mayorCantidad < cantidadJugadasGanadas[x]) {
					mayorCantidad = cantidadJugadasGanadas[x]; 
				}
			}
			
		return mayorCantidad;
	}
}
