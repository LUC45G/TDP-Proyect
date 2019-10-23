package logicas;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.ImmovableObject;

public class VisitorEnemyShoot extends Visitor {
	
	private Disparo miDisparo;
	
	public VisitorEnemyShoot(Disparo d) {
		super();
		miDisparo = d;    //this is legal??
	}
	
	public void visitAlly(Ally a) {
		a.receive_attack(miDisparo);
	}
	
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miDisparo);
	}
	
	public void visitAllyShoot(DisparoAliado da) {
		da.vanish();
	}
	public void visitEnemyShoot(DisparoEnemigo es) {
		es.StartMoving();
	}
	
}
