package interfaces;

public class Circulo implements Geometria{

	//ATRIBUTOS
	private double radio;
	final double PI = Math.PI;
	
	//CONSTRUCTORES
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	//FUNCIONES
	public double getArea(){
		return PI * radio * radio;
	}

	//COMPORTAMIENTO (ITERFACES)
	@Override
	public int compareTo(Geometria figura) {
		Circulo circulo = (Circulo)figura;
		if (getArea() > circulo.getArea()) return 1;
		else if (getArea() < circulo.getArea()) return -1;
		else return 0;
	}
	
	
}
