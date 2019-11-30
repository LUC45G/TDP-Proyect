package logicas.Visitors;

import gameObjects.Disparos.DisparoEnemigo;

public class VisitorBarricada extends Visitor {
	
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.vanish();
	}
	
}
