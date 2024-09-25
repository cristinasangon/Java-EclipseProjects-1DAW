package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String bd= "biblioteca";
	private static String parametros= "?useSSL=false&serverTimezone=UTC";
	private static String user= "root";
	private static String pass= "root";
	private static String url= "jdbc:mysql://localhost:3306/" + bd + parametros;
	
	Connection conn = null;
	
	public DbConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection obtenerConexion() throws SQLException {
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("La conexion se realizó con exito");
		return conn;
	}
	
	public void cerrarConexion() throws SQLException {
		if(conn != null) {
			System.out.println("Cerrando conexion...");
			conn.close();
			System.out.println("Db disconect");
		}
	}

}
