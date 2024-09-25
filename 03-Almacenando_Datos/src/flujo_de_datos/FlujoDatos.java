package flujo_de_datos;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class FlujoDatos {

	public FlujoDatos() {
		System.out.println(" == = == = == = ESTUDIO FLUJO DE DATOS = == = == = == ");
		String dato = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		
		System.out.print("Introduce un dato: ");
		try {
			dato = br.readLine();
			int num = Integer.parseInt(dato);
			System.out.println("Dato = " + dato);
		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

}
