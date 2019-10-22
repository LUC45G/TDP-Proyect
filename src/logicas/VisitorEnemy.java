package logicas;

import gameObjects.DisparoAliado;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorEnemy extends Visitor {
	private Enemy miEnemigo;
	
	public VisitorEnemy(Enemy enemy) {
		miEnemigo=enemy;
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miEnemigo);
	}
	public void visitAllyShoot(DisparoAliado d) {
		d.vanish();
	}
}
