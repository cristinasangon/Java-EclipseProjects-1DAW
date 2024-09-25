package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ej8_RepartoCartas {

	public Ej8_RepartoCartas() throws IOException {
		File fichero = new File("FicherosRepaso//repartoCartas.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		int cantJugadas = Integer.parseInt(br.readLine());
		int cantJugadores = Integer.parseInt(br.readLine());
		String cartaGanadora = br.readLine();
		String[][] jugadas = new String[cantJugadas][cantJugadores];
				
		for(int x = 0; x < cantJugadas; x++) {
			String linea = br.readLine();
			jugadas[x] = linea.split(",");
		}
		
		br.close(); fr.close();
		
		int[] jugadasGanadas = new int[cantJugadores];
		for(int x = 0; x < jugadas.length; x++) {
			System.out.println("______________________________________________");
			System.out.println("Jugada " + (x + 1));
			System.out.println("Gana el jugador " + (devuelveGanador(jugadas[x]) + 1));
			
			jugadasGanadas[devuelveGanador(jugadas[x])] += 1;
		}
		
		int cantidadGanadora = cantidadJugadasGanadasMaxima(jugadasGanadas);
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("Jugadores que han ganado mas veces (Han ganado " + cantidadGanadora + " jugadas)");
		System.out.println("==========================================================");
		for(int x = 0; x < jugadasGanadas.length; x++) {
			if(jugadasGanadas[x] == cantidadGanadora) {
				System.out.println("jugador " + (x + 1));
			}
		}
		
	}
	public static int devuelveGanador(String[] jugada) {
		int ganador = 0;
		
		for(int x = 0; x < jugada.length; x++) {
			if(jugada[x].indexOf("3C") >= 0) {
				ganador = x;
			}
		}
		
		return ganador;
	}
	
	public static int cantidadJugadasGanadasMaxima(int[] jugadasGanadas) {
		int cant = 0;
		
		for(int x = 0; x < jugadasGanadas.length; x++) {
			if(cant < jugadasGanadas[x]) {
				cant = jugadasGanadas[x];
			}
		}
		
		return cant;
	}
}
