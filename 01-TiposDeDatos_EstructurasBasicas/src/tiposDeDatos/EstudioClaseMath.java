package tiposDeDatos;

public class EstudioClaseMath 
	{

	public EstudioClaseMath() 
		{
		System.out.println("______________________________________________________");
		System.out.println("");
		System.out.println("- - - - - - - - - CLASE MATH - - - - - - - - -");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.ceil: Redondea al mayor");
		
		System.out.println(Math.ceil(2.3)); //Resultado 3.0
		System.out.println(Math.ceil(0.895)); //Resultado 1.0
		System.out.println(Math.ceil(-1.87)); //Resultado -1.0
		System.out.println(Math.ceil(-0.9)); //Resultado -0.0
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.floor: Redondea al menor (Truncar)");
				
		System.out.println(Math.floor(2.8)); //Resultado 2.0
		System.out.println(Math.floor(0.895)); //Resultado 0.0
		System.out.println(Math.floor(-1.87)); //Resultado -2.0
		System.out.println(Math.floor(-0.9)); //Resultado -1.0
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.floor: Redondea al mas cercano");
						
		System.out.println(Math.rint(0.891)); //Resultado 1.0
		System.out.println(Math.rint(6.5)); //Resultado 6.0	
		System.out.println(Math.rint(6.51)); //Resultado 7.0	
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.pow y Math.sqrt: Potencias y raices");
		
		System.out.println(Math.pow(5, 2)); //5^2 -> 5*5 -> 25.0
		System.out.println(Math.sqrt(25)); //Raiz cuadrada de 25 -> 5
		
		System.out.println(Math.pow(25, 1/2.0)); //Raiz cuadrada de 25 -> 5
		System.out.println(Math.pow(125, 1/3.0)); //Raiz cubica de 125 -> 5
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.sin, Math.toRadians, Math.toDegress, Math.ocos: Trigonometria");
				
		int angulo = 30;
		System.out.printf("El seno de un angulo de %d grados es %.1f %n", angulo, Math.sin(Math.toRadians(angulo)));
		
		double cosAngulo = 0.86;
		System.out.printf("El coseno de %.2f corresponde a un angulo de %f grados %n", cosAngulo, Math.toDegrees(Math.acos(cosAngulo)));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.max, Math.min: Maximo y minimo de dos numeros");
		System.out.println(Math.max(13, 26));
		System.out.println(Math.min(13, 26));
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		System.out.println("");
		System.out.println("- Math.random: Genera numeros al azar");
		
		int rand = 0, x= 0;
		
		for (x = 0; x < 20; x++) //Genera numeros al azar del 1 al 4
			{
			rand = (int) Math.floor(Math.random()*5);
			System.out.print(rand + " - ");
			}
		
		System.out.println("");
		
		for (x = 0; x < 20; x++) //Genera numeros al azar del 1 al 10
			
			{
			rand = (int) Math.floor(Math.random()*10+1);
			System.out.print(rand + " - ");
			}
		
		System.out.println("");
		int mayor = 7, menor = 5;
		for (x = 0; x < 20; x++) //Genera numeros dentro de un rango de variables
			{
			rand = (int) Math.floor(Math.random()*(mayor - menor + 1) + menor);
			System.out.print(rand + " - ");
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

	}
