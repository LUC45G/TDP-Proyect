package logicas;

import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public class VisitorEnemy extends Visitor {
	private Enemy miEnemigo;
	
	public VisitorEnemy(Enemy enemy) {
		miEnemigo=enemy;
	}
	public void visitImmovableObject(ImmovableObject i) {
		i.affect(miEnemigo);
		//miEnemigo.StopMoving(); esto es responsabilidad del metodo affect creo
	}
	public void visitAllyShoot(DisparoAliado d) {
		d.vanish();
	}
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.StartMoving();
	}
}
