package estudio_excepciones;

import java.util.Scanner;

import excepciones.DniException;

public class Excepciones {

	public Excepciones(String dni) throws ArithmeticException, DniException{
		System.out.println(" == = == = == = == ESTUDIO EXCEPCIONES == = == = == = == ");
		Scanner leer = new Scanner(System.in);
		
		System.out.println();
		System.out.println(" == = == VIDEO Nº 1");
		
		boolean esIncorrecto = true;
		String numero = "";
		int num = 0; 
		
		while(esIncorrecto) {
			esIncorrecto = false;
			System.out.print("Introduce un numero: ");
			numero = leer.next();
			try{
				num = Integer.parseInt(numero);
			}
			catch (NumberFormatException e) {
				esIncorrecto = true;
				System.out.println("'" + numero + "' no es un numero");
			}
		}
		
		System.out.println();
		System.out.println("Has introducido el numero " + numero);
		
		System.out.println();
		System.out.println(" == = == VIDEO Nº 2");
		
		operar(num);
		compruebaDni(dni);
	}
	// == = == VIDEO Nº 2
	private void operar(int num) {
		dividir (num);
	}
	
	private void dividir (int num) {
		//int div = num / 0;
	}
	
	public void compruebaDni(String dni) throws DniException{
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		dni = dni.toUpperCase();
		if(dni.length() == 9) {
			String numeroDNI = dni.substring(0,8);
			char letra = dni.charAt(8);
			try {
				int numDni = Integer.parseInt(numeroDNI);
				int resto = numDni % 23;
				char letraDni = letrasDNI.charAt(resto);
				if(letra != letraDni) {
					throw new DniException();
				}
			}
			catch(NumberFormatException e){
			}
		}
		else {
			throw new DniException();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
