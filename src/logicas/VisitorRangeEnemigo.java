package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.VisitorRange;

public class VisitorRangeEnemigo extends VisitorRange {
	private Enemy miEnemy;
	public VisitorRangeEnemigo(Enemy a) {
		miEnemy=a;
	}
	public void visitAlly(Ally a) { miEnemy.GetState().ChangeState(); }

}
