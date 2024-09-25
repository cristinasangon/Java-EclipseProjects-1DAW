package repasoFicheros;

public class Utilidades {
	//SOLO SIRVE PARA MATRIZ QUE TIENE TODAS LAS FILAS CON EL MISMO TAMAÑO Y TODAS LAS COLUMNAS CON EL MISMO TAMAÑO
	public static int[][] convierteArrayStringEnInt(String[][]array){
	int[][] arrayConvertida = new int[array.length][array[0].length];
	
	for(int x = 0; x < array.length; x++) {
		for(int y = 0; y < array[x].length; y++) {
			arrayConvertida[x][y] = Integer.parseInt(array[x][y]);
		}
	}
	
	return arrayConvertida;	
	}
	
	public static void mostrarMatriz(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.printf("%-5d", matriz[x][y]);
			}
			System.out.println();
		}
	}
	
	//SOLO SIRVE PARA MATRICES CUADRADAS
	public static int[] sacarDiagonalInversa(int[][]matriz) {
		int[] diagonalinversa = new int[matriz.length];
		int y = matriz.length - 1; 
		
		for(int x = 0; x < diagonalinversa.length; x++) {
			diagonalinversa[x] = matriz[x][y];
			y--;
		}
		
		return diagonalinversa;
	}
	
	public static int sumaDigitos(int num) {
		int suma = 0;
		
		while(num%10 > 0) {
			suma += num%10;
			num /= 10;
		}
		
		return suma;
	}
	
	public static boolean esPrimo(int num) {
		int x = 2;
		
		if(num < 0) {
			return false;
		}
		while(x < num) {
			if((num%x) == 0) {
				return false;
			}
			x++;
		}
		
		return true;
	}
}
