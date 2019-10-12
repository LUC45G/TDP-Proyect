package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Clase general que modela un objeto que puede estar presente dentro del mapa
 *
 */
public abstract class GameObject {
	
	protected ImageIcon _sprite;
	protected Rectangle _hitbox;
	
	public ImageIcon GetSprite() {
		return _sprite;
	}

	public Rectangle GetHitbox() {
		return _hitbox;
	}

	public GameObject(ImageIcon sprite, Rectangle hitbox) {
		_sprite = sprite;
		_hitbox = hitbox;
	}
	
	protected GameObject() {}

}
