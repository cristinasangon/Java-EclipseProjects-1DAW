package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import controller.BancoController;
import excepciones.CamposVaciosException;
import excepciones.CuentaBancariaException;
import excepciones.SaldoInsuficienteException;
import modelo.CuentaBancaria;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			BancoController caixa = new BancoController();
			
			boolean programaContinua = true;
			while(programaContinua) {
				System.out.println();
				System.out.println();
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("CAIXA BANK");
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("1 - Mostrar todas las cuentas bancarias");
				System.out.println("2 - Agregar una cuenta nueva");
				System.out.println("3 - Mostrar todas las cuentas de un cliente");
				System.out.println("4 - Ingresar dinero");
				System.out.println("5 - Retirar dinero");
				System.out.println("6 - Bloquear una cuenta bancaria");
				System.out.println("7 - Eliminar todas las cuentas bloqueadas de un cliente");
				System.out.println("8 - Salvar datos");
				System.out.println("9 - Salir");
				System.out.println("---------------------------------------------------------------------------");

				boolean incorrecto = true;
				String datoTeclado = "";
				int op = 0;
				while(incorrecto) {
					try {
						System.out.println("___________________________________________________________________________");
						System.out.print("Elige una opcion (1 - 9): ");
						datoTeclado = Leer.cadena();
						op = Integer.parseInt(datoTeclado);
						if(op >= 1 && op <=9) {
							incorrecto = false;
							break;
						}else {
							System.out.println("'" + datoTeclado + "' no es una opcion válida");
						}
					} catch (NumberFormatException e) {
						System.out.println("'" + datoTeclado + "' no es una opcion válida");
					}
				}
				
				switch (op) {
				case 1: {
					System.out.println("___________________________________________________________________________");
					for(CuentaBancaria cuenta: caixa.mostrarCuentas()) {
						System.out.println(cuenta);
					}
					break;
				}
				case 2: {
					System.out.println("___________________________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					System.out.print("DNI del titular: "); String dni = Leer.cadena();
					System.out.print("Nombre del titular: "); String titular = Leer.cadena();
					System.out.print("Saldo: "); String saldo = Leer.cadena();

					System.out.println("___________________________________________________________________________");
					try {
						if(caixa.agregarCuenta(numCuenta, dni, titular, saldo)) {
							System.out.println("Cuenta añañdida con éxito");
						}else {
							System.out.println("La cuenta no se ha podido añadir porque ya existe");
						}
					} catch (NumberFormatException | CuentaBancariaException | CamposVaciosException e) {
						System.out.println("La cuenta no se ha podido añadir por: " + e.getMessage());
					}
					break;
				}
				case 3: {
					System.out.println("___________________________________________________________________________");
					System.out.print("DNI del cliente: "); String dni = Leer.cadena();
					int cont = 0;
					for(CuentaBancaria cuenta: caixa.mostrarCuentasCliente(dni)) {
						System.out.println(cuenta);
						cont++;
					}
					if(cont == 0) {
						System.out.println("El cliente con DNI '" + dni + "' no existe o no tiene ninguna cuenta");
					}
					break;
				}
				case 4: {
					System.out.println("___________________________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					System.out.print("Cantidad a ingresar: "); String cantidad = Leer.cadena();
					
					try {
						int cant = Integer.parseInt(cantidad);
						if(caixa.ingresarRetirarDinero(numCuenta, cant)) {
							System.out.println("OPERACION REALIZADA: +" + cant + "€");
						}else {
							System.out.println("OPERACION NO REALIZADA POR CUENTA INEXISTENTE");
						}
					} catch (NumberFormatException e) {
						System.out.println("OPERACION NO REALIZADA POR CANTIDAD '" + cantidad + "' INVÁLIDA");
					} catch (SaldoInsuficienteException e) {
						System.out.println("OPERACION NO REALIZADA POR " + e.getMessage());
					}
					break;
				}
				case 5: {
					System.out.println("___________________________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					System.out.print("Cantidad a retirar: "); String cantidad = Leer.cadena();
					
					try {
						int cant = Integer.parseInt(cantidad);
						cant *=-1;
						if(caixa.ingresarRetirarDinero(numCuenta, cant)) {
							System.out.println("OPERACION REALIZADA: " + cant + "€");
						}else {
							System.out.println("OPERACION NO REALIZADA POR CUENTA INEXISTENTE");
						}
					} catch (NumberFormatException e) {
						System.out.println("OPERACION NO REALIZADA POR CANTIDAD '" + cantidad + "' INVÁLIDA");
					} catch (SaldoInsuficienteException e) {
						System.out.println("OPERACION NO REALIZADA POR " + e.getMessage());
					}
					break;
				}
				case 6: {
					System.out.println("___________________________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					
					if(caixa.boquearCuenta(numCuenta)) {
						System.out.println("La cuenta con num '" + numCuenta + "' ahora esta bloqueada");
					}else {
						System.out.println("La cuenta con num '" + numCuenta + "' no existe o ya esta bloqueada");
					}
					break;
				}
				case 7: {
					System.out.println("___________________________________________________________________________");
					System.out.print("DNI del cliente: "); String dni = Leer.cadena();
					
					System.out.println("Se han eliminado un total de " + caixa.eliminarCuentasBloqueadasCliente(dni) + " cuentas bancarias bloqueadas del cliente con dni '" + dni + "'");
					break;
				}
				case 8: {
					if(caixa.salvarDatos()) {
						System.out.println("___________________________________________________________________________");
						System.out.print("DATOS SALVADOS"); 
					}
					break;
				}
				default:
					System.out.println();
					System.out.println();
					System.out.println("___________________________________________________________________________");
					System.out.print("HASTA LA PROXIMA!!"); 
					programaContinua = false;
					break;
				}
			}
			
		} catch (NumberFormatException | DateTimeParseException | IOException | CuentaBancariaException	| CamposVaciosException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}
