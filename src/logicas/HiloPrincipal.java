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
	private boolean _stop, _realStop;
	
	
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
				
				if(_stop)
					_realStop = _realStop && g.notificar();
				
				g.Update();
				
				if(g.GetHitbox().getX()<=-10)
					g.GetVisitor().visitLose();
				
			}
			
			_stop = _realStop;
			
			Controller.GetInstance().Intersection();
			
			Controller.GetInstance().Update();			
		}
	}

	public void StopEverything() {
		_stop = true;
		_realStop = true;
	}
	
}
