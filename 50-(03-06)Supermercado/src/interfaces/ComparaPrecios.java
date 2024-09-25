package interfaces;

import java.util.Comparator;

import modelo.Producto;

public class ComparaPrecios implements Comparator<Producto>{

	public ComparaPrecios() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		return Double.compare(o1.getPrecio(), o2.getPrecio());
	}

}
