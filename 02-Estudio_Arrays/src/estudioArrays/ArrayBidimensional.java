package estudioArrays;

import java.util.Scanner;

public class ArrayBidimensional {

	public ArrayBidimensional() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - ESTUDIO ARRAYS BIDIMENSIONALES - - -");
		Scanner leer = new Scanner(System.in);
		
		int [][] notas;
		int[] numeros = {1,2,3,4,5,6};
		notas = new int [5][20];
		
		int [][] notas2 = new int [6][30];
		notas2 [0][0] = 1;
		
		int [][] notas3 = new int[4][];
		notas3[0] = new int [10];
		notas3[1] = new int [12];
		notas3[2] = new int [15];
		notas3[3] = numeros;
		
		int [][] notas4 = {{5,6,7,8,9,4}
						  ,{5,6,8,1,7,9}
						  ,{5,5,4,6,8,7}
						  ,{2,3,5,6,8,8}};
		for(int x = 0; x < notas4.length; x++) {
			for(int y = 0; y < notas4[x].length; y++) {
				System.out.print(notas4[x][y] + "-");
			}
			System.out.println("");
		}
		
		System.out.println("================================================");
		
		for(int x = 0; x < notas4.length; x++) {
			for(int y = 0; y < notas4[x].length; y++) {
				notas4[x][y] = (int) (Math.random() * 10);
				System.out.print(notas4[x][y] + "-");
			}
			System.out.println("");
		}
		
		System.out.println("================================================");
		
		imprimirArray(notas4);
		
		System.out.println("================================================");
		
		for(int x = 0; x < notas4.length; x++) {
			for(int y = 0; y < notas4[x].length; y++) {
				System.out.print(notas4[x][y] + "-");
			}
			System.out.println("");
		}
		
		System.out.println("================================================");
		
		String nombres[] = {"Maria", "Cristina", "Victor", "Antonia", "Manola", "Sergio"};
		String asignaturas[] = {"Programacion", "Sistemas", "Bases de datos", "Lenguaje de marcas"};
		
		System.out.println("");
		System.out.printf("Introduce una asignatura: %n 1 - Programacion %n 2 - Sistemas %n 3 - Bases de datos %n 4 - Lenguaje de marcas %n");
		int num = leer.nextInt();
		num--;
		
		System.out.println("");
		System.out.println(asignaturas[num]);
		System.out.println("==================");
		for(int y = 0; y < notas4[num].length; y++) {
			System.out.println(nombres[y] + " -------> " + notas4[num][y]);
		}
		
		System.out.println("");
		System.out.print("Introduce el numero del alumno(1-6)");
		num = leer.nextInt();
		num--;
		
		System.out.println("");
		System.out.println(nombres[num]);
		System.out.println("==================");
		for(int x = 0; x < notas4.length; x++) {
			System.out.println(asignaturas[x] + " -------> " + notas4[x][num]);
		}
	}
	private void imprimirArray(int[][] notas) {
		notas[0][0] = 0;
		for(int x = 0; x < notas.length; x++) {
			for(int y = 0; y < notas[x].length; y++) {
				System.out.print(notas[x][y] + "-");
			}
			System.out.println("");
		}
	}
}
