package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	enemigo con el quintuple de velocidad y 1/3 de fuerza
 */
public class EnemySlim extends Enemy {
	
	public EnemySlim(int x,int y) {
		super();
		_velocidad*=5;
		_strength/=3;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Enemy5.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new EnemySlim(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

}