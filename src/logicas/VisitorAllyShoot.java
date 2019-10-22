package logicas;

import gameObjects.Disparo;
import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorAllyShoot extends Visitor {
	
	private Disparo miDisparo;
	
	public VisitorAllyShoot(Disparo d) {
		super();
		miDisparo=d;
	}
	
	public void visitEnemy(Enemy e) {
		e.receive_attack(miDisparo);
	}
	
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miDisparo);
	}
	
	public void visitEnemyShoot(DisparoEnemigo d) {
		d.vanish();
	}
	
	public void visitAllyShot(DisparoAliado d) {
		d.StartMoving();
	}
}
