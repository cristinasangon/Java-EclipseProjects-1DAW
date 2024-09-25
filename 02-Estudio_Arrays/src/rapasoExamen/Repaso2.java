package rapasoExamen;

import java.util.Arrays;

public class Repaso2 {

	public Repaso2() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 2  =  ==  =  ==  =  ==  ");
		
		int sorteo[] = generaAleatorios(1, 49, 6);
		System.out.println("==================================================");
		System.out.println(" SORTEO: " + Arrays.toString(sorteo));
		System.out.println("==================================================");	
		
		int aciertos = 0, intentos = 0;
		int boleto[] = new int[6];
		while(aciertos < 6) {
			aciertos = 0;
			boleto = generaAleatorios(1, 49, 6);
			intentos++;
			for(int x = 0; x < boleto.length; x++) {
				for(int y = 0; y < boleto.length; y++) {
					if(boleto[x] == sorteo[y]) {
						aciertos++;
					}
				}
			}
		}
		System.out.println(" BOLETO GANADOR: " + Arrays.toString(boleto));
		System.out.println("==================================================");
		System.out.println();		
		System.out.println("Se han realizado " + intentos + " intentos");
		
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
