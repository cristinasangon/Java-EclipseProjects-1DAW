package ejercicos_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EncriptaDesencripta {

	public EncriptaDesencripta() throws IOException {
		//Inicio del programa
		
		//Creo el fichero (solo si no existe)
		File fichero = new File("Ficheros//encriptaDesencripta.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		boolean finPrograma = false;
		
		while(!finPrograma) {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
			//Leo la primera linea que me dice cuantos mensajes hay y creo un array para almacenar el fichero (le sumo tres a esa cantidad de mensajes ya que ocupamos 3 lineas como informmacion)
			int cantidadMensajes = Integer.parseInt(br.readLine());
			String[] ficheroArray = new String[cantidadMensajes + 3];
			ficheroArray[0] = "" + cantidadMensajes;
			
			//Bucle que recorre las lineas del fichero, almacenando los datos en el array(x empieza en 1 porque el valor 0 ya se lo hemos dado antes del bucle)
			for(int x = 1; x < ficheroArray.length; x++) {
				ficheroArray[x] = br.readLine();
			}
			
			//Cierro la conexion
			br.close();
			fr.close();
			
			//Muestro menu
			System.out.println("=======================================================");
			System.out.println("Elije una opcion(1 - 3):");
			System.out.println("=======================================================");
			System.out.println("1 - Encriptar");
			System.out.println("2 - Desencriptar");
			System.out.println("3 - Salir");
			System.out.println("=======================================================");
			int op = Leer.entero();
			
			switch (op) {
			case 1:
				//Comprobammos si esta encriptado(la segunda linea del fichero en 1 significa que lo está y en 0 significa que esta desencriptado)
				if(ficheroArray[1].equals("1")) {
					System.out.println("Los mensajes ya estan encriptados");
					break;
				}
				for(int x = 3; x < ficheroArray.length; x++) {
					String encriptado = encripta(ficheroArray[x], ficheroArray[2]);
					ficheroArray[x] = encriptado;
				}
				
				System.out.println("****************************************");
				System.out.println("Encriptado con exito");
				System.out.println("****************************************");
				
				ficheroArray[1] = "1";
				
				FileWriter fw = new FileWriter(fichero);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int x = 0; x < ficheroArray.length; x++) {
					bw.write(ficheroArray[x]);
					bw.newLine();
				}
				
				fw.flush();bw.close();fw.close();
				
				break;
				
			case 2:
				//Comprobammos si esta desencriptado(la segunda linea del fichero en 0 significa que lo está y en 1 significa que esta encriptado)
				if(ficheroArray[1].equals("0")) {
					System.out.println("Los mensajes ya estan desencriptados");
					break;
				}
				for(int x = 3; x < ficheroArray.length; x++) {
					String desencriptado = desencripta(ficheroArray[x], ficheroArray[2]);
					ficheroArray[x] = desencriptado;
				}
				
				System.out.println("****************************************");
				System.out.println("Desencriptado con exito");
				System.out.println("****************************************");
				
				ficheroArray[1] = "0";
				
				fw = new FileWriter(fichero);
				bw = new BufferedWriter(fw);
				
				for(int x = 0; x < ficheroArray.length; x++) {
					bw.write(ficheroArray[x]);
					bw.newLine();
				}
				
				fw.flush();bw.close();fw.close();
				
				break;
				
			case 3:
				finPrograma = true;
				break;

			default:
				System.err.println("Opcion no válida");
				break;
			}
		}
	}
	public static String encripta(String mensaje, String clave) {
		String mensajeEncriptado = "";
		int[] claveArray = convertirClaveEnArrayEntera(clave);
		int tamañoClave = claveArray.length;
				
		String[][] mensajeArray = convertirMensajeBidimensional(mensaje, tamañoClave);
		
		String[][] encriptadoBidim = new String[mensajeArray.length][tamañoClave];
		for(int x = 0; x < encriptadoBidim.length; x++) {
			for(int y = 0; y < encriptadoBidim[x].length; y++) {
				encriptadoBidim[x][y] = mensajeArray[x][claveArray[y]];
				mensajeEncriptado += encriptadoBidim[x][y];
			}
		}
		return mensajeEncriptado;
	}
	
	public static String desencripta(String mensaje, String clave) {
		String mensajeDesencriptado = "";
		int[] claveArray = convertirClaveEnArrayEntera(clave);
		int tamañoClave = claveArray.length;
				
		String[][] mensajeArray = convertirMensajeBidimensional(mensaje, tamañoClave);
		
		String[][] desencriptadoBidim = new String[mensajeArray.length][tamañoClave];
		for(int x = 0; x < desencriptadoBidim.length; x++) {
			for(int y = 0; y < desencriptadoBidim[x].length; y++) {
				desencriptadoBidim[x][claveArray[y]] = mensajeArray[x][y];
			}
		}
		
		for(int x = 0; x < desencriptadoBidim.length; x++) {
			for(int y = 0; y < desencriptadoBidim[x].length; y++) {
				mensajeDesencriptado += desencriptadoBidim[x][y];
			}
		}
		
		mensajeDesencriptado = mensajeDesencriptado.replace("*", "");
		
		return mensajeDesencriptado;
	}
	
	public static String[][] convertirMensajeBidimensional(String mensaje, int tamY){
		int tamX = 0, largoMensaje = mensaje.length(), z = 0;
		
		while(largoMensaje >= 0) {
			tamX++;
			largoMensaje -= tamY;
		}
		
		if(largoMensaje < 0) {
			for(int x = 0; x > largoMensaje; x--) {
				mensaje += "*"; 
			}
		}
		
		String[][] mensajeBidim = new String[tamX][tamY];
		
		for(int x = 0; x < tamX; x++) {
			for(int y = 0; y < tamY; y++) {
				mensajeBidim[x][y] = Character.toString(mensaje.charAt(z));
				z++;
			}
		}
		
		return mensajeBidim;
	}
	
	public static int[] convertirClaveEnArrayEntera(String clave) {
		String[] claveString = clave.split(",");
		int[] claveInt = new int[claveString.length];
		
		for(int x = 0; x < claveString.length; x++) {
			claveInt[x] = Integer.parseInt(claveString[x]);
		}
		
		return claveInt;
	}

}
