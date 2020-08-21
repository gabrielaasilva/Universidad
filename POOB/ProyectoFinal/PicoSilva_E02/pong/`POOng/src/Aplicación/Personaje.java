package Aplicación;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personaje extends JLabel{
	private int x, y;
	

	public Personaje(ImageIcon imagen){
		this.x = x;
		this.y = y;
		
	}

	public JLabel getPersonaje() {
		return new JLabel();
	}

	public void movientoDerecha() {
		int x1 = this.getX();
		if (x1 < 240) {
			x1 += 20;
			this.setBounds(x1, this.getY(), 60, 55);
		}
		
	}

	public void movientoIzquierda() {
		int x1 = this.getX();
		if (x1 > 0) {
			x1 -= 20;
			this.setBounds(x1, this.getY(), 60, 55);
		}

	}

}
