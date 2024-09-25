package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class LibroDao {

	private List<Libro> libros;
	Connection cn = null;
	
	public LibroDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Libro> consultaLibros(String sql) throws SQLException, CamposVaciosException, IsbnException{
		DbConnection dbc = new DbConnection();
		cn = dbc.getConnection();
		
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
			
			Libro libro = new Libro(idLibro, titulo, autor, editorial, isbn, prestado, fechaPrestamo, fechaDevolucion, fechaAlta);
			libros.add(libro);
		}
		
		cn = null;
		dbc.cerrarConexion();
		return libros;
	}
	
	public boolean agregarLibro(Libro libro) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.getConnection();
		
		boolean agregado = false;
		String sql = "INSERT INTO libros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(1, libro.getIdLibro());
		pst.setString(2, libro.getTitulo());
		pst.setString(3, libro.getAutor());
		pst.setString(4, libro.getEditorial());
		pst.setBoolean(5, libro.isPrestado());
		pst.setDate(6, null);
		pst.setDate(7, null);
		pst.setString(8, libro.getIsbn());
		Timestamp ts = Timestamp.valueOf(libro.getFechaAlta());
		pst.setTimestamp(9, ts);
		
		pst.executeUpdate();
		agregado = true;
		cn = null;
		dbc.cerrarConexion();
		return agregado;
	}
	
	public boolean borrarLibro(String campo, String valor) throws SQLException {
		DbConnection dbc = new DbConnection();
		cn = dbc.getConnection();
		
		boolean borrado = false;
		String sql = "DELETE FROM libros WHERE " + campo + " = '" + valor + "'";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.executeUpdate();
		borrado = true;
		cn = null;
		dbc.cerrarConexion();
		return borrado;
	}
	
	public int modificarLibro(String isbn, boolean prestado) throws SQLException {
		int cant = 0;
		DbConnection dbc = new DbConnection();
		cn = dbc.getConnection();
		int prestadoInt = prestado ? 1 : 0;
		String sql;
		
		
		LocalDate fechaPrestamo;
		LocalDate fechaDevolucion;
		if(prestado) {
			fechaPrestamo = LocalDate.now();
			sql = "UPDATE libros SET prestado = '" + prestadoInt + "', fechaPrestamo = '" + Date.valueOf(fechaPrestamo) + "', fechaDevolucion = null WHERE isbn = '" + isbn + "'";
		}else {
			fechaDevolucion = LocalDate.now();
			sql = "UPDATE libros SET prestado = '" + prestadoInt + "', fechaDevolucion = '" + Date.valueOf(fechaDevolucion) + "' WHERE isbn = '" + isbn + "'";
		}
		
		PreparedStatement pst = cn.prepareStatement(sql);
		
		cant = pst.executeUpdate();
		cn = null;
		dbc.cerrarConexion();
		return cant;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
