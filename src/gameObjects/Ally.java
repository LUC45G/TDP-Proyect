package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

public abstract class Ally extends Character {
	
	protected int _cost;

	protected Ally() {
		// TODO Auto-generated constructor stub
	}

	protected Ally(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
	}	
	
	protected Ally(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox, fuerza);
		_shoot=new Disparo(null,null,_strength); //esto esta como el tuje pero lo hice asi no mas
		_visitor=new VisitorAlly(this);
		
	}
	
	
	
	/**
	 * Consulta y devuelve el costo del aliado
	 * @return costo
	 */
	public int GetCost() {
		return _cost;
	}

	public void receive_attack(Disparo miDisparo) {
		this.set_health(_health-miDisparo.get_strength());
		//este metodo es con fines funcionales no se si es la idea que sea asi
	}
	public void accept(Visitor v) {
		v.VisitAlly(this);
	}
}
