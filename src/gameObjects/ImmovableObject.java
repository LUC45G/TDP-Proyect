package gameObjects;

import logicas.Visitor;

public class ImmovableObject extends GameObject {
	
	protected ImmovableObject() {}

	public void affect(Disparo miDisparo) {
		//este metodo debe ser redefinido por cada sub_clase de ImmovableObject
		// miDisparo.vanish(); _health--;
	}
	public void affect(Character c) {
		//este metodo debe ser redefinido por cada sub_clase de ImmovableObject
	}
	public void accept(Visitor v) {
		v.visitImmovableObject(this);
	}

	@Override
	public void Update() {
		
	}

	public ImmovableObject Clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
