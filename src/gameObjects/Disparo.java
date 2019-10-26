package gameObjects;

import logicas.Controller;
import logicas.Visitor;

public abstract class Disparo extends GameObject implements Cloneable {
	
	protected Visitor visitorDisparo;
	protected int _strength;
	
	public Disparo(int s) {
		super();
		_strength = s;
		_velocidad = -20;
	}
	
	public abstract Disparo Clone();

	public int get_strength() {
		return _strength;
	}


	public Visitor getVisitorDisparo() {
		return _visitor;
	}


	public void setVisitorDisparo(Visitor visitorDisparo) {
		this._visitor = visitorDisparo;
	}
	/**
	 * desaparece graficamente y logicamente
	 */
	public void vanish() {
		Controller.GetInstance().Remove(this);
	}


}
