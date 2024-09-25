package excepciones;

public class SinExistenciasException extends Exception{

	public SinExistenciasException() {
		super("La compra no se puede realizar porque no quedan existencias");
	}

}
