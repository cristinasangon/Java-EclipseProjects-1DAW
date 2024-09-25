package excepciones;

public class IsbnException extends Exception{

	public IsbnException() {
		super("isbn incorrecto");
	}
	
	public IsbnException(String isbn) {
		super("el isbn '" + isbn + "' es incorrecto");
	}

}
