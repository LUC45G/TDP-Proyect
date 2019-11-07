package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;
import logicas.VisitorEnemyShoot;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int s, int r) {
		super(s, r, -1);
		_visitor=new VisitorEnemyShoot(this);
		_sprite = new ImageIcon(this.getClass().getResource("/img/Shoot2.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth()*2/3, _sprite.getIconHeight());
	}

	@Override
	public Disparo Clone() {
		return new DisparoEnemigo(_strength, _range);
	}
	
	public void accept(Visitor ve) {
		ve.visitEnemyShoot(this);
	}

}
