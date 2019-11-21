package logicas;

import gameObjects.DisparoEnemigo;

public class VisitorBarricada extends Visitor {
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.vanish();
	}
	
}
