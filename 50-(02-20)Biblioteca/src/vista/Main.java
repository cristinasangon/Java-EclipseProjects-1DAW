package vista;

import excepciones.BooleanException;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		String isbn = "8-412345-678905";
		String titulo = "Mi libro";
		String autor = "Alguien";
		String editorial = "Santillana";
		String precio = "10.5";
		String prestado = "true";
		
		Libro libro = new Libro();
		
		try {
			libro = new Libro(isbn, titulo, autor, editorial, editorial, precio, prestado);
			System.out.println("Libro introducido correctamente");
		} catch (IsbnException e) {
			e.printStackTrace();
		} catch (CamposVaciosException e) {
			e.printStackTrace();
		} catch (BooleanException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Formato de precio incorrecto");
		}

		
		//instanciar libro
		//instanciar getLibros de BibliotecaController (esto mete todos los datos del fichero y los almacena en una lista)
		//instanciar lista de libros ue obtiene la lista de getLibros.getLibros
		//mostrar todos los libros con un for
	}

}
