package interfaces;

import java.util.Comparator;

import Modelo.Libro;

public class ComparaFechas implements Comparator<Libro>{

	public ComparaFechas() {
		// TODO Auto-generated constructor stub
	}

	public int compare (Libro l1, Libro l2) {
		if(l1.getFechaDevolucion() == null) {
			return 1;
		}
		else if(l2.getFechaDevolucion() == null) {
			return -1;
		}
		return l1.getFechaDevolucion().compareTo(l2.getFechaDevolucion());
	}

}
