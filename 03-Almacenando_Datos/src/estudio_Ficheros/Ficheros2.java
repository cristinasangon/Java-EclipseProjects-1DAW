package estudio_Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros2 {

	public Ficheros2() throws IOException {
		System.out.println(" == = == = == = ESTUDIO FICHEROS = == = == = == ");
		
	//alumnos.txt
		File fichero;
		fichero = new File("Ficheros//alumnos.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr;
		BufferedReader br;
		String nombre = "";
		fr = new FileReader(fichero);
		br = new BufferedReader(fr);
		
		while((nombre = br.readLine()) != null) {
			System.out.println(nombre);
		}
		
		System.out.println("== == == == == == == == == == == == == ==");
		
	//alumnos2.txt
		fichero = new File("Ficheros//alumnos2.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		fr = new FileReader(fichero);
		br = new BufferedReader(fr);
		
		nombre = "";
		int edad = 0;
		String curso = "";
		while((nombre = br.readLine()) != null) {
			edad = Integer.parseInt(br.readLine());
			curso = br.readLine();
			System.out.println(nombre + " | " + curso + " | " + edad);
		}
		
		System.out.println("== == == == == == == == == == == == == ==");
		
	//alumnos3.txt
		fichero = new File("Ficheros//alumnos3.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		fr = new FileReader(fichero);
		br = new BufferedReader(fr);
		
		String linea = "";
		nombre = ""; 
		edad = 0;
		curso = "";
		
		while((linea = br.readLine()) != null) {
			String[] datos = linea.split(",");
			nombre = datos[0];
			edad = Integer.parseInt(datos[1]);
			curso = datos[2];
			System.out.println(nombre + " | " + curso + " | " + edad);
		}
		
		
		
		
		
		
		
		
		
	}

}
