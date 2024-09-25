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

import com.mysql.cj.protocol.Resultset;

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
		cn = dbc.obtenerConexion();
		
		PreparedStatement pst = cn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		libros = new ArrayList<Libro>();
		while(rs.next()) {
			int idLibro = rs.getInt(1);
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
			
			Libro libro = new Libro(idLibro, titulo, autor, editorial, prestado, fechaPrestamo, fechaDevolucion, isbn, fechaAlta);
			libros.add(libro);
		}
		
		cn = null;
		dbc.cerrarConexion();
		return libros;
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
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
		Date fechaActual = new Date();
		java.sql.Timestamp ts = new java.sql.Timestamp(fechaActual.getTime());
		pst.setTimestamp(9, ts);
		
		pst.executeUpdate();
	
		cn = null;
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean borrarLibro(String isbn) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		String sql = "DELETE FROM libros WHERE isbn = '" + isbn + "'";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.executeUpdate();
		
		cn = null;
		dbc.cerrarConexion();
		return true;
	}
	
	public boolean modificarLibro(String isbn, boolean prestado) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.obtenerConexion();
		
		String sql = "";
		PreparedStatement pst;
		if(prestado) {
			sql = "UPDATE libros SET prestado = ?, fechaPrestamo = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, true);
			java.sql.Date fechaActual = new java.sql.Date(new Date().getTime());
			pst.setDate(2, fechaActual);
			pst.setDate(3, null);
			pst.setString(4, isbn);
		}else {
			sql = "UPDATE libros SET prestado = ?, fechaDevolucion = ? WHERE isbn = ?";
			pst = cn.prepareStatement(sql);
			pst.setBoolean(1, false);
			java.sql.Date fechaActual = new java.sql.Date(new Date().getTime());
			pst.setDate(2, fechaActual);
			pst.setString(3, isbn);
		}
		pst.executeUpdate();
		
		cn = null;
		dbc.cerrarConexion();
		return true;
	}

}
