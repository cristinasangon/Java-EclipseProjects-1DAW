package ejerciciosExamen;

public class Ex1_Ej4 {

	public Ex1_Ej4() {
		// TODO Auto-generated constructor stub
		System.out.println("== == == == EXAMEN 1 - EJERCICIO 4 == == == ==");
		// 
		String alumnos[] = {"Pepe", "Juan", "Mario", "Andres", "Alba", "Dani", "Fran", "Pedro", "Patri", "Jesus"};
		String asignaturas[] = {"Examen1", "Examen2", "Examen3", "Examen4", "Examen5"};
		int notas[][] = {{4, 5, 3, 10, 6, 2, 10, 7, 8, 1},
		                 {3, 4, 7, 8, 5, 5, 8, 8, 9, 2}, 
		                 {5, 4, 3, 9, 7, 4, 9, 7, 9, 3},
		                 {5, 6, 7, 9, 6, 6, 9, 6, 6, 4},  
		                 {5, 6, 5, 9, 8, 3, 9, 5, 7, 5}};
		
		//Calculamos nota mas alta examen 1
		int mayorEx1 = 0;
		for(int x = 0; x < notas[0].length; x++) {
			if(notas[0][x] > mayorEx1) {
				mayorEx1 = notas[0][x];
			}
		}
		
		//Calculamos nota mas alta examen 5
		int mayorEx5 = 0;
		for(int x = 0; x < notas[4].length; x++) {
			if(notas[4][x] > mayorEx5) {
				mayorEx5 = notas[4][x];
			}
		}
		
		//Recorremos arrays notas mostrando los alumnos que tienen esas notas
		System.out.println();
		System.out.println("Nota mas alta del ex1: " + mayorEx1 + "   nota ex5: " + mayorEx5);
		System.out.println("=========================================");
		for(int x = 0; x < alumnos.length; x++) {
			if((notas[0][x] == mayorEx1) && (notas[4][x] == mayorEx5)) {
				System.out.printf("%-20s :%-15d %d %n", alumnos[x], notas[0][x], notas[4][x]);
			}
		}
	}

}
