package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import controller.LibroController;
import dao.DbConnection;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection dbc = new DbConnection();
		Connection cn = dbc.getConnection();
		try {
			System.out.println("\nMOSTRAR LIBROS");
			System.out.println("======================================================================================================================================");
			LibroController libroController = new LibroController(cn);
			List<Libro> libros = libroController.getLibros();
			for(Libro l: libros) {
				System.out.println(l);
			}
			
			System.out.println("\nAGREGAR LIBRO");
			System.out.println("======================================================================================================================================");
			String titulo = "Platero y yo";
			String autor = "Ramon Jimenez;Juan";
			String editorial = "SoldeSol";
			String isbn = "978-84-7897-061-2";
			if(libroController.agregarLibro(titulo, autor, editorial, isbn)) {
				System.out.println(titulo + " agregado con exito");
			}else {
				System.out.println(titulo + " no se ha podido agregar");
			}
			
			
			System.out.println("\nMOSTRAR LIBROS CON NUEVO LIBRO");
			System.out.println("======================================================================================================================================");
			libros = libroController.getLibros();
			for(Libro l: libros) {
				System.out.println(l);
			}
			
			System.out.println("\nBORRAR LIBRO");
			System.out.println("======================================================================================================================================");
			isbn = "978-8437601618";
			if(libroController.borrarLibro(isbn)) {
				System.out.println(titulo + " borrado con exito");
			}else {
				System.out.println(titulo + " no se puede borrar porque ya ha sido borrado anteriormente");
			}
			
			System.out.println("\nMOSTRAR LIBROS CON LIBRO BORRADO");
			System.out.println("======================================================================================================================================");
			libros = libroController.getLibros();
			for(Libro l: libros) {
				System.out.println(l);
			}
			
			System.out.println("\nMOSTRAR LIBROS DE UN AUTOR");
			System.out.println("======================================================================================================================================");
			autor = "Perez Reverte;Arturo";
			libros = libroController.getLibrosAutor(autor);
			boolean encontrado = false;
			for(Libro l: libros) {
				System.out.println(l);
				encontrado = true;
			}
			if(!encontrado) {
				System.out.println("No se ha encontrado ningun libro con autor " + autor);
			}
			
			System.out.println("\nBUSCAR UN LIBRO");
			System.out.println("======================================================================================================================================");
			isbn = "978-84-08-13405-3";
			libros = libroController.getLibroIsbn(isbn);
			encontrado = false;
			for(Libro l: libros) {
				System.out.println(l);
				encontrado = true;
			}
			if(!encontrado) {
				System.out.println("No se ha encontrado ningun libro con isbn " + isbn);
			}
			
			System.out.println("\nMODIFICAR LIBRO");
			System.out.println("======================================================================================================================================");
			int idLibro = 2;
			titulo = "Las Llanuras del Transito";
			autor = "Auel,Jean M.";
			editorial = "Planeta";
			isbn = "978-84-95354-15-0";
			boolean prestado = true;
			LocalDate fechaPrestamo = LocalDate.parse("2017-03-30");
			LocalDate fechaDevolucion = LocalDate.parse("2017-03-30");
			LocalDateTime fechaAlta = LocalDateTime.parse("2017-03-13T23:00");
			if(libroController.modificarLibro(idLibro, titulo, autor, editorial, isbn, prestado, fechaPrestamo, fechaDevolucion, fechaAlta)) {
				System.out.println(titulo + " modificado con exito");
			}else {
				System.out.println(titulo + " no se ha podido modificar");
			}
			
			System.out.println("\nMOSTRAR LIBROS CON LIBRO MODIFIADO");
			System.out.println("======================================================================================================================================");
			libros = libroController.getLibros();
			for(Libro l: libros) {
				System.out.println(l);
			}
			dbc.disconnect();
		} catch (SQLException | IsbnException | CamposVaciosException e) {
			System.out.println(e.getMessage());
		}
		
		//System.out.println(compruebaIsbn("978-8437601618"));
	}
	public static boolean compruebaIsbn(String isbn){
		try {
			isbn = isbn.replace("-", "");
			int dc = Integer.parseInt(isbn.substring(isbn.length() - 1));
			int suma = 0;
			for(int x = 0; x < (isbn.length() - 1); x++) {
				int digito = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1)%2) == 0) {
					digito *= 3;
				}
				suma += digito;
			}
			
			suma %= 10;
			suma = 10 - suma;
			if(suma == 10) {
				suma = 0;
			}
			if(suma == dc) {
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
