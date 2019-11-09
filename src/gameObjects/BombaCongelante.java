package gameObjects;

import java.awt.Rectangle;

import logicas.VisitorCongelado;

public class BombaCongelante extends ImmovableObject {

	public BombaCongelante() {
		super();
		_visitor = new VisitorCongelado();
		_hitbox = new Rectangle(0, 0, 0, 0);
		_cost*=10;
	}

	@Override
	public ImmovableObject Clone() {
		return new BombaCongelante();
	}

	@Override
	public void affect(Character c) {
		
	}

}
