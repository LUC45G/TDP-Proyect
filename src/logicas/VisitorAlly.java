package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorAlly extends Visitor{
	private Ally miAliado;
	public VisitorAlly(Ally a) {
		
	}
	public void visitEnemy(Enemy e) {
		e.receive_attack(miAliado);
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miAliado);
	}
}
