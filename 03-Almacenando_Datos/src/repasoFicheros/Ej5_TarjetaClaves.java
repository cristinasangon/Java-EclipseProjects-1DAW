package repasoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import ejercicos_ficheros.Leer;

public class Ej5_TarjetaClaves {

	public Ej5_TarjetaClaves() throws IOException {
		File fichero = new File("FicherosRepaso//tarjetaClaves.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		int cantUsuarios = Integer.parseInt(br.readLine());
		
		System.out.println("== = == = == = == = == = == = == = == = == = == = ==");
		System.out.println("INICIAR SESIÓN");
		System.out.println("== = == = == = == = == = == = == = == = == = == = ==");
		System.out.print("Nombre de usuario: ");
		String user = Leer.cadena();
		System.out.print("Contraseña: ");
		String pass = Leer.cadena();
				
		
		boolean usuarioEncontrado = false;
		String linea = "";
		String[] tarjetaClave = new String[25];
		while(!usuarioEncontrado && (linea = br.readLine()) != null) {
			String[] userPass = linea.split(",");
			linea = br.readLine();
			if(userPass[0].equals(user) && userPass[1].equals(pass)) {
				usuarioEncontrado = true;
				tarjetaClave = linea.split(",");
			}
		}
		
		br.close(); fr.close();
		
		String[][] tarjetaClaveArrayBi = convierteClave(tarjetaClave);
		if(usuarioEncontrado) {
			mostrarTarjeta(tarjetaClave);
			int corX = (int) Math.floor(Math.random()*(0 + 5) - 0);
			int corY = (int) Math.floor(Math.random()*(0 + 5) - 0);
		
			System.out.println("______________________________");
			String letras = "ABCDE";
			System.out.print("Introduce la coordenada " + (corX + 1) + letras.charAt(corY) + ": ");
			String coordenada = Leer.cadena();
			
			if(coordenada.equals(tarjetaClaveArrayBi[corX][corY])) {
				System.out.println("¡Correcto!");
			}
			else {
				System.out.println("¡Incorrecto!");
			}
		}
		else {
			System.out.println("El usuario o la contraseña son incorrectos");
		}
	}
	public static void mostrarTarjeta(String[] tarjetaClave) {
		System.out.println("    A    B    C    D    E");
		int z = 0;
		for(int x = 0; x < 5; x++) {
			System.out.print(x + 1);
			for(int y = 0; y < 5; y++) {
				System.out.printf("%5s", tarjetaClave[z]);
				z++;
			}
			System.out.println();
		}
	}
	
	public static String[][] convierteClave(String[] tarjetaClave){
		String[][] claveConvertida = new String[5][5];
		int z = 0;
		
		for(int x = 0; x < claveConvertida.length; x++) {
			for(int y = 0; y < claveConvertida[x].length; y++) {
				claveConvertida[x][y] = tarjetaClave[z];
				z++;
			}
		}
		return claveConvertida;
	}
}
