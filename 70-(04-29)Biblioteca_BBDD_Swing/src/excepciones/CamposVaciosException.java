package excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException(String campo) {
		super("Campo '" + campo + "' obligatorio");
	}

}
