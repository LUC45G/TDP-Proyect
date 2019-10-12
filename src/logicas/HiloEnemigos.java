package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Hilo encargado de mover a los enemigos
 *
 */
public class HiloEnemigos extends Thread {

	private ArrayList<Rectangle> _enemies;
	
	public HiloEnemigos() {
		_enemies = new ArrayList<Rectangle>();
	}
	
	public ArrayList<Rectangle> GetEnemigos() {
		return _enemies;
	}
	
	public void AgregarEnemigo(Rectangle r) {
		_enemies.add(r);
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("HiloEnemigos=>"); e.printStackTrace();
			}
			
			for(Rectangle r : _enemies) 
				r.x-=7;
			
		}
	}
	
}
