package ejerciciosExamen;

import java.util.Scanner;

public class Ex2_Ej1 {

	public Ex2_Ej1() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 2 - EJERCICIO 1 == == == ==");
		// 
		Scanner leer = new Scanner(System.in);
		
		int susp = 0;
		boolean promociona = true;
		String[] alumnos = {"Pepe", "Maria", "Luis", "Juan", "Marina", "Carmen", "Antonio", "Ana", "Fernando", "Rosario"};
		String[] asignaturas = {"Ingles", "Matematicas", "Naturales", "Lengua", "Geografia"};
		int[][] notas = {{3, 5, 6, 7, 8, 6, 7, 4, 5, 6},
		                 {6, 4, 7, 5, 7, 5, 6, 9, 2, 9},
		                 {3, 6, 4, 7, 8, 6, 5, 5, 9, 2},
		                 {5, 3, 5, 7, 8, 4, 7, 3, 4, 6},
		                 {5, 6, 4, 7, 8, 6, 5, 3, 6, 2}};

		System.out.println();
		System.out.println("==============================================");
		System.out.println("Elige una opcion");
		System.out.println("==============================================");
		System.out.println("1 - Mostrar todos los alumnos que promocionan");
		System.out.println("2 - Mostrar el boletin de un alumno");
		System.out.println("==============================================");
		int op = leer.nextInt();
		
		switch(op) {
			case 1:
				System.out.println();
				System.out.println("LISTADO DE PROMOCIONADOS");
				System.out.println("==============================================");
				for(int y = 0; y < alumnos.length; y++) {
					for(int x = 0; x < asignaturas.length; x++) {
						if(notas[x][y] < 5) {
							susp++;
						}
					}
					if((susp >= 3) || (notas[1][y] < 5 && notas[3][y] < 5)) {
						promociona = false;
					}
					else{
						System.out.println(alumnos[y]);
					}
					promociona = true;
					susp = 0;
				}
				break;
			case 2:
				System.out.println();
				System.out.println("LISTA DE ALUMNOS");
				System.out.println("==============================================");
				for(int x = 0; x < alumnos.length; x++) {
					System.out.println(x + " - " + alumnos[x]);
				}
				
				System.out.println();
				System.out.println("Introduce el numero de lista del alumno: ");
				int numLista = leer.nextInt();
				
				System.out.println();
				System.out.println(alumnos[numLista]);
				System.out.println("==============================================");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.printf("%-15s %s %n", asignaturas[x], notas[x][numLista]);
				}
		}
	}

}
