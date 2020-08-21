package Aplicacion;
import java.awt.Color;

public class Barrier implements Pieces{
    private MarbelGame mb;
    private int fila,columna;
    
    public Barrier(MarbelGame mb, int fila, int columna){
        this.mb=mb;
        this.fila = fila;
        this.columna = columna;
    }
    
    @Override
    public Color getColor() {
    	Color newColor = new Color(225,0,78);
        return newColor;
    }
    
    public boolean canMove() {
        return false;
    }
    
    public int getForma(){
        return BARRERA;
    }
    
	public int getColumna() {
		return columna;
	}
	
	public int getFila() {
		return fila;
	}
}