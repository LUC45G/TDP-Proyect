package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.Muerte;

public class VisitorBombaAtomica extends Visitor {

	public void visitAlly(Ally a) { a.SetState(new Muerte(a, 0, 0, 0)); }

	public void visitEnemy(Enemy e) { e.SetState(new Muerte(e, 0, 0, 0)); }
	

}
