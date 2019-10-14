package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

import gameObjects.Disparo;

/**
 * Hilo encargado de mover los disparos
 */
public class HiloDisparos extends Thread {
	
	private ArrayList<Rectangle> _shootHitboxes;
	private Controller 			 _controller;
	
	public HiloDisparos() {
		_shootHitboxes 	= new ArrayList<Rectangle>();
		_controller = null;
	}
	
	public void SetController(Controller c) {
		_controller = c;
	}
	
	public ArrayList<Rectangle> GetHitboxes() {
		return _shootHitboxes;
	}
	
	public void AgregarDisparo(Disparo d) {
		_shootHitboxes.add(d.GetHitbox());
	}
	
	public void run() {
		while(true) {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("HiloDisparos=>"); e.printStackTrace();
			}
			 
			for(Rectangle r : _shootHitboxes) 
				r.x-=3;
			
			_controller.Update();
			
			System.out.println("Un tic -> size: " + _shootHitboxes.size());
		 }
	}

}
