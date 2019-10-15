package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public abstract class Visitor {
	
	public void VisitAlly(Ally a) {}

	public void VisitEnemy(Enemy e) {}
	
	public void VisitImmovableObject(ImmovableObject i) {}
}
