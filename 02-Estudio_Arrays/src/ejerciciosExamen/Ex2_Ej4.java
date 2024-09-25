package ejerciciosExamen;

public class Ex2_Ej4 {

	public Ex2_Ej4() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 2 - EJERCICIO 4 == == == ==");
		// 
		int num = 0;
		
		for(int x = 0; x < 50000; x++) {
			num = x;
			int dig = 0, fac = 0, suma = 0;
			if(x != 0) {
				while(num > 0) {
					dig = num % 10;
					num/= 10;
					fac = factorial(dig);
					suma += fac;
				}
				if(suma == x) {
					System.out.println(x);
				}	
			}
		}
		
		
		
	}
	public static int factorial(int num) {
		int fact = 1;
		if(num != 0) {
			for(int x = 1; x <= num; x++) {
				fact *= x;
			}	
		}
		return fact;
	}
}
