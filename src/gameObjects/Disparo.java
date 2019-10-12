package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Disparo extends GameObject implements Cloneable {
	
	
	public Disparo(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Mueve al disparo
	 */
	public void Move() {
		
		// Mover disparo
			
		// Controlar si choca
		
	}
	
	/* Metodos privados para poder clonar */
	
	
	
	
	public Disparo Clone() {
		Disparo d = new Disparo(this.GetSprite(), this.GetHitbox());
		// Seguir inicializando el clon
		return d;
	}


}
