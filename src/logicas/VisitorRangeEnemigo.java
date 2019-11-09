package logicas;

import gameObjects.Ally;
import gameObjects.VisitorRange;

public class VisitorRangeEnemigo extends VisitorRange {

	public void visitAlly(Ally a) { a.GetState().ChangeState(); }

}
