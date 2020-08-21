package src.Aplicacion;

import java.awt.Color;
import java.util.Random;

public class MarbelGame {
	private Pieces[][] pieces;
	private int size, canicas, barreras;
	private boolean x;
	private boolean y;

	public MarbelGame(int size, int canicas, int barreras) {
		this.size = size;
		this.canicas = canicas;
		this.barreras = barreras;
		pieces = new Pieces[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				
				pieces[i][j] = null;
			}
		}
		drawEmpty();
		drawFill();
		for(Pieces[] i:pieces) {
			System.out.println(i);
			for(Pieces j:i ) {
				
			}
		}
		
	}

	private void drawFill() {
		int numero1, numero2;
		for (int i = 0; i < canicas; i++) {
			numero1 = (int) (Math.random() * size);
			numero2 = (int) (Math.random() * size);

			if (getPieces(numero1, numero2) == null) {
				setPieces(numero1, numero2, new FillMarbel(this, numero1, numero2));
			} else {
				numero1 = (int) (Math.random() * size);
				numero2 = (int) (Math.random() * size);
				setPieces(numero1, numero2, new FillMarbel(this, numero1, numero2));
			}
		}

	}

	private void drawEmpty() {
		int numero, conta = 0;
		getRandomBooleanX();
		getRandomBooleanY();
		for (int i = 0; i < canicas; i++) {
			numero = (int) (Math.random() * size);
			System.out.println(numero);
			if (x) {
				if (conta == canicas) {
					break;
				}
				setPieces(0, numero, new EmptyMarbel(this, 0, numero));
				conta++;
			} else if (x == false) {
				if (conta == canicas) {
					break;
				}
				setPieces(size - 1, numero, new EmptyMarbel(this, size - 1, numero));
				conta++;
			}
			if (y) {
				if (conta == canicas) {
					break;
				}
				System.out.println("no entro nunca");
				setPieces(numero, 0, new EmptyMarbel(this, numero, 0));
				conta++;
			} else if (y == false) {
				if (conta == canicas) {
					break;
				}
				System.out.println("no entro nunca");
				setPieces(numero, size - 1, new EmptyMarbel(this, numero, size - 1));
				conta++;
			}

		}
	}

	public boolean getRandomBooleanX() {
		x = Math.random() < 0.5;
		return x;

	}

	public boolean getRandomBooleanY() {
		y = Math.random() < 0.5;
		return y;

	}

	public Pieces getPieces(int fila, int columna) {
		return pieces[fila][columna];
	}

	public void setPieces(int fila, int columna, Pieces nuevo) {
		pieces[fila][columna] = nuevo;
	}

}
