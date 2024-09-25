package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Rep_Ej4_MatricesDiagonalesPrimas {

	public Rep_Ej4_MatricesDiagonalesPrimas() throws IOException {
		File fichero = new File("FicherosRepaso//matricesDiagonalesPrimas.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		int cantMatrices = Integer.parseInt(linea);
	
		for(int x = 0; x < cantMatrices; x++) {
			System.out.println("___________________________________________________________");
			System.out.println("MATRIZ " + (x + 1));
			System.out.println("----------");
			linea = br.readLine();
			int indice = Integer.parseInt(linea);
			String[][] matrizTemporal = new String[indice][indice];
			for(int y = 0; y < indice; y++) {
				linea = br.readLine();
				matrizTemporal[y] = linea.split(",");
			}
			int[][]matriz = Utilidades.convierteArrayStringEnInt(matrizTemporal);
			Utilidades.mostrarMatriz(matriz);
			
			System.out.println("-----------------");
			int[] diagonalInversa = Utilidades.sacarDiagonalInversa(matriz);
			for(int y = 0; y < diagonalInversa.length; y++) {
				int sumaDigitos = Utilidades.sumaDigitos(diagonalInversa[y]);
				System.out.print(diagonalInversa[y] + "..." + sumaDigitos);
				
				if(Utilidades.esPrimo(sumaDigitos)) {
					System.out.print("...PRIMO");
				}
				System.out.println();
			}
		}
		
		br.close(); fr.close();
	}
	
}
