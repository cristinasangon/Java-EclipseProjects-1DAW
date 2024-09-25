package modelo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro implements Comparable<Libro>{

//ATRIBUTOS
	private int idLibros;
	private String titulo, autor, editorial, isbn;
	private boolean prestado;
	private LocalDate fechaPrestamo, fechaDevolucion; 
	private LocalDateTime fechaAlta;
	
//CONTSTRUCTORES
	public Libro(String titulo, String autor, String editorial, String isbn) throws IsbnException, CamposVaciosException{
		super();
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setIsbn(isbn);
		this.setPrestado(false);
		java.util.Date fecha = new java.util.Date();
		this.setFechaAlta(new java.sql.Timestamp(fecha.getTime()).toLocalDateTime());
		this.setFechaPrestamo(null);
		this.setFechaDevolucion(null);
	}
	
	public Libro(int idLibros, String titulo, String autor, String editorial, String isbn, boolean prestado, LocalDate fechaPrestamo, LocalDate fechaDevolucion, LocalDateTime fechaAlta)  throws IsbnException, CamposVaciosException{
		super();
		this.idLibros = idLibros;
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setIsbn(isbn);
		this.setPrestado(prestado);
		this.setFechaAlta(fechaAlta);
		this.setFechaPrestamo(fechaPrestamo);
		this.setFechaDevolucion(fechaDevolucion);
	}



//GETTERS Y SETTERS
	public int getIdLibros() {
		return idLibros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException {
		if(titulo.length() == 0) {throw new CamposVaciosException("Titulo");}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposVaciosException {
		if(autor.equals("")) {throw new CamposVaciosException("Autor");}
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if(editorial.equals("")) {throw new CamposVaciosException("Editorial");}
		this.editorial = editorial;
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException, CamposVaciosException {
		if(isbn.length() == 0) {throw new CamposVaciosException("ISBN");}
		if(!compruebaIsbn(isbn)) {throw new IsbnException("ISBN incorrecto", idLibros);}
		this.isbn = isbn;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
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

	public void setFechaDevolucion(LocalDate fechaDevolucion){
		this.fechaDevolucion = fechaDevolucion;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime timestamp) {
		this.fechaAlta = timestamp;
	}

//FUNCIONES
	public static boolean compruebaIsbn(String isbn){
		try {
			isbn = isbn.replace("-", "");
			int dc = Integer.parseInt(isbn.substring(isbn.length() - 1));
			int suma = 0;
			for(int x = 0; x < (isbn.length() - 1); x++) {
				int digito = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1)%2) == 0) {
					digito *= 3;
				}
				suma += digito;
			}
			
			suma %= 10;
			if(suma != 0) {
				suma = 10 - suma;
			}
			if(suma == dc) {
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
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
	
	//TO STRING 
		@Override
		public String toString() {
			return "Libro = " + idLibros + ", " + titulo + ", " + autor + ", " + editorial + ", " + isbn + ", " + prestado + ", " + fechaPrestamo + ", " + fechaDevolucion + ", " + fechaAlta;
		}
	
	//COMPARABLE
		@Override
		public int compareTo(Libro o) {
			return getTitulo().compareTo(o.getTitulo());
		}
	
	

}
