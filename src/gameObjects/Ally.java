package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

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

	public void receive_attack(Enemy e) {
		this.set_health(_health-e.get_strength());
		//este metodo es con fines funcionales no se si es la idea que sea asi
	}
	public void accept(Visitor v) {
		v.VisitAlly(this);
	}
}
