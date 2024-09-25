package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.LibroDao;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroController {

	//ATRIBUTOS
	private List<Libro> libros;
	Connection cn;
	
	public LibroController(Connection cn) {
		this.cn = cn;
	}

	public List<Libro> getLibros() throws SQLException, IsbnException, CamposVaciosException{
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.getConsultaLibros("SELECT * FROM libros");
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) throws IsbnException, CamposVaciosException, SQLException {
		Libro libro = new Libro(titulo, autor, editorial, isbn);
		
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.agregarLibroPst(libro);
	}
	
	public boolean borrarLibro(String isbn) throws IsbnException, CamposVaciosException, SQLException {
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.borrarLibroPst(isbn);
	}
	
	public List<Libro> getLibrosAutor(String autor) throws SQLException, IsbnException, CamposVaciosException{
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.getConsultaLibros("SELECT * FROM libros WHERE autor = '" + autor + "'");
	}
	
	public List<Libro> getLibroIsbn(String isbn) throws SQLException, IsbnException, CamposVaciosException{
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.getConsultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
	}
	
	public boolean modificarLibro(int idLibro, String titulo, String autor, String editorial, String isbn, boolean prestado, LocalDate fechaPrestamo, LocalDate fechaDevolucion, LocalDateTime fechaAlta) throws IsbnException, CamposVaciosException, SQLException {
		Libro libro = new Libro(idLibro, titulo, autor, editorial, isbn, prestado, fechaPrestamo, fechaDevolucion, fechaAlta);
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.modificarLibroPst(libro);
	}
}
