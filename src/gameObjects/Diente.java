package gameObjects;

import java.awt.Rectangle;

import logicas.VisitorSquanchy;

public class Diente extends ImmovableObject {

	public Diente() {
		super();
		_visitor = new VisitorSquanchy();
		_hitbox = new Rectangle(0, 0, 0, 0);
		_cost*=20;
	}

	@Override
	public ImmovableObject Clone() {
		return new Diente();
	}

	@Override
	public void affect(Character c) {
		
	}

}
