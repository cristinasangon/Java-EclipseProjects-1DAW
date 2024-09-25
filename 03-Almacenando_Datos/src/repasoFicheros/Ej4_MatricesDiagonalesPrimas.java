package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ej4_MatricesDiagonalesPrimas {

	public Ej4_MatricesDiagonalesPrimas() throws IOException {
		File fichero = new File("FicherosRepaso//matricesDiagonalesPrimas.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		int cantMatrices = Integer.parseInt(linea);
		
		for(int x = 0; x < cantMatrices; x++) {
			linea = br.readLine();
			int indice = Integer.parseInt(linea);
			int[][] matriz = new int[indice][indice];
			
			for(int y = 0; y < indice; y++) {
				linea = br.readLine();
				matriz[y] = convierteStringEnArrayInt(linea);
			}
			System.out.println("__________________________________________________");
			System.out.println("Indice: " + indice);
			System.out.println("-------------------------");
			muestraMatriz(matriz);
			System.out.println("-------------------------");
			int[] diaonalInversa = sacarDiagonalInversa(matriz);
			for(int y = 0; y < diaonalInversa.length; y++) {
				int sumaDigitos = sumaDigitos(diaonalInversa[y]);
				System.out.print(diaonalInversa[y] + "..." + sumaDigitos);
				if(esPrimo(sumaDigitos)) {
					System.out.print("...PRIMO");
				}
				System.out.println();
			}
		}
	}
	
	public static int[] convierteStringEnArrayInt(String linea) {
		String[] lineaArray = linea.split(",");
		int[] lineaConvertida = new int[lineaArray.length];
		
		for(int x = 0; x < lineaArray.length; x++) {
			lineaConvertida[x] = Integer.parseInt(lineaArray[x]);
		}
		
		return lineaConvertida;
	}
	
	public static void muestraMatriz(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.printf("%-4d", matriz[x][y]);
			}
			System.out.println();
		}
	}
	
	public static int[] sacarDiagonalInversa(int[][] matriz) {
		int[] diagonalInversa = new int[matriz.length];
		int x = 0, y = matriz.length - 1;
		
		while(x < diagonalInversa.length) {
			diagonalInversa[x] = matriz[x][y];
			x++;
			y--;
		}
		
		return diagonalInversa;
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
		
		while(x < num) {
			if(num%x == 0) {
				return false;
			}
			x++;
		}
		return true;
	}

}
