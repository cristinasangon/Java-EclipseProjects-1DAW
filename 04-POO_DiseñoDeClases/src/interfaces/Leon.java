package interfaces;

public class Leon extends Animal implements Cazador{

	//ATRIBUTOS
	
	//CONSTRUCTORES
	public Leon() {
		// TODO Auto-generated constructor stub
	}

	public Leon(String especie, String habitat) {
		super(especie, habitat);
		// TODO Auto-generated constructor stub
	}

	//COMPORTAMIENTO (INTERFACES)
	@Override
	public void acechar() {
		System.out.println("Vaya lomito que tiene esa cebra");
	}
}
