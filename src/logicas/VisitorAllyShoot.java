package logicas;

import gameObjects.Disparo;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;

public class VisitorAllyShoot extends Visitor {
	
	private Disparo miDisparo;
	
	public VisitorAllyShoot(Disparo d) {
		super();
		miDisparo=d;
	}
	
	public void visitEnemy(Enemy e) {
		e.receive_attack(miDisparo);
	}
	
	public void visitEnemyShoot(DisparoEnemigo d) {
		d.vanish();
	}

}
