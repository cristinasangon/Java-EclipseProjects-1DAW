package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import ejercicos_ficheros.Leer;

public class Ej6_NotasAlumnos {

	public Ej6_NotasAlumnos() throws IOException {
		File fichero = new File("FicherosRepaso//notasAlumnos.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		//Abro lectura para almacenar datos
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		//Leemos primera linea(alumnos)
		String linea = br.readLine();
		String[] alumnos = linea.split(",");
		
		//Leemos segunda linea(asignaturas)
		linea = br.readLine();
		String[] asignaturas = linea.split(",");
		
		//Leemos con bucle las siguientes lineaa(notas)
		int[][] notas = new int[asignaturas.length][alumnos.length];
		for(int x = 0; x < notas.length; x++) {
			linea = br.readLine();
			notas[x] = convierteStringEnArrayInt(linea);
		}
		
		//Cierro lectura de fichero y trabajo con mis arrays
		br.close(); fr.close();
		
		boolean programaContinua = true;
		while(programaContinua) {
			System.out.println("===================================================================");
			System.out.println("Elige una opcion(1-6): ");
			System.out.println("===================================================================");
			System.out.println("1 - Mostrar las notas de todos los alumnos en cada asignatura");
			System.out.println("2 - Mostrar todas las notas de un alumno y decir si promociona o no");
			System.out.println("3 - Introducir todas las notas de una asignatura");
			System.out.println("4 - Introducir todas las notas de un alumno");
			System.out.println("5 - Mostrar todos los alumnos que promocionan");
			System.out.println("6 - Salir");
			System.out.println("===================================================================");
			
			//Controlamos excepcion por si el usuario introduce un caracter no numerico
			boolean invalido = true;
			int op = 0;
			while(invalido) {
				try {
					op = Leer.entero();
					break;
				} catch (NumberFormatException e) {
					System.err.print("DATO INVÁLIDO, INTRODUCE UN DATO VÁLIDO (1-6): ");
				}	
			}
			
			switch (op) {
			case 1: {
				System.out.println("======================================");
				System.out.println("       Lista de clase con notas");
				System.out.println("======================================");
				
				System.out.print("            ");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.printf("%5s", asignaturas[x]);
				}
				
				System.out.println();
				
				for(int x = 0; x < alumnos.length; x++) {
					System.out.printf((x + 1) + " - %-8s", alumnos[x]);
					for(int y = 0; y <  asignaturas.length; y++) {
						System.out.printf("%5d", notas[y][x]);
					}
					System.out.println();
				}
				System.out.println("======================================");
				break;
			}
			case 2: {
				boolean inexistente = true;
				int numLista = 0;
				
				//Bucle que comprueba si el dato es correcto
				while(inexistente) {
					//Controlamos excepcion por si el usuario introduce un caracter no numerico
					while(invalido) {
						invalido = true;
						System.out.println("");
						System.out.println("Nº de lista del alumno a mostrar: ");
						try {
							numLista = Leer.entero();
							invalido = false;
						} catch (NumberFormatException e) {
							System.out.print("DATO INVÁLIDO");
						}	
					}
					
					//Compruebo que el alumno exista
					if((numLista > (alumnos.length)) || numLista <= 0) {
						invalido = true;
						System.out.print("No hay ningun alumno con ese numero de lista");
					}
					else {
						inexistente = false;
					}
				}
				numLista--;
				
				System.out.println("======================================");
				System.out.println("Notas de " + alumnos[numLista] );
				System.out.println("======================================");
				
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.printf(" - %-8s %3d", asignaturas[x], notas[x][numLista]);
					System.out.println();
				}
				System.out.println("======================================");
				if(promociona(numLista, notas)) {
					System.out.println("El alumno promociona");
					System.out.println("======================================");
				}
				else {
					System.out.println("El alumno no promociona");
				}
				
				break;
			}
			case 3: {
				boolean inexistente = true;
				int numAsig = 0;
				
				//Bucle que comprueba si el dato es correcto
				while(inexistente) {
					//Controlamos excepcion por si el usuario introduce un caracter no numerico
					while(invalido) {
						invalido = true;
						System.out.println("");
						System.out.println("Nº de Asignatura: ");
						try {
							numAsig = Leer.entero();
							invalido = false;
						} catch (NumberFormatException e) {
							System.out.print("DATO INVÁLIDO");
						}	
					}
					
					//Compruebo que la asignatura exista
					if((numAsig > (asignaturas.length)) || numAsig <= 0) {
						invalido = true;
						System.out.print("No hay ninguna nota con ese numero");
					}
					else {
						inexistente = false;
					}
				}
				numAsig--;
				
				System.out.println("======================================");
				System.out.println("                " + asignaturas[numAsig]);
				System.out.println("======================================");
				
				int nota = 0;
				for(int x = 0; x < alumnos.length; x++) {
					inexistente = true;
					invalido = true;
					while(inexistente) {
						//Controlamos excepcion por si el usuario introduce un caracter no numerico
						while(invalido) {
							invalido = true;
							System.out.println("");
							System.out.println("Nota de " + alumnos[x] + ": ");
							try {
								nota = Leer.entero();
								invalido = false;
							} catch (NumberFormatException e) {
								System.out.print("DATO INVÁLIDO");
							}	
						}
						
						//Compruebo que la nota este entre 3 y 10
						if((nota > 10) || (nota < 0)) {
							invalido = true;
							System.out.print("La nota debe estar entre 0 y 10");
						}
						else {
							inexistente = false;
							notas[numAsig][x] = nota;
						}
					}
				}
				
				System.out.println("Notas actualizadas correctamente");
				break;
			}
			case 4: {
				boolean inexistente = true;
				int numLista = 0;
				
				//Bucle que comprueba si el dato es correcto
				while(inexistente) {
					//Controlamos excepcion por si el usuario introduce un caracter no numerico
					while(invalido) {
						invalido = true;
						System.out.println("");
						System.out.println("Nº de lista del alumno a mostrar: ");
						try {
							numLista = Leer.entero();
							invalido = false;
						} catch (NumberFormatException e) {
							System.out.print("DATO INVÁLIDO");
						}	
					}
					
					//Compruebo que el alumno exista
					if((numLista > (alumnos.length)) || numLista <= 0) {
						invalido = true;
						System.out.print("No hay ningun alumno con ese numero de lista");
					}
					else {
						inexistente = false;
					}
				}
				numLista--;
				
				System.out.println("======================================");
				System.out.println(alumnos[numLista]);
				System.out.println("======================================");
				
				int nota = 0;
				for(int x = 0; x < asignaturas.length; x++) {
					inexistente = true;
					invalido = true;
					while(inexistente) {
						//Controlamos excepcion por si el usuario introduce un caracter no numerico
						while(invalido) {
							invalido = true;
							System.out.println("");
							System.out.println("Nota de " + asignaturas[x] + ": ");
							try {
								nota = Leer.entero();
								invalido = false;
							} catch (NumberFormatException e) {
								System.out.print("DATO INVÁLIDO");
							}	
						}
						
						//Compruebo que la nota este entre 3 y 10
						if((nota > 10) || (nota < 0)) {
							invalido = true;
							System.out.print("La nota debe estar entre 0 y 10");
						}
						else {
							inexistente = false;
							notas[x][numLista] = nota;
						}
					}
				}
				
				System.out.println("Notas actualizadas correctamente");
				break;
			}
			case 5: {
				System.out.println("======================================");
				System.out.println("       LISTA DE PROMOCIONADOS");
				System.out.println("======================================");
				for(int numLista = 0; numLista < alumnos.length; numLista++) {
					if(promociona(numLista, notas)) {
						System.out.println(alumnos[numLista]);
					}
				}
				break;
			}
			case 6: {
				programaContinua = false;
				break;
			}
			default:
				System.out.println("LA OPCIÓN ELEGIDA NO EXISTE");
			}
			System.out.println();
				
		}
	}
	public static int[] convierteStringEnArrayInt (String linea){
		String[] lineaArray = linea.split(",");
		int[] lineaConvertida = new int[lineaArray.length];
		
		for(int x = 0; x < lineaArray.length; x++) {
			lineaConvertida[x] = Integer.parseInt(lineaArray[x]);
		}
		
		return lineaConvertida;
	}
	
	public static boolean promociona(int numLista, int[][] notas) {
	
		if((notas[0][numLista] < 5) && (notas[1][numLista] < 5) ) {
			return false;
		}
		
		return true;
	}

}
