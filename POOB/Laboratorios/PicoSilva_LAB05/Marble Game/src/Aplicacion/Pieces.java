package Aplicacion;

import java.awt.Color;

public interface Pieces {
	int MARBLE = 0;
	int BARRERA = 1;
	
	default int getForma() {
		return MARBLE;		
	}
	
	default boolean isFilled() {
		return true;
	}
	
	default boolean canMove(){
		return true;
	}
	
	default int getColumna(){
		return 0;
	}
	
	default int getFila() {
		return 0; 
	}
	Color getColor();
}
