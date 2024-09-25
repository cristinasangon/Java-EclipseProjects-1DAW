package modelo;

import java.util.Objects;

public class Persona1 {

	//Estructura: Propiedades o atributos
	private String nombre;
	private String apellidos;
	private double dni;
	private int edad;
	private int altura;
	private float peso;
	
	//Constructor vacio
	public Persona1() {
		this.nombre = "desconocido";
		this.apellidos = "desconocido";
		this.edad = 0;
	}

	//Construtor con algunos parametros
	public Persona1(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Persona1(String nombre, String apellidos, int edad) {
		this(nombre, apellidos);
		this.edad = edad;
	}
	
	public Persona1(String nombre, String apellidos, double dni, int edad, int altura, float peso) {
		this(nombre, apellidos, edad);
		this.dni = dni;
		this.altura = altura;
		this.peso = peso;
	}
	
	//Comportamiento: métodos
		public void caminar() {
			System.out.println("Estoy caminando");
		}
		
		public void hablar() {
			System.out.println("Estoy hablando");
		}
		
		public void nacer() {
			System.out.println("¡Acabo de nacer!");
		}
		
		public void morir() {
			System.out.println("Hasta nunca...");
		}
		
		public void presentacion() {
			System.out.println("Mi nombre es " + this.nombre + " " + this.apellidos + ", y tengo " + this.edad + " años de edad");
		}
		
		//EQUALS Y HASCODE
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Persona1 other = (Persona1) obj;
			return Double.doubleToLongBits(dni) == Double.doubleToLongBits(other.dni);
		}

		
}
