package rapasoExamen;

import java.util.Scanner;

public class Repaso7 {

	public Repaso7() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 7  =  ==  =  ==  =  ==  ");
		
		String[] alumnos = {"Cristina", "Victor", "Dieguito", "Diego", "Lidia"};
		String[] asignaturas = {"Mates", "Ingles", "Lengua", "Geografia", "Biologia"};
		int[][] notas = {{10, 7, 1, 3, 8},
						 {9, 8, 2, 5, 5},
						 {7, 5, 3, 2, 8},
						 {5, 7, 8, 5, 9},
						 {7, 8, 5, 7, 6}};
		
		Scanner leer = new Scanner(System.in);
		int op = 1;
		while(op < 6) {
			System.out.println();
			System.out.println("== = == = == = == = == = == = == = == = == = == = == = == = ==");
			System.out.println("ELIGE UNA OPCION (1-6):");
			System.out.println("== = == = == = == = == = == = == = == = == = == = == = == = ==");
			System.out.println("1 - Mostrar las notas de todos los alumnos en cada asignatura");
			System.out.println("2 - Mostrar todas las notas de un alumno y decir si promociona o no");
			System.out.println("2 - Mostrar todas las notas de un alumno y decir si promociona o no");
			System.out.println("3 - Introducir todas las notas de una asignatura");
			System.out.println("4 - Introducir las notas de un alumno en cada asignatura");
			System.out.println("5 - Mostrar todos los alumnos que promocionan");
			System.out.println("6 - Salir");
			System.out.println("== = == = == = == = == = == = == = == = == = == = == = == = ==");
			op = leer.nextInt();
		
			System.out.println();
			System.out.println();
			switch(op) {
				case 1:
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Boletin de clase");
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < notas.length; x++) {
						System.out.println(" " + alumnos[x]);
						for(int y = 0; y < notas[x].length; y++) {
							System.out.println(" - " + asignaturas[y] + ": " + notas[y][x]);
						}
						System.out.println();
					}
					System.out.println("== = == = == = == = == = == = ==");
					break;
				case 2:
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Lista de clase");
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < alumnos.length; x++) {
						System.out.println(x + " - " + alumnos[x]);
					}
					System.out.println("== = == = == = == = == = == = ==");
					
					System.out.print("Introduce el numero del alumno para ver su boletin: ");
					int numLista = leer.nextInt();
					
					System.out.println();
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Boletin de " + alumnos[numLista]);
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < asignaturas.length; x++) {
						System.out.println(asignaturas[x] + ": " + notas[x][numLista]);
					}
					System.out.println("== = == = == = == = == = == = ==");
					if(promociona(notas, numLista)) {
						System.out.println("El alumno promociona");
					}
					else {
						System.out.println("El alumno no promociona");
					}
					System.out.println("== = == = == = == = == = == = ==");
					break;
				case 3:
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Lista de asignaturas");
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < asignaturas.length; x++) {
						System.out.println(x + " - " + asignaturas[x]);
					}
					System.out.println("== = == = == = == = == = == = ==");
					
					System.out.print("Introduce el numero de la asignatura: ");
					int asignatura = leer.nextInt();
					
					for(int x = 0; x < alumnos.length; x++) {
						System.out.println(" - " + alumnos[x] + ": ");
						notas[asignatura][x] = leer.nextInt();
					}
					System.out.println("== = == = == = == = == = == = ==");
					break;
				case 4:
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Lista de alumnos");
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < alumnos.length; x++) {
						System.out.println(x + " - " + alumnos[x]);
					}
					System.out.println("== = == = == = == = == = == = ==");
					
					System.out.print("Introduce el numero de la asignatura: ");
					int alumno = leer.nextInt();
					
					for(int x = 0; x < asignaturas.length; x++) {
						System.out.println(" - " + asignaturas[x] + ": ");
						notas[x][alumno] = leer.nextInt();
					}
					System.out.println("== = == = == = == = == = == = ==");
					break;
				case 5:
					System.out.println("== = == = == = == = == = == = ==");
					System.out.println("Lista de promocionados");
					System.out.println("== = == = == = == = == = == = ==");
					for(int x = 0; x < alumnos.length; x++) {
						if(promociona(notas, x)) {
							System.out.println(" - " + alumnos[x]);
						}
					}
					System.out.println("== = == = == = == = == = == = ==");
			}
		}
		
			
	}
	public static boolean promociona(int[][] notas, int numLista) {
		int susp = 0;
		boolean promociona = true; 
		for(int x = 0; x < notas.length; x++) {
			if(notas[x][numLista] < 5) {
				susp++;
			}
		}
		
		if((susp >= 3) || (notas[0][numLista] < 5 && notas[2][numLista] < 5)) {
			promociona = false;
		}
		return promociona;
	}
}
