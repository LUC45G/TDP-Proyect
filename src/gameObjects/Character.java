package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;


/**
 * Modela a los personajes, tanto aliados como enemigos
 *
 */
public abstract class Character extends GameObject implements Cloneable {
	
	protected int _health;
	protected Rectangle _boundingBox;

	public Character(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		_health = 10;
	}
	
	protected Character() {}
	
}
