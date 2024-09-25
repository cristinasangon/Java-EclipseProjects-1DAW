package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ejercicos_ficheros.Leer;

public class Rep_Ej6_NotasaAlumnos {

	public Rep_Ej6_NotasaAlumnos() throws IOException {
		File fichero = new File("FicherosRepaso//notasAlumnos.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		String[] alumnos = linea.split(",");
		
		linea = br.readLine();
		String[] asignaturas = linea.split(",");
		
		String[][] notasTemporal = new String[asignaturas.length][alumnos.length];
		for(int x = 0; x < asignaturas.length; x++) {
			linea = br.readLine();
			notasTemporal[x] = linea.split(",");
		}
		
		br.close();fr.close();
		
		int[][] notas = convierteArrayStringEnInt(notasTemporal);
		notasTemporal = null;
		
		boolean programaContinua = true;
		while(programaContinua) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("ELIGE UNA OPCION (1-6): ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1 - Mostrar las notas de todos los alumnos en todas las asignaturas");
			System.out.println("2 - Mostrar todas las notas de un alumno y decir si promociona");
			System.out.println("3 - Modificar todas las notas de una asignatura");
			System.out.println("4 - Modificar todas las notas de un alumno");
			System.out.println("5 - Mostrar todos los alumnos promocionados");
			System.out.println("6 - Salir");
			System.out.println("--------------------------------------------------------------------");
			
			//PEDIR DATO Y COMPROBAR QUE SEA CORRECTO
			String dato = Leer.cadena();
			while(compruebaOpMenu(dato) == -1) {
				System.out.print("Introduce una opcion válida (1-6): ");
				dato = Leer.cadena();
			}
			int op = compruebaOpMenu(dato);
			
			switch (op) {
			case 1: {
				System.out.println("-------------------------------------------");
				System.out.println("Lista de clase con notas");
				System.out.println("-------------------------------------------");
				System.out.print("               ");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.printf("%5s", asignaturas[x]);
				}
				System.out.println();
				
				for(int x = 0; x < alumnos.length; x++) {
					System.out.printf((x + 1) + " - %-10s", alumnos[x]);
					for(int y = 0; y < asignaturas.length; y++) {
						System.out.printf("%5d", notas[y][x]);
					}
					System.out.println();
				}
				System.out.println("-------------------------------------------");
				break;
			}
			case 2: {
				//MUESTRO LISTA
				System.out.println("-------------------------------------------");
				System.out.println("Lista de clase");
				System.out.println("-------------------------------------------");
				for(int x = 0; x < alumnos.length; x++) {
					System.out.println((x + 1) + " - " + alumnos[x]);
				}		
				System.out.println("-------------------------------------------");
				
				//PIDO DATO
				System.out.print("Introduce un numero de lista: ");
				dato = Leer.cadena();
				while(compruebaNumLista(dato, alumnos) == -1) {
					System.out.println("Alumno con numero de lista '" + dato + "' no encontrado");
					System.out.print("Introduce un nuevo numero de lista: ");
					dato = Leer.cadena();
				}
				int numLista = compruebaNumLista(dato, alumnos) - 1;
				
				//MUESTRO NOTAS DE ESE ALUMNO
				System.out.println("-------------------------------------------");
				System.out.println("Notas de " + alumnos[numLista]);
				System.out.println("-------------------------------------------");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.println(" - " + asignaturas[x] + ": " + notas[x][numLista]);
				}	
				System.out.println();
				if(promociona(notas, numLista)) {
					System.out.println("El alumno promociona");
				}
				else {
					System.out.println("El alumno no promociona");
				}
				System.out.println("-------------------------------------------");
				break;
			}
			case 3: {
				//MUESTRO LISTA
				System.out.println("-------------------------------------------");
				System.out.println("Lista de asignaturas");
				System.out.println("-------------------------------------------");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.println((x + 1) + " - " + asignaturas[x]);
				}		
				System.out.println("-------------------------------------------");
				
				//PIDO DATO
				System.out.print("Introduce el numero de la asignatura: ");
				dato = Leer.cadena();
				while(compruebaNumAsignatura(dato, alumnos) == -1) {
					System.out.println("Asignatura con numero '" + dato + "' no encontrada");
					System.out.print("Introduce un nuevo numero: ");
					dato = Leer.cadena();
				}
				int numAsig = compruebaNumAsignatura(dato, alumnos) - 1;
				
				//VOY PIDIENDO NUEVA NOTA
				System.out.println("-------------------------------------------");
				System.out.println("Notas de " + asignaturas[numAsig]);
				System.out.println("-------------------------------------------");
				for(int x = 0; x < alumnos.length; x++) {
					System.out.print(" - Nota de " + alumnos[x] + ": ");
					
					//PIDO NOTA
					dato = Leer.cadena();
					while(compruebaNota(dato) == -1) {
						System.out.println("Nota '" + dato + "' no válida");
						System.out.print(" - Nota de" + alumnos[x] + ": ");
						dato = Leer.cadena();
					}
					
					//CAMBIO EL VALOR DEL ARRAYNOTAS
					notas[numAsig][x] = compruebaNota(dato);
				}
				System.out.println("-------------------------------------------");
				System.out.println("Notas cambiadas con exito");
				break;
			}
			case 4: {
				//MUESTRO LISTA
				System.out.println("-------------------------------------------");
				System.out.println("Lista de alumnos");
				System.out.println("-------------------------------------------");
				for(int x = 0; x < alumnos.length; x++) {
					System.out.println((x + 1) + " - " + alumnos[x]);
				}		
				System.out.println("-------------------------------------------");
				
				//PIDO DATO
				System.out.print("Introduce un numero de lista: ");
				dato = Leer.cadena();
				while(compruebaNumLista(dato, alumnos) == -1) {
					System.out.println("Alumno con numero de lista '" + dato + "' no encontrado");
					System.out.print("Introduce un nuevo numero de lista: ");
					dato = Leer.cadena();
				}
				int numLista = compruebaNumLista(dato, alumnos) - 1;
				
				//VOY PIDIENDO NUEVA NOTA
				System.out.println("-------------------------------------------");
				System.out.println("Notas de " + alumnos[numLista]);
				System.out.println("-------------------------------------------");
				for(int x = 0; x < asignaturas.length; x++) {
					System.out.print(" - Nota en " + asignaturas[x] + ": ");
					
					//PIDO NOTA
					dato = Leer.cadena();
					while(compruebaNota(dato) == -1) {
						System.out.println("Nota '" + dato + "' no válida");
						System.out.print(" - Nota en " + asignaturas[x] + ": ");
						dato = Leer.cadena();
					}
					
					//CAMBIO EL VALOR DEL ARRAYNOTAS
					notas[x][numLista] = compruebaNota(dato);
				}
				System.out.println("-------------------------------------------");
				
				System.out.println("Notas cambiadas con exito");
				break;
			}
			case 5: {
				System.out.println("-------------------------------------------");
				System.out.println("Lista de promocionados");
				System.out.println("-------------------------------------------");
				for(int x = 0; x < alumnos.length; x++) {
					if(promociona(notas, x)) {
						System.out.println(alumnos[x]);
					}
				}
				System.out.println("-------------------------------------------");
				break;
			}
			case 6: {
				programaContinua = false;
				break;
			}
			default:
				break;
			}
		}
		
	}
	public static int[][] convierteArrayStringEnInt(String[][] array){
		int[][] arrayConvertida = new int[array.length][array[0].length];
		
		for(int x = 0; x < array.length; x++) {
			for(int y = 0; y < array[x].length; y++) {
				arrayConvertida[x][y] = Integer.parseInt(array[x][y]);
			}
		}
		
		return arrayConvertida;
	}
	
	public static int compruebaDatoInt(String dato) {
		try {
			int entero = Integer.parseInt(dato);
			return entero;
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public static int compruebaOpMenu(String dato) {
		int entero = compruebaDatoInt(dato);
		if(entero == -1) {
			return -1;
		}
		else if(entero > 6 || entero < 1) {
			return -1;
		}
		else {
			return entero;
		}
	}
	
	public static int compruebaNumLista(String dato, String[] alumnos) {
		int entero = compruebaDatoInt(dato);
		if(entero == -1) {
			return -1;
		}
		else if(entero > alumnos.length || entero < 1) {
			return -1;
		}
		else {
			return entero;
		}
	}
	
	public static int compruebaNumAsignatura(String dato, String[] asignaturas) {
		int entero = compruebaDatoInt(dato);
		if(entero == -1) {
			return -1;
		}
		else if(entero > asignaturas.length || entero < 1) {
			return -1;
		}
		else {
			return entero;
		}
	}
	
	public static int compruebaNota(String dato) {
		int entero = compruebaDatoInt(dato);
		if(entero == -1) {
			return -1;
		}
		else if(entero > 10 || entero < 0) {
			return -1;
		}
		else {
			return entero;
		}
	}
	
	public static boolean promociona(int[][] notas, int numLista) {
		
		if((notas[0][numLista] < 5) && (notas[1][numLista] < 5)) {
			return false;
		}
		
		return true;
	}
}
