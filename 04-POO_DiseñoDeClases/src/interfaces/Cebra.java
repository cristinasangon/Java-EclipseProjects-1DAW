package interfaces;

public class Cebra extends Animal implements Presa{

	//ATRIBUTOS
	
	//CONSTRUCTORES
	public Cebra() {
		
	}

	public Cebra(String especie, String habitat) {
		super(especie, habitat);
	}

	//COMPORTAMIENTO (INTERFACES)
	@Override
	public void vigilar() {
		System.out.println("A correr....");
	}
	
}
