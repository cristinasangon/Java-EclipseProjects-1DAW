package Modelo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro implements Comparable<Libro>{
//ATRIBUTOS
	private String titulo; //Obligatorio
	private String autor;
	private String editorial;
	private String isbn;
	private double precio;
	private LocalDate fechaDevolucion;
	private boolean prestado;
		
//CONSTRUCTORES
	public Libro() {
		this.titulo = "desconocido";
		this.fechaDevolucion = null;
		this.prestado = false;
	}
	
	public Libro(String titulo, String autor, String editorial, String isbn, String precio,String fechaDevolucion, String prestado) 
			     throws IsbnException, CamposVaciosException, NumberFormatException, DateTimeException {
		super();
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setIsbn(isbn);
		setPrecio(precio);
		setFechaDevolucion(fechaDevolucion);
		setPrestado(prestado);
	}

	public Libro(String titulo, String autor, String editorial, String isbn, String precio) 
				 throws IsbnException, CamposVaciosException, NumberFormatException {
		super();
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setIsbn(isbn);
		setPrecio(precio);
		this.fechaDevolucion = null;
		this.prestado = false;
	}

//GETTERS Y SETTERS
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

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws NumberFormatException{
		this.precio = Double.parseDouble(precio);
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

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) {
		this.prestado = Boolean.parseBoolean(prestado);
	}
	
//FUNCIONES
	private boolean compruebaIsbn(String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		
		int digControl = 0;
		try {
			digControl = Integer.parseInt(Character.toString(isbn.charAt(isbn.length()-1)));
		} catch (NumberFormatException e) {
			return false;
		}
		
		int numero = 0, suma = 0;
		for(int x = 0; x < (isbn.length() - 1); x++) {
			try {
				numero = Integer.parseInt(Character.toString(isbn.charAt(x)));
			} catch (NumberFormatException e) {
				return false;
			}
			if((x + 1) % 2 == 0) {
				numero *= 3;
			}
			suma += numero; 
		}
		
		if((10 - (suma % 10)) == digControl) {
			return true;
		}
		else {
			return false;
		}
	}

//TO STRING
	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial + "," + fechaDevolucion + "," + precio + "," + prestado;
	}

//EQUALS Y HASCODE
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

	@Override
	public int compareTo(Libro o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}
	
	
	
	
	
		
		
			
	
			
			
			
}
