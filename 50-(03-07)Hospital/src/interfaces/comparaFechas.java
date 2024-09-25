package interfaces;

import java.util.Comparator;

import modelo.Paciente;

public class comparaFechas implements Comparator<Paciente>{

	public comparaFechas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Paciente o1, Paciente o2) {
		return o1.getFechaIngreso().compareTo(o2.getFechaIngreso());
	}

}
