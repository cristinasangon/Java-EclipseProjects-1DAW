package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Tute {

	public Tute() throws IOException {
		//Inicio del programa
		
		//Creo el fichero (solo si no existe)
		File fichero = new File("Ficheros//jugadasTute.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		//Instancio Filereader y Bufferedreader
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		//Saco la primera linea(es el palo del triunfo)
		String paloTriunfo = br.readLine();
		
		//Saco la segunda linea(me dice la cantidad de jugadas que hay)
		int cantidadJugadas = Integer.parseInt(br.readLine());
		
		//Saco la tercera linea(me dice la cantidad de jugadores que hay)
		int cantidadJugadores = Integer.parseInt(br.readLine());
		
		//Creo un array para almacenar las jugadas de cada jugador
		String jugadas[][] = new String[cantidadJugadas][cantidadJugadores];
		String linea = "";
		
		//Creo un bucle para leer el fichero e ir almacenando las jugadas en el array creado anteriormente
		for(int x = 0; x < cantidadJugadas; x++) {
			System.out.println("==================== JUGADA " + (x + 1) + " ====================");
			linea = br.readLine();
			jugadas[x] = linea.split(",");
			
			//Metodo que recibe la jugada y canta
			canta(jugadas[x], paloTriunfo);
			System.out.println();
		}
		
		//Cierro Filereader y Bufferedreader
		br.close();
		fr.close();
		
		//Fin del programa
	}
	public static void canta(String[] jugada, String paloTriunfo) {
		paloTriunfo = Character.toString(paloTriunfo.charAt(paloTriunfo.length()-1));
		String[] palos = {"Copa", "Espada", "Basto", "Oro"}; 
		String[][] ganador = {{"10C" , "11C"}, {"10E" , "11E"}, {"10B" , "11B"}, {"10O" , "11O"}};
		
		int puntos = 0;
		boolean nadieCanta = true;
		
		//Buclle para recorrer la jugada jugador por jugador
		for(int x = 0; x < jugada.length; x++) {
			//Bucle que busca si hay alun 10 y 11 de cualquier palo y suma 20, si es del palo ganador, suma 20 mas
			for(int y = 0; y < ganador.length; y++) {
				puntos = 0;
				if((jugada[x].indexOf(ganador[y][0]) >= 0) && (jugada[x].indexOf(ganador[y][1]) >= 0)) {
					puntos += 20;
					if(y == 0) {
						puntos += 20;
					}
				}
				if(puntos > 0) {
					System.out.println("El jugador " + (x + 1) + " canta " + puntos + " en " + palos[y]);
					nadieCanta = false;
				}
			}
		}
		if(nadieCanta) {
			System.out.println("Nadie canta");
		}
	}
}
