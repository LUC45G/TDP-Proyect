package gameObjects;

import logicas.VisitorBombaAtomica;

public class BombaAtomica extends ImmovableObject {

	public BombaAtomica() {
		_visitor = new VisitorBombaAtomica();
	}

}
