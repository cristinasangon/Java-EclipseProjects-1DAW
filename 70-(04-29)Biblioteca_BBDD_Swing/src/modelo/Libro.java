package modelo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro {

//ATRIBUTOS
	private int idLibro;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private boolean prestado;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private LocalDateTime fechaAlta;

//CONSTRUCTORES
	public Libro(int idLibro, String titulo, String autor, String editorial, String isbn, boolean prestado, LocalDate fechaPrestamo, LocalDate fechaDevolucion, LocalDateTime fechaAlta) throws CamposVaciosException, IsbnException {
		super();
		this.idLibro = idLibro;
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setIsbn(isbn);
		setPrestado(prestado);
		setFechaPrestamo(fechaPrestamo);
		setFechaDevolucion(fechaDevolucion);
		setFechaAlta(fechaAlta);
	}

	public Libro(String titulo, String autor, String editorial, String isbn) throws CamposVaciosException, IsbnException {
		super();
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setIsbn(isbn);
		setPrestado(false);
		this.fechaPrestamo = null;
		this.fechaDevolucion = null;
		Date fechaActual = new Date();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(fechaActual.getTime());
		this.fechaAlta = sqlTimestamp.toLocalDateTime();
	}

//GETTERS Y SETTERS
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException{
		if(titulo.equals("")) {
			throw new CamposVaciosException("titulo");
		}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposVaciosException {
		if(autor.equals("")) {
			throw new CamposVaciosException("autor");
		}
		this.autor = autor;
	}

	public String getEditorial(){
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if(editorial.equals("")) {
			throw new CamposVaciosException("editorial");
		}
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException {
		if(!compruebaIsbn(isbn)) {
			throw new IsbnException(isbn);
		}
		this.isbn = isbn;
	}
	
	public boolean isPrestado() {
		return prestado;
	}
	
	public void setPrestado(boolean prestado) throws IsbnException {
		this.prestado = prestado;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
//FUNCIONES
	public static boolean compruebaIsbn(String isbn) {
		isbn = isbn.replace("-", "");
		isbn = isbn.replace(" ", "");
		
		if(isbn.equals("")) {
			return false;
		}
		
		int suma = 0;
		int dc = 0;
		int dcCalculado = 0;
		try {
			dc = Integer.parseInt(Character.toString(isbn.charAt(isbn.length() - 1)));
			for(int x = 0; x < isbn.length() - 1; x++) {
				int numero = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1) % 2) == 0) {
					numero *= 3;
				}
				suma += numero;
			}
			suma %= 10;
			if(suma == 0) {
				dcCalculado = 0;
			}else {
				dcCalculado = 10 - suma;
			}
			
			if(dcCalculado == dc) {
				return true;
			}else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

//TOSTRING
	@Override
	public String toString() {
		return "Libro =" + idLibro + ", " + titulo + ", " + autor + ", " + editorial + ", " + isbn + ", " + prestado + ", " + fechaPrestamo	+ ", " + fechaDevolucion + ", " + fechaAlta;
	}
	
	
}
