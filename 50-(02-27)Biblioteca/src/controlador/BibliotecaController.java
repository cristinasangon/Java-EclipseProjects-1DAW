package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import Modelo.Libro;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import interfaces.ComparaFechas;
import interfaces.ComparaPrecios;

public class BibliotecaController {

//ATRIBUTOS
	ArrayList<Libro> biblioteca = new ArrayList<Libro>();

//CONSTRUCTOR
	public BibliotecaController() throws IOException, NumberFormatException, DateTimeException, IsbnException, CamposVaciosException {
		File fichero = new File("biblioteca.txt");
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		while((linea = br.readLine()) != null) {
			String[] libroArrayFichero = linea.split(",");
			
			String isbn = libroArrayFichero[0];
			String titulo = libroArrayFichero[1];
			String autor = libroArrayFichero[2];
			String editorial = libroArrayFichero[3];
			String fechaDevolucion = libroArrayFichero[4];
			String precio = libroArrayFichero[5];
			String prestado = libroArrayFichero[6];
			
			Libro libro = new Libro(titulo, autor, editorial, isbn, precio, fechaDevolucion, prestado);
			
			this.biblioteca.add(libro);
		}
		
		br.close();
		fr.close();
	}

//GETTER Y SETTER
	public ArrayList<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}

//FUNCIONES
	public Libro buscarLibroPorIsbn(String isbn) {
		Libro l = null;
		for(int x = 0; x < biblioteca.size(); x++) {
			if(isbn.equals(biblioteca.get(x).getIsbn())) {
				l = biblioteca.get(x);
			}
		}
		return l;
	}
	
	public boolean modificarLibro(String isbn, String titulo, String autor, String editorial, String precio) throws CamposVaciosException {
		Libro l = buscarLibroPorIsbn(isbn);
		if(l != null) {
			for(int x = 0; x < biblioteca.size(); x++) {
				if(isbn.equals(biblioteca.get(x).getIsbn())) {
					biblioteca.get(x).setTitulo(titulo);
					biblioteca.get(x).setAutor(autor);
					biblioteca.get(x).setEditorial(editorial);
					biblioteca.get(x).setPrecio(precio);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean añadirLibro(Libro libroAñadir) {
		if(!biblioteca.contains(libroAñadir)) {
			biblioteca.add(libroAñadir);
			return true;
		}
		return false;
	}
	
	public boolean eliminarLibro (String isbn) {
		Libro l = buscarLibroPorIsbn(isbn);
		if(l != null) {
			for(int x = 0; x < biblioteca.size(); x++) {
				if(isbn.equals(biblioteca.get(x).getIsbn())) {
					biblioteca.remove(x);
					return true;
				}
			}
		}
		return false;	
	}
	
	public boolean prestarLibro (String isbn, String fecha) throws DateTimeParseException{
		Libro l = buscarLibroPorIsbn(isbn);
		if(l != null && l.isPrestado() == false) {
			l.setPrestado("true");
			l.setFechaDevolucion(fecha);
			return true;
		}
		return false;
	}
	
	public boolean devolverLibro (String isbn) {
		Libro l = buscarLibroPorIsbn(isbn);
		if(l != null && l.isPrestado() == true) {
			l.setPrestado("false");
			l.setFechaDevolucion("null");
			return true;
		}
		return false;
	}

	public ArrayList<Libro> filtrarLibrosPorAutor (String autor){
		ArrayList<Libro> librosAutor = new ArrayList<Libro>();
		
		for(Libro libroX: biblioteca) {
			if(libroX.getAutor().equals(autor)) {
				librosAutor.add(libroX);
			}
		}
		return librosAutor;
	}
	
	public ArrayList<Libro> mostrarLibrosPendientesDevolucion (){
		ArrayList<Libro> librosPendientesDevolucion = new ArrayList<Libro>();
		
		for(Libro libroX: biblioteca) {
			if(libroX.isPrestado()) {
				librosPendientesDevolucion.add(libroX);
			}
			
		}
		return librosPendientesDevolucion;
	}
	
	public ArrayList<Libro> ordenarLibrosAlfabeticamente (){
		ArrayList<Libro> librosOrdenados = new ArrayList<Libro>();
		librosOrdenados = biblioteca;
		
		Collections.sort(librosOrdenados);
		
		return librosOrdenados;
	}
	
	public ArrayList<Libro> ordenarLibrosPorFechaDevolucion (){
		ArrayList<Libro> librosOrdenados = new ArrayList<Libro>();
		librosOrdenados = biblioteca;
		
		Collections.sort(librosOrdenados, new ComparaFechas());
		
		return librosOrdenados;
	}
	
	public ArrayList<Libro> ordenarLibrosPorPrecio (){
		ArrayList<Libro> librosOrdenados = new ArrayList<Libro>();
		librosOrdenados = biblioteca;
		
		Collections.sort(librosOrdenados, new ComparaPrecios());
		
		return librosOrdenados;
	}
	
	public void guardarDatosFichero() throws IOException {
		FileWriter fw = new FileWriter("biblioteca.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Libro libroX: biblioteca) {
			bw.write(libroX.toString());
			bw.newLine();
		}
		
		fw.flush();bw.close();fw.close();
	}
}
