package modelo;

public class Persona {

	//Estructura: Propiedades o atributos
	String nombre;
	String apellidos;
	int edad;
	int altura;
	float peso;
			
	//Comportamiento: métodos
	public void caminar() {
		System.out.println("Estoy caminando");
	}
	
	public void hablar() {
		System.out.println("Estoy hablando");
	}
	
	public void nacer() {
		System.out.println("¡Acabo de nacer!");
	}
	
	public void morir() {
		System.out.println("Hasta nunca...");
	}

}
