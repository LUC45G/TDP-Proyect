package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

/**
 * Clase general que modela un objeto que puede estar presente dentro del mapa
 *
 */
public abstract class GameObject {
	protected ImageIcon _sprite;
	protected Rectangle _hitbox;
	protected Visitor 	_visitor;
	protected int 		_velocidad;
	
	protected GameObject() {}
	
	public GameObject(ImageIcon sprite, Rectangle hitbox) {
		_sprite = sprite;
		_hitbox = hitbox;
	}
	
	public ImageIcon GetSprite() {
		return _sprite;
	}

	public Rectangle GetHitbox() {
		return _hitbox;
	}
	
	public void SetX(int value) {
		_hitbox.x = value;
	}
	
	public void SetY(int value) {
		_hitbox.y = value;
	}
	
	public Visitor GetVisitor() {
		return _visitor;
	}
	
	public void Move() {
		_hitbox.x -= _velocidad;
	}

	public void accept(Visitor V) {}

	

}
