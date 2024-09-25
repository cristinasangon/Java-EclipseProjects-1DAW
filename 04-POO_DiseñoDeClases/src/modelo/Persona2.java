package modelo;

public class Persona2 {

		//Estructura: Propiedades o atributos
		private String nombre;
		private String apellidos;
		private int edad;
		private int altura;
		private float peso;
		
		//Constructor vacio
		public Persona2() {
			this.nombre = "desconocido";
			this.apellidos = "desconocido";
			this.edad = 0;
		}

		//Construtor on algunos parametros
		public Persona2(String nombre, String apellidos) {
			this.nombre = nombre;
			this.apellidos = apellidos;
		}
		
		public Persona2(String nombre, String apellidos, int edad) {
			this(nombre, apellidos);
			this.edad = edad;
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
				System.out.println("Mi nombre es " + this.nombre + " " + this.apellidos + " y tengo " + this.edad + " años de edad");
			}
			
			public void saludo(String mensaje) {
				System.out.println("Mi nombre es " + this.nombre + " " + this.apellidos + " y quiero saludarte dandote el siguiente mensaje: " + mensaje);
			}
			
			public String obtenerNombreCompleto() {
				return this.nombre + " " + this.apellidos;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getApellidos() {
				return apellidos;
			}

			public void setApellidos(String apellidos) {
				this.apellidos = apellidos;
			}

			public int getEdad() {
				return edad;
			}

			public void setEdad(int edad) {
				this.edad = edad;
			}

			public int getAltura() {
				return altura;
			}

			public void setAltura(int altura) {
				this.altura = altura;
			}

			public float getPeso() {
				return peso;
			}

			public void setPeso(float peso) {
				this.peso = peso;
			}

			@Override
			public String toString() {
				return "Persona2 [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", altura="
						+ altura + ", peso=" + peso + "]";
			}	
}