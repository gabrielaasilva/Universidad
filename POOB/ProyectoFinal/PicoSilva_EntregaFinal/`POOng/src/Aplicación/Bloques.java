package Aplicación;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
/**
 * Bloques
 */
public class Bloques {
	private final int alto = 20;
	private final int ancho = 20;
	private int x,y;
	private int dy = 1;
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Bloques(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Obtiene la figura base del bloque
	 * @return Rectangle2D
	 */
	public Rectangle2D getFiguraBloque() {
		return new Rectangle2D.Double(x,y,ancho,alto);
	}
	/**
	 * Obtiene la coordena en x de la posicion del bloque.
	 * @return int x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Obtiene la coordena en y de la posicion del bloque.
	 * @return int y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Obtiene el ancho de la figura
	 * @return int ancho
	 */
	public int getAncho() {
		return ancho;
	}
	
	/**
	 * Obtiene el alto de la figura
	 * @return int alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Mueve el bloque
	 * @param Rectangle extremos
	 * @param boolean lado
	 */
	public void move(Rectangle extremos,boolean lado) {
		if (lado) {
			y --;		
		} else {
			y++;
			
		}
	}
	 /**
	 * Actualiza la posicion de el bloque
	 * @param int x
	 * @param int y
	 */
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
}



