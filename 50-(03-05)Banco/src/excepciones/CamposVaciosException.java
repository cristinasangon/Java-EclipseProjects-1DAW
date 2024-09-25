package excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException() {
		super("El campo es obligatorio");
	}

}
