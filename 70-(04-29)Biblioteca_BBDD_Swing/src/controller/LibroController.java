package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.LibroDao;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroController {

	private List<Libro> libros;
	
	public LibroController() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Libro> getLibros(String sql) throws SQLException, CamposVaciosException, IsbnException{
		LibroDao libroDao = new LibroDao();
		return libroDao.consultaLibros(sql);
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) throws CamposVaciosException, IsbnException, SQLException {
		Libro libro = new Libro(titulo, autor, editorial, isbn);
		LibroDao libroDao = new LibroDao();
		
		String sql = "SELECT * FROM libros WHERE isbn = '" + libro.getIsbn() + "'";
		List<Libro> libros = libroDao.consultaLibros(sql);
		for(Libro l: libros) {
			return false;
		}
		
		return libroDao.agregarLibro(libro);
	}
	
	public boolean borrarLibro(String campo, String valor) throws CamposVaciosException, IsbnException, SQLException {
		LibroDao libroDao = new LibroDao();
		
		String sql = "SELECT * FROM libros WHERE " + campo + " = '" + valor + "'";
		List<Libro> libros = libroDao.consultaLibros(sql);
		for(Libro l: libros) {
			libroDao.borrarLibro(campo, valor);
			return true;
		}
		return false;
	}
	
	public int modificarLibro(String isbn, boolean prestado) throws SQLException {
		LibroDao libroDao = new LibroDao();
		return libroDao.modificarLibro(isbn, prestado);
	}

}
