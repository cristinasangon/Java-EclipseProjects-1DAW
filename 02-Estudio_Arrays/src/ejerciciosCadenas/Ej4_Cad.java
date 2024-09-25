package ejerciciosCadenas;

import java.util.Scanner;

public class Ej4_Cad {

	public Ej4_Cad() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EJERCICIO 4 == == == ==");
		// Crea un programa que pida al usuario introducir una contraseña que debe cumplir 
		// con los siguientes requisitos:
		// - Tiene al menos 8 caracteres
		// - Tiene que tener al menos un número
		// - Tiene que tener al menos una letra mayúscula 
		// - Tiene que tener al menos una letra minúscula 
		// - Tiene que tener al menos un carácter especial (ni número ni letra)
		Scanner leer = new Scanner(System.in);
		boolean esSegura = false;
		
		while(esSegura == false) {
			System.out.print("Introduce tu contraseña: ");
			String pass = leer.nextLine();
			
			boolean mayus = false, minus = false, num = false, special = false;
			if(pass.length() >= 8) {
				int x = 0;
				while((num == false || mayus == false || minus == false || special == false) && x < pass.length()){
					char caracter = pass.charAt(x);
					if(Character.isDigit(caracter)) {num = true;}
					else if(Character.isUpperCase(caracter)) {mayus = true;}
					else if(Character.isLowerCase(caracter)) {minus = true;}
					else {special = true;}
					x++;
				}
				
				if(num == true && mayus == true && minus == true && special == true) {
					esSegura = true;
					}
				else {
					if(num == false) {System.out.println("Debe tener al menos 1 numero");}
					if(mayus == false) {System.out.println("Debe tener al menos 1 mayuscula");}
					if(minus == false) {System.out.println("Debe tener al menos 1 minuscula");}
					if(special == false) {System.out.println("Debe tener al menos 1 caracter especial");}
				}
			}
			else {System.out.println("Debe tener al menos 8 caracteres");}
		}
		
		System.out.println("La contraseña es segura y se ha aplicado");
		
		
		
		
	}
}
