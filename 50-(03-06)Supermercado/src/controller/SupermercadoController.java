package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.CodBarrasException;
import excepciones.SinExistenciasException;
import interfaces.ComparaPrecios;
import modelo.Producto;

public class SupermercadoController {

	List<Producto> productos;
	
	public SupermercadoController() throws IOException, NumberFormatException, DateTimeParseException, CodBarrasException, CamposVaciosException {
		File fichero = new File("supermercado.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		productos = new ArrayList<Producto>();
		String linea = "";
		while((linea = br.readLine()) != null) {
			String[] lineaArray = linea.split(",");
			
			String codBarras = lineaArray[0];
			String nombre = lineaArray[1];
			String tipoProducto = lineaArray[2];
			String precio = lineaArray[3];
			String fechaCaducidad = lineaArray[4];
			String existencias = lineaArray[5];
			String caducado = lineaArray[6];
			
			Producto producto = new Producto(codBarras, nombre, tipoProducto, precio, fechaCaducidad, existencias, caducado); 
			
			productos.add(producto);
		}
		
		br.close(); fr.close();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Producto buscarProducto (String codBarras) {
		Producto producto = null;
		for(Producto productoX: productos) {
			if(productoX.getCodBarras().equals(codBarras)) {
				producto = productoX;
				break;
			}
		}
		return producto;
	}
	
	public List<Producto> mostrarProductos(){
		List<Producto> productosOrdenados = productos;
		Collections.sort(productosOrdenados);
		return productosOrdenados;
	}
	
	public boolean agregarNuevoProducto(String codBarras, String nombre, String tipoProducto, String precio) throws NumberFormatException, CodBarrasException, CamposVaciosException {
		Producto producto = new Producto(codBarras, nombre, tipoProducto, precio);
		
		if(buscarProducto(codBarras) != null) {
			return false;
		}
		
		productos.add(producto);
		return true;
	}
	
	public List<Producto> mostrarProductosTipo(String tipoProducto){
		List<Producto> productosOrdenados = new ArrayList<Producto>();
		
		for(Producto producto: productos) {
			if(tipoProducto.equals(producto.getTipoProducto())) {
				productosOrdenados.add(producto);
			}
		}
		
		Collections.sort(productosOrdenados, new ComparaPrecios());
		
		return productosOrdenados;
	}
	
	public boolean comprarReponerProducto(String codBarras, int cantidad) throws SinExistenciasException {
		Producto producto = buscarProducto(codBarras);
		if(producto == null) {
			return false;
		}
		
		int calcularExistencias = producto.getExistencias() + cantidad;
		if(calcularExistencias <= 0) {
			throw new SinExistenciasException();
		}
		String existencias = "" + calcularExistencias; 
		producto.setExistencias(existencias);
		return true;
	}
	
	public int eliminarProductosCaducados() {
		List<Producto> todos = new ArrayList<Producto>();
		for(Producto producto: productos) {
			todos.add(producto);
		}
		int cant = 0;
		
		for(Producto producto: todos) {
			if(producto.isCaducado()) {
				this.productos.remove(producto);
				cant++;
			}
		}
		return cant;
	}

	public boolean salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("supermercado.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Producto producto: productos) {
			bw.write(producto.toString());
			bw.newLine();
		}
		
		fw.flush(); bw.close(); fw.close();
		return true;
	}
}
