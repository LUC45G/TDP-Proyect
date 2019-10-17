package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

import gameObjects.Enemy;
import gameObjects.GameObject;

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
				Thread.sleep(450);
			} catch (InterruptedException e) {
				System.out.println("HiloEnemigos=>"); e.printStackTrace();
			}
			
			ArrayList<GameObject> all = DataStorage.GetInstance().GetAllObjects();
			
			for(GameObject g : all) {
				if(Controller.GetInstance().puedeAvanzar(g.GetHitbox()))
					g.Move();
			}
			
			Controller.GetInstance().Update();
			
		}
	}
	
}
