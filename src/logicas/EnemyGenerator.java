package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import gameObjects.*;

public class EnemyGenerator {
	
	protected ArrayList<Enemy>  _enemies;		 // Lista de enemigos a clonar
	protected HiloPrincipal 	_mainThread;	 // Hilo principal
	protected DataStorage 		_dataStorage; 	 // Almacenamiento de cosas
	
	public EnemyGenerator() {
		_enemies 	= new ArrayList<Enemy>();
		_dataStorage = DataStorage.GetInstance();
		
		/* Inicializar la lista */
		_enemies.add(new Enemy1(0, 0));
		
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
		e.SetX(700); e.SetY(y*90); // Placeholders
		//StateCharacter puto=new StatePeace(e);
		e.setPeace();
		return e.GetSprite();
	}

}
