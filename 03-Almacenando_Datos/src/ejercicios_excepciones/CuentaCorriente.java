package ejercicios_excepciones;

import java.util.Scanner;

import excepciones.CuentaCorrienteException;

public class CuentaCorriente {

	public CuentaCorriente(String ccc) throws CuentaCorrienteException {
		System.out.println(" == = == = == = == ESTUDIO EXCEPCIONES == = == = == = == ");
		
		System.out.println();
		System.out.println(" == = == VIDEO Nº 3");
		
		comprobarCCC(ccc);
				
				
	}
	private void comprobarCCC(String ccc) throws CuentaCorrienteException{
		ccc = ccc.replaceAll(" ", "");
		try {
			if(ccc.length() != 20) {
				throw new CuentaCorrienteException();
			}
			double dCCC = Double.parseDouble(ccc);
		}
		catch (NumberFormatException e) {
			throw new CuentaCorrienteException();
		}
		
		//EXTRAER EEEESSSS, DC, NNNNNNNNNN
		String eeeeSSSS = "00" + ccc.substring(0, 8);
		String dc = ccc.substring(8, 10);
		String nnnnn = ccc.substring(10);
		
		int D = calculaDigito(eeeeSSSS);
		D = 11 - (D % 11);
		if(D == 10) {D = 1;}
		if(D == 11) {D = 0;}
		
		int C = calculaDigito(nnnnn);
		C = 11 - (C % 11);
		if(C == 10) {C = 1;}
		if(C == 11) {C = 0;}
		
		String DC = D + "" + C;
		if(!dc.equals(DC)) {
			throw new CuentaCorrienteException();
		}
	}
	
	private int calculaDigito (String cuenta) {
		int[] regla = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
		int digito = 0;
		for (int x = 0; x < cuenta.length(); x++) {
			digito += Integer.parseInt(Character.toString(cuenta.charAt(x))) * regla[x];
		}
		return digito;
	}
}
