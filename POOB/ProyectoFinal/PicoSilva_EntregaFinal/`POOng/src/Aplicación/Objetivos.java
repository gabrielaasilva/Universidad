package Aplicación;

import java.awt.geom.Rectangle2D;

public class Objetivos {
	private final int alto = 35, ancho = 35;
	private int x , y ; 
	
	public Objetivos(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public Rectangle2D getFiguraObjetivo() {
		return new Rectangle2D.Double(x,y,ancho,alto);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
}
