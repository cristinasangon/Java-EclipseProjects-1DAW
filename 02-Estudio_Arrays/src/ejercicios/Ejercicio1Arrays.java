package ejercicios;

import java.util.Scanner;

public class Ejercicio1Arrays {

	public Ejercicio1Arrays() {
		Scanner leer = new Scanner (System.in);

		// Programa que permita introducir las notas de 30 alumnos de la asignatura de programacion y una vez introducidas mostrar un menu:
		// 1. Mostrar listado de nomres con sus respectivas notas asi como su numero de lista
		// 2. Modificar una nota de un alumno introduciendo su numero de lista para identificar
		// 3. Mostrar estadisticas de las notas de los alumnos - sobresaliente (9 - 10)
		//													   - notable (7 - 8)
		//	                                             	   - bien (6)
		//  	 											   - aprobado (5)
		//	                                                   - suspenso (0 - 5)
		
		int op = 0;

		String [] nombres = new String [30];
		nombres[0] = "Clara";nombres[1] = "Matias";nombres[2] = "Benjamin";nombres[3] = "Antonio";nombres[4] = "Kivich";
		nombres[5] = "Tomas";nombres[6] = "Lucia";nombres[7] = "Benito";nombres[8] = "Santiago";nombres[9] = "Carlota";
		nombres[10] = "Martina";nombres[11] = "Mariela";nombres[12] = "Victor";nombres[13] = "Cristina";nombres[14] = "Diego";
		nombres[15] = "Laura";nombres[16] = "Tamara";nombres[17] = "Pablo";nombres[18] = "Dolores";nombres[19] = "Ramon";
		nombres[20] = "Maria";nombres[21] = "Maria";nombres[22] = "Manolo";nombres[23] = "Juan";nombres[24] = "Pepe";
		nombres[25] = "Salvador";nombres[26] = "Antonia";nombres[27] = "Daniela";nombres[28] = "Josefa";nombres[29] = "Marta";
		
		double [] notas = new double [30]; 
		notas[0] = 4;notas[1] = 7;notas[2] = 1;notas[3] = 1;notas[4] = 2;notas[5] = 4;notas[6] = 2;notas[7] = 6;notas[8] = 8;notas[9] = 9;
		notas[10] = 2;notas[11] = 5;notas[12] = 10;notas[13] = 10;notas[14] = 5;notas[15] = 6;notas[16] = 7;notas[17] = 6;notas[18] = 2;notas[19] = 10;
		notas[20] = 3;notas[21] = 1;notas[22] = 7;notas[23] = 6;notas[24] = 4;notas[25] = 2;notas[26] = 3;notas[27] = 2;notas[28] = 7;notas[29] = 8;
				
		while (op != 4){
				System.out.println("");
				System.out.println("- - - - - - - - - - - - MENU PRINCIPAL - - - - - - - - - - - -");
				System.out.println("ELIGE UNA OPCION:");
				System.out.println("");
				System.out.println(" 1 - Mostrar un listado de todos los alumnos y sus notas");
				System.out.println(" 2 - Modificar la nota de un alumno en especifico");
				System.out.println(" 3 - Ver estadisticas de las calificaciones");
				System.out.println("");
				System.out.println(" 4 - Salir");
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				op = leer.nextInt();
			
			System.out.println("");
			switch (op)	{
				case 1:
					System.out.println("LISTADO DE ALUMNOS");
					System.out.println("");
					for (int x = 0; x < nombres.length; x++) {
						System.out.printf("%-2d - %-10s %-20.0f %n", x, nombres[x], notas[x]);
					}	
					break;
					
				case 2:
					int id = -1,  confirmar = -1;
					while(id < 0 || id > 29) {
						System.out.print("Introduce el numero de lista del alumno a modificar (0-29): ");
						id = leer.nextInt();
						
						while (confirmar != 1 && confirmar != 2) {
						System.out.println("");
						System.out.println("¿Estas seguro de que quieres modificar la nota de " + nombres[id] + "?");
						System.out.println("1 - Si, cotinuar");
						System.out.println("2 - No, introducir otra id");
						confirmar = leer.nextInt();
						}
						
						if (confirmar == 2) {
							id = -1;
							confirmar = -1;
						}
					}
					int nuevaNota = -1;
					while (nuevaNota < 0 || nuevaNota > 10) {
						System.out.printf("Introduce la nueva nota para %s (0-10): %n", nombres[id]);
						nuevaNota = leer.nextInt();
					}
					notas[id] = nuevaNota;
					break;
				
				case 3:
					int sobre = 0, not = 0, bien = 0, apro = 0, susp = 0;
					for (int x = 0; x < notas.length; x++) {
						if(notas[x] == 9 || notas[x] == 10) {
						sobre ++;
						}
						else if(notas[x] == 7 || notas[x] == 8) {
						not ++;
						}
						else if(notas[x] == 6) {
						bien ++;
						}
						else if(notas[x] == 5) {
						apro ++;
						}
						else{
						susp ++;
						}
					}
					System.out.printf("%n Porcentaje de sobresalientes: %.2f", porcentaje(sobre)); System.out.print("%");
					System.out.printf("%n Porcentaje de notables: %.2f", porcentaje(not)); System.out.print("%");
					System.out.printf("%n Porcentaje de bien: %.2f", porcentaje(bien)); System.out.print("%");
					System.out.printf("%n Porcentaje de aprobados: %.2f", porcentaje(apro)); System.out.print("%");
					System.out.printf("%n Porcentaje de susapensos: %.2f", porcentaje(susp)); System.out.print("%");
					System.out.println("");
					break;
				case 4:
					System.out.println("¡Hasta la proxima!");
					break;
				default:
						System.err.println("ERROR: Introduzca una opcion valida (1-4)");
					break;
			}
			
		}
		
	}
	
	public static double porcentaje (int y) {
		double x = 0;
		x = ((double)y * 100)/30;
		return x;
	}
}
