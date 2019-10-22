package logicas;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public abstract class Visitor {
	
	public void VisitAlly(Ally a) {}

	public void VisitEnemy(Enemy e) {}
	
	public void VisitShoot(Disparo d) {}
	
	public void VisitImmovableObject(ImmovableObject i) {}
}
