package Aplicación;

public class Nuevo_elemento extends Objetivos{
	
	private int x, y;
	public Nuevo_elemento(int x, int y) {
		super(x, y);
		this.x= x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	
	public int CambiarFortaleza(int fortaleza) {
		int cambio = (int)(fortaleza*0.5)+ fortaleza;
		return cambio;
	}
	
	/** metodo que mueve en x el nuevo elemento para perseguir a la pelota 
	 * @param int x
	 * @return void
	 *  **/
	public void setElementoX(int x) {
		this.x = x;
	}
	
	
}
