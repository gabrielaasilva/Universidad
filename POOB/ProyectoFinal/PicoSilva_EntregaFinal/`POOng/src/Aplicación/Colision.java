package Aplicación;

import java.awt.Color;

/**
 *Diseño de colisión 
 */
public class Colision {

	private Pong pong;
	private long tiempoEjecucion;
	
	public Colision(Pong pong) {
		this.pong = pong;
	}
	
/**
 * Permite saber si el personaje uno intersecta con la pelota
 * @return boolean val
 */
	public boolean colisionP1() {
		boolean val;
		if ((pong.getBall().getRectangle().getX() < pong.getPersonaje1().getX() + pong.getPersonaje1().getAncho()
				&& pong.getBall().getRectangle().getX() + pong.getBall().getRectangle().getWidth() > pong.getPersonaje1().getX())
				&& pong.getPersonaje1().getY() + pong.getPersonaje1().getAlto() == pong.getBall().getRectangle()
						.getY() && pong.getPersonaje1().getFortaleza()>=10) {

			val = true;
			pong.getPersonaje1().golpeaPelota();
		} else {
			val = false;
		}
		return val;
	}
	
	/**
	 * Permite saber si el personaje dos intersecta con la pelota
	 * @return boolean val
	 */
	public boolean colisionP2() {
		boolean val;
		if ((pong.getBall().getRectangle().getX() < pong.getPersonaje2().getX() + pong.getPersonaje2().getAncho()
				&& pong.getBall().getRectangle().getX() + pong.getBall().getRectangle().getWidth() > pong.getPersonaje2().getX())
				&& pong.getPersonaje2().getY() == pong.getBall().getRectangle().getY() + pong.getBall().getRectangle().getHeight() && pong.getPersonaje2().getFortaleza() >=10) {
			val = true;
			pong.getPersonaje2().golpeaPelota();
		} else {
			val = false;
		}
		return val;
	}
	
	/**
	 * Permite saber si el jugador uno hace un punto 
	 * @return boolean val
	 */
	public boolean puntajeUno() {
		boolean val;
		if (pong.getBall().getRectangle().getY() + pong.getBall().getAlto() == 390) {
			//System.out.println("PUNTAJE JUGADOR UNO : " + puntaje1);
			val = true;
			pong.puntoPersonaje1();
			System.out.println("Puntaje Uno : "+ pong.puntaje1());
		} else {
			val = false;
		}

		return val;
	}
	
	/**
	 * Permite saber si el jugador dos hace un punto 
	 * @return boolean val
	 */
	public boolean puntajeDos() {
		boolean val;
		if (pong.getBall().getRectangle().getY() == 0) {
			val = true;
			pong.puntoPersonaje2();
			System.out.println("Puntaje Dos : " + pong.puntaje2());
		} else {
			val = false;
		}
		return val;
	}
	
	/**
	 * colision Bloque
	 */
	public boolean colisionBloqueP1() {
		boolean val = false;
		if((pong.getBloque().getFiguraBloque().getX() < pong.getPersonaje1().getX() + pong.getPersonaje1().getAncho()
				&& pong.getBloque().getFiguraBloque().getX() + pong.getBloque().getFiguraBloque().getWidth() > pong.getPersonaje1().getX())
				&& pong.getPersonaje1().getY() + pong.getPersonaje1().getAlto() == pong.getBloque().getFiguraBloque().getY()) {
			val = true;
		}else {
			val = false;
		}
		return val;
	}

	
	/**
	 * colision Bloque
	 */
	public boolean colisionBloqueP2() {
		boolean val = false;
		if((pong.getBloque().getFiguraBloque().getX() < pong.getPersonaje2().getX() + pong.getPersonaje2().getAncho()
				&& pong.getBloque().getFiguraBloque().getX() + pong.getBloque().getFiguraBloque().getWidth() > pong.getPersonaje2().getX())
				&& pong.getPersonaje2().getY() + pong.getPersonaje1().getAlto() == pong.getBloque().getFiguraBloque().getY()) {
			val = true;
		}else {
			val = false;
		}
		return val;
	}

	/**
	 * colisionPoder
	 */
	
	public boolean colisionPoder() {
		boolean val = false;;
		if(pong.getPoder() !=null) {
			if(pong.getBall().getRectangle().intersects(pong.getPoder().getFiguraPoder())) {
				System.out.println("deberia ser true");
				tiempoEjecucion = pong.getPoder().iniciar();
				val = true;
				return val;
			}
		}
		return val;
	}

	/**
	 * colision Objetivo
	 */
	public boolean colisionObjetivo() {
		boolean val = false;;
		if(pong.getObjetivo() !=null) {
			if(pong.getBall().getRectangle().intersects(pong.getObjetivo().getFiguraObjetivo())) {
				val = true;
			}
		}
		return val;
	}
	
	/**
	 * retorna el tiempo de ejecución de inicio
	 * @return long 
	 */	
	public long tiempo() {
		return tiempoEjecucion;
	}

}
