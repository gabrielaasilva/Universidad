package Presentación;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Repetidor de la tarea dentro de un timer.
 * @author 57301
 *
 */
public class Repetidor extends TimerTask{

	private Timer ti;
	
	public Repetidor(Timer ti ) {
		this.ti = ti;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Yo no quiero entrar :C");
		ti.cancel();
	}
	
}
