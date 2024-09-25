package vista;

//ESTUDIO EXCEPCIONES
import estudio_excepciones.Excepciones;
import excepciones.CuentaCorrienteException;
import excepciones.DniException;
import flujo_de_datos.FlujoDatos;
import flujo_de_datos.Leer;
import repasoFicheros.Ej1_DesencriptarPorTransposicion;
import repasoFicheros.Ej2_MensajeSecreto;
import repasoFicheros.Ej3_CuadradoMagico;
import repasoFicheros.Ej4_MatricesDiagonalesPrimas;
import repasoFicheros.Ej5_TarjetaClaves;
import repasoFicheros.Ej6_NotasAlumnos;
import repasoFicheros.Ej7_Tute;
import repasoFicheros.Ej8_RepartoCartas;
import repasoFicheros.Rep_Ej1_DesencriptadoPorTransposicion;
import repasoFicheros.Rep_Ej4_MatricesDiagonalesPrimas;
import repasoFicheros.Rep_Ej6_NotasaAlumnos;
import repasoFicheros.Rep_Ej8_RepartoCartas;
import ejercicios_excepciones.CuentaCorriente;
import ejercicos_ficheros.CuadradoMagico;
import ejercicos_ficheros.EncriptaDesencripta;
//ESTUDIO FICHEROS
import ejercicos_ficheros.FicheroAlumnos;
import ejercicos_ficheros.Matrices;
import ejercicos_ficheros.MatricesDiagonalesPrimas;
import ejercicos_ficheros.MensajeSecreto;
import ejercicos_ficheros.TarjetaClaves;
import ejercicos_ficheros.TarjetaClavesNuevoUsuario;
import ejercicos_ficheros.Tute;
import estudio_Ficheros.Ficheros;
import estudio_Ficheros.Ficheros2;

//EXCEPCIONES
import java.io.IOException;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//EXCEPCIONES VIDEO 1 Y 2
/*
		try {
		Excepciones excepciones = new Excepciones("12345678A");
		}
		catch (ArithmeticException e) {
			// TODO: handle exception
			System.err.println("Procesamos error div por cero en vista");
		} catch (DniException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
*/
		
		//EXCEPCIONES VIDEO 3 (CUENTA CORRIENTE)
/*
		try {
			CuentaCorriente cuentaCorriente = new CuentaCorriente("1111 2222 0098 7456 1233");
			System.out.println("Cuenta valida");
		} catch (CuentaCorrienteException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
*/
/*
		System.out.println("Introduce un dato: ");
		String dato = "";
		try {
			dato = Leer.dato();
			System.out.println("Dato válido: " + dato);
		} 
		catch (IOException e) {
			System.err.println("Dato no válido.");
		}
		
		System.out.println("== == == == == == == == == == == == == ==");
		
		System.out.println("Introduce un numero entero: ");
		try {
			int num = Leer.datoInt();
			System.out.println("Numero válido: " + num);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Dato no válido.");
		}
*/
		//FlujoDatos flujoDatos = new FlujoDatos();
	
		try {
			//Ficheros ficheros = new Ficheros();
			//Ficheros2 ficheros2 = new Ficheros2();
			//FicheroAlumnos ficheroAlumnos = new FicheroAlumnos();
			//TarjetaClaves tarjetaClaves = new TarjetaClaves();
			//Matrices matrices = new Matrices();
			//Tute tute = new Tute();
			//MatricesDiagonalesPrimas matricesDiagonalesPrimas = new MatricesDiagonalesPrimas();
			//EncriptaDesencripta encriptaDesencripta = new EncriptaDesencripta();
			//CuadradoMagico cuadradoMagico = new CuadradoMagico();
			//MensajeSecreto mensajeSecreto = new MensajeSecreto();
			//TarjetaClavesNuevoUsuario tarjetaClavesNuevoUsuario = new TarjetaClavesNuevoUsuario();
		//EJERCICIOS REPASO
			//Ej1_DesencriptarPorTransposicion ej1_DesencriptarPorTransposicion = new Ej1_DesencriptarPorTransposicion();
			//Ej2_MensajeSecreto ej2_MensajeSecreto = new Ej2_MensajeSecreto();
			//Ej3_CuadradoMagico ej3_CuadradoMagico = new Ej3_CuadradoMagico();
			//Ej4_MatricesDiagonalesPrimas ej4_MatricesDiagonalesPrimas = new Ej4_MatricesDiagonalesPrimas();
			//Ej5_TarjetaClaves ej5_TarjetaClaves = new Ej5_TarjetaClaves();
			//Ej6_NotasAlumnos ej6_NotasAlumnos = new Ej6_NotasAlumnos();
			//Ej7_Tute ej7_Tute = new Ej7_Tute();
			//Ej8_RepartoCartas ej8_RepartoCartas = new Ej8_RepartoCartas();
		//REPETICION EJERCICIOS REPASO
			//Rep_Ej1_DesencriptadoPorTransposicion rep_ej1_DesencriptadoPorTransposicion = new Rep_Ej1_DesencriptadoPorTransposicion();
			Rep_Ej4_MatricesDiagonalesPrimas rep_Ej4_MatricesDiagonalesPrimas = new Rep_Ej4_MatricesDiagonalesPrimas();
			//Rep_Ej6_NotasaAlumnos rep_Ej6_NotasaAlumnos = new Rep_Ej6_NotasaAlumnos();
			//Rep_Ej8_RepartoCartas rep_Ej8_RepartoCartas = new Rep_Ej8_RepartoCartas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
