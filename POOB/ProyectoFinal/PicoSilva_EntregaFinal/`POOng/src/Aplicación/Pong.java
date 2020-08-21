package Aplicación;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Modelamiento del juego.
 */
public class Pong {

	private Ball ball, ball2;
	private Personaje personaje1;
	private Personaje personaje2;
	private Bloques bloque;
	private Colision colision;
	private Poderes poder;
	private Nuevo_elemento nuevo_el;
	private String categoriaPuntaje;
	private Objetivos objetivo;
	private int puntaje1, puntaje2, conta = 0, contaTiempo = 0;;
	private boolean poderActivo, ultimoGolpear;
	private long tiempoEjecucion;
	
	

	/**
	 * Constructor
	 * 
	 * @param categoriaPuntaje
	 */
	public Pong(String categoriaPuntaje) {
		personaje1 = new Personaje(0, 0, 40, 35);
		personaje2 = new Personaje(240, 360, 40, 35);
		ball = new Ball(235, 20);
		colision = new Colision(this);
		hiloPoderes();
		puntaje1 = 0;
		puntaje2 = 0;
		poderActivo = false;
	}

	/**
	 * Retorna el puntaje del jugador uno
	 * 
	 * @return int puntaje1
	 */
	public int puntaje1() {
		return puntaje1;
	}

	/**
	 * Retorna el puntaje del jugador dos
	 * 
	 * @return int puntaje2
	 */
	public int puntaje2() {
		return puntaje2;
	}

	public int golpeaPuntaje() {
		int valorEntero = (int) Math.floor(Math.random() * (((puntaje1() + puntaje2()) / 2) - 2 + 1) + 2);
		return valorEntero;
	}

	/**
	 * Actualiza puntaje jugador uno
	 * 
	 * @param numero
	 */
	public void setPuntaje1(int numero) {
		puntaje1 += numero;
	}

	/**
	 * Actualiza puntaje jugador dos
	 * 
	 * @param numero
	 */
	public void setPuntaje2(int numero) {
		puntaje2 += numero;
	}
	
	/**
	 * Cambia puntaje jugador 1
	 * 
	 * @param numero
	 */
	public void cambiarPuntaje1(int numero ) {
		puntaje1 = numero;
	}
	/**
	 * Cambia puntaje jugador 2
	 * 
	 * @param numero
	 */
	public void cambiarPuntaje2(int numero ) {
		puntaje2 = numero;
	}
	/**
	 * Sumatoria de puntaje jugador uno
	 */
	public void puntoPersonaje1() {
		puntaje1++;
	}

	/**
	 * Sumatoria de puntaje jugador dos
	 */
	public void puntoPersonaje2() {
		puntaje2++;
	}

	
	/**
	 * Retorna el personaje uno pedido
	 * 
	 * @return Personaje personaje1
	 */
	public Personaje getPersonaje1() {
		return personaje1;
	}

	/**
	 * Retorna el personaje dos pedido
	 * 
	 * @return Personaje personaje2
	 */
	public Personaje getPersonaje2() {
		return personaje2;
	}

	/**
	 * Retrona la pelota pedida
	 * 
	 * @return Ball ball
	 */
	public Ball getBall() {
		return ball;
	}

	/**
	 * Retorna el bloque pedido
	 * 
	 * @returnBloques bloque
	 */
	
	public Bloques getBloque() {
		return bloque;
	}
	public void crearBloque() {
		if(colision.colisionPoder() || colision.colisionObjetivo() && bloque == null) {
			ultimoGolpear = ball.getResultado();
			if(ultimoGolpear) {
				bloque = new Bloques((int) Math.floor(Math.random()*(270-20+1)+20),150);
			}else {
				bloque = new Bloques((int) Math.floor(Math.random()*(270-20+1)+20),250);
			}
		}
	}
	/**
	 * Método encargado de la acción del bloque sobre un personaje
	 */
	public void accionBloque(){
		if(colision.colisionBloqueP1()) {
			personaje1.quitarFortalezaBloque();
			eliminarBloques();
		}else if(colision.colisionBloqueP2()) {
			personaje2.quitarFortalezaBloque();
			eliminarBloques();
		}
	} 
	/**
	 * sumatoria contador
	 */

	public void sumarConta() {
		conta++;
	}

	/**
	 * Retorna la colision pedida
	 * 
	 * @return Colision colision
	 */

	public Colision getColision() {
		return colision;
	}
	/**
	 * Elimina un bloque
	 */
	public void eliminarBloques() {
		bloque = null;
	}
	


	/**
	 * Retorna el objetivo pedido
	 * 
	 * @return Objetivos objetivo
	 */
	public Objetivos getObjetivo() {
		return objetivo;
	}

	/**
	 * Retorna el poder pedido
	 * 
	 * @return Poder poder
	 */
	public Poderes getPoder() {
		return poder;
	}

	/**
	 * Salvar juego actual
	 * 
	 * @param file
	 */
	public void salvar(File file) {

		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			if (getBall() != null) {
				try {
					bw.write("Pelota" + " " + getBall().getX() + " " + getBall().getY());
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (getPersonaje1() != null) {
				try {
					bw.write("Personaje1 " + " " + getPersonaje1().getX() + " " + getPersonaje1().getY() + " " + personaje1.getFortaleza());
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (getPersonaje2() != null) {
				try {
					bw.write("Personaje2" + " " + getPersonaje2().getX() + " " + getPersonaje2().getY() + " " + personaje2.getFortaleza());
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				bw.write("Puntaje1" + " " + puntaje1());
				bw.newLine();
				bw.write("Puntaje2 " + " " + puntaje2());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abrir un juego nuevo
	 * 
	 * @param file
	 */
	public void abrir(File file) {
		String cadena;
		String[] cadena2;
		FileReader in;
		try {
			in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			while ((cadena = br.readLine()) != null) {
				cadena2 = cadena.split(" ");
				if (cadena2[0] == "Pelota ") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					ball.setPosicion(num1, num2);
				} else if (cadena2[0] == "Personaje1 ") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					int num3 = Integer.parseInt(cadena2[3]);
					personaje1.setPosicion(num1, num2);
					personaje1.setFortaleza(num3);

				} else if (cadena2[0] == "Personaje2 ") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					int num3 = Integer.parseInt(cadena2[3]);
					personaje2.setPosicion(num1, num2);
					personaje2.setFortaleza(num3);
				}else if(cadena2[0] == "Puntaje1") {
					int num1 = Integer.parseInt(cadena2[1]);
					cambiarPuntaje1(num1);
				}else if(cadena2[0] == "Puntaje2") {
					int num1 = Integer.parseInt(cadena2[1]);
					cambiarPuntaje2(num1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * El funcionamiento del hilo es dar aleatoriamente al juego un poder cada diez
	 * segundos. adicionalmente aca se crean tambien el nuevo elemento y los
	 * objetivos
	 */
	private void hiloPoderes() {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				poder = new Poderes((int) Math.floor(Math.random() * 279 + 1),
						(int) Math.floor(Math.random() * (40 - 360 + 1) + 360));

			}
		};
		TimerTask tarea2 = new TimerTask() {
			@Override
			public void run() {
				objetivo = new Objetivos((int) Math.floor(Math.random() * 279 + 1),
						(int) Math.floor(Math.random() * (40 - 360 + 1) + 360));
			}
		};
		TimerTask tiempo = new TimerTask() {
			@Override
			public void run() {
				contaTiempo += 1000;
			}
		};
		TimerTask new_Elemento = new TimerTask() {
			@Override
			public void run() {
				nuevo_el = new Nuevo_elemento((int) Math.floor(Math.random() * 279 + 1),
						(int) Math.floor(Math.random() * (40 - 360 + 1) + 360));
				;
			}
		};
		timer.schedule(tiempo, 0, 1000);
		timer.schedule(tarea, 0, 10000);
		timer.schedule(tarea2, 5000, 10000);
		timer.schedule(new_Elemento, 10000, 10000);
	}

	/**
	 * Obtiene el tiempo de ni idea xdd
	 * 
	 * @return
	 */
	public int getTiempo() {
		return contaTiempo;
	}

	/**
	 * Elimina objetivo
	 */
	public void eliminarObjetivo() {
		objetivo = null;
	}

	/**
	 * Elimina poder
	 */
	public void eliminarPoder() {
		poder = null;
	}

	/**
	 * Funcionamiento poderes
	 */
	public void colisionBola() {
		if(colision.colisionPoder() || colision.colisionObjetivo()) {
			crearBloque();
		}
		if (poder != null) {
			if (poder.getNamePoder() == "Freezer") {
				ultimoGolpear = ball.getResultado();
				tiempoEjecucion = 3000;
				poderActivo = true;
				comprobarFreezer();
			} else if (poder.getNamePoder() == "Turtle") {
				ultimoGolpear = ball.getResultado();
				tiempoEjecucion = 3000;
				poderActivo = true;
				comprobarTurtle();
			} else if (poder.getNamePoder() == "Cold") {
				Color nieve = new Color(0, 206, 209);
				ultimoGolpear = ball.getResultado();
				tiempoEjecucion = 3000;
				poderActivo = true;
				comprobarColdPersonajeUno(nieve);
				comprobarColdPersonajeDos(nieve);
			} else if (poder.getNamePoder() == "Energy") {
				ultimoGolpear = ball.getResultado();
				if (ultimoGolpear == true) {
					personaje2.recuperaFortaleza();
				} else {
					personaje1.recuperaFortaleza2();
				}
			} else if (poder.getNamePoder() == "Phantom") {
				ultimoGolpear = ball.getResultado();
				comprobarPhantom();

			}
		}
	}

	/**
	 * Funcionamiento poderes
	 */
	public String comprobarPoderHilo() {
		String cadena = "";
		if (colision.colisionPoder()) {
			cadena = poder.getNamePoder();
			// eliminarPoder();
		}
		return cadena;
	}

	/**
	 * Funcionamiento poderes
	 */
	public void comprobarFreezer() {
		if (poderActivo) {
			if (ultimoGolpear == true) {
				if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
					personaje1.setMove(true);
				} else {
					personaje1.setMove(false);
					// poderActivo = false;
				}
			} else {
				if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
					personaje2.setMove(true);

				} else {
					personaje2.setMove(false);
					// poderActivo = false;
				}
			}
		}
	}

	/**
	 * Funcionamiento poderes
	 */
	public void comprobarTurtle() {
		if (poderActivo) {
			if (ultimoGolpear == true) {				
				if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
					personaje1.setMove(true);
				} else {
					personaje1.setMove(false);
					// poderActivo = false;
				}
			} else {
				if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
					personaje2.setMove(true);

				} else {
					personaje2.setMove(false);
					// poderActivo = false;
				}
			}

		}
	}

	/**
	 * Funcionamiento poderes
	 */
	public void comprobarColdPersonajeUno(Color nieve) {
		if (colision.colisionPoder()) {
			ball.changeColor(nieve);
		}
		if (poderActivo) {
			if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
				personaje1.setMove(true);
			} else {
				if (ball.getColor().equals(nieve) && colision.colisionP1()) {
					personaje1.setMove(false);
					Color color = new Color(46, 139, 87);
					ball.changeColor(color);
				}
			}
		}
	}

	/**
	 * Funcionamiento poderes
	 */
	public void comprobarColdPersonajeDos(Color nieve) {
		if (colision.colisionPoder()) {
			ball.changeColor(nieve);
		}
		if (poderActivo) {
			if (System.currentTimeMillis() - colision.tiempo() >= tiempoEjecucion) {
				personaje2.setMove(true);
			} else {
				if (ball.getColor().equals(nieve) && colision.colisionP2()) {
					personaje2.setMove(false);
					Color color = new Color(46, 139, 87);
					ball.changeColor(color);
				}

			}
		}
	}

	/**
	 * Funcionamiento poderes
	 */
	public void comprobarPhantom() {

		if (colision.colisionPoder()) {
			if (ultimoGolpear == true) {
				ball.setVisibilidad(false);
				ball2 = new Ball(280, 360);
				if (ball2.getY() < 200) {
					ball2 = null;
				}
			} else {
				ball.setVisibilidad(false);
				ball2 = new Ball(20, 50);
				if (ball2.getY() > 200) {
					ball2 = null;
				}
			}
		}
	}

	/**
	 * Colision Objetivo
	 */
	public void colisionObjetivo() {
		ultimoGolpear = ball.getResultado();
		if(colision.colisionObjetivo()) {
			if(ultimoGolpear) {
				setPuntaje2(golpeaPuntaje());
				eliminarObjetivo();
			}else {
				setPuntaje1(golpeaPuntaje());
				eliminarObjetivo();
			}
		}
	}
	
	/**
	 * Retorna la pelota número dos
	 * @return Ball ball2
	 */
	public Ball getBall2() {
		return ball2;
	}
}
