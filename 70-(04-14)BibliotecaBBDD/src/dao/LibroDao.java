package dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroDao {

	private Connection cn;
	private List<Libro> libros = new ArrayList<Libro>();
	
	public LibroDao(Connection cn) {
		this.cn = cn;
	}
	
	public List<Libro> getConsultaLibros(String sql) throws SQLException, IsbnException, CamposVaciosException{
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Libro libro;
		while(rs.next()) {
			int id = rs.getInt("idlibros");
			String titulo = rs.getString("titulo");
			String autor = rs.getString("autor");
			String editorial = rs.getString("editorial");
			String isbn = rs.getString("isbn");
			boolean prestado = rs.getBoolean("prestado");
			LocalDate fechaPrestamo;
			if(rs.getDate("fechaPrestamo") == null) {
				fechaPrestamo = null;
			}else {
				fechaPrestamo = rs.getDate("fechaPrestamo").toLocalDate();
			}
			LocalDate fechaDevolucion;
			if(rs.getDate("fechaDevolucion") == null) {
				fechaDevolucion = null;
			}else {
				fechaDevolucion = rs.getDate("fechaDevolucion").toLocalDate();
			}
			LocalDateTime fechaAlta = rs.getTimestamp("fechaAlta").toLocalDateTime();
			libro = new Libro(id, titulo, autor, editorial, isbn, prestado, fechaPrestamo, fechaDevolucion, fechaAlta);
			libros.add(libro);
			libro = null;
		}
		return libros;
	}
	
	public boolean agregarLibroPst(Libro libro) throws SQLException, IsbnException, CamposVaciosException {
		boolean agregado = false;
		List<Libro> libros = getConsultaLibros("SELECT * FROM libros");
		for(Libro l: libros) {
			if(l.getIsbn().equals(libro.getIsbn())) {
				return false;
			}
		}
		String titulo = libro.getTitulo();
		String autor = libro.getAutor();
		String editorial = libro.getEditorial();
		String isbn = libro.getIsbn();
		boolean prestado = libro.isPrestado();
		LocalDateTime fechaAlta = libro.getFechaAlta(); 
		
		String sql = "INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(1, 0);
		pst.setString(2, titulo);
		pst.setString(3, autor);
		pst.setString(4, editorial);
		pst.setBoolean(5, prestado);
		pst.setDate(6, null);
		pst.setDate(7, null);
		pst.setString(8, isbn);
		Timestamp ts = Timestamp.valueOf(fechaAlta);
		pst.setTimestamp(9, ts);
		
		pst.executeUpdate();
		pst = null;
		
		agregado = true;
		return agregado;
	}
	
	public boolean borrarLibroPst(String isbn) throws SQLException, IsbnException, CamposVaciosException {
		boolean borrar = false;
		List<Libro> libros = getConsultaLibros("SELECT * FROM libros");
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				borrar = true;
			}
		}
		
		boolean borrado = false;
		if(borrar) {
			String sql = "DELETE FROM libros WHERE isbn = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, isbn);
			
			pst.executeUpdate();
			pst = null;
			borrado = true;
		}
		
		return borrado;
	}
	
	public boolean modificarLibroPst(Libro libro) throws SQLException, IsbnException, CamposVaciosException {
		boolean modificado = false;
		
		int idLibro = libro.getIdLibros();
		String titulo = libro.getTitulo();
		String autor = libro.getAutor();
		String editorial = libro.getEditorial();
		String isbn = libro.getIsbn();
		boolean prestado = libro.isPrestado();
		Date fechaPrestamo = java.sql.Date.valueOf(libro.getFechaPrestamo());
		Date fechaDevolucion = java.sql.Date.valueOf(libro.getFechaDevolucion());
		LocalDateTime fechaAlta = libro.getFechaAlta(); 
		
		String sql = "UPDATE libros SET titulo=?, autor=?, editorial=?, prestado=?, fechaPrestamo=?, fechaDevolucion=?, isbn=?, fechaAlta=? WHERE idLibros=?";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(9, idLibro);
		pst.setString(1, titulo);
		pst.setString(2, autor);
		pst.setString(3, editorial);
		pst.setBoolean(4, prestado);
		pst.setDate(5, fechaPrestamo);
		pst.setDate(6, fechaDevolucion);
		pst.setString(7, isbn);
		Timestamp ts = Timestamp.valueOf(fechaAlta);
		pst.setTimestamp(8, ts);
		
		pst.executeUpdate();
		pst = null;
		
		modificado = true;
		return modificado;
	}

}
