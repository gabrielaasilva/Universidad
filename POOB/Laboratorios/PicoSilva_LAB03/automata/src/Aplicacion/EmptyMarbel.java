package src.Aplicacion;

import java.awt.Color;

public class EmptyMarbel implements Pieces {
	private Color[] colores = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.YELLOW,Color.ORANGE,Color.PINK,
			Color.RED};
	private MarbelGame mb;
	private int fila,columna;
	
	
	public EmptyMarbel(MarbelGame mb, int fila, int columna) {
		this.mb=mb;
		this.fila = fila;
		this.columna = columna;
		
	}
	@Override
	public Color getColor() {
		
		return Color.BLUE;
	}

	
	public int getFila() {
		return fila;
	}
	
	public int getColomna() {
		return columna;
	}	
	
	public final boolean isFilled() {
		return false;
	}	

	
}
