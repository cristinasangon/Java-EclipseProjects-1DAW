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
		int idLibro = 13;
		String titulo = "El quijote";
		String autor = "Perez Reverte;Arturo";
		String editorial = "Bibliotex";
		boolean prestado = true;
		LocalDate fechaPrestamo = LocalDate.of(2017, 02, 01);
		LocalDate fechaDevolucion = LocalDate.of(2017, 02, 06);
		String isbn = "‎‎‎978-84-08-13405-3";
		LocalDateTime fechaAlta = LocalDateTime.of(2017, 03, 13, 22, 00, 00);
		
	
		try {
			LibroController libroController = new LibroController();
			
			//System.out.println("agregar" + libroController.agregarLibro(titulo, autor, editorial, isbn));
			
			//System.out.println("borrar" + libroController.borrarLibro(isbn));
			
			isbn = "‎978-1569319017";
			prestado = true;
			System.out.println("modificar----" + libroController.modificarLibro(isbn, prestado));
			
			List<Libro> libros = libroController.getLibros("SELECT * FROM libros");
			System.out.println("---" + libros.size());
			for(Libro lib: libros) {
				System.out.println(lib);
			}
			
		} catch (IsbnException | CamposVaciosException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		DbConnection dbc;
		try {
			dbc = new DbConnection();
			Connection cn = dbc.obtenerConexion();
			dbc.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
