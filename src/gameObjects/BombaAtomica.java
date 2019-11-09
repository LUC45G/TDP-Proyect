package gameObjects;

import java.awt.Rectangle;

import logicas.VisitorBombaAtomica;

public class BombaAtomica extends ImmovableObject {

	public BombaAtomica() {
		super();
		_visitor = new VisitorBombaAtomica();
		_hitbox = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public ImmovableObject Clone() {
		return new BombaAtomica();
	}

	@Override
	public void affect(Character c) {
		
	}

}
