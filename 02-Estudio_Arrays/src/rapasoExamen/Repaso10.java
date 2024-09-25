package rapasoExamen;

import java.lang.Character;

public class Repaso10 {

	public Repaso10() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 10  =  ==  =  ==  =  ==  ");
		
		String contra = "Programacion12_";
		if(contrasenaSegura(contra)) {
			System.out.println("La contraseña es segura");
		}
		else {
			System.out.println("La contraseña no es segura");
		}

	}
	public static boolean contrasenaSegura(String contra) {
		boolean esSegura = false;
		int x = 0;
		
		boolean num = false, mayus = false, minus = false, especial = false; 
		if(contra.length() >= 8) {
			while(esSegura == false && x < contra.length()) {
				if(Character.isDigit(contra.charAt(x))) {
					num = true;
				}
				else if(Character.isUpperCase(contra.charAt(x))) {
					mayus = true;
				}
				else if(Character.isLowerCase(contra.charAt(x))) {
					minus = true;
				}
				else {
					especial = true;
				}
				
				if(num && mayus && minus && especial) {
					esSegura = true;
				}
				x++;
			}
		}
		return esSegura;
	}
}
