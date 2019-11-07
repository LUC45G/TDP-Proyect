package logicas;

import gameObjects.Enemy;
import gameObjects.VisitorRange;

public class VisitorRangeAliado extends VisitorRange {

	public VisitorRangeAliado() {
		
	}

	public void visitEnemy(Enemy e) { e.GetState().ChangeState(); }
	
}
