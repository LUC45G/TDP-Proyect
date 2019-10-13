package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import gameObjects.*;

public class EnemyGenerator {
	
	protected ArrayList<Enemy>  _enemies;		 // Lista de enemigos a clonar
	protected HiloEnemigos 		_enemyThread;	 // Hilo de los enemigos
	protected DataStorage 		_dataStorage; 	 // Almacenamiento de cosas
	
	public EnemyGenerator() {
		_enemies 	= new ArrayList<Enemy>();
		_dataStorage = DataStorage.GetInstance();
		
		/* Inicializar la lista */
		_enemies.add(new Enemy1(0, 0));
		
		/* Inicializo el hilo */
		_enemyThread = new HiloEnemigos();
		_enemyThread.start();
	}
	
	public ArrayList<Rectangle> GetEnemies() {
		return _enemyThread.GetEnemigos();
	}
	
	public ImageIcon GetEnemy(int i) {
		Enemy e = (Enemy) _enemies.get(i).Clone();
		_dataStorage.Store(e);
		e.SetX(0); e.SetY(90); // Placeholders
		_enemyThread.AgregarEnemigo(e.GetHitbox());
		return e.GetSprite();
	}

}
