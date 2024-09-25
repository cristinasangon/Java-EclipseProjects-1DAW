package interfaces;

public class Rectangulo implements Geometria{

	//ATRIBUTOS
	private double largo;
	private double ancho;
	
	//CONSTRUCTORES
	public Rectangulo(double largo, double ancho) {
		this.ancho = ancho;
		this.largo = largo;
	}
	
	//FUNCIONES
	public double getArea() {
		return this.largo*this.ancho;
	}

	//COMPORTAMIENTO (INTERFACES)
	@Override
	public int compareTo(Geometria figura) {
		Rectangulo rectangulo = (Rectangulo)figura;
		if (getArea() > rectangulo.getArea()) return 1;
		else if (getArea() < rectangulo.getArea()) return -1;
		else return 0;
	}

	
}
