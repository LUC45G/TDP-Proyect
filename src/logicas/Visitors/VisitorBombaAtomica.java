package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.Enemigos.Enemy;
import gameObjects.Estados.Muerte;

public class VisitorBombaAtomica extends Visitor {

	public void visitAlly(Ally a) { a.ChangeState(new Muerte(a, a.get_delay(), a.get_strength(), a.get_velocidad())); }

	public void visitEnemy(Enemy e) { e.ChangeState(new Muerte(e, e.get_delay(), e.get_strength(), e.get_velocidad())); }
	

}
