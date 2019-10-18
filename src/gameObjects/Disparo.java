package gameObjects;

import logicas.Visitor;

public abstract class Disparo extends GameObject implements Cloneable {
	
	protected Visitor visitorDisparo;
	private int _strength;
	
	public Disparo() {
		super();
		_strength = 100;
		_velocidad = -10;
	}
	
	public abstract Disparo Clone();

	public int get_strength() {
		return _strength;
	}


	public Visitor getVisitorDisparo() {
		return visitorDisparo;
	}


	public void setVisitorDisparo(Visitor visitorDisparo) {
		this.visitorDisparo = visitorDisparo;
	}


}
