package Aplicacion;

import java.awt.Color;

public class FillMarbel implements Pieces {
	
	
	private Color color;
	private MarbelGame mb;
	private int fila,columna;
	
	
	public FillMarbel(MarbelGame mb, int fila, int columna) {
		this.mb=mb;
		this.fila = fila;
		this.columna = columna;
		
	}
	
	public int getColumna() {
		return columna;
	}
	
	public int getFila() {
		return fila;
	}
	
	public Color getColor() {
        return changeColor(color);
    }

        public Color changeColor(Color color){
        this.color=color;
        return color;
    }

}
