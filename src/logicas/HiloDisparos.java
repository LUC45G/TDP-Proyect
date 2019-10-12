package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Hilo encargado de mover los disparos
 */
public class HiloDisparos extends Thread {
	
	private ArrayList<Rectangle> _shoots;
	
	public HiloDisparos() {
		_shoots = new ArrayList<Rectangle>();
	}
	
	public ArrayList<Rectangle> GetDisparos() {
		return _shoots;
	}
	
	public void AgregarDisparo() {
		// _shoots.add
	}
	
	public void run() {
		while(true) {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("HiloDisparos=>"); e.printStackTrace();
			}
			 
			for(Rectangle r : _shoots) {
				r.x-=3;
			}
		 }
	}

}
