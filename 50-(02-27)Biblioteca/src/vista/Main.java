package vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Modelo.Libro;
import controlador.BibliotecaController;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import interfaces.ComparaFechas;
import interfaces.ComparaPrecios;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			BibliotecaController biblio = new BibliotecaController();
			ArrayList<Libro> libros = biblio.getBiblioteca();
			Scanner leer = new Scanner(System.in);
			String datoTeclado = "";
			
			boolean programaContinua = true;
			while(programaContinua) {
				System.out.println();
				System.out.println();
				System.out.println("====================================================");
				System.out.println("MENU:");
				System.out.println("====================================================");
				System.out.println("1 - Añadir un libro");
				System.out.println("2 - Borrar un libro");
				System.out.println("3 - Buscar un libro");
				System.out.println("4 - Modificar un libro");
				System.out.println("5 - Prestar un libro");
				System.out.println("6 - Devolver un libro");
				System.out.println("7 - Mostrar todos los libros");
				System.out.println("8 - Mostrar todos los libros de un autor");
				System.out.println("9 - Mostrar los libros pendientes de entrega");
				System.out.println("10 - Mostrar libros ordenados alfabeticamente");
				System.out.println("11 - Mostrar libros ordenados por fecha de devolucion");
				System.out.println("12 - Mostrar libros ordenados por precio");
				System.out.println("13 - Salir");
				System.out.println("====================================================");
				
				int op = 0;
				boolean datoNoValido = true;
				while(datoNoValido) {
					System.out.print("Elige una opcion (1 - 13): ");
					datoTeclado = leer.next();
					try {
						op = Integer.parseInt(datoTeclado);
						if(op <= 13 && op >= 1) {
							datoNoValido = false;
						}
						else {
							System.err.println("'" + datoTeclado + "' no es una opcion válida");
						}
					} catch (NumberFormatException e) {
						System.err.println("'" + datoTeclado + "' no es una opcion válida");
					}
				}
				
				switch (op) {
//1 - Añadir un libro -------------------------------------------------------------------------
				case 1: {
					datoNoValido = true;
					while(datoNoValido) {
						System.out.print("Introduce el isbn: ");
						String isbn = leer.next();
						
						System.out.print("Introduce el titulo: ");
						String titulo = leer.next();
						
						System.out.print("Introduce el autor: ");
						String autor = leer.next();
						
						System.out.print("Introduce la editorial: ");
						String editorial = leer.next();
						
						System.out.print("Introduce el precio: ");
						String precio = leer.next();
						
						Libro libro = null;
						try {
							libro = new Libro(titulo, autor, editorial, isbn, precio);
							datoNoValido = false;
						} catch (CamposVaciosException | NumberFormatException | IsbnException e) {
							System.out.println("_______________");
							System.out.println("Has introducido datos no válidos, por favor, vuelve a introducir los datos:");
							System.out.println();
						}
						
						if(!datoNoValido) {
							if(biblio.añadirLibro(libro)) {
								System.out.println("_______________");
								System.out.println("Libro añadido con éxito");
							}
							else {
								System.out.println("_______________");
								System.out.println("El libro ya existe o no ha podido ser añadido");
							}
						}
					}
					break;
				}
				
//2 - Borrar un libro -------------------------------------------------------------------------
				case 2: {
					System.out.print("Introduce el isbn del libro a eliminar: ");
					String isbn = leer.next();
					
					if(biblio.eliminarLibro(isbn)) {
						System.out.println("_______________");
						System.out.println("Libro eliminado con éxito");
					}	
					else {
						System.out.println("_______________");
						System.out.println("El libro con ISBN: '" + isbn + "' no existe y, por lo tanto, no se puede eliminar");
					}
					break;
				}
				
//3 - Buscar un libro -------------------------------------------------------------------------
				case 3: {
					System.out.print("Introduce el isbn del libro: ");
					String isbn = leer.next();
					
					Libro libro = null;
					
					if((libro = biblio.buscarLibroPorIsbn(isbn)) != null) {
						System.out.println("_______________");
						System.out.println(libro);
					}
					else {
						System.out.println("_______________");
						System.out.println("El libro con ISBN: '" + isbn + "' no existe");
					}
					break;
				}
				
//4 - Modificar un libro -------------------------------------------------------------------------
				case 4: {
					System.out.print("Introduce el isbn del libro que quieres modificar: ");
					String isbn = leer.next();
					
					Libro libro = null;
					
					if((libro = biblio.buscarLibroPorIsbn(isbn)) != null) {
						datoNoValido = true;
						while(datoNoValido) {
							System.out.print("Introduce el titulo: ");
							String titulo = leer.next();
							
							System.out.print("Introduce el autor: ");
							String autor = leer.next();
							
							System.out.print("Introduce la editorial: ");
							String editorial = leer.next();
							
							System.out.print("Introduce el precio: ");
							String precio = leer.next();
							try {
								biblio.modificarLibro(isbn, titulo, autor, editorial, precio);
								
								datoNoValido = false;
								
								System.out.println("_______________");
								System.out.println("Libro modificado con exito");
								
							} catch (CamposVaciosException | NumberFormatException e) {
								System.out.println("_______________");
								System.out.println("Has introducido datos no válidos, por favor, vuelve a introducir los datos:");
								System.out.println();
							}
						}
					}
					else {
						System.out.println("_______________");
						System.out.println("El libro con ISBN: '" + isbn + "' no existe");
					}
					break;
				}
				
//5 - Prestar un libro -------------------------------------------------------------------------
				case 5: {
					System.out.print("Introduce el isbn del libro: ");
					String isbn = leer.next();
					
					Libro libro = null;
					
					if((libro = biblio.buscarLibroPorIsbn(isbn)) != null) {
						LocalDate fechaDevolucion = LocalDate.now();
						fechaDevolucion = fechaDevolucion.plusDays(20);
						String fecha = fechaDevolucion.toString();
						
						if(biblio.prestarLibro(isbn, fecha) == true) {
							System.out.println("_______________");
							System.out.println("Toma el libro '" + libro.getTitulo() + "', debes devolverlo antes del '" + fecha + "'");
						}
						else {
							System.out.println("_______________");
							System.out.println("El libro '" + libro.getTitulo() + "' ya esta prestado, debes esperar hasta '" + libro.getFechaDevolucion() + "'");
						}
					}
					else {
						System.out.println("_______________");
						System.out.println("El libro con ISBN: '" + isbn + "' no existe");
					}
					break;
				}
				
//6 - Devolver un libro -------------------------------------------------------------------------
				case 6: {
					System.out.print("Introduce el isbn del libro: ");
					String isbn = leer.next();
					
					Libro libro = null;
					
					if((libro = biblio.buscarLibroPorIsbn(isbn)) != null) {
						
						if(biblio.devolverLibro(isbn) == true) {
							System.out.println("_______________");
							System.out.println("Gracias por devolver el libro'" + libro.getTitulo() + "'");
						}
						else {
							System.out.println("_______________");
							System.out.println("El libro '" + libro.getTitulo() + "' no esta prestado y, por lo tanto, no puede ser devuelto");
						}
					}
					else {
						System.out.println("_______________");
						System.out.println("El libro con ISBN: '" + isbn + "' no existe");
					}
					break;
				}
				
//7 - Mostrar todos los libros -------------------------------------------------------------------------
				case 7: {
					System.out.println("_______________");
					for(Libro libroX: libros) {
						System.out.println(libroX);
					}
					break;
				}
				
//8 - Mostrar todos los libros de un autor -------------------------------------------------------------------------
				case 8: {
					System.out.print("Introduce el autor: ");
					String autor = Leer.cadena();
					
					ArrayList<Libro> librosAutor = biblio.filtrarLibrosPorAutor(autor);
					
					System.out.println("_______________");
					for(Libro libroX: librosAutor) {
						System.out.println(libroX);
					}
					break;
				}
				
//9 - Mostrar los libros pendientes de entrega -------------------------------------------------------------------------
				case 9: {
					ArrayList<Libro> librosPendientesDevolucion = biblio.mostrarLibrosPendientesDevolucion();
					
					System.out.println("_______________");
					for(Libro libroX: librosPendientesDevolucion) {
						System.out.println(libroX);
					}
					break;
				}
				
//10 - Mostrar libros ordenados alfabeticamente -------------------------------------------------------------------------
				case 10: {
					ArrayList<Libro> librosOrdenados = biblio.ordenarLibrosAlfabeticamente();
					
					System.out.println("_______________");
					for(Libro libroX: librosOrdenados) {
						System.out.println(libroX);
					}
					break;
				}
				
//11 - Mostrar libros ordenados por fecha de devolucion -------------------------------------------------------------------------
				case 11: {
					ArrayList<Libro> librosOrdenados = biblio.ordenarLibrosPorFechaDevolucion();
					
					System.out.println("_______________");
					for(Libro libroX: librosOrdenados) {
						System.out.println(libroX);
					}
					break;
				}
				
//12 - Mostrar libros ordenados por precio -------------------------------------------------------------------------
				case 12: {
					ArrayList<Libro> librosOrdenados = biblio.ordenarLibrosPorPrecio();
					
					System.out.println("_______________");
					for(Libro libroX: librosOrdenados) {
						System.out.println(libroX);
					}
					break;
				}
				
//13 - Salir -------------------------------------------------------------------------
				case 13: {
					biblio.guardarDatosFichero();
					programaContinua = false;
					System.out.println("Hasta la proxima!");
					break;
				}
				default:
					System.out.println("Algo va mal");
				}
				
			}
		} catch (IOException | NumberFormatException | DateTimeParseException | IsbnException | CamposVaciosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
