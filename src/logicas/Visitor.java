package logicas;

import gameObjects.GameObject;

public abstract class Visitor {

	public Visitor() {
		
	}
	
	public abstract void Visit(GameObject g);

}
