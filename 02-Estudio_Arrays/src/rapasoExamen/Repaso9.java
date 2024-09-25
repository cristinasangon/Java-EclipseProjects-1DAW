package rapasoExamen;

public class Repaso9 {

	public Repaso9() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 9  =  ==  =  ==  =  ==  ");
		
		String dni = "47347230M";
		if(compruebaDNI(dni)) {
			System.out.println("El dni es valido");
		}
		else {
			System.out.println("El dni no es valido");
		}
		
	}
	public static boolean compruebaDNI(String dni) {
		String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		
		String letra = dni.substring((dni.length()-1),dni.length());
		int numeros = Integer.parseInt(dni.substring(0,(dni.length()-1)));
		if(letra.equals(letras[numeros%23])) {
			return true;
		}
		else {
			return false;
		}
	}
}
