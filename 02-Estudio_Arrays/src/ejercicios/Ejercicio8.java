package ejercicios;

public class Ejercicio8 {

	public Ejercicio8() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 8 - - - - - - - - -");
		// Dado un array de enteros de tamaño 5x5, diseñar un programa en Java que lo rellene 
		// como en la siguiente figura:
		// 0 1 2 3 4
		// 1 2 3 4 3
		// 2 3 4 3 2
		// 3 4 3 2 1
		// 4 3 2 1 0
		
		int cont = 0, aumento = 1, primero = -1;
		int matriz[][] = new int [5][5];
		
		for(int x = 0; x < 5; x++) {
			cont = primero;
			for(int y = 0; y < 5; y++) {
				cont = cont + aumento;
				if(cont ==4) {
					aumento = -1;
				}
				matriz [x][y] = cont;
			}
			aumento = 1;
			primero++;
		}
		
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				System.out.printf("| %2d ", matriz[x][y]);
			}
			System.out.print("|");
			System.out.println();
		}
	}

}
