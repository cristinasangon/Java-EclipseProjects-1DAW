package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroDao {

	List<Libro> libros;
	Connection cn = null;
	
	public LibroDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Libro> consultaLibros(String sql) throws SQLException, IsbnException, CamposVaciosException{
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		libros = new ArrayList<Libro>();
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			int idLibro = rs.getInt(1);
			String titulo = rs.getString(2);
			String autor = rs.getString(3);
			String editorial = rs.getString(4);
			boolean prestado = rs.getBoolean(5);
			
			LocalDate fechaPrestamo = null;
			if(rs.getDate(6) != null) {
				fechaPrestamo = rs.getDate(6).toLocalDate();;
			}
			
			LocalDate fechaDevolucion = null;
			if(rs.getDate(7) != null) {
				fechaDevolucion = rs.getDate(7).toLocalDate();;
			}
			
			String isbn = rs.getString(8);
			LocalDateTime fechaAlta = rs.getTimestamp(9).toLocalDateTime();
			
			Libro libro = new Libro(idLibro, titulo, autor, editorial, prestado, fechaPrestamo, fechaDevolucion, isbn, fechaAlta);
			libros.add(libro);
		}
				
		dbc.cerrarConexion();
		return libros;
	}
	
	public boolean agregarLibro(Libro libro) throws SQLException, IsbnException, CamposVaciosException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		String sql = "INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		
		pst.setInt(1, libro.getIdLibro());
		pst.setString(2, libro.getTitulo());
		pst.setString(3, libro.getAutor());
		pst.setString(4, libro.getEditorial());
		pst.setBoolean(5, false);
		pst.setDate(6, null);
		pst.setDate(7, null);
		pst.setString(8, libro.getIsbn());
		pst.setTimestamp(9, java.sql.Timestamp.valueOf(libro.getFechaAlta()));
		
		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean borrarLibro(String isbn) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		String sql = "DELETE FROM libros WHERE isbn = '" + isbn + "'";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean modificarLibro(String isbn, boolean prestado) throws SQLException, IsbnException, CamposVaciosException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		String sql = "";
		PreparedStatement pst = null;
		if(prestado) {
			sql = "UPDATE libros SET prestado = ?, fechaPrestamo = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			pst.setDate(3, null);
			pst.setString(4, isbn);
		}else {
			sql = "UPDATE libros SET prestado = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
			pst.setString(3, isbn);
		}

		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}
}
