package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorEnemy extends Visitor{
	private Enemy miEnemigo;
	public VisitorEnemy(Enemy e) {
		super();
		miEnemigo=e;    //this is legal??
	}
	public void visitAlly(Ally a) {
		a.receive_attack(miEnemigo);
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miEnemigo);
	}
}
