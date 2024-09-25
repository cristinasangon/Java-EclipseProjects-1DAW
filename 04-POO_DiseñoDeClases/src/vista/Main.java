package vista;

import equals_hascode.EstudioEquals;
import herencia.Consultor;
import herencia.Empleado;
import herencia.Trabajador;
import interfaces.Geometria;
import interfaces.Leon;
import interfaces.Rana;
import modelo.Artista;
import modelo.Bicicleta;
import modelo.Circulo;
import modelo.Persona;
import modelo.Persona1;
import modelo.Persona2;
import modelo.Punto;
import modelo.Rectangulo;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		//Clasepersona();
		//Constructores();
		//Propiedades_y_Metodos();
		//Argumentos();
		//PasoValorReferencia();
		//metodosEstaticos();
		//sobrecarga();
		//polimorfismo();
		//interfaces();
		EstudioEquals estudioEquals = new EstudioEquals();
	}

	private static void Clasepersona() {
		Persona persona = new Persona();
		Persona persona2 = new Persona();
		Persona persona3 = new Persona();
		
		System.out.println("= == = == = == Persona");
		persona.nacer();
		persona.hablar();
		persona.caminar();
		persona.morir();
		persona = null;
		System.out.println();
		
		System.out.println("= == = == = == Persona 2");
		persona2.nacer();
		System.out.println();
		
		System.out.println("= == = == = == Persona 3");
		persona3.caminar();
		System.out.println();
	}
	
	private static void Constructores() {
		Persona1 johndoe = new Persona1();
		johndoe.presentacion();
		
		Persona1 manuel = new Persona1("Manuel", "Ruiz Gonzalez");
		manuel.presentacion();
		
		Persona1 antonio = new Persona1("Antonio", "Castillo Real", 31);
		antonio.presentacion();
	}
	
	private static void Propiedades_y_Metodos(){
		Persona2 p = new Persona2();
		p.setNombre("Pepe");
		p.setApellidos("Perez");
		p.setAltura(180);
		p.setEdad(25);
		p.setPeso(75.5f);
		System.out.println(p.getNombre());
		
		System.out.println(p);
	}
	
	private static void Argumentos() {
		Punto punto1 = new Punto(5, 1);
		Punto punto2 = new Punto(1, 3);
		Punto punto3 = new Punto(2, 6);
		Punto punto4 = new Punto(7, 4);
		Punto[] puntos = {punto1, punto2, punto3, punto4};
		
		Rectangulo rectangulo1 = new Rectangulo(punto1, punto2, punto3, punto4);
		Rectangulo rectangulo2 = new Rectangulo(puntos);
		System.out.println(rectangulo1.toString());
		
		rectangulo1 = null;
		rectangulo2 = null;
				
		Rectangulo rectangulo = new Rectangulo();
		rectangulo.setOtraFigura(punto2, punto3);
		System.out.println(rectangulo.toString());
	}
	
	private static void PasoValorReferencia() {
		Circulo circle = new Circulo(2, 3);
		System.out.println(circle);
		
		moveCircle(circle, 23, 56);
		System.out.println(circle);
	}
	
	private static void moveCircle(Circulo circle, int n, int m) {
		circle.setX(circle.getX() + n);
		circle.setY(circle.getY() + m);
		
		circle = new Circulo(0, 3);
	}
	
	private static void metodosEstaticos() {
		Bicicleta bici1 = new Bicicleta(21, 27, 0);
		Bicicleta bici2 = new Bicicleta(18, 24, 0);
		
		System.out.println(bici1);
		System.out.println(bici2);
		
		System.out.println(Bicicleta.getNumeroDeBicicletas());
	}
	
	private static void sobrecarga() {
		Artista artista = new Artista();
		
		artista.dibuja("hola");
		artista.dibuja(3);
		artista.dibuja(12.5);
		artista.dibuja(3, 8.3f);
		
		Persona2 persona1 = new Persona2();
		Persona2 persona2 = new Persona2("Pepe", "Pérez");
		Persona2 persona3 = new Persona2("Alejandro", "Ruiz", 33);
		
		System.out.println(persona1);
		System.out.println(persona2);
		System.out.println(persona3);
	}
	
	public static void polimorfismo() {
		Trabajador trabajador;
		Trabajador empleado;
		Trabajador consultor;
		
		trabajador = new Trabajador("Bill Gates", "Presidente", "Remond", "", "");
		empleado = new Empleado("Larry Ellison", "Presidente", "Redwood", "", "", 100000.0, 1000.0);
		consultor = new Consultor("Steve Jobs", "Consultor Jefe", "Cupertino", "", "", 20, 1000.0);
		
		saludar(trabajador);
		saludar(empleado);
		saludar(consultor);
		
		imprimirNombreYPaga(trabajador);
		imprimirNombreYPaga(empleado);
		imprimirNombreYPaga(consultor);
		
	}
	
	public static void saludar(Trabajador t) {
		System.out.println("Hola, " + t.getNombre());
	}
	
	public static void imprimirNombreYPaga(Trabajador t) {
		System.out.printf("El trabajador %s tiene una paga de %.2f€ %n", t.getNombre(), t.calcularPaga());
	}
	
	public static void interfaces() {
		Leon  leon= new Leon("mamifero", "sabana");
		Rana rana = new Rana("anfibio", "charca");
		
		leon.acechar();
		rana.acechar();
		rana.vigilar();
		
		interfaces.Rectangulo rectangulo = new interfaces.Rectangulo(4, 5);
		interfaces.Rectangulo rectangulo2 = new interfaces.Rectangulo(4, 5);
		Geometria rectangulo3 = new interfaces.Rectangulo(5, 6);
		
		System.out.println(rectangulo.compareTo(rectangulo2));
		System.out.println(rectangulo.compareTo(rectangulo3));
		
		interfaces.Circulo circulo = new interfaces.Circulo(4);
		interfaces.Circulo circulo2 = new interfaces.Circulo(6);
		
		System.out.println(circulo.compareTo(circulo2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
