package interfaces;

import java.util.Comparator;

import modelo.Paciente;

public class ComparaEnfermedad implements Comparator<Paciente>{

	public ComparaEnfermedad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Paciente o1, Paciente o2) {
		return o1.getEnfermedad().compareTo(o2.getEnfermedad());
	}

}
