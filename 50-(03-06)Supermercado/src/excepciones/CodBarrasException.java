package excepciones;

public class CodBarrasException extends Exception{

	public CodBarrasException() {
		super("El código de barras introducido es inválido");
	}

}
