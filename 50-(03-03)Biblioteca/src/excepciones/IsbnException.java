package excepciones;

public class IsbnException extends Exception{

	public IsbnException() {
		super("ISBN no válido");
	}

}