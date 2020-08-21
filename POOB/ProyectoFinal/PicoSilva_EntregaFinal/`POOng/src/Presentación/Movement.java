	package Presentación;

import javax.swing.JLabel;

/**
 * Clase Movement, permite el movimiento de los objetos necesarios para el juego
 * Extiende de la clase multitarea "Thread" ya que son varios objetos moviendose
 * al tiempo.
 */
public class Movement extends Thread {
	private Imagen grafico;
	private String poder;
	private String tipo;
	private int numero;
	private Game juego;
	
	public Movement(Imagen grafico) {
		this.grafico = grafico;
		long tiempo = System.currentTimeMillis();
	}

	@Override
	public void run() {
		int conta = 150;
		while (true) {
			grafico.setPuntajes();
			grafico.setFortaleza();
			if (poder == "Flash") {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (poder == "Fastball") {
				System.out.println("Entro al hilo");
				try {
					Thread.sleep((long) (numero - (numero * 0.2)));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				if (tipo == "Fast") {
					try {
						Thread.sleep(5);
						numero = 5;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (tipo == "Slow") {
					try {
						Thread.sleep(12);
						numero = 12;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (tipo == "Increase") {
					try {
						if (conta > 0) {
							Thread.sleep(conta);
							conta--;
							numero = conta;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
			grafico.repaint();
		}

	}

	/**
	 * Actualiza la variable g
	 * 
	 * @param g
	 */
	public void setPoder(String g) {
		poder = g;
		System.out.println("poder en hilo : "+poder);
	}

	/**
	 * Actualiza la variable tipo
	 * 
	 * @param tipo
	 */
	public void setTipoPelota(String tipo) {
		this.tipo = tipo;

	}

}
