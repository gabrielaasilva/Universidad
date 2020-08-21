package Aplicación;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * Diseño de pelota
 */
public class Ball {
	private final int alto = 5;
	private final int ancho = 5;
	private int x, y;
	private int dx = 1, dy = 1;
	private boolean resultado ,isAlive;
	private Color color;

	/**
	 * Constructor de pelota
	 * 
	 * @param x
	 * @param y
	 */
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		color = new Color(46, 139, 87);
		isAlive = true;
	}

	/**
	 * Obtiene la forma de la pelota
	 * 
	 * @return Rectangle2D
	 */
	public Rectangle2D getRectangle() {
		return new Rectangle2D.Double(x, y, ancho, alto);

	}

	public void changeColor(Color color) {
		this.color = color;
	}
	/**
	 * Movimiento de la pelota
	 * 
	 * @param extremos
	 * @param golpea
	 * @param golpea2
	 * @param reinicioUno
	 * @param reinicioDos
	 */

	
	public Color getColor() {
		return color;
	}

	
	public void move(Rectangle extremos, boolean golpea, boolean golpea2, boolean reinicioUno, boolean reinicioDos) {

		x += dx;
		y += dy;
		if (reinicioUno) {
			x = 150;
			y = 200;
		} else if (reinicioDos) {
			x = 150;
			y = 200;
			dy = +dy;
			dx = -dx;
		}
		if (golpea == false && golpea2 == false) {
			if (x > 290) {
				dx = -dx;
			}
			if (y > 390) {
				dy = -dy;
			}
			if (x < 0) {
				dx = -dx;
			}
			if (y < 0) {
				dy = -dy;
			}
		} else if (golpea == true && golpea2 == false) {
			resultado = true;
			y = 354;
			dx = -dx;
			dy = -dy;
		} else if (golpea == false && golpea2 == true) {
			resultado = false;
			y = 40;
			dx = +dx;
			dy = -dy;
		}

	}

	/**
	 * Obtiene la coordena en x de la posicion de la pelota.
	 * 
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Obtiene la coordena en y de la posicion de la pelota.
	 * 
	 * @return int y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Obtiene el ancho de la figura base de la pelota.
	 * 
	 * @return int ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Obtiene el alto de la figura base de la pelota.
	 * @return int alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Confirma si la pelota intersecta con un poder.
	 * @return
	 */
	public boolean getResultado() {
		return resultado;
	}
	
	public void  setPosicion(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isVisible() {
		return isAlive;
	}
	
	public void setVisibilidad(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * cambia ultimo en golpear
	 * @param resultado
	 */
	public void changeRegusltado(boolean resultado) {
		this.resultado = resultado;
	}
	
}
