package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.VisitorBombaAtomica;

public class BombaAtomica extends ImmovableObject {

	public BombaAtomica() {
		super();
		_visitor = new VisitorBombaAtomica();
		_sprite = new ImageIcon(this.getClass().getResource("/img/moab.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=5;
	}

	@Override
	public ImmovableObject Clone() {
		return new BombaAtomica();
	}

	@Override
	public void affect(Character c) {
		
	}
	@Override
	public ImageIcon GetSpriteImmovableObject(){
		return new ImageIcon(this.getClass().getResource("/img/moab.png"));
		
	}
}
