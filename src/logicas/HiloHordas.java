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
		private boolean 			 _end;
		private boolean				 _alreadyStarted;
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
		
		public void End() {
			_end = true;
		}
		
		public void crearHordas(int dificultad) {
			_dificultad = dificultad;
			_end 		= false;
			
			if(!_alreadyStarted) {
				_alreadyStarted = true;
				this.start();
			}
			else
				this.run();
		}
		public void AgregarEnemigo(Enemy e) {
			_enemiesHitboxes.add(e.GetHitbox());
		}
		private void SpawnEnemies() {
			Random r = new Random();
			// Generar enemigo y spawnearlo en la grafica
			int y = r.nextInt(6);
			int rng = r.nextInt(6);
			ImageIcon e = _generator.GetEnemy(rng, y);
			_controller.spawnEnemie(e);
			
		}
		
		public void run() {
			while(_freno<_dificultad*5 && !_end) {
				 try {
					this.SpawnEnemies();
					_freno++;
					Thread.sleep(1500);
				} catch (InterruptedException e) { 
					_end = true;
				}
			}
		}

}


