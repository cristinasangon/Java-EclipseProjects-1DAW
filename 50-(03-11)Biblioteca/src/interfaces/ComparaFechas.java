package interfaces;

import java.util.Comparator;

import modelo.Libro;

public class ComparaFechas implements Comparator<Libro>{

	public ComparaFechas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Libro o1, Libro o2) {
		if(o1 == null || o2 == null) {
			return 0;
		}
		return o1.getFechaDevolucion().compareTo(o2.getFechaDevolucion());
	}

}
