package rapasoExamen;

import java.util.Arrays;

public class Repaso13 {

	public Repaso13() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 13  =  ==  =  ==  =  ==  ");
		
		String mensaje = "Atacaremos al amanecer";
		int[] clave = {6, 5, 0, 3, 1, 4, 8, 7, 2};
		
		String mensajeEncriptado = encripta(mensaje, clave);
		System.out.println(mensajeEncriptado);
		
		String mensajeDesencriptado = desencripta(mensajeEncriptado, clave);
		System.out.println(mensajeDesencriptado);
	}
	public static String encripta(String mensaje, int[] clave) {
		int añadir = mensaje.length() / clave.length;
		if((mensaje.length() % clave.length) != 0) {
			añadir++;
		}
		
		String[][] mensajeDiv = new String[añadir][clave.length];
		String [][] mensajeEncriptado = new String[añadir][clave.length];
		String encriptado = "";
		
		int z = 0;
		for(int x = 0; x < mensajeDiv.length; x++) {
			for(int y = 0; y < mensajeDiv[x].length; y++) {
				if(z < mensaje.length()) {
					mensajeDiv[x][y] = Character.toString(mensaje.charAt(z));
				}
				else {
					mensajeDiv[x][y] = "-";
				}
				z++;
				mensajeEncriptado[x][clave[y]] = mensajeDiv[x][y];
			}
		}
		
		for(int x = 0; x < mensajeEncriptado.length; x++) {
			for(int y = 0; y < mensajeEncriptado[x].length; y++) {
				encriptado += mensajeEncriptado[x][y];
			}
		}
		
		return encriptado;
	}
	
	public static String desencripta(String mensaje, int[] clave) {
		int añadir = mensaje.length() / clave.length;
		if((mensaje.length() % clave.length) != 0) {
			añadir++;
		}
		
		String[][] mensajeDiv = new String[añadir][clave.length];
		String [][] mensajeDesencriptado = new String[añadir][clave.length];
		String desEncriptado = "";
		
		int z = 0;
		for(int x = 0; x < mensajeDiv.length; x++) {
			for(int y = 0; y < mensajeDiv[x].length; y++) {
				mensajeDiv[x][y] = Character.toString(mensaje.charAt(z));
				z++;	
			}
		}
		
		for(int x = 0; x < mensajeDesencriptado.length; x++) {
			for(int y = 0; y < mensajeDesencriptado[x].length; y++) {
				mensajeDesencriptado[x][y] = mensajeDiv[x][clave[y]];
				desEncriptado += mensajeDesencriptado[x][y];
			}
		}
		
		return desEncriptado;
	}

}
