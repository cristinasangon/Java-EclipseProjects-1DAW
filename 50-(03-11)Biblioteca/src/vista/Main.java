package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;

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
				System.out.println();
				System.out.println();
				System.out.println("==============================================================================");
				System.out.println("BIBLIOTECA");
				System.out.println("==============================================================================");
				System.out.println("1 - Mostrar todos los libros");
				System.out.println("2 - Agregar un nuevo libro");
				System.out.println("3 - Mostrar todos los libros de un autor");
				System.out.println("4 - Mostrar todos los libros prestados");
				System.out.println("5 - Prestar un libro");
				System.out.println("6 - Devolver un libro");
				System.out.println("7 - Eliminar todos los libros de una editorial");
				System.out.println("8 - Salvar datos");
				System.out.println("9 - Salir");
				System.out.println("==============================================================================");

				boolean invalido = true;
				int op = 0;
				while(invalido) {
					System.out.println("______________________________________________________________________________");
					System.out.print("Elige una opcion (1 - 9): ");
					String dato = Leer.cadena();
					try {
						op = Integer.parseInt(dato);
						if(op >= 1 && op <=9) {
							invalido = false;
						}else {
							System.out.println("'" + dato + "' no es una opcion válida");
						}
					} catch (Exception e) {
						System.out.println("'" + dato + "' no es una opcion válida");
					}
				}
				
				switch (op) {
				case 1:
					System.out.println("______________________________________________________________________________");
					for(Libro libro: biblioteca.mostrarLibros()) {
						System.out.println(libro);
					}
					break;
				case 2:
					System.out.println("______________________________________________________________________________");
					System.out.print("ISBN: "); String isbn = Leer.cadena();
					System.out.print("Titulo: "); String titulo = Leer.cadena();
					System.out.print("Autor: "); String autor = Leer.cadena();
					System.out.print("Editorial: "); String editorial = Leer.cadena();
					System.out.print("Precio: "); String precio = Leer.cadena();

					try {
						if(biblioteca.agregarLibro(isbn, titulo, autor, editorial, precio)) {
							System.out.println("Libro '" + titulo + "' ha sido agregado con exito");	
						}else {
							System.out.println("El libro '" + titulo + "' ya esta en la bilioteca");	
						}
					} catch (NumberFormatException | CamposVaciosException | IsbnException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("______________________________________________________________________________");
					System.out.print("Autor: "); autor = Leer.cadena();
					for(Libro libro: biblioteca.mostrarLibrosAutor(autor)) {
						System.out.println(libro);
					}
					
					break;
				case 4:
					System.out.println("______________________________________________________________________________");
					for(Libro libro: biblioteca.mostrarLibrosprestados()) {
						System.out.println(libro);
					}
					break;
				case 5:
					System.out.println("______________________________________________________________________________");
					System.out.print("ISBN: "); isbn = Leer.cadena();
					if(biblioteca.prestarLibro(isbn)) {
						System.out.println("Debes devolver el libro antes del dia " + biblioteca.buscarLibro(isbn).getFechaDevolucion());
					}else {
						System.out.println("El libro no existe o ya ha sido prestado");
					}
					break;
				case 6:
					System.out.println("______________________________________________________________________________");
					System.out.print("ISBN: "); isbn = Leer.cadena();
					if(biblioteca.devolverLibro(isbn)) {
						System.out.println("Gracias por devolver '" + biblioteca.buscarLibro(isbn).getTitulo() + "'");
					}else {
						System.out.println("El libro no existe o ya ha sido devuelto");
					}
					break;
				case 7:
					System.out.println("______________________________________________________________________________");
					System.out.print("Editorial: "); editorial = Leer.cadena();
					System.out.println("Se han eliminado " + biblioteca.eliminarLibrosEditorial(editorial) + " libros de " + editorial);
					break;
				case 8:
					System.out.println("______________________________________________________________________________");
					if(biblioteca.salvarDatos()) {
						System.out.println("DATOS SALVADOS");
					}else {
						System.out.println("DATOS NO SALVADOS");
					}
					break;
				default:
					System.out.println("______________________________________________________________________________");
					System.out.println("¡HASTA LA PROXIMA!");
					programaContinua = false;
					break;
				}
				
				
				
				
				
			}
		} catch (NumberFormatException | DateTimeParseException | IsbnException | CamposVaciosException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
