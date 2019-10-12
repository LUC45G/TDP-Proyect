package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Ally extends Character {
	
	protected int _cost;

	public Ally(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
	}
	
	protected Ally() {}
	
	/**
	 * Consulta y devuelve el costo del aliado
	 * @return costo
	 */
	public int GetCost() {
		return _cost;
	}

}
