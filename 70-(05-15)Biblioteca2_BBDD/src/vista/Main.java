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
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String titulo = "La plata del rio Cartaya";
		String autor = "Gustabo Garcia";
		String editorial = "Planeta";
		String isbn = "978-1974711130";
		
		try {
			LibroController libroController = new LibroController();
			List<Libro> libros = libroController.getLibros("SELECT * FROM libros");
			System.out.println("----" + libros.size());
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			
			//isbn = isbn.substring(3, isbn.length());
			System.out.println(isbn);
			System.out.println(libroController.agregarLibro(titulo, autor, editorial, isbn));
			
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
