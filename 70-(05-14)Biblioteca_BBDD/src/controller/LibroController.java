package controller;

import java.sql.SQLException;
import java.util.List;

import dao.LibroDao;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroController {

	List<Libro> libros;
	
	public LibroController() {
	}
	
	public List<Libro> getLibros(String sql) throws SQLException, IsbnException, CamposVaciosException{
		LibroDao libroDao = new LibroDao();
		return libroDao.consultaLibros(sql);
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) throws CamposVaciosException, IsbnException, SQLException {
		Libro libro = new Libro(titulo, autor, editorial, isbn);
		LibroDao libroDao = new LibroDao();
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + libro.getIsbn() + "'");
		if(libros.size() > 0) {
			return false;
		}
		return libroDao.agregarLibro(libro);
	}
	
	public boolean borrarLibro(String isbn) throws SQLException, IsbnException, CamposVaciosException {
		LibroDao libroDao = new LibroDao();
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
		if(libros.size() <= 0) {
			return false;
		}
		return libroDao.borrarLibro(isbn);
	}
	
	public boolean modificarLibro(String isbn, boolean prestado) throws SQLException, IsbnException, CamposVaciosException {
		LibroDao libroDao = new LibroDao();
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
		if(libros.size() <= 0) {
			return false;
		}
		return libroDao.modificarLibro(isbn, prestado);
	}

}
