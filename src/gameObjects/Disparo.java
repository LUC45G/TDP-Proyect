package gameObjects;

import logicas.Controller;
import logicas.Visitor;

public abstract class Disparo extends GameObject implements Cloneable {
	
	protected int _strength, _velocidad;
	
	public Disparo(int s, int r, int multiplier) {
		super();
		_strength  = s;
		_range 	   = r;
		_velocidad = 20 * multiplier;
	}
	
	public abstract Disparo Clone();

	public int get_strength() {
		return _strength;
	}
	
	public int get_range() { return _range; }
	public void set_strength(int s) { _strength = s; }
	public void set_range(int r) { _range = r; }
	
	@Override
	public void Update() {
		_hitbox.x += (_velocidad/2);
		
		if(--_range <= 0)
			this.vanish();
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
