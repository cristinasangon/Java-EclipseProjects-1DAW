package ejerciciosExamen;

import java.util.Scanner;

public class Ex1_Ej1 {

	public Ex1_Ej1() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 1 - EJERCICIO 1 == == == ==");
		// 
		Scanner leer = new Scanner(System.in);
		
		System.out.println();
		System.out.println("====================================");
		System.out.println("Venta de entradas CineCampa");
		System.out.print("Número de entradas: ");
		int entradas = leer.nextInt();
		
		System.out.print("Dia de la semana (1-7): ");
		int dia = leer.nextInt();
		System.out.print("¿Tiene tarjeta CineCampa? (si = 1/no = 2): ");
		int tarjeta = leer.nextInt();
		
		double precio = 0,precioPareja = 0, total = 0, descuento = 0, aPagar = 0;
		int pareja = 0;
		switch(dia) {
			case 1:
			case 2:
			case 5:
			case 6: 
			case 7:
				precio = 8;
				total = precio * entradas;
				break;
			case 3:
				precio = 5;
				total = precio * entradas;
				break;
			case 4:
				precioPareja = 11;
				precio = 8;
				while(entradas >= 2) {
					total += 11;
					entradas -= 2;
					pareja ++;
				}
				if(entradas > 0) {
					total += 8;
				}
				break;
		}
		
		if(tarjeta == 1) {
			descuento = total * 0.10;
		}
		
		System.out.println("====================================");
		System.out.println("Aquí tiene sus entradas. Gracias por su compra");
		System.out.println("====================================");
		if(pareja > 0) {
			System.out.println("Entradas de pareja " + pareja);
			System.out.println("Precio por entrada de pareja " + precioPareja + "€");
		}
		if(entradas > 0) {
			System.out.println("Entradas de individuales " + entradas);
			System.out.println("Precio por entrada individual " + precio + "€");
		}
		System.out.println("Total " + total + "€");
		if(descuento > 0) {
			System.out.printf("Descuento %.2f € %n", descuento);
		}
		aPagar = total - descuento;
		System.out.println("A pagar " + aPagar + "€");
		System.out.println("====================================");
	}

}
