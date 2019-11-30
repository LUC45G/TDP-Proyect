package logicas.Hilos;

import java.util.ArrayList;

import gameObjects.GameObject;
import logicas.Controller;
import logicas.DataStorage;

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
				
				
				g.Update();
				
				if(g.get_hitbox().getX()<=-10)
					g.get_visitor().visitLose();
				
			}
			
			
			Controller.GetInstance().Intersection();
			
			Controller.GetInstance().Update();			
		}
	}

	
}
