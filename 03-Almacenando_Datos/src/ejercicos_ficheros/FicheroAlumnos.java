package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FicheroAlumnos {

	public FicheroAlumnos() throws IOException {
		// TODO Auto-generated constructor stub
		File fichero;
		fichero = new File("Ficheros//ficheroAlumnos.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String dato = "";
		
		String nombre = "", curso = "";
		int edad = 0;
		
		while((dato = br.readLine()) != null) {
			nombre = dato;
			edad = Integer.parseInt(br.readLine());
			curso = br.readLine();
			
			System.out.println(nombre + " | " + curso + " | " + edad);
		}
	}

}
