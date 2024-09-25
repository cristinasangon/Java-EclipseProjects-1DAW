package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro implements Comparable<Libro>{

//ATRIBUTOS ---------------------------------------------------------------------------------------------
	String isbn;
	String titulo;
	String autor;
	String editorial;
	LocalDate fechaDevolucion;
	double precio;
	boolean prestado;
	
//CONSTRUCTORES -----------------------------------------------------------------------------------------
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String isbn, String titulo, String autor, String editorial, String fechaDevolucion, String precio, String prestado) throws IsbnException, CamposVaciosException, DateTimeParseException, NumberFormatException {
		super();
		setIsbn(isbn);
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setFechaDevolucion(fechaDevolucion);
		setPrecio(precio);
		setPrestado(prestado);
		
	}

	public Libro(String isbn, String titulo, String autor, String editorial, String precio) throws IsbnException, CamposVaciosException, NumberFormatException {
		super();
		setIsbn(isbn);
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		this.fechaDevolucion = null;
		setPrecio(precio);
		this.prestado = false;
	}
	
//GETTERS Y SETTERS -------------------------------------------------------------------------------------
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException {
		if(compruebaIsbn(isbn)) {
			this.isbn = isbn;
		}
		else {
			throw new IsbnException();
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException {
		if(titulo.equals("")) {
			throw new CamposVaciosException();
		}
		else {
			this.titulo = titulo;	
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposVaciosException {
		if(autor.equals("")) {
			throw new CamposVaciosException();
		}
		else {
			this.autor = autor;
		}
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if(editorial.equals("")) {
			throw new CamposVaciosException();
		}
		else {
			this.editorial = editorial;
		}
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) throws DateTimeParseException{
		if(fechaDevolucion.equals("null")) {
			this.fechaDevolucion = null;
		}
		else {
			this.fechaDevolucion = LocalDate.parse(fechaDevolucion);
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws NumberFormatException{
		this.precio = Double.parseDouble(precio);
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) {
		this.prestado = Boolean.parseBoolean(prestado);
	}

//TO STRING ---------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return  isbn + "," + titulo + "," + autor + "," + editorial + "," + fechaDevolucion + "," + precio + "," + prestado;
	}

//EQUALS Y HASCODE --------------------------------------------------------------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

//COMPARABLE (ORDENACION NATURAL) -----------------------------------------------------------------------
	@Override
	public int compareTo(Libro o) {
		return getTitulo().compareTo(o.getTitulo());
	}
	
//FUNCIONES ---------------------------------------------------------------------------------------------
	public static boolean compruebaIsbn (String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		
		int dc = 0;
		try {
			dc = Integer.parseInt(isbn.substring(isbn.length() - 1));
		} catch (NumberFormatException e) {
			return false;
		}
		String numeros = isbn.substring(0, isbn.length() - 1);
		
		int calcularDC = 0;
		for(int x = 0; x < numeros.length(); x++) {
			int num = 0;
			try {
				num = Integer.parseInt(Character.toString(numeros.charAt(x)));
			} catch (NumberFormatException e) {
				return false;
			}
			
			if(((x + 1) % 2) == 0){
				num *= 3; 
			}
			
			calcularDC += num;
		}
		
		calcularDC %= 10;
		calcularDC = 10 - calcularDC;
		
		if(calcularDC == dc) {
			return true;
		}
		
		return false;
	}
	


	
}
