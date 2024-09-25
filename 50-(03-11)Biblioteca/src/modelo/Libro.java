package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro implements Comparable<Libro>{

//ATRIBUTOS
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private double precio;
	private LocalDate fechaDevolucion;
	private boolean prestado;
	
//CONTSTRUCTORES
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(String isbn, String titulo, String autor, String editorial, String precio, String fechaDevolucion, String prestado) throws IsbnException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setIsbn(isbn);
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setPrecio(precio);
		setFechaDevolucion(fechaDevolucion);
		setPrestado(prestado);
	}

	public Libro(String isbn, String titulo, String autor, String editorial, String precio) throws IsbnException, CamposVaciosException, NumberFormatException {
		super();
		setIsbn(isbn);
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setPrecio(precio);
		this.fechaDevolucion = null;
		this.prestado = false;
	}
	
//GETTERS Y SETTERS
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException {
		if(compruebaIsbn(isbn)) {
			this.isbn = isbn;
		}else {
			throw new IsbnException();
		}
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException {
		if(titulo.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.titulo = titulo;
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposVaciosException {
		if(autor.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.autor = autor;
		}
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if(editorial.equals("")) {
			throw new CamposVaciosException();
		}else{
			this.editorial = editorial;
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
		}else {
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
			suma = 10 - suma;
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
		return isbn + "," + titulo + "," + autor + "," + editorial + "," + fechaDevolucion + "," + precio + "," + prestado;
	}

//COMPARABLE
	@Override
	public int compareTo(Libro o) {
		return getTitulo().compareTo(o.getTitulo());
	}
	
	

}
