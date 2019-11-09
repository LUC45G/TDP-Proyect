package gameObjects;

import logicas.Visitor;
import logicas.VisitorPowerUp;

public abstract class ImmovableObject extends GameObject {
	
	protected ImmovableObject() {
		_visitor = new VisitorPowerUp();
	}

	public void affect(Disparo miDisparo) {
		//este metodo debe ser redefinido por cada sub_clase de ImmovableObject
		// miDisparo.vanish(); _health--;
	}
	public abstract void affect(Character c);
	
	public void accept(Visitor v) {
		v.visitImmovableObject(this);
	}

	@Override
	public void Update() {
		
	}

	public abstract ImmovableObject Clone();

}
