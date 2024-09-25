package interfaces;

import java.util.Comparator;

import modelo.CuentaBancaria;

public class comparaFechas implements Comparator<CuentaBancaria>{

	public comparaFechas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(CuentaBancaria o1, CuentaBancaria o2) {
		if(o1.getFechaAlta() == null || o2.getFechaAlta() == null) {
			return 0;
		}
		return o1.getFechaAlta().compareTo(o2.getFechaAlta());
	}

}
