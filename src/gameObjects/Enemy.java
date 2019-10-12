package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Clase que modela a los enemigos
 *
 */
public abstract class Enemy extends Character {

	public Enemy(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		
	}
	
	protected Enemy() { }

}
