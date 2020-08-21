package Aplicación;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Ball {
	private final int alto = 5;
	private final int ancho = 5;
	private int x, y;
	private int dx = 1, dy = 1;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle2D getBall() {
		return new Rectangle2D.Double(x, y, ancho, alto);

	}

	public void move(Rectangle extremos, boolean golpea, boolean golpea2, boolean reinicioUno, boolean reinicioDos) {
		x += dx;
		y += dy;
		if (reinicioUno) {
			x = 150;
			y = 200;
		}else if(reinicioDos) {
			x = 150;
			y =200;
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
			y = 335;
			dx = -dx;
			dy = -dy;
		} else if (golpea == false && golpea2 == true) {
			y = 60;
			dx = +dx;
			dy = -dy;
		}

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
