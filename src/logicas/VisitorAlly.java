package logicas;

import gameObjects.Ally;
import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorAlly extends Visitor {

	private Ally miAliado;
	public VisitorAlly(Ally ally) {	
		miAliado=ally;
	}
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.vanish();
	}
	public void visitAllyShoot(DisparoAliado da) {
		da.StartMoving();
	}
	public void visitEnemy(Enemy e) {
		e.StopMoving();
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miAliado);
	}
}
