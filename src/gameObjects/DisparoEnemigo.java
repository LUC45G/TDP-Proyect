package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.VisitorEnemyShoot;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int s) {
		super(s);
		visitorDisparo=new VisitorEnemyShoot(this);
		//_sprite = new ImageIcon(this.getClass().getResource("/img/Shoot1.gif"));
		//_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
	}

	@Override
	public Disparo Clone() {
		return new DisparoEnemigo(_strength);
	}

}
