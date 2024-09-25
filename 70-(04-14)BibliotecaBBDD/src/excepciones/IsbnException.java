package excepciones;

public class IsbnException extends Exception{

	public IsbnException() {
		super("ISBN INVALIDO");
	}
	
	public IsbnException(String mensaje) {
		super(mensaje);
	}
	
	public IsbnException(String mensaje, int id) {
		super(mensaje + " | " + id);
	}

}
