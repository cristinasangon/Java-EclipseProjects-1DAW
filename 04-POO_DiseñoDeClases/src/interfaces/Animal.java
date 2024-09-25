package interfaces;

public class Animal {

	//ATRIBUTOS
	private String especie;
	private String habitat;
	
	//CONSTRUCTORES
	public Animal() {
		this.especie = "Por determinar";
		this.habitat = "Por determinar";
	}
	
	public Animal(String especie, String habitat) {
		this.especie = especie;
		this.habitat = habitat;
	}

	
	//GETTERS Y SETTERS
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", habitat=" + habitat + "]";
	}
}
