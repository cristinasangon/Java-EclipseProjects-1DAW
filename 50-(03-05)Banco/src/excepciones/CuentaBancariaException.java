package excepciones;

public class CuentaBancariaException extends Exception{

	public CuentaBancariaException() {
		super("Numero de cuenta bancaria inválido");
	}

}
