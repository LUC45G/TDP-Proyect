package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	enemigo con el triple de velocidad
 */
public class EnemyFast extends Enemy {
	
	public EnemyFast(int x,int y) {
		super();
		_velocidad*=3;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Enemy2.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot = new DisparoEnemigo(_strength);
	}
	@Override
	public Character Clone() {
		Character a = new EnemyFast(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void setPeace() {
		_sprite=_bank.getPeace(this);
		
	}

	@Override
	public void setAngry() {
		_sprite=_bank.getAngry(this);
		
	}

}
