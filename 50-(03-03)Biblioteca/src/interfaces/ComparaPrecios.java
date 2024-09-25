package interfaces;

import java.util.Comparator;

import modelo.Libro;

public class ComparaPrecios implements Comparator<Libro>{

	@Override
	public int compare(Libro o1, Libro o2) {
		return Double.compare(o1.getPrecio(), o2.getPrecio());
	}

	

}
