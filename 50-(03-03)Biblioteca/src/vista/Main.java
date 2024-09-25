package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.border.TitledBorder;

import controller.BibliotecaController;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			BibliotecaController biblioteca = new BibliotecaController();
			
			boolean programaContinua = true;
			
			while(programaContinua) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("BIBLIOTECA");
				System.out.println("----------------------------------------------------------------");
				System.out.println("1 - Añadir un nuevo libro");
				System.out.println("2 - Eliminar un libro");
				System.out.println("3 - Buscar un libro");
				System.out.println("4 - Modificar un libro");
				System.out.println("5 - Prestar un libro");
				System.out.println("6 - Devolver un libro");
				System.out.println("7 - Mostrar todos los libros");
				System.out.println("8 - Mostrar todos los libros ordenados alfabéticamente");
				System.out.println("9 - Mostrar todos los libros ordenados por fecha de devolucion");
				System.out.println("10 - Mostrar todos los libros ordenados por precio");
				System.out.println("11 - Mostrar todos los libros de un autor");
				System.out.println("12 - Mostrar todos los libros pendientes de devolucion");
				System.out.println("13 - Salir");
				System.out.println("________________________________________________________________");
				
				boolean datoInvalido = true;
				int op = 0;
				while(datoInvalido) {
					System.out.print("Elige una opcion (1 - 13): ");
					String datoTeclado = Leer.cadena();
					try {
						op = Integer.parseInt(datoTeclado);
						if(op >= 1 && op <= 13) {
							datoInvalido = false;
						}
						else {
							System.out.println();
							System.err.println("'" + datoTeclado + "' no es una opcion válida");
						}
					} catch (NumberFormatException e) {
						System.out.println();
						System.err.println("'" + datoTeclado + "' no es una opcion válida");
					}
				}
				
				switch (op) {
//AÑADIR UN LIBRO ---------------------------------------------------------------------------------------
				case 1: {
					System.out.println("__________________________________________");
					System.out.println("INTRODUCE LOS DATOS DEL NUEVO LIBRO:");
					System.out.print("isbn: "); String isbn = Leer.cadena();
					System.out.print("titulo: "); String titulo = Leer.cadena();
					System.out.print("autor: "); String autor = Leer.cadena();
					System.out.print("editorial: "); String editorial = Leer.cadena();
					System.out.print("precio: "); String precio = Leer.cadena();
						
					try {
						if(biblioteca.añadirLibro(isbn, titulo, autor, editorial, precio)) {
							System.out.println("Libro agregado");
						}
						else {
							System.out.println("El libro ya está en la biblioteca y, por lo tanto, no puede ser añadido de nuevo");
						}
					} catch (IsbnException | CamposVaciosException | NumberFormatException e) {
						System.out.println("Has introducido datos no válidos y el libro no ha podido ser añadido");
					}
					break;
				}
				
//BORRAR UN LIBRO ---------------------------------------------------------------------------------------				
				case 2: {
					System.out.println("__________________________________________");
					System.out.println("ELIMINAR UN LIBRO:");
					System.out.print("isbn: "); 
					String isbn = Leer.cadena();
					
					if(biblioteca.eliminarLibro(isbn)) {
						System.out.println("Libro eliminado");
					}
					else {
						System.out.println("El libro no está en la biblioteca y, por lo tanto, no puede ser eliminado");
					}
					break;
				}
				
//BUSCAR UN LIBRO ---------------------------------------------------------------------------------------				
				case 3: {
					System.out.println("__________________________________________");
					System.out.println("BUSCAR UN LIBRO:");
					System.out.print("isbn: "); 
					String isbn = Leer.cadena();
					
					Libro libro = null;
					if((libro = biblioteca.buscarLibro(isbn)) != null) {
						System.out.println(libro.toString());
					}else {
						System.out.println("El libro con isbn: '" + isbn + "' no está en la biblioteca");
					}
					break;
				}
			
//MODIFICAR UN LIBRO ------------------------------------------------------------------------------------
				case 4: {
					System.out.println("__________________________________________");
					System.out.println("MODIFICAR UN LIBRO:");
					System.out.print("isbn: "); 
					String isbn = Leer.cadena();
					
					Libro libro = biblioteca.buscarLibro(isbn);
					if(libro != null) {
						System.out.println("__________________________________________");
						System.out.println("INTRODUCE LOS NUEVOS DATOS: ");
						String titulo, autor, editorial, precio;
						
						datoInvalido = true;
						while(datoInvalido) {
							try {
								System.out.print("titulo:"); titulo = Leer.cadena();
								libro.setTitulo(titulo);
								datoInvalido = false;
							} catch (CamposVaciosException e) {
								System.out.println("Este campo no puede estar vacio");
							}
						}
						
						datoInvalido = true;
						while(datoInvalido) {
							try {
								System.out.print("autor:"); autor = Leer.cadena();
								libro.setAutor(autor);
								datoInvalido = false;
							} catch (CamposVaciosException e) {
								System.out.println("Este campo no puede estar vacio");
							}
						}
						
						datoInvalido = true;
						while(datoInvalido) {
							try {
								System.out.print("editorial:"); editorial = Leer.cadena();
								libro.setEditorial(editorial);
								datoInvalido = false;
							} catch (CamposVaciosException e) {
								System.out.println("Este campo no puede estar vacio");
							}
						}
						
						datoInvalido = true;
						while(datoInvalido) {
							precio = "";
							try {
								System.out.print("precio:"); precio = Leer.cadena();
								libro.setPrecio(precio);
								datoInvalido = false;
							} catch (NumberFormatException e) {
								System.out.println("'" + precio + "' no es un precio válido");
							}
						}
						
						System.out.println("__________________________");
						System.out.println("Libro modificado con éxito");
					}else {
						System.out.println("El libro con isbn: '" + isbn + "' no está en la biblioteca");
					}
					break;
				}
				
//PRESTAR UN LIBRO ------------------------------------------------------------------------------------
				case 5: {
					System.out.println("__________________________________________");
					System.out.println("PRESTAR UN LIBRO:");
					System.out.print("isbn: "); 
					String isbn = Leer.cadena();
					
					LocalDate obtenerFecha = LocalDate.now();
					obtenerFecha = obtenerFecha.plusDays(20);
					String fecha = obtenerFecha.toString();
					
					Libro libro = biblioteca.buscarLibro(isbn);
					if(libro != null) {
						if(biblioteca.prestarLibro(isbn, fecha)) {
							System.out.println("Toma el libro '" + libro.getTitulo() + "' tienes que devolverlo antes de '" + libro.getFechaDevolucion() + "'");
						}else {
							System.out.println("El libro '" + libro.getTitulo() + "' ya está prestado");
						}
					}else {
						System.out.println("El libro con isbn: '" + isbn + "' no esta en la biblioteca");
					}
					break;
				}
				
//DEVOLVER UN LIBRO ------------------------------------------------------------------------------------
				case 6: {
					System.out.println("__________________________________________");
					System.out.println("DEVOLVER UN LIBRO:");
					System.out.print("isbn: "); 
					String isbn = Leer.cadena();
					
					Libro libro = biblioteca.buscarLibro(isbn);
					if(libro != null) {
						if(biblioteca.devolverLibro(isbn)) {
							System.out.println("Gracias por devolver el libro '" + libro.getTitulo() + "'");
						}else {
							System.out.println("El libro '" + libro.getTitulo() + "' no está prestado");
						}
					}else {
						System.out.println("El libro con isbn: '" + isbn + "' no esta en la biblioteca");
					}
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS -----------------------------------------------------------------------------
				case 7: {
					System.out.println("__________________________________________");
					System.out.println("TODOS LOS LIBROS:");
					for(Libro libroX: biblioteca.getBiblioteca()) {
						System.out.println(libroX);
					}
					System.out.println("__________________________________________");
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS ORDENADOS ALFABÉTICAMENTE ---------------------------------------------------
				case 8:{
					System.out.println("__________________________________________");
					System.out.println("TODOS LOS LIBROS ORDENADOS A-Z:");
					for(Libro libroX: biblioteca.ordenarAlfabeticamente()) {
						System.out.println(libroX);
					}
					System.out.println("__________________________________________");
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS ORDENADOS POR FECHA DE DEVOLUCION -------------------------------------------
				case 9:{
					System.out.println("_______________________________________________________");
					System.out.println("TODOS LOS LIBROS ORDENADOS POR FECHA DE DEVOLUCION:");
					for(Libro libroX: biblioteca.ordenarFechaDevolucion()) {
						System.out.println(libroX);
					}
					System.out.println("_______________________________________________________");
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS ORDENADOS POR PRECIO --------------------------------------------------------
				case 10:{
					System.out.println("_______________________________________________________");
					System.out.println("TODOS LOS LIBROS ORDENADOS POR PRECIO:");
					for(Libro libroX: biblioteca.ordenarPorPrecio()) {
						System.out.println(libroX);
					}
					System.out.println("_______________________________________________________");
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS DE UN AUTOR --------------------------------------------------------
				case 11:{
					System.out.println("_______________________________________________________");
					String autor = "";
					datoInvalido = true;
					while(datoInvalido) {
						System.out.print("autor:"); autor = Leer.cadena();
						if(!autor.equals("")) {
							datoInvalido = false;
						}
					}
					
					System.out.println("_______________________________________________________");
					System.out.println("Libros de " + autor);
					for(Libro libroX: biblioteca.filtrarLibrosPorAutor(autor)) {
						System.out.println(libroX);
					}
					System.out.println("_______________________________________________________");
					break;
				}
				
//MOSTRAR TODOS LOS LIBROS PENDIENTES DE DEVOLUCION --------------------------------------------------------
				case 12:{
					System.out.println("_______________________________________________________");
					System.out.println("TODOS LOS LIBROS PENDIENTES DE DEVOLUCION:");
					for(Libro libroX: biblioteca.filtrarLibrosPendientesDevolucion()) {
						System.out.println(libroX);
					}
					System.out.println("_______________________________________________________");
					break;
				}
				default:
					biblioteca.salvarDatos();
					programaContinua = false;
					System.out.println("¡HASTA LA PROXIMA!");
					break;
				}
			}
		} catch (DateTimeParseException | NumberFormatException | IOException | IsbnException | CamposVaciosException e) {
			System.out.println("Datos no válidos procedentes de fichero");
		}

	}
	
}
