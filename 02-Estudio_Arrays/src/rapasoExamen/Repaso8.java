package rapasoExamen;

public class Repaso8 {

	public Repaso8() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 8  =  ==  =  ==  =  ==  ");
		
		String frase = "Dábale arroz a la zorra el abad";
		frase = frase.replace(" ", "");
		frase = frase.replace("á", "a");
		frase = frase.replace("é", "e");
		frase = frase.replace("í", "i");
		frase = frase.replace("ó", "o");
		frase = frase.replace("ú", "o");
		
		String reversa = "";
		for(int x = 0; x < frase.length(); x++) {
			reversa = frase.charAt(x) + reversa; 
		}

		if(frase.equalsIgnoreCase(reversa) == true) {
			System.out.println("La frase es palindroma");
		}
		else {
			System.out.println("La frase no es palindroma");
		}
	}

}
