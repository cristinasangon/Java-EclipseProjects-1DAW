package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import controller.BancoController;
import excepciones.CamposVaciosException;
import excepciones.CuentaBancariaException;
import excepciones.saldoInsuficienteException;
import modelo.CuentaBancaria;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	try {
			BancoController banco = new BancoController();
			
			boolean programaContinua = true;
			while(programaContinua) {
				System.out.println();
				System.out.println("____________________________________________________________");
				System.out.println("CAIXA BANK:");
				System.out.println("------------------------------------------------------------");
				System.out.println("1 - Mostrar todas las cuentas bacarias");
				System.out.println("2 - Agregar una nueva cuenta bancaria");
				System.out.println("3 - Mostrar todas las cuentas de un cliente");
				System.out.println("4 - Retirar dinero de una cuenta");
				System.out.println("5 - Bloquear una cuenta");
				System.out.println("6 - Eliminar las cuentas bloqueadas de un cliente");
				System.out.println("7 - Salir");
				System.out.println("____________________________________________________________");
				
				String datoTeclado = "";
				boolean datoInvalido = true;
				int op = 0;
				
				while(datoInvalido) {
					try {
						System.out.print("Elige una opción (1 - 7): ");
						datoTeclado = Leer.cadena();
						op = Integer.parseInt(datoTeclado);
						if(op >= 1 && op <= 7) {
							datoInvalido = false;
						}else {
							System.out.println("'" + datoTeclado + "' no es una opción valida");
						}
					} catch (NumberFormatException e) {
						System.out.println("'" + datoTeclado + "' no es una opción valida");
					}
				}
				
				switch (op) {
//MOSTRAR TODAS LAS CUENTAS ORDENADAS POR FECHA
				case 1: {
					for(CuentaBancaria cuenta: banco.ordenarCuentasPorFecha()) {
						System.out.println(cuenta);
					}
					break;
				}
				
//AGREGAR UNA NUEVA CUENTA BANCARIA
				case 2: {
					try {
						System.out.println("____________________________________________________________");
						System.out.println("Introduce los datos de la nueva cuenta bancaria: ");
						System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
						System.out.print("DNI:"); String dni = Leer.cadena();
						System.out.print("Titular: "); String titular = Leer.cadena();
						System.out.print("Saldo: "); String saldo = Leer.cadena();
						
						if(banco.agregarNuevaCuenta(numCuenta, dni, titular, saldo)) {
						System.out.println("_____________________________________________________________________");
						System.out.println("La cuenta se ha añadido correctamente");
						}else {
						System.out.println("_____________________________________________________________________");
						System.out.println("No puedes añadir cuenta bancaria ya existente");
						}
					} catch (Exception e) {
						System.out.println("_____________________________________________________________________");
						System.out.println("La cuenta no se ha añadido porque se han introducido datos no válidos");
					}
					
					break;
				}
				
//MOSTRAR TODAS LAS CUENTAS DE UN DETERMINADO CLIENTE
				case 3: {
					System.out.println("____________________________________________________________");
					System.out.print("DNI del cliente: "); String dni = Leer.cadena();

					for(CuentaBancaria cuenta: banco.filtrarCuentasPorCliente(dni)) {
						System.out.println(cuenta);
					}
					break;
				}
				
//RETIRAR DINERO DE UNA CUENTA
				case 4: {
					System.out.println("____________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					System.out.println("____________________________________________________________");
					System.out.println("Elige una opcion: ");
					System.out.println("1 - Ingresar dinero");
					System.out.println("2 - Retirar dinero");
					System.out.println("____________________________________________________________");
					
					datoTeclado = ""; datoInvalido = true; op = 0;
					while(datoInvalido) {
						try {
							System.out.print("Opcion (1/2): ");
							datoTeclado = Leer.cadena();
							op = Integer.parseInt(datoTeclado);
							if(op >= 1 && op <= 2) {
								datoInvalido = false;
							}else {
								System.out.println("'" + datoTeclado + "' no es una opción valida");
							}
						} catch (NumberFormatException e) {
							System.out.println("'" + datoTeclado + "' no es una opción valida");
						}
					}
					
					System.out.println("____________________________________________________________");
					try {
						System.out.print("Cantidad: "); datoTeclado = Leer.cadena();
						int cantidad = 0;
						cantidad = Integer.parseInt(datoTeclado);
						if(op == 2) {
							cantidad *= -1;
						}
						if(banco.ingresarRetirarDinero(numCuenta, cantidad)) {
							System.out.println("Operacion realizada: " + cantidad + "€");
						}else {
							System.out.println("La operacion no se puede realizar por: CUENTA BANCARIA INEXISTENTE");
						}
					}catch (saldoInsuficienteException e) {
						System.out.println("La operacion no se puede realizar por: SALDO INSUFICIENTE");
					}catch (NumberFormatException e) {
						System.out.println("La operacion no se puede realizar por: CANTIDAD INTRODUCIDA INVALIDA");
					}
					break;
				}
				
//BLOQUEAR UNA CUENTA
				case 5: {
					System.out.println("____________________________________________________________");
					System.out.print("Numero de cuenta: "); String numCuenta = Leer.cadena();
					
					System.out.println("____________________________________________________________");
					if(banco.bloquearCuenta(numCuenta)) {
						System.out.println("La cuenta '" + numCuenta + "' ha sido bloqueada");
					}else {
						System.out.println("La cuenta '" + numCuenta + "' no existe o ya esta bloqueada");
					}
					break;
				}
				
//ELIMINAR TODAS LAS CUENTAS BLOQUEADAS DE UN CLIENTE
				case 6: {
					System.out.println("____________________________________________________________");
					System.out.print("DNI del cliente: "); String dni = Leer.cadena();
					
					System.out.println("Se han eliminado " + banco.eliminarCuentasBloqueadasCliente(dni) + " cuentas bloqueadas");
					break;
				}
				
				default:
					System.out.println();
					System.out.println("____________________________________________________________");
					System.out.println("¡HASTA LA PROXIMA!");
					if(!banco.salvarDatos()) {
						System.out.println("DATOS NO GUARDADOS");
					}
					programaContinua = false;
				}
			}
		} catch (NumberFormatException | CuentaBancariaException | CamposVaciosException | DateTimeParseException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
