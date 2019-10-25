package logicas;

	
	import java.awt.Rectangle;
	import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import gameObjects.Enemy;

	/**
	 * Hilo encargado de generar las hordas
	 */
	public class HiloHordas extends Thread {
		
		private ArrayList<Rectangle> _enemiesHitboxes;
		private Controller 			 _controller;
		private EnemyGenerator       _generator;
		private int					 _dificultad;
		private int 				 _freno;		
		public HiloHordas() {
			_enemiesHitboxes 	= new ArrayList<Rectangle>();
			_controller = null;
			_generator=null;
			_dificultad = 0;
			_freno=0;
		}
		
		public void SetController(Controller c) {
			_controller = c;
			_generator=c.getGenerator();
		}
		
		public ArrayList<Rectangle> GetHitboxes() {
			return _enemiesHitboxes;
		}
		
		public void crearHordas(int dificultad) {
			_dificultad=dificultad;
			if(this.isInterrupted())
				this.resume();
				//des interrupir but no se xq no anda
			else
				this.start();
		}
		public void AgregarEnemigo(Enemy e) {
			_enemiesHitboxes.add(e.GetHitbox());
		}
		private void SpawnEnemies() {
			Random r = new Random();
			int y;
			// Generar enemigo y spawnearlo en la grafica
			y = r.nextInt(6);
			//rng = r.nextInt( Cantidad De Enemigos );
			ImageIcon e = _generator.GetEnemy(0, y);
			_controller.spawnEnemie(e);
			
		}
		
		public void run() {
			while(true) {
				 try {
					while(_freno<_dificultad*5) {
						Thread.sleep(1000);
						this.SpawnEnemies();
						_freno++;
					}
					
				} catch (InterruptedException e) {
					System.out.println("HiloDisparos=>"); e.printStackTrace();
			}
				 
				
				
				
		}
	}

}



