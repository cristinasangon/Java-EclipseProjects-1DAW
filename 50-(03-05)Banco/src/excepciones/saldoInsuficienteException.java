package excepciones;

public class saldoInsuficienteException extends Exception{

	public saldoInsuficienteException() {
		super("La operacion no se puede realizar por: SALDO INSUFICIENTE");
	}

}
