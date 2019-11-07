package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import gameObjects.*;

public class Generator {
	
	protected ArrayList<Enemy>  _enemies;		 // Lista de enemigos a clonar
	protected ArrayList<ImmovableObject> _powerUps;
	protected HiloPrincipal 	_mainThread;	 // Hilo principal
	protected DataStorage 		_dataStorage; 	 // Almacenamiento de cosas
	
	public Generator() {
		_enemies 	= new ArrayList<Enemy>();
		_powerUps 	= new ArrayList<ImmovableObject>();
		_dataStorage= DataStorage.GetInstance();
		
		/* Inicializar la lista */
		_enemies.add(new Enemy1(0, 0));
		_enemies.add(new EnemyBoss(0, 0));
		_enemies.add(new EnemyFast(0, 0));
		_enemies.add(new EnemyFat(0, 0));
		_enemies.add(new EnemySlim(0, 0));
		_enemies.add(new EnemyStrong(0, 0));
		
		/* Inicializar la lista de power ups */
		_powerUps.add(new Barricada());
		_powerUps.add(new EscudoProtector());
		_powerUps.add(new Diente());
		_powerUps.add(new BombaAtomica());
		_powerUps.add(new BombaCongelante());
		
		
		/* Inicializo el hilo */
		_mainThread = new HiloPrincipal();
		_mainThread.start();
	}
	
	public ArrayList<Rectangle> GetHitboxes() {
		ArrayList<Rectangle> tr = new ArrayList<Rectangle>();
		for(Enemy e : _enemies) {
			tr.add(e.GetHitbox());
		}
		return tr;
	}
	
	/**
	 * Crea un enemigo y devuelve su sprite
	 * @param i Indice del enemigo a crear
	 * @param y Posicion en Y donde spawnear
	 * @return Sprite del enemigo
	 */
	public ImageIcon GetEnemy(int i, int y) {
		Enemy e = (Enemy) _enemies.get(i).Clone();
		e.SetController(Controller.GetInstance());
		_dataStorage.Store(e);
		e.SetX(700); e.SetY(y*90);
		return e.GetSprite();
	}
	
	public ImmovableObject GetPowerUp(int i) {
		return _powerUps.get(i).Clone();
	}

}
