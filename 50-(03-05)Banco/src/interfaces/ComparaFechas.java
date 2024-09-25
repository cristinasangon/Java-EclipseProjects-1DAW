package interfaces;

import java.util.Comparator;

import modelo.CuentaBancaria;

public class ComparaFechas implements Comparator<CuentaBancaria>{

	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) {
		return o1.getFechaAlta().compareTo(o2.getFechaAlta());
	}

}
