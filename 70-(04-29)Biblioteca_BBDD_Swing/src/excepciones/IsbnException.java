package excepciones;

public class IsbnException extends Exception{

	public IsbnException(String dato) {
		super("El isbn '" + dato + "' es icorrecto");
	}

}
