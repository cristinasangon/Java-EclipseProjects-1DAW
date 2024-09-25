package tiposDeDatos;

public class EstudioPrintf 
	{

	public EstudioPrintf() 
		{
		System.out.println("_______________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - PRINT F - - - - - - - - - - - -");
		
		/* Sirve para mejorar la presentacion de determinados resultados
		   * %d es para mostrar un numero entero o double
		   * %d es para mostrar una cadena String
		   * %n es un salto de linea 
		   * %f forma de mostrar una cantidad real de decimales
		   * */
		
		int x = 33, y = 10, cont = 0;
		double decimal = 1 / 3.0;
		String nom1 = "Cristina", ape1 = "Sanchez", nom2 = "Victor", ape2 = "Mateo";
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR 2 NUMEROS ENTEROS");
		
		System.out.printf("  |Numero entero: %d otro numero: %d %n", x, y); 
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR NUMERO ENTERO CON 10 HUECOS DE DISTANCIA DEL BORDE IZQUIERDO");
		
		System.out.printf("  |%10d %n", x);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR NUMERO QUE TIENE MUCHOS DECIMALES CON LOS DECIMALES DE UN NUMERO REAL");
				
		System.out.println("  |Con todos los decimales: " + decimal);
		System.out.printf("  |Con decimales reales: %f %n", decimal);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR NUMERO CON UNA CANTIDAD DETERMINADA DE DECIMALES");
						
		System.out.printf("  |Con 3 decimales: %.3f %n", decimal);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR CON 10 HUECOS DE DISTANCIA Y UNA CANTIDAD DETERMINADA DE DECIMALES");
								
		System.out.printf("  |Derecha: %10.3f %n", decimal);
		System.out.printf("  |Izquierda: %-10.3f %d %n", decimal, x);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- MOSTRAR NOMBRE Y APELLIDOS DE UNA MEJOR MANERA VISUAL");
										
		System.out.printf("  |%s %n", nom1);
		System.out.printf("  |%10s %n", nom1);
		System.out.printf("  |%-10s %-10s %n", nom1, ape1);
		System.out.printf("  |%-10s %-10s %n", nom2, ape2);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// Programa que muestre numeros del 33 al 122 y muestre a su lado su caracter Ascii
		
		while(x < 123)
			{
			cont ++;
			char c = (char) x;
			System.out.printf("%3d  %c", x, c);
			x ++;
			if (cont == 5)
				{
				System.out.println("");
				cont = 0;
				}
			else
				{
				System.out.print(" | ");
				}
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("");
		System.out.println("_______________________________________________________");
		}

	}
