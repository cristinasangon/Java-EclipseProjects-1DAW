package ejercicios;

public class Ejercicio7 {

	public Ejercicio7() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 7 - - - - - - - - -");
		// Diseña un programa en Java que rellene un array de 4x4 de la siguiente manera:
		// 1 0 0 0
		// 0 1 0 0
		// 0 0 1 0
		// 0 0 0 1
		// A continuación muestre el contenido del array por pantalla.
		
		int matriz[][] = new int [4][4];
		int x = -1, y = -1;
		
		for(int v = 0; v < 4; v++) {
			x++;
			y++;
			matriz[x][y] = 1;
		}
	
		for(x = 0; x < 4; x++) {
			for(y = 0; y < 4; y++) {
				System.out.printf("| %2d ", matriz[x][y]);
			}
			System.out.print("|");
			System.out.println();
		}
	
	}

}
