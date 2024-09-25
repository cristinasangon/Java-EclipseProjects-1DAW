package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import controller.HospitalCotroller;
import excepciones.CamposVaciosException;
import excepciones.DniException;
import modelo.Paciente;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] arg) {
		try {
			HospitalCotroller hospital = new HospitalCotroller();
			
			boolean programaContinua = true;
			while(programaContinua) {
				System.out.printf("%n%n%n%n%n%n%n%n%n");
				System.out.println("-----------------------------------------------------------");
				System.out.println("EMS HOSPITAL");
				System.out.println("-----------------------------------------------------------");
				System.out.println("1 - Mostrar todos los pacientes");
				System.out.println("2 - Ingresar nuevo paciente");
				System.out.println("3 - Mostrar pacientes que tienen una enfermedad");
				System.out.println("4 - Mostrar pacientes graves");
				System.out.println("5 - Poner en estado grave a un paciente");
				System.out.println("6 - Dar de alta a un paciente");
				System.out.println("7 - Eliminar pacientes dados de alta");
				System.out.println("8 - Salvar datos");
				System.out.println("9 - Salir");
				System.out.println("-----------------------------------------------------------");
				
				boolean datoIncorrecto = true;
				String datoTeclado = "";
				int op = 0;
				while(datoIncorrecto) {
					System.out.println("___________________________________________________________________________________");
					System.out.print("Elige una opcion (1 - 9): ");
					try {
						datoTeclado = Leer.cadena();
						op = Integer.parseInt(datoTeclado);
						if(op >= 1 && op <= 9) {
							datoIncorrecto = false;
							break;
						}
						System.out.println("'" + datoTeclado + "' no es una opcion correcta");
					} catch (NumberFormatException e) {
						System.out.println("'" + datoTeclado + "' no es una opcion correcta");
					}
				}
				
				switch (op) {
				case 1: {
					System.out.println("___________________________________________________________________________________");
					for(Paciente paciente: hospital.mostrarPacientes()) {
						System.out.println(paciente);
					}
					break;
				}
				case 2: {
					System.out.println("___________________________________________________________________________________");
					System.out.print("DNI del paciente: "); String dni = Leer.cadena();
					System.out.print("Nombre del paciente: "); String nombre = Leer.cadena();
					System.out.print("Edad del paciente: "); String edad = Leer.cadena();
					System.out.print("Enfermedad del paciente: "); String enfermedad = Leer.cadena();
					
					System.out.println("___________________________________________________________________________________");
					try {
						if(hospital.ingresarNuevoPaciente(dni, nombre, edad, enfermedad)) {
							System.out.println("'" + nombre + "' ingresado correctamente");
						}else {
							System.out.println("El paciente con dni '" + dni + "' ya está ingresado");
						}
					} catch (NumberFormatException | DniException | CamposVaciosException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				}
				case 3: {
					System.out.println("___________________________________________________________________________________");
					System.out.print("Enfermedad: "); String enfermedad = Leer.cadena();
					
					for(Paciente paciente: hospital.mostrarPacientesPorEnfermedad(enfermedad)) {
						System.out.println(paciente);
					}
					break;
				}
				case 4: {
					System.out.println("___________________________________________________________________________________");
					for(Paciente paciente: hospital.mostrarPacientesGraves()) {
						System.out.println(paciente);
					}
					break;
				}
				case 5: {
					System.out.println("___________________________________________________________________________________");
					System.out.print("DNI del paciente: "); String dni = Leer.cadena();
					
					if(hospital.asignarPacienteGrave(dni)) {
						System.out.println("El pacciente con DNI '" + dni + "' ahora está en estado grave");
					}else {
						System.out.println("El paciente no existe o ya esta grave");
					}
					break;
				}
				case 6: {
					System.out.println("___________________________________________________________________________________");
					System.out.print("DNI del paciente: "); String dni = Leer.cadena();
					
					if(hospital.darAltaPaciente(dni)) {
						System.out.println("El paciente con DNI '" + dni + "' ha sido dao de alta");
					}else {
						System.out.println("El paciente no existe o ya esta dado de alta");
					}
					break;
				}
				case 7: {
					System.out.println("___________________________________________________________________________________");
					System.out.println("Se han eliminado " + hospital.eliminarPacientesDadosAlta() + " pacientes dados de alta");
					break;
				}
				case 8: {
					System.out.println("___________________________________________________________________________________");

					if(hospital.salvarDatos()) {
						System.out.println("Datos salvados");
					}
					break;
				}
				default:
					System.out.println();
					System.out.println("___________________________________________________________________________________");
					System.out.println("¡HASTA LA PROXIMA!");
					System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
					programaContinua = false;
				}
			}
			
		} catch (IOException | NumberFormatException | DateTimeParseException | DniException | CamposVaciosException e) {
			e.printStackTrace();
		} 
	}
	
	

}
