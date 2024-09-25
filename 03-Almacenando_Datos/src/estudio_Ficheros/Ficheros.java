package estudio_Ficheros;

import java.io.File;
import java.io.IOException;

public class Ficheros {

	public Ficheros() {
		System.out.println(" == = == = == = ESTUDIO FICHEROS = == = == = == ");
		File fichero, directorio;
		
		directorio = new File("Ficheros");
		boolean exito = directorio.mkdir();
		if(exito) {System.out.println("Directorio creado con exito");}
		else {System.out.println("Directorio no creado o ya existente");}
		
		if(directorio.isDirectory()) {
			System.out.println("Es un directorio");
		}
		
		System.out.println("== == == == == == == == == == == == == ==");
		
		fichero = new File("Ficheros//fichero.txt");
		try {
			exito = fichero.createNewFile();
			if(exito) {System.out.println("Fichero creado con exito");}
			else {System.out.println("Fichero no creado o ya existente");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
