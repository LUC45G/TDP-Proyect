package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.VisitorAllyShoot;

public class DisparoAliado extends Disparo{

	public DisparoAliado() {
		super();
		visitorDisparo=new VisitorAllyShoot(this);
		_sprite = new ImageIcon(this.getClass().getResource("/img/Shoot1.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth()*2/3, _sprite.getIconHeight());
	}

	@Override
	public Disparo Clone() {
		return new DisparoAliado();
	}

}
