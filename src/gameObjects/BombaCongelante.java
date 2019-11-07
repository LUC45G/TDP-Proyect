package gameObjects;

import logicas.VisitorCongelado;

public class BombaCongelante extends ImmovableObject {

	public BombaCongelante() {
		_visitor = new VisitorCongelado();
	}

}
