package ejercicios;

import java.util.Arrays;

public class MensajeSecreto {

	public MensajeSecreto() {
		// TODO Auto-generated constructor stub
		
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		String mensaje = "5,2,5,-10,12,194,7,22,-11,13,197,5,40,14,-13,9,222,20,13,12,-77,7,1,-34,7,-7,26,99,24,777,1,214,9,9,1,98,2,26,49,15,7,8,26,25,13,100,26,77,14,200,22,7,3,-38,5,98,9,3";
		String[] mensajeArray = mensaje.split(",");
		String desencriptado = "";
		
		int x = 0, vueltas = 0, posicion = 0, relativo = 0;
		
		// mensajeArray[0] es la cantidad de palabras que tiene el mensaje
		for(int y = 0; y < Integer.parseInt(mensajeArray[0]); y++) {
			// Aumentamos x paraa saber cuantas letras tiene la palabra
			x++;
			// A vueltas le doy el valor de x para poder seguir modificando x
			vueltas = Integer.parseInt(mensajeArray[x]);
			// Usamos vueltas para dar tantas vueltas como letras haya en la palabra
			for(int i = 0; i < vueltas; i++) {
				// Aumento x para saber la posicion de la letra
				x++;
				posicion = Integer.parseInt(mensajeArray[x]);
				// Aumento x para saber el relativo (si es par, la posicion empieza por delante y si es impar, la posicion empieza por detras)
				x++;
				relativo = Integer.parseInt(mensajeArray[x]);
				System.out.print(posicion + " " + relativo + " ");
				// Compruebo si el relativo es par o impar
				if((relativo % 2) != 0) {
					// Si es impar le resto a la cantidad de letras la posicion y le sumo 1 para obtener la cantidad correcta
					posicion = abecedario.length() - posicion;
					posicion += 1;
				}
				// Voy añadiendo cada letra al mensaje
				desencriptado = desencriptado + abecedario.charAt(posicion -1);
			}
			// Pongo un espacio al cambiar de palabra
			desencriptado = desencriptado + " ";
			System.out.println();
		}
		System.out.println();
		// Muestro el mensaje desencriptado
		System.out.println(desencriptado);
	}

}
