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
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import interfaces.ComparaFechas;
import interfaces.ComparaPrecios;
import modelo.Libro;

public class BibliotecaController {

	List<Libro> biblioteca;
	
	public BibliotecaController() throws IOException, NumberFormatException, DateTimeParseException, IsbnException, CamposVaciosException {
		File fichero = new File("biblioteca.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		biblioteca = new ArrayList<Libro>();
		while((linea = br.readLine()) != null) {
			String[] lineaSeparada = linea.split(",");
			
			String id = lineaSeparada[0];
			String isbn = lineaSeparada[1];
			String titulo = lineaSeparada[2];
			String autor = lineaSeparada[3];
			String editorial = lineaSeparada[4];
			String fechaDevolucion = lineaSeparada[5];
			String precio = lineaSeparada[6];
			String prestado = lineaSeparada[7];
			
			Libro libro = new Libro(id, isbn, titulo, autor, editorial, precio, fechaDevolucion, prestado);
			biblioteca.add(libro);
		}
		br.close();fr.close();
	}

	public List<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public Libro buscarLibro(String isbn) {
		Libro libro = null;
		for(Libro libroX: biblioteca) {
			if(libroX.getIsbn().replace("-", "").equals(isbn.replace("-", ""))) {
				libro = libroX;
			}
		}
		return libro;
	}
	
	public List<Libro> mostrarLibros(){
		List<Libro> todosLibros = new ArrayList<Libro>();
		todosLibros.addAll(biblioteca);
		Collections.sort(todosLibros);
		return todosLibros;
	}
	
	public boolean agregarLibro(String isbn, String titulo, String autor, String editorial, String precio) throws NumberFormatException, IsbnException, CamposVaciosException {
		Libro libro = new Libro(isbn, titulo, autor, editorial, precio);
		
		if(buscarLibro(isbn) != null) {
			return false;
		}
		biblioteca.add(libro);
		return true;
	}
	
	public List<Libro> mostrarLibrosAutor(String autor){
		List<Libro> librosAutor = new ArrayList<Libro>();
		for(Libro libro: biblioteca) {
			if(libro.getAutor().equals(autor)) {
				librosAutor.add(libro);
			}
		}
		Collections.sort(librosAutor, new ComparaPrecios());
		return librosAutor;
	}
	
	public List<Libro> mostrarLibrosprestados(){
		List<Libro> librosPrestados = new ArrayList<Libro>();
		for(Libro libro: biblioteca) {
			if(libro.isPrestado()) {
				librosPrestados.add(libro);
			}
		}
		Collections.sort(librosPrestados, new ComparaFechas());
		return librosPrestados;
	}
	
	public boolean prestarLibro(String isbn) {
		Libro libro = buscarLibro(isbn);
		if(libro == null) {
			return false;
		}
		
		if(libro.isPrestado()) {
			return false;
		}
		
		LocalDate calculaFecha = LocalDate.now();
		calculaFecha = calculaFecha.plusDays(20);
		String fechaDevolucion = calculaFecha.toString();
		libro.setFechaDevolucion(fechaDevolucion);
		libro.setPrestado("true");
		return true;
	}
	
	public boolean devolverLibro(String isbn) {
		Libro libro = buscarLibro(isbn);
		if(libro == null) {
			return false;
		}
		
		if(!libro.isPrestado()) {
			return false;
		}
		
		libro.setFechaDevolucion("null");
		libro.setPrestado("false");
		return true;
	}
	
	public int eliminarLibrosEditorial(String editorial) {
		int cant = 0;
		List<Libro> librosEliminar = new ArrayList<Libro>();
		for(Libro libro: biblioteca) {
			if(libro.getEditorial().equals(editorial)) {
				librosEliminar.add(libro);
				cant++;
			}
		}
		biblioteca.removeAll(librosEliminar);
		return cant;
	}

	public boolean salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("biblioteca.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(Libro libro: biblioteca) {
			bw.write(libro.toString());
			bw.newLine();
		}
		
		fw.flush();bw.close();fw.close();
		
		return true;
	}
}
