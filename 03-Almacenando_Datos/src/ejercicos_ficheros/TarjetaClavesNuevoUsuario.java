package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TarjetaClavesNuevoUsuario {

	public TarjetaClavesNuevoUsuario() throws IOException {
		File fichero = new File("Ficheros//tarjetaClavesNuevoUsuario.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		boolean continuaPrograma = true;
		
		while(continuaPrograma) {
			System.out.println("=======================================");
			System.out.println("Elige una opcion(1-3):");
			System.out.println("=======================================");
			System.out.println("1 - Iniciar Sesion");
			System.out.println("2 - Crear un nuvevo usuario");
			System.out.println("3 - Cerrar");
			System.out.println("=======================================");
			int op = 0;
			
			try {
				op = Leer.entero();
			}
			catch (NumberFormatException e) {
				System.out.println("Debes introducir un numero");
			}
			
			switch (op) {
			case 1: {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				
				br.close(); fr.close();
				break;
			}
			
			case 2: {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				
				int cantidadUsuarios = Integer.parseInt( br.readLine());
				String[] ficheroArray = new String[(cantidadUsuarios * 2) + 3];
				ficheroArray[0] ="" + cantidadUsuarios; 
				
				for(int x = 1; x <= (cantidadUsuarios * 2); x++) {
					ficheroArray[x] = br.readLine(); 
				}
				
				System.out.print("Introduce un nombre de usuario: ");
				String user = Leer.cadena();
				
				System.out.print("Introduce tu contraseña: ");
				String pass = Leer.cadena();
				
				while(existeNombreUsuario(user, ficheroArray)) {
					System.out.println("Ese nombre de usuario ya existe");
					System.out.print("Introduce un nuevo nombre de usuario: ");
					user = Leer.cadena();
				}
				
				//Almaceno nombre de usuario y contraseña en array
				ficheroArray[ficheroArray.length - 2] = user + "," + pass; 
				
				//Genero la tarjeta de claves
				int[] tarjetaClaves = generaNumerosAleatoriosSinRepeticion(100, 999, 25);
				
				//Convierto mi array de aleatorios en una cadena para poder almacenarlo en el fichero
				ficheroArray[ficheroArray.length - 1] = convierteArrayEnString(tarjetaClaves);
				
				//Sumo 1 a la cantidad deusuarios
				cantidadUsuarios ++;
				ficheroArray[0] = "";
				ficheroArray[0] += cantidadUsuarios;
				
				br.close(); fr.close();
				
				//Lo escribo todo en el fichero
				FileWriter fw = new FileWriter(fichero);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int x = 0; x < ficheroArray.length; x++) {
					bw.write(ficheroArray[x]);
					bw.newLine();
				}
				
				fw.flush(); bw.close(); fr.close();
				break;
			}
			
			case 3: {
				continuaPrograma = false;
				break;
			}
			default:
				System.err.println("Opcion no válida");;
			}
		}
	}
	public static boolean existeNombreUsuario(String nombreUsuario, String[] fichero) {
		int x = 1;
		while(x < (fichero.length - 2)) {
			String[] userPass = fichero[x].split(",");
			if(userPass[0].equals(nombreUsuario)) {
				return true;
			}
			x++; x++;
		}
			
		return false;
	}
	
	public static int[] generaNumerosAleatoriosSinRepeticion(int menor, int mayor, int cantidad) {
		int[] aleatorios = new int[cantidad];
		
		for(int z = 0; z < aleatorios.length; z++) {
			aleatorios[z] = menor - 1;
		}
		
		int x = 0;
		while(x < cantidad) {
			int rand = (int) (Math.random()*(mayor - menor + 1) + menor);
			boolean esIgual = false;
			int y = 0;
			while(!esIgual && y < cantidad) {
				if(aleatorios[y] == rand) {
					esIgual = true;
				}
				y++;
			}
			
			if(!esIgual) {
				aleatorios[x] = rand;
				x++;
			}
			
		}
		return aleatorios;
	}
	
	public static String convierteArrayEnString(int[] array) {
		String convertido = "";
		
		for(int x = 0; x < array.length; x++) {
			convertido += array[x] + ",";
		}
		
		convertido = convertido.substring(0, convertido.length()-1);
		
		return convertido;
	}

}
