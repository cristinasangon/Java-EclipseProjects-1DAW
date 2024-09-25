/*package vista;

import java.util.Scanner;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4_1;
import ejercicios.Ejercicio4_2;
import ejercicios.Ejercicio4_3;
import estudioArrays.ArrayBidimensional;
import estudioArrays.ArrayUnidimensional;

public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		System.out.println("=================== EJECUTAR ===================");
		System.out.println("1 - Estudio Arrays");
		System.out.println("2 - Ejercicios");
		System.out.println("================================================");
		int op = leer.nextInt();
		switch(op) {
			case 1:
				System.out.println("================ ESTUDIO ARRAYS ================");
				System.out.println("1 - Arrays Unidimensionales");
				System.out.println("2 - Arrays Bidimensionales");
				System.out.println("================================================");
				op = leer.nextInt();
				switch(op) {
					case 1:
						ArrayUnidimensional arrayUnidimensional = new ArrayUnidimensional();
						break;
					case 2:
						ArrayBidimensional arrayBidimensional = new ArrayBidimensional();
						break;
				}
				break;
			case 2:
				System.out.println("================== EJERCICIOS ==================");
				System.out.println("1 - Ejercicio 1");
				System.out.println("2 - Ejercicio 2");
				System.out.println("3 - Ejercicio 3");
				System.out.println("4 - Ejercicio 4");
				System.out.println("5 - Ejercicio 5");
				System.out.println("6 - Ejercicio 6");
				System.out.println("================================================");
				op = leer.nextInt();
				switch(op) {
					case 1:
						Ejercicio1 ejercicio1 = new Ejercicio1();
						break;
					case 2:
						Ejercicio2 ejercicio2 = new Ejercicio2();
						break;
					case 3:
						Ejercicio3 ejercicio3 = new Ejercicio3();
						break;
					case 4:
						System.out.println("================== EJERCICIO 4 ==================");
						System.out.println("1 - Ejercicio 4.1");
						System.out.println("2 - Ejercicio 4.2");
						System.out.println("3 - Ejercicio 4.3");
						System.out.println("================================================");
						op = leer.nextInt();
						switch(op) {
							case 1:
								Ejercicio4_1 ejercicio4_1 = new Ejercicio4_1();
								break;
							case 2:
								Ejercicio4_2 ejercicio4_2 = new Ejercicio4_2();
								break;
							case 3:
								Ejercicio4_3 ejercicio4_3 = new Ejercicio4_3();
								break;
						}
						break;
					
				}
				
		}
	}

}
*/
