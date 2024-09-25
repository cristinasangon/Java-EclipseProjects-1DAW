package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
	
	public List<Libro> consultaLibros(String sql) throws SQLException, CamposVaciosException, IsbnException{
		DbConnection dbc = new DbConnection();
		cn = dbc.getConexion();
		
		libros = new ArrayList<Libro>();
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			int idLibros = rs.getInt(1);
			String titulo = rs.getString(2);
			String autor = rs.getString(3);
			String editorial = rs.getString(4);
			boolean prestado = rs.getBoolean(5);
			
			LocalDate fechaPrestamo = null;
			if(rs.getDate(6) != null) {
				fechaPrestamo = rs.getDate(6).toLocalDate();
			}
			
			LocalDate fechaDevolucion = null;
			if(rs.getDate(7) != null) {
				fechaDevolucion = rs.getDate(7).toLocalDate();
			}
			
			String isbn = rs.getString(8);
			LocalDateTime fechaAlta = rs.getTimestamp(9).toLocalDateTime();
			
			Libro libro = new Libro(idLibros, titulo, autor, editorial, prestado, fechaPrestamo, fechaDevolucion, isbn, fechaAlta);
			libros.add(libro);
		}
		
		dbc.cerrarConexion();
		return libros;
	}
	
	public boolean agragarLibro(String titulo, String autor, String editorial, String isbn) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.getConexion();
		
		String sql = "INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		
		pst.setInt(1, 0);
		pst.setString(2, titulo);
		pst.setString(3, autor);
		pst.setString(4, editorial);
		pst.setBoolean(5, false);
		pst.setDate(6, null);
		pst.setDate(7, null);
		pst.setString(8, isbn);
		java.sql.Timestamp ts = new java.sql.Timestamp(new Date().getTime());
		pst.setTimestamp(9, ts);
		
		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean borrarLibro(String isbn) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.getConexion();
		
		String sql = "DELETE FROM libros WHERE isbn = '" + isbn + "'";
		PreparedStatement pst = cn.prepareStatement(sql);
		
		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean modificarLibro(String isbn, boolean prestado) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.getConexion();
		
		String sql = "";
		PreparedStatement pst;
		
		if(prestado) {
			sql = "UPDATE libros SET prestado = ?, fechaPrestamo = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setDate(2, new java.sql.Date(new Date().getTime()));
			pst.setDate(3, null);
			pst.setString(4, isbn);
		}else {
			sql = "UPDATE libros SET prestado = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setDate(2, new java.sql.Date(new Date().getTime()));
			pst.setString(3, isbn);
		}
		
		pst.executeUpdate();
		
		dbc.cerrarConexion();
		return true;
	}

}
