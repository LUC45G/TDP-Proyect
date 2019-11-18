package gameObjects;

import java.awt.Rectangle;

import logicas.VisitorProtector;

public class EscudoProtector extends ImmovableObject {

	public EscudoProtector() {
		super();
		_hitbox = new Rectangle(0, 0, 1, 1);
		_visitor=new VisitorProtector(); //falta implementear
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new EscudoProtector();
	}

}
