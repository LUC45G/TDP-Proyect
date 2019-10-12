package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy1 extends Enemy {

	public Enemy1(int x, int y) {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/0.png"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}

}
