package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.VisitorRange;

public class VisitorRangeAliado extends VisitorRange {
	private Ally miAlly;
	public VisitorRangeAliado(Ally a) {
		miAlly=a;
	}
	public void visitEnemy(Enemy e) { miAlly.GetState().ChangeState(); }
	
}
