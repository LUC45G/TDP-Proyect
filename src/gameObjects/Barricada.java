package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Barricada extends ImmovableObject {

	public Barricada() {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/barricada.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=2;
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new Barricada();
	}

}
