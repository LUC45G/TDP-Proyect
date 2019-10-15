package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

public class Disparo extends GameObject implements Cloneable {
	protected Visitor visitorDisparo;
	private int _strength;
	public Disparo(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox);
		_strength=fuerza;
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
		Disparo d = new Disparo(this.GetSprite(), this.GetHitbox(),this.get_strength());
		// Seguir inicializando el clon
		return d;
	}


	public int get_strength() {
		// TODO Auto-generated method stub
		return _strength;
	}


	public Visitor getVisitorDisparo() {
		return visitorDisparo;
	}


	public void setVisitorDisparo(Visitor visitorDisparo) {
		this.visitorDisparo = visitorDisparo;
	}


}
