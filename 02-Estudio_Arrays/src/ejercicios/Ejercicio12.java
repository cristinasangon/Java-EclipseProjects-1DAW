package ejercicios;

import java.util.Scanner;

public class Ejercicio12 {

	public Ejercicio12() {
		// TODO Auto-generated constructor stub
		System.out.println("- - - - - - - - - EJERCICIO 12 - - - - - - - - -");
		// Programa que muestre todas las notas de un alumno. Decir si promociona o no 
		// según las siguientes condiciones: 
		// - No promociona si ha suspendido 3 o más asignaturas
		// - No promociona si ha suspendido Lengua y Matemáticas
		Scanner leer = new Scanner(System.in);
		
		String[] alumnos = {"Cristina", "Victor", "Sandra", "Sofia", "Felipe"};
		String[] asignaturas = {"Lengua", "Ingles", "Matematicas", "Biologia", "Geografia"};
		
		int[][] notas = {{10,9,3,6,2},
						 {9,10,5,2,9},
						 {6,5,2,8,3},
						 {9,6,1,5,7},
						 {8,7,6,2,8}};
		
		System.out.println();
		System.out.println("LISTA DE ALUMNOS");
		System.out.println("-------------------------------");
		for(int x = 0; x < alumnos.length; x++) {
			System.out.printf("%d - %5s %n", x, alumnos[x]);
		}
		
		System.out.print("Introduce el numero de lista del alumno: ");
		int numLista = leer.nextInt();
		int susp = 0;
		
		System.out.println();
		System.out.println(alumnos[numLista]);
		System.out.println("-------------------------------");
		for(int x = 0; x < notas.length; x++) {
			System.out.println(asignaturas[x] + ": " + notas[x][numLista]);
			if(notas[x][numLista] < 5) {
				susp++;
			}
		}
		
		System.out.println();
		if(susp > 2 || (notas[0][numLista] < 5 && notas[2][numLista] < 5)) {
			System.out.println("El alumno no promociona");
		}
		else {
			System.out.println("El alumno promociona");
		}
	}

}
