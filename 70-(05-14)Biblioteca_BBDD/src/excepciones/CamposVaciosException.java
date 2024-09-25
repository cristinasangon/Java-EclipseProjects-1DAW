package excepciones;

public class CamposVaciosException extends Exception{

	public CamposVaciosException() {
		super("Campo obligatorio");
	}
	
	public CamposVaciosException(String campo) {
		super("Campo '" + campo + "' obligatorio");
	}

}
