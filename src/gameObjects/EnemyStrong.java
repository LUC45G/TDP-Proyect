package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	enemigo con el triple de vida/fuerza
 */
public class EnemyStrong extends Enemy {
	
	public EnemyStrong(int x,int y) {
		super();
		_shoot=new DisparoEnemigo(_strength*3);
		_health*=3;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new EnemyStrong(0, 0);
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
