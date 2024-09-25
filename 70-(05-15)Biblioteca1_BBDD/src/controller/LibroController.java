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
		// TODO Auto-generated constructor stub
	}
	
	public List<Libro> getLibros(String sql) throws SQLException, CamposVaciosException, IsbnException{
		LibroDao libroDao = new LibroDao();
		return libroDao.consultaLibros(sql);
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) throws SQLException, CamposVaciosException, IsbnException {
		LibroDao libroDao = new LibroDao();
		Libro libro = new Libro(titulo, autor, editorial, isbn);
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
		if(libros.size() > 0) {
			return false;
		}
		return libroDao.agregarLibro(titulo, autor, editorial, isbn);
	}
	
	public boolean borrarLibro(String isbn) throws SQLException, CamposVaciosException, IsbnException {
		LibroDao libroDao = new LibroDao();
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
		if(libros.size() <= 0) {
			return false;
		}
		return libroDao.borrarLibro(isbn);
	}
	
	public boolean modificarLibro(String isbn, boolean prestado) throws SQLException, CamposVaciosException, IsbnException {
		LibroDao libroDao = new LibroDao();
		libros = libroDao.consultaLibros("SELECT * FROM libros WHERE isbn = '" + isbn + "'");
		if(libros.size() <= 0) {
			return false;
		}else {
			for(Libro lib: libros) {
				if(lib.isPrestado() == prestado) {
					return false;
				}
			}
		}
		return libroDao.modificarLibro(isbn, prestado);
	}

}
