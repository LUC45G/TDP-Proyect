package logicas;

import gameObjects.Disparo;
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
	public void visitShoot(Disparo d) {
		d.vanish();
	}
}
