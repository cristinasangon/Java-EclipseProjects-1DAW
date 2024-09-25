package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ej7_Tute {

	public Ej7_Tute() throws IOException {
		File fichero = new File("FicherosRepaso//tute.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String[] jugada = new String[4];
		for(int x = 0; x < jugada.length; x++) {
			jugada[x] = br.readLine();
		}
		
		String paloTriunfo = br.readLine();
		
		br.close(); fr.close();
		
		System.out.println("=============================================");
		System.out.println("JUGADA TUTE");
		System.out.println("=============================================");
		int cante = 0;
		boolean nadieCanta = true;
		for(int x = 0; x < jugada.length; x++) {
			cante += canta(jugada[x], paloTriunfo, (x + 1));
			if(cante == 1) {
				nadieCanta = false;
			}
		}
		
		if(nadieCanta) {
			System.out.println("Nadie canta");
		}
	}
	
	public static int canta(String jugadaJugador, String paloTriunfo, int jugador) {
		String[][] palos = {{"11C", "12C"}, {"11B", "12B"}, {"11O", "12O"}, {"11E", "12E"},};
		String[] palosCante = {"Copa", "Basto", "Oro", "Espada"};
		
		for(int x = 0; x < palos.length; x++) {
		int cont = 0;
			for(int y = 0; y < palos[x].length; y++) {
				if(jugadaJugador.indexOf(palos[x][y]) >= 0) {
					cont++;
				}
				if(cont == 2) {
					String paloComprueba = palos[x][y];
					paloComprueba = paloComprueba.substring(2, 3);
					if(paloComprueba.equals(paloTriunfo)) {
						cont++;
					}
				}
			}
			if(cont == 3) {
				System.out.println("El jugador " + jugador + " canta 40 en " + palosCante[x]);
				return 1;
			}
			else if(cont == 2) {
				System.out.println("El jugador " + jugador + " canta 20 en " + palosCante[x]);
				return 1;
			}
		}
		
		return 0;
	}

}
