package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class LagoMapa extends ImmovableObject {

	public LagoMapa() {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/fuego_lago.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
