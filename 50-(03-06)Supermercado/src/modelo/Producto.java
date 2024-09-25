package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Objects;

import excepciones.CamposVaciosException;
import excepciones.CodBarrasException;

public class Producto implements Comparable<Producto>{

//ATRIBUTOS
	private String codBarras; //Clave principal
	private String nombre;
	private String tipoProducto;
	private double precio;
	private LocalDate fechaCaducidad;
	private int existencias;
	private boolean caducado;
	
//CONSTRUCTORES
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String codBarras, String nombre, String tipoProducto, String precio, String fechaCaducidad, String existencias, String caducado) throws CodBarrasException, CamposVaciosException, NumberFormatException, DateTimeParseException {
		super();
		setCodBarras(codBarras);
		setNombre(nombre);
		setTipoProducto(tipoProducto);
		setPrecio(precio);
		setFechaCaducidad(fechaCaducidad);
		setExistencias(existencias);
		setCaducado(caducado);
	}

	public Producto(String codBarras, String nombre, String tipoProducto, String precio) throws CodBarrasException, CamposVaciosException, NumberFormatException{
		super();
		setCodBarras(codBarras);
		setNombre(nombre);
		setTipoProducto(tipoProducto);
		setPrecio(precio);
		LocalDate fecha = LocalDate.now(); this.fechaCaducidad = fecha.plusDays(30);
		this.existencias = 0;
		this.caducado = false;
	}

//GETTERS Y SETTERS
	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) throws CodBarrasException {
		codBarras = codBarras.replace(" ", "");
		if(compruebaCodigoDeBarras(codBarras)) {
			this.codBarras = codBarras;
		}else {
			throw new CodBarrasException();
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CamposVaciosException {
		if(nombre.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.nombre = nombre;	
		}
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) throws CamposVaciosException {
		if(tipoProducto.equals("")) {
			throw new CamposVaciosException();
		}else {
			this.tipoProducto = tipoProducto;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws NumberFormatException{
		this.precio = Double.parseDouble(precio);
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) throws DateTimeParseException{
		if(fechaCaducidad.equals("null")) {
			this.fechaCaducidad = null;
		}
		this.fechaCaducidad = LocalDate.parse(fechaCaducidad);
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(String existencias) throws NumberFormatException{
		this.existencias = Integer.parseInt(existencias);
	}

	public boolean isCaducado() {
		return caducado;
	}

	public void setCaducado(String caducado) {
		this.caducado = Boolean.parseBoolean(caducado);
	}
	
//FUNCIONES
	public static boolean compruebaCodigoDeBarras(String codBarras) {
		int suma = 0;
		
		int dc = 0;
		try {
			dc = Integer.parseInt(codBarras.substring(codBarras.length() - 1));
		} catch (NumberFormatException e) {
			return false;
		}
		
		codBarras = codBarras.substring(0, codBarras.length() - 1);
		
		for(int x = 1; x <= codBarras.length(); x++) {
			int num = 0;
			try {
				num = Integer.parseInt(Character.toString(codBarras.charAt(x - 1)));
			} catch (NumberFormatException e) {
				return false;
			}
			if((x % 2) == 0) {
				num *= 3;
			}
			suma += num;
		}
		
		int codControl = 0;
		while((suma % 10) != 0) {
			suma++;
			codControl++;
		}
		
		if(codControl == dc) {
			return true;
		}
		return false;
	}

//EQUALS Y HASCODE
	@Override
	public int hashCode() {
		return Objects.hash(codBarras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codBarras, other.codBarras);
	}

//TO STRING
	@Override
	public String toString() {
		return codBarras + "," + nombre + "," + tipoProducto + "," + precio + "," + fechaCaducidad + "," + existencias + "," + caducado;
	}

//COMPARABLE
	@Override
	public int compareTo(Producto o) {
		return this.getTipoProducto().compareTo(o.getTipoProducto());
	}
	
	

}
