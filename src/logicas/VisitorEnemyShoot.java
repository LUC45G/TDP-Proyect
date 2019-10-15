package logicas;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.ImmovableObject;

public class VisitorEnemyShoot extends Visitor{
	private Disparo miDisparo;
	public VisitorEnemyShoot(Disparo d) {
		super();
		miDisparo=d;    //this is legal??
	}
	public void visitAlly(Ally a) {
		a.receive_attack(miDisparo);
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miDisparo);
	}
}
