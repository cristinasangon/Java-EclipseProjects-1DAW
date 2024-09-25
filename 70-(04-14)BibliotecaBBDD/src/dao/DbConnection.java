package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static String bd = "biblioteca";
	static String parametros = "?useSSL=false&serverTimezone=UTC";
	static String user = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/" + bd + parametros;
	Connection conn = null;
	
	public DbConnection() {
		try {
			//Obtenemos driver para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obetenemos una conexion con los parametros especificados anteriormente
			conn = DriverManager.getConnection(url, user, password);
			if(conn != null) {
				//System.out.println("Connecting database [" + conn + "] OK");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Exception connection: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Exception driver: " + e.getMessage());
		}
		
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void disconnect() throws SQLException {
		if(conn != null) {
			System.out.println("Cerrando conexion...");
			conn.close();
			System.out.println("Conexion finalizada");
		}
	}
}
