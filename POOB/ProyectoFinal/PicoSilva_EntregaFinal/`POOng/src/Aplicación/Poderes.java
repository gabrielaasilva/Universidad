package Aplicación;

import java.awt.geom.Rectangle2D;

import java.awt.geom.Rectangle2D.Double;

/**
 * Diseño de poderes
 */
public class Poderes {

	private final int alto = 35, ancho = 35;
	private int x, y, numero;
	private long tiempo,duracion;
	private String[] powers = { "Fastball", "Freezer", "Flash", "Turtle", "Cold", "Phantom", "Energy" };

	public Poderes(int x, int y) {
		this.x = x;
		this.y = y;
		tiempo = 0 ;
		duracion = 0;
		numero = (int) Math.floor(Math.random() * (0 - 6) + 6);
	}

	/**
	 * Obtiene la figura base del poder
	 * @return Rectangle2D
	 */

	public Rectangle2D getFiguraPoder() {
		return new Rectangle2D.Double(x, y, ancho, alto);
	}

	/**
	 * Obtiene el nombre del poder
	 * 
	 * @return String nombre
	 */
	public String getNamePoder() {
		return powers[numero];
	}
	 
	/**
	 * Coloca un poder en especifico 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Obtiene la coordena en x de la posicion del poder.
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Obtiene la coordena en y de la posicion del poder.
	 * @return int y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Obtiene el alto de la figura
	 * @return int alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * Obtiene el ancho de la figura
	 * @return int ancho
	 */
	public int getAncho() {
		return ancho;
	}

	
	public long iniciar() {
		return System.currentTimeMillis();
	} 
	
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
