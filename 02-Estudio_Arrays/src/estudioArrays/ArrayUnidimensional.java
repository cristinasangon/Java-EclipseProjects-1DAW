package estudioArrays;

public class ArrayUnidimensional {

	public ArrayUnidimensional() {
		System.out.println("- - - ESTUDIO ARRAYS UNIDIMENSIONALES - - -");
		
		int[]enteros;
		enteros = new int[10];
		enteros[0] = 7;enteros[1] = 8;enteros[2] = 9;enteros[3] = 7;enteros[4] = 5;enteros[5] = 2;enteros[6] = 7;
	
		System.out.println("");
		int suspensos = 0;
		int notas[] = {8,2,6,4,5,6,7,8,3,10};
		for(int x = 0; x < 10; x++) {
			System.out.print(notas[x] + ", ");
			if(notas[x] < 5) {
				suspensos++;
			}
		}
		System.out.println("");
		System.out.println("Suspensos: " + suspensos);
		
		int notas2[] = notas;
		notas2[0] = 10;
		metodo1(notas);
		
		System.out.println("");
		int primitiva[] = generaPrimitiva();
		for(int x = 0; x < primitiva.length; x++) {
			System.out.print(primitiva[x] + " - ");
		}
		
		System.out.println("");
		System.out.println("");
		String nombres[] = {"Alba", "Cristina", "Victor", "Elena", "Antonio", "Andres", "Gabi", "Jose Antonio", "Pedro", "Dani"};
		for(int x = 0; x < notas.length; x++) {
			System.out.println(nombres[x] + ": " + notas[x]);
		}
	}
	private int[] generaPrimitiva() {
		int nuevaPrimitiva[] = {5,14,28,9,6,38};
		return nuevaPrimitiva;
	}

	private void metodo1(int[] notasModificadas) {
		// TODO Auto-generated method stub
		notasModificadas[9] = 0;
	}

}
