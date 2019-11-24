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
		private Generator       	 _generator;
		private int					 _dificultad;
		private int 				 _freno;		
		private int 				 _cantidadSpawneada;
		private int 				 _nivel;
		private boolean 			 _end;
		private boolean				 _alreadyStarted;
		private Random				 _rng;
		
		public HiloHordas() {
			_enemiesHitboxes 	= new ArrayList<Rectangle>();
			_controller = null;
			_generator=null;
			_dificultad = 0;
			_freno=0;
			_nivel = 1;
			_rng = new Random();
		}
		
		private void SpawnMapElements() {
			int aux, x, y, index;
			for (int i = 0; i < 6; i++) {
				aux = _rng.nextInt(100);
				
				if (aux % (2 + _dificultad) == 0) {
					y = i * 90;
					x = _rng.nextInt(Controller.GetInstance()._mapWidth / 2);
					
					index = _rng.nextInt(100) % 2;
					Controller.GetInstance().SpawnInMap(x, y, _generator.GetMapElement(index));
				}
				
			}
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

		public void SubEnemy() {
			_cantidadSpawneada--;
			
			if(_cantidadSpawneada == 0)
				Controller.GetInstance().Win();
		}
		
		public void crearHordas(int dificultad) {
			_dificultad = dificultad;
			_nivel = _dificultad / 3;
			_end 		= false;
			SpawnMapElements();
			
			if(!_alreadyStarted) {
				_alreadyStarted = true;
				this.start();
			}
			else {
				this.run();
			}
			
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
			_controller.spawnEnemy(e);
			
		}
		
		public void run() {
			
			int sleepTime = 4500 / (_dificultad/3) * 2;
			_cantidadSpawneada = _dificultad*3;
			
			while(_freno<_dificultad*3 && !_end) {
				 try {
					this.SpawnEnemies();
					_freno++;
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) { 
					_end = true;
				}
			}
		}

		public int GetNivel() {
			return _nivel;
		}

}



