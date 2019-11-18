package logicas;

import gameObjects.DisparoEnemigo;

public class VisitorBarricada extends VisitorPowerUp {
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.vanish();
	}
	
}
