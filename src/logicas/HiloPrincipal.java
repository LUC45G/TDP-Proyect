package logicas;

import java.util.ArrayList;

import gameObjects.GameObject;

/**
 * Hilo encargado de mover a los enemigos
 *
 */
public class HiloPrincipal extends Thread {
	
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