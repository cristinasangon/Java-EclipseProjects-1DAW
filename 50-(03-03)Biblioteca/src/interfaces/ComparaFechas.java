package interfaces;

import java.util.Comparator;

import modelo.Libro;

public class ComparaFechas implements Comparator<Libro>{
	
	@Override
	public int compare(Libro o1, Libro o2) {
		return o1.getFechaDevolucion().compareTo(o2.getFechaDevolucion());
	}

}
