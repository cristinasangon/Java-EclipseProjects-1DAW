package rapasoExamen;

import java.util.Arrays;

public class Repaso1 {

	public Repaso1() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 1  =  ==  =  ==  =  ==  ");
		
		int sorteo[] = generaAleatorios(1, 49, 6);
		System.out.println();
		System.out.println("==================================================");
		System.out.println(" SORTEO: " + Arrays.toString(sorteo));
		System.out.println("==================================================");		
		int aciertos = 0;
		int boletos[][] = new int [10][6];
		for(int x = 0; x <  boletos.length; x++) {
			boletos[x] = generaAleatorios(1, 49, 6);
			for(int y = 0; y <  boletos[x].length; y++) {
				for(int i = 0; i < boletos[x].length; i++) {
					if(sorteo[i] == boletos[x][y]) {
						aciertos++;
					}
				}
			}
			System.out.println("BOLETO " + x + ": " + Arrays.toString(boletos[x]) + "  | " + aciertos + " aciertos");
			aciertos = 0;
		}
		System.out.println("==================================================");		
		
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
