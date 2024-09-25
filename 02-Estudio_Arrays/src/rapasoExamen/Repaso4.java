package rapasoExamen;

public class Repaso4 {

	public Repaso4() {
		// TODO Auto-generated constructor stub
		System.out.println("  ==  =  ==  =  ==  =  REPASO 4  =  ==  =  ==  =  ==  ");
		
		int[][] matriz = new int[5][5];
		int x = 0, y = 2, v = 1;
		matriz[x][y] = v;
		v++;
		while(v <= 25) {
			if(v != 1 && (((v - 1) % 5) == 0)) {
				x++;
				if(x == 5) {
					x = 0;
				}
			}
			else {
				x--;
				y++;
				if(x == -1) {
					x = 4;
				}
				if(y == 5) {
					y = 0;
				}
			}
			matriz[x][y] = v;
			v++;
		}
		
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("| ");
			for(int z = 0; z < matriz[i].length; z++) {
				System.out.print(matriz[i][z] + " | ");
			}
			System.out.println();
		}
	}

}
