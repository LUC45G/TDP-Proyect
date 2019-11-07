package logicas;

import java.util.ArrayList;

import gameObjects.GameObject;

/**
 * Hilo encargado de mover a los enemigos
 *
 */
public class HiloPrincipal extends Thread {
	
	private ArrayList<GameObject> all;
	private GameObject g;
	private int size;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				System.out.println("HiloEnemigos=>"); e.printStackTrace();
			}
			
			all = DataStorage.GetInstance().GetAllObjects();
			size = all.size();
			
			
			for(int i = size-1; i >= 0; i--) {
				g = all.get(i);
				
				if(g.CanMove())
					g.Update();
				if(g.GetHitbox().getX()<=-10)
					Controller.GetInstance().lose();
				
			}
					
			
			
			Controller.GetInstance().Intersection();
			
			Controller.GetInstance().Update();
			
		}
	}
	
}
