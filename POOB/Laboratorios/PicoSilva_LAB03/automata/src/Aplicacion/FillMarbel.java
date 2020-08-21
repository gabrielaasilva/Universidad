package src.Aplicacion;

import java.awt.Color;

public class FillMarbel implements Pieces {

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLUE;
	}
	
	private MarbelGame mb;
	private int fila,columna;
	
	
	public FillMarbel(MarbelGame mb, int fila, int columna) {
		this.mb=mb;
		this.fila = fila;
		this.columna = columna;
		
	}
	
	public int getFila() {
		return fila;
	}
	
	public int getColomna() {
		return columna;
	}	

}
