package Presentación;

/**
 * Clase Movement, permite el movimiento de los objetos necesarios para el juego
 * Extiende de la clase multitarea "Thread" ya que son varios objetos moviendose al tiempo.
 */
public class Movement extends Thread{
	private Imagen grafico;
	
	public Movement(Imagen grafico) {
		this.grafico = grafico;	
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			grafico.repaint();
		}
	}
	
	
	

}
