package interfaces;

import java.util.Comparator;
import Modelo.Libro;

public class ComparaPrecios implements Comparator<Libro>{

	public ComparaPrecios() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Libro l1, Libro l2) {
		return Double.compare(l1.getPrecio(), l2.getPrecio());
	}

}
