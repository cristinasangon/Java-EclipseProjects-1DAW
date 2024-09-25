package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;

public class Libro {

//A T R I B U T O S
	private int idLibros;
	private String titulo;
	private String autor;
	private String editorial;
	private boolean prestado;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private String isbn;
	private LocalDateTime fechaAlta;
	
//C O N S T R U C T O R E S
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(int idLibros, String titulo, String autor, String editorial, boolean prestado, LocalDate fechaPrestamo,
			LocalDate fechaDevolucion, String isbn, LocalDateTime fechaAlta) throws CamposVaciosException, IsbnException {
		super();
		setIdLibros(idLibros);
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		setPrestado(prestado);
		setFechaPrestamo(fechaPrestamo);
		setFechaDevolucion(fechaDevolucion);
		setIsbn(isbn);
		setFechaAlta(fechaAlta);
	}

	public Libro(String titulo, String autor, String editorial, String isbn) throws CamposVaciosException, IsbnException {
		super();
		this.idLibros = 0;
		setTitulo(titulo);
		setAutor(autor);
		setEditorial(editorial);
		this.prestado = false;
		this.fechaPrestamo = null;
		this.fechaDevolucion = null;
		setIsbn(isbn);
		java.sql.Timestamp ts = new java.sql.Timestamp(new Date().getTime());
		this.fechaAlta = ts.toLocalDateTime();
	}

//G E T T E R S   Y   S E T T E R S
	public int getIdLibros() {
		return idLibros;
	}

	public void setIdLibros(int idLibros) {
		this.idLibros = idLibros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposVaciosException {
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposVaciosException {
		if(editorial.equals("")) {
			throw new CamposVaciosException("editorial");
		}
		this.editorial = editorial;
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

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
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

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
//F U N C I O N E S
	public static boolean compruebaIsbn(String isbn) {
		isbn = isbn.replace("-", "");
		
		try {
			int suma = 0;
			int dc = Integer.parseInt(Character.toString(isbn.charAt(isbn.length() - 1)));
			for(int x = 0; x < (isbn.length() - 1); x++) {
				int digito = Integer.parseInt(Character.toString(isbn.charAt(x)));
				if(((x + 1) % 2) == 0) {
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
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

//T O   S T R I N G 
	@Override
	public String toString() {
		return "Libro [idLibros=" + idLibros + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", prestado=" + prestado + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion
				+ ", isbn=" + isbn + ", fechaAlta=" + fechaAlta + "]";
	}
	

}
