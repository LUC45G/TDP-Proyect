package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;
import logicas.VisitorAllyShoot;
import logicas.VisitorEnemy;

public class DisparoAliado extends Disparo {

	public DisparoAliado() {
		super();
		_visitor=new VisitorAllyShoot(this);
		_sprite = new ImageIcon(this.getClass().getResource("/img/Shoot1.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth()*2/3, _sprite.getIconHeight());
	}

	@Override
	public Disparo Clone() {
		return new DisparoAliado();
	}
	
	public void accept(Visitor ve) {
		ve.visitAllyShoot(this);
	}

}
