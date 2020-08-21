package Aplicacion;

import java.awt.Color;

public class EmptyMarbel implements Pieces {
	private Color color;
	private MarbelGame mb;
	private int fila, columna;

	public EmptyMarbel(MarbelGame mb, int fila, int columna) {
		this.mb = mb;
		this.fila = fila;
		this.columna = columna;

	}

	public Color getColor() {
		return changeColor(color);
	}

	public Color changeColor(Color color) {
		this.color = color;
		return color;
	}

	public int getColumna() {
		return columna;
	}

	public int getFila() {
		return fila;
	}

	public final boolean isFilled() {
		return false;
	}

	public final boolean canMove() {
		return false;
	}

}
