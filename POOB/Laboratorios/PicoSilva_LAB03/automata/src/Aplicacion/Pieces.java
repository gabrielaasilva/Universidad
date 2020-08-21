package src.Aplicacion;

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
	Color getColor();
}
