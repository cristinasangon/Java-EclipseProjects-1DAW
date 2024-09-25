package ejercicios;
public class CuentaCorriente {

	public CuentaCorriente() {
		// TODO Auto-generated constructor stub
		String ccc = "14320154497422504551";
		int[] corrector = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
		
		if(	compruebaCuentaCorriente(ccc, corrector) == true) {
			System.out.println("La cuenta es correcta");
		}
		else {
			System.out.println("La cuenta no es correcta");
		}
		
		
	}
public static boolean compruebaCuentaCorriente (String ccc, int[] corrector) {
	//------------------------------------------------Sacar valores de entidad y sucursal
	String entSuc = "00";
	entSuc += ccc.substring(0, 8);
	
	//------------------------------------------------Sacar valores del digito de control
	String dc = ccc.substring(8, 10);

	//------------------------------------------------Sacar valores del numero de cuenta
	String numCuenta = ccc.substring(10, 20);

	//------------------------------------------------Multiplicar e iracumulando y sumando
	int sumEntSuc = 0, sumNumCuenta = 0;
	for(int x = 0; x < 10; x++) {
		sumEntSuc += (Integer.parseInt(Character.toString(entSuc.charAt(x))) * corrector[x]);
		sumNumCuenta += (Integer.parseInt(Character.toString(numCuenta.charAt(x))) * corrector[x]);
	}
	
	//------------------------------------------------Corregir si el digito es 10 u 11
	int d = 11 - (sumEntSuc % 11), c = 11 - (sumNumCuenta % 11);
	if(d == 10) {d = 1;}
	if(d == 11) {d = 0;}
	if(c == 10) {c = 1;}
	if(c == 11) {c = 0;}
	
	//------------------------------------------------Comprobar que d y c sean igual que dc
	if(d != Integer.parseInt(Character.toString(dc.charAt(0)))){
		return false;
	}
	
	if(c != Integer.parseInt(Character.toString(dc.charAt(1)))){
		return false;
	}
	
	return true;
	}
}
