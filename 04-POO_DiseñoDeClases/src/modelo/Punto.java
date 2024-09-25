package modelo;

public class Punto {
	
	  private int x;
	  private int y;

	  // Constructor
	  public Punto(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }
	  
	  public String toString() {
		  return "(" + x + ", " + y + ")";
	  }
	  
}