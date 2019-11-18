package logicas;

import gameObjects.Ally;
import gameObjects.DienteSquanchy;

public class VisitorSquanchy extends VisitorPowerUp {

	public void visitAlly(Ally a) { a.ChangeState(new DienteSquanchy(a, a.GetState())); }
	
}
