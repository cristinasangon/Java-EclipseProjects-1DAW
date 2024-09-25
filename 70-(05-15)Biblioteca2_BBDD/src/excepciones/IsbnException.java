package excepciones;

public class IsbnException extends Exception{

	public IsbnException(String isbn) {
		super("El isbn '" + isbn + "' no es válido");
	}

}
