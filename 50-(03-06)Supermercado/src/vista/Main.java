package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import controller.SupermercadoController;
import excepciones.CamposVaciosException;
import excepciones.CodBarrasException;
import excepciones.SinExistenciasException;
import modelo.Producto;
import utilidades.Leer;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		try {
			SupermercadoController mercadona = new SupermercadoController();
			
			boolean programaContinua = true;
			while(programaContinua) {
				System.out.printf("%n %n %n %n %n %n %n %n %n %n %n %n %n %n %n %n");
				System.out.println("----------------------------------------------------");
				System.out.println("MERCADONA");
				System.out.println("----------------------------------------------------");
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Agregar un nuevo producto");
				System.out.println("3 - Mostrar todos los productos de un tipo");
				System.out.println("4 - Comprar un producto");
				System.out.println("5 - Reponer un producto");
				System.out.println("6 - Eliminar productos caducados");
				System.out.println("7 - Salvar datos");
				System.out.println("8 - Salir");
				System.out.println("----------------------------------------------------");
				
				String datoTeclado = "";
				boolean datoInorrecto = true;
				int op = 0;
				while(datoInorrecto) {
					System.out.print("Elige una opcion (1-8): ");
					datoTeclado = Leer.cadena();
					try {
						op = Integer.parseInt(datoTeclado);
						if(op >= 1 && op <= 8) {
							datoInorrecto = false;
						}else {
							System.out.println("'" + datoTeclado + "' no es una opcion válida");
						}
					} catch (Exception e) {
						System.out.println("'" + datoTeclado + "' no es una opcion válida");
					}
				}
				
				switch (op) {
				case 1: {
					System.out.println("____________________________________________________");
					for(Producto producto: mercadona.mostrarProductos()) {
						System.out.println(producto);
					}
					break;
				}
				case 2: {
					System.out.println("____________________________________________________");
					System.out.print("Codigo de barras: "); String codBarras = Leer.cadena();
					System.out.print("Nombre: "); String nombre = Leer.cadena();
					System.out.print("Tipo de producto: "); String tipoProducto = Leer.cadena();
					System.out.print("Precio: "); String precio = Leer.cadena();
					
					try {
						if(mercadona.agregarNuevoProducto(codBarras, nombre, tipoProducto, precio)) {
							System.out.println("'" + nombre + "' agregado correctamente");
						}else {
							System.out.println("El producto no puede ser agregado porque ya existe");
						}
					} catch (NumberFormatException | CamposVaciosException | CodBarrasException e) {
						System.out.println("El producto no puede ser agregado porque se han introducido datos inválidos");
					}
					break;
				}
				case 3: {
					System.out.println("____________________________________________________");
					System.out.print("Tipo de producto: "); String tipoProducto = Leer.cadena();
					System.out.println("____________________________________________________");
					for(Producto producto: mercadona.mostrarProductosTipo(tipoProducto)) {
						System.out.println(producto);
					}
					break;
				}
				case 4: {
					System.out.println("____________________________________________________");
					System.out.print("Codigo de barras: "); String codBarras = Leer.cadena();
					System.out.print("Cantidad que quiere comprar: "); String cant = Leer.cadena();
					
					System.out.println("____________________________________________________");
					try {
						int cantidad = Integer.parseInt(cant);
						cantidad *= -1;
						if(mercadona.comprarReponerProducto(codBarras, cantidad)) {
							System.out.println("Gracias por comprar " + cant + " de " + mercadona.buscarProducto(codBarras).getNombre());
						}else {
							System.out.println("El producto que quiere comprar no existe");
						}
					} catch (NumberFormatException e) {
						System.out.println("'" + cant + "' no es una cantidad válida");
					}catch (SinExistenciasException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case 5: {
					System.out.println("____________________________________________________");
					System.out.print("Codigo de barras: "); String codBarras = Leer.cadena();
					System.out.print("Cantidad a reponer: "); String cant = Leer.cadena();
					
					System.out.println("____________________________________________________");
					try {
						int cantidad = Integer.parseInt(cant);
						if(mercadona.comprarReponerProducto(codBarras, cantidad)) {
							System.out.println("Gracias por reponer " + cant + " de " + mercadona.buscarProducto(codBarras).getNombre());
						}else {
							System.out.println("El producto que quiere reponer no existe");
						}
					} catch (NumberFormatException e) {
						System.out.println("'" + cant + "' no es una cantidad válida");
					}catch (SinExistenciasException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case 6: {
					System.out.println("____________________________________________________");
					System.out.println("Se han eliminado " + mercadona.eliminarProductosCaducados() + " productos");
					break;
				}
				case 7: {
					mercadona.salvarDatos();
					break;
				}
				case 8: {
					System.out.printf("%n %n %n %n %n %n %n %n %n %n %n %n %n %n %n %n");
					System.out.println("____________________________________________________");
					System.out.println("Gracias por visitar Mercadona");
					programaContinua = false;
					break;
				}
				default:
				}
			}
			
		} catch (IOException | NumberFormatException | DateTimeParseException | CodBarrasException | CamposVaciosException e) {
			System.err.println("FALLO EN DATOS RECOGIDOS DE FICHERO");
		}
		
	}
}
