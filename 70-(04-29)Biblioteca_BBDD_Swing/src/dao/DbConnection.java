package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static String bd = "biblioteca";
	private static String parametros = "?useSSL=false&serverTimezone=UTC";
	private static String user = "root";
	private static String pass = "root";
	private static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	Connection conn = null;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("Conexion realizada con exito");
	}

	public Connection getConnection() {
		return conn;
	}

	public void cerrarConexion() throws SQLException {
		if(conn != null) {
			System.out.println("Clossing database: [" + conn + "] ....");
			conn.close();
			System.out.println("Db disconnect.");
		}
	}
}
