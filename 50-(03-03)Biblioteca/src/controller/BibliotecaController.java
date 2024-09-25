package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import interfaces.ComparaFechas;
import interfaces.ComparaPrecios;
import modelo.Libro;

public class BibliotecaController {

	ArrayList<Libro> biblioteca; 
	
	public BibliotecaController() throws IOException, DateTimeParseException, NumberFormatException, IsbnException, CamposVaciosException {
		File fichero = new File("biblioteca.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		biblioteca = new ArrayList<Libro>();
		String linea = "";
		while((linea = br.readLine()) != null) {
			String[] libroArray = linea.split(",");
			
			String isbn = libroArray[0];
			String titulo = libroArray[1];
			String autor = libroArray [2];
			String editorial = libroArray[3];
			String fechaPrestado = libroArray[4];
			String precio = libroArray[5];
			String prestado = libroArray[6];
			
			Libro libro = new Libro(isbn, titulo, autor, editorial, fechaPrestado, precio, prestado);
			biblioteca.add(libro);
		}
		
		br.close();
		fr.close();
	}

	public ArrayList<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public Libro buscarLibro (String isbn) {
		Libro libro = null;
		for(Libro libroX: biblioteca) {
			if(isbn.equals(libroX.getIsbn())){
				libro = libroX;
			}
		}
		return libro;
	}
	
	public boolean añadirLibro (String isbn, String titulo, String autor, String editorial, String precio) throws IsbnException, CamposVaciosException, NumberFormatException {
		Libro libro = new Libro(isbn, titulo, autor, editorial, precio);
		if(buscarLibro(libro.getIsbn()) != null) {
			return false;
		}
		biblioteca.add(libro);
		return true;
	}
	
	public boolean eliminarLibro (String isbn) {
		Libro libro = null;
		if((libro = buscarLibro(isbn)) == null) {
			return false;
		}
		biblioteca.remove(libro);
		return true;
	}
	
	public boolean prestarLibro (String isbn, String fecha) {
		Libro libro = null;
		if((libro = buscarLibro(isbn)) == null) {
			return false;
		}
		
		if(libro.isPrestado()) {
			return false;
		}
		
		libro.setFechaDevolucion(fecha);
		libro.setPrestado("true");
		return true;
	}
	
	public boolean devolverLibro (String isbn) {
		Libro libro = null;
		if((libro = buscarLibro(isbn)) == null) {
			return false;
		}
		
		if(!libro.isPrestado()) {
			return false;
		}
		
		libro.setFechaDevolucion("null");
		libro.setPrestado("false");
		return true;
	}
	
	public ArrayList<Libro> ordenarAlfabeticamente(){
		ArrayList<Libro> librosOrdenados = biblioteca;
		Collections.sort(biblioteca);
		return librosOrdenados;
	}
	
	public ArrayList<Libro> ordenarFechaDevolucion(){
		ArrayList<Libro> librosOrdenados = new ArrayList<Libro>();
		for(Libro libroX: biblioteca) {
			if(libroX.getFechaDevolucion() != null) {
				librosOrdenados.add(libroX);
			}
		}
		Collections.sort(librosOrdenados, new ComparaFechas());
		return librosOrdenados;
	}
	
	public ArrayList<Libro> ordenarPorPrecio(){
		ArrayList<Libro> librosOrdenados = biblioteca;
		Collections.sort(biblioteca, new ComparaPrecios());
		return librosOrdenados;
	}
	
	public ArrayList<Libro> filtrarLibrosPorAutor(String autor){
		ArrayList<Libro> lista = new ArrayList<Libro>();
		for(Libro libroX: biblioteca) {
			if(libroX.getAutor().equals(autor)) {
				lista.add(libroX);
			}
		}
		return lista;
	}
	
	public ArrayList<Libro> filtrarLibrosPendientesDevolucion(){
		ArrayList<Libro> lista = new ArrayList<Libro>();
		for(Libro libroX: biblioteca) {
			if(libroX.isPrestado()) {
				lista.add(libroX);
			}
		}
		return lista;
	}
	
	public void salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("biblioteca.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Libro libro: biblioteca) {
			bw.write(libro.toString());
			bw.newLine();
		}
		
		fw.flush(); bw.close(); fw.close();
	}

}
