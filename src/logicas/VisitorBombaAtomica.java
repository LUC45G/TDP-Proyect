package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.Muerte;

public class VisitorBombaAtomica extends Visitor {

	public void visitAlly(Ally a) { a.SetState(new Muerte(a, a.GetAttackSpeed(), a.GetStrength(), 0)); }

	public void visitEnemy(Enemy e) { e.SetState(new Muerte(e, e.GetAttackSpeed(), e.GetStrength(), 0)); }
	

}
