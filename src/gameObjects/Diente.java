package gameObjects;

import logicas.VisitorSquanchy;

public class Diente extends ImmovableObject {

	public Diente() {
		_visitor = new VisitorSquanchy();
	}

}
