package interfaces;

public class Rana extends Animal implements Cazador, Presa{

	//AATRIBUTOS
	
	//CONSTRUCTORES
	public Rana() {
		// TODO Auto-generated constructor stub
	}

	
	public Rana(String especie, String habitat) {
		super(especie, habitat);
		// TODO Auto-generated constructor stub
	}

	//COMPORTAMIENTO
	@Override
	public void vigilar() {
		System.out.println("Quien anda ahi");
	}

	@Override
	public void acechar() {
		System.out.println("Que gordita esta esa mosca");
	}

}
