package excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException(String campo) {
		super("El campo '" + campo + "' es obligatorio");
	}

}
