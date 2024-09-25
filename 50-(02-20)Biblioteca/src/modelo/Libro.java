package modelo;

import java.time.LocalDate;

import excepciones.BooleanException;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro {

	//ATRIBUTOS
	private String isbn, titulo, autor, editorial;
	private LocalDate fechaDevolucion;
	private double precio;
	private boolean prestado;
	
	//CONSTRUCTORES
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	
	public Libro(String isbn, String titulo, String autor, String editorial, String fechaDevolucion, String precio, String prestado) throws IsbnException, CamposVaciosException, BooleanException {
		super();
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setFechaDevolucion(fechaDevolucion);
		this.setPrecio(precio);
		this.setPrestado(prestado);
	}

	//SETTERS AND GETTERS
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException{
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
		if(titulo.equals("")){
			throw new CamposVaciosException();
		}
		this.titulo = titulo;
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

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		
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

	public void setPrestado(String prestado) throws BooleanException {
		if(prestado.equals("true") || prestado.equals("false")) {
			this.prestado = Boolean.parseBoolean(prestado);
		}
		else {
			throw new BooleanException();
		}
		
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

}
