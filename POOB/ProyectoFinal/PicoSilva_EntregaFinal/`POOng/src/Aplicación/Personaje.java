package Aplicación;

import java.awt.Rectangle;

import javax.swing.JLabel;

/**
 * Diseño de personaje
 */
public class Personaje {
	private int x, y, ancho, alto;
	private int fortaleza = 500, conta  = 0,conta2  = 0;
	private boolean canMove;
	private boolean quitarFortaleza;
	private String confirmacion = "si entra";
	private long tiempoIni, tiempoFina;
	public Personaje(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		canMove = true;
		quitarFortaleza = false;
	}
	
	/**
	 * Obtiene la coordena en x de la posicion del personaje.
	 * @return int x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Obtiene la coordena en y de la posicion del personaje.
	 * @return int y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Obtiene el ancho de la figura base del personaje.
	 * @return int ancho 
	 */
	public int getAncho() {
		return ancho;
	}
	
	/**
	 * Obtiene el alto de la figura base del personaje.
	 * @return int alto 
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * Actualiza la posición del personaje.
	 * @param x
	 * @param y
	 */
	public void actualizarPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Permite mover a la izquierda el personaje
	 * @return int x
	 */
	public int moverIzquierda() {
		if(canMove) {
			if (x > 0) {
				x -= 20;
				quitarFortaleza();
			}
		}
		return x;
	}
	/**
	 * Permite mover a la derecha el personaje
	 * @return int x
	 */
	public int moverDerecha() {
		if(canMove) {
			if (x < 260) {
				x += 20;
				quitarFortaleza();
			}	
		}
		return x;
	}
	
	public void setMove(boolean hola) {
		canMove = hola;
	}
	
	/**
	 * Da el valor de fortaleza que tenga el personaje
	 * @return fortaleza
	 */
	public int getFortaleza() {
		return fortaleza;
	}
	/**
	 * Actualiza el valor de la fortaleza
	 * @param forleza
	 */
    public void setFortaleza(int forleza) {
        this.fortaleza = fortaleza;
    }
    
    /**
     * Disminuye en 10 el valor de fortaleza al personaje cada vez que golpea la pelota
     */
    public void golpeaPelota() {
        fortaleza-=5;
    }
    
    public void setPosicion(int x, int y) {
    	this.x = x;
    	this.y = y;
 
    }

    public int moverDespacioDer() {
    	if (x < 240) {
			x += 5;
		}
    	return x;
    }
    
    public int moverDespacioIzq() {
    	if (x > 0) {
			x -= 5;
		}
    	return x;
    }
 
    public void recuperaFortaleza() {
    	if (conta  ==0) {
    		fortaleza += fortaleza*0.5;
    		conta++;
    	}
    	
    }
    
    public void recuperaFortaleza2() {
    	if (conta2  ==0) {
    		fortaleza += fortaleza*0.5;
    		conta2++;
    	}
    	
    }
    
    public void quitarFortaleza() {
    	fortaleza-=2;
    }
    
    public void quitarFortalezaBloque() {  
  		fortaleza = (int) (fortaleza*0.5);
    	
    }
    
    /*
     * 
     * */
    

    public void quitarFortalezaElemento() {
    	if(quitarFortaleza == false && confirmacion == "si entra") {
    		quitarFortaleza = true;
    		confirmacion = "";
    		}else {
    		quitarFortaleza = false;
    	}
    }
    

	
	
	public void getTiempo() {
		tiempoFina = System.currentTimeMillis();
	}
	
	public void setX(int x) {
		this.x=x;
		fortaleza -=5;
	}
}
