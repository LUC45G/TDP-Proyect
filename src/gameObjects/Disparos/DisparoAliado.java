package gameObjects.Disparos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitors.Visitor;
import logicas.Visitors.VisitorAllyShoot;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int s, int r) {
		super(s, r, 1);
		_visitor=new VisitorAllyShoot(this);
		_sprite = new ImageIcon(this.getClass().getResource("/img/Shoot1.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth()*2/3, _sprite.getIconHeight());
	}

	@Override
	public Disparo Clone() {
		return new DisparoAliado(_strength, _range);
	}
	
	@Override
	public void accept(Visitor ve) {
		ve.visitAllyShoot(this);
	}


}
