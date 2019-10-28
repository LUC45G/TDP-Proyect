package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	enemigo con el triple de todo y 10 veces de vida qsy
 */
public class EnemyBoss extends Enemy {
	
	public EnemyBoss(int x,int y) {
		super();
		_velocidad*=3;
		_shoot  = new DisparoEnemigo(_strength*3);
		_health*= 10;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Enemy6.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new EnemyFast(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void setPeace() {
		_bank.getPeace(this);
		
	}

	@Override
	public void setAngry() {
		_bank.getAngry(this);
		
	}

}
