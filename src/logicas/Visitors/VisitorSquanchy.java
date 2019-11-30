package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.Estados.DienteSquanchy;

public class VisitorSquanchy extends VisitorPowerUp {

	public void visitAlly(Ally a) { a.ChangeState(new DienteSquanchy(a, a.GetState())); }
	
}
