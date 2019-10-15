package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;
import logicas.VisitorEnemy;

/**
 * Clase que modela a los enemigos
 *
 */
public abstract class Enemy extends Character {
	protected VisitorEnemy colisionator;
	public Enemy(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		colisionator=new VisitorEnemy(this);
	}
	
	protected Enemy() { }
	

	public void receive_attack(Ally a) {
		this.set_health(_health-a.get_strength());		
	}
	
	public void accept(Visitor v) {
		v.VisitEnemy(this);
	}

}
