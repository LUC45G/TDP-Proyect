package logicas;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameObjects.Enemy;

public class EnemyGenerator {
	
	protected ArrayList<Enemy> _enemies;
	
	public EnemyGenerator() {
		_enemies = new ArrayList<Enemy>();
		
		/* Inicializar la lista */
	}
	
	public ImageIcon GetEnemy(int i) {
		return _enemies.get(i).GetSprite();
	}

}
