package equals_hascode;

import modelo.Persona1;

public class EstudioEquals {

	public EstudioEquals() {
		Persona1 p = new Persona1("Gustabo", "Garcia", 47347230, 69, 180, 80);
		Persona1 p1 = new Persona1("Jack", "Conway", 47347230, 70, 185, 75);
		
		System.out.println(p.equals(p1));
		System.out.println("Hascode: " + p.hashCode());
		System.out.println("Hascode: " + p1.hashCode());
	}

}
