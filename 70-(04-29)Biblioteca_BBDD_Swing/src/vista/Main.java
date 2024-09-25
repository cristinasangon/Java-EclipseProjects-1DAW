package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import controller.LibroController;
import dao.DbConnection;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			frmLibros2 formulario = new frmLibros2();
		} catch (SQLException | CamposVaciosException | IsbnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
