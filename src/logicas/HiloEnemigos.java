package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

import gameObjects.Enemy;

/**
 * Hilo encargado de mover a los enemigos
 *
 */
public class HiloEnemigos extends Thread {

	private ArrayList<Rectangle>  _enemiesHitboxes;
	
	public HiloEnemigos() {
		_enemiesHitboxes = new ArrayList<Rectangle>();
	}
	
	public ArrayList<Rectangle> GetHitboxes() {
		return _enemiesHitboxes;
	}
	
	public void AgregarEnemigo(Enemy e) {
		_enemiesHitboxes.add(e.GetHitbox());
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("HiloEnemigos=>"); e.printStackTrace();
			}
			
			for(Rectangle r : _enemiesHitboxes) 
				r.x-=7;
			
			
			
		}
	}
	
}
