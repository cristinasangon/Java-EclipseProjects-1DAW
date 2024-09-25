package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import controller.LibroController;
import dao.DbConnection;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		String titulo = "La cabaña del leñador";
		String autor = "Paco canelas";
		String editorial = "Planeta";
		String isbn = "978-84-95354-15-0";
		
		
		try {
			LibroController libroController = new LibroController();
			List<Libro> libros;
			
			libroController.agregarLibro(titulo, autor, editorial, isbn);
			
			libros = libroController.getLibros("SELECT * FROM libros");
			System.out.println("----" + libros.size());
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			
			System.out.println(libroController.modificarLibro(isbn, true));
			
			libros = libroController.getLibros("SELECT * FROM libros");
			System.out.println("----" + libros.size());
			for(Libro lib: libros) {
				System.out.println(lib);
			}
		} catch (SQLException | CamposVaciosException | IsbnException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
