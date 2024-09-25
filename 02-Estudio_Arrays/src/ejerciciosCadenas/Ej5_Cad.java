package ejerciciosCadenas;

public class Ej5_Cad {

	public Ej5_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 5 == == == ==");
		// Programa que encripta un mensaje mediante el cifrado de césar. 
		// También debe desencriptar. (al código ascii de cada letra se le suma 3 
		// para encriptar y se le resta 3 para encriptar). La frase que debe encriptar 
		// es “Atacaremos al amanecer”.
		
		String mensaje = "Atacaremos al amanecer";
		
		String mensajeEncriptado = encripta(mensaje);
		System.out.printf("MENSAJE ENCRIPTADO: %n%s%n%n", mensajeEncriptado);
		
		String mensajeDesencriptado = desencripta(mensajeEncriptado);
		System.out.printf("MENSAJE DESENCRIPTADO: %n%s%n%n", mensajeDesencriptado);
	}
	public static String encripta(String mensaje) {
		String encriptado = ""; char ascii = ' ';
		for(int x = 0; x < mensaje.length(); x++) {
			ascii = (char) (mensaje.charAt(x) + 3);
			encriptado += Character.toString(ascii);
		}
		return encriptado;
	}
	
	public static String desencripta(String mensaje) {
		String encriptado = ""; char ascii = ' ';
		for(int x = 0; x < mensaje.length(); x++) {
			ascii = (char) (mensaje.charAt(x) - 3);
			encriptado += Character.toString(ascii);
		}
		return encriptado;
	}

}
