package ejercicios;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Aleatorios {

	public Aleatorios() {
		// TODO Auto-generated constructor stub
		System.out.println("ALEATORIOS");
		int [] aleatorios = generaAleatorios(0, 7, 8);
		System.out.println(Arrays.toString(aleatorios));
	}
	public static int [] generaAleatorios(int menor, int mayor, int cant) {
		int[] resultado = new int[cant]; 
		int rand = 0, x = 0, y = 0;
		boolean esDif = true;
		
		if(menor > mayor) {
			int aux = mayor;
			mayor = menor;
			menor = aux;
		}
		
		while(x < resultado.length) {
			esDif = true;
			y = 0;
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			while(esDif == true && y < resultado.length) {
				if(rand == resultado[y]) {
					esDif = false;
				}
				y++;
			}
			if(esDif == true) {
				resultado[x] = rand;
				x++;
			}
		}
		
		return resultado;
	}
}
