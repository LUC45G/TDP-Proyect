package logicas;

import gameObjects.Ally;
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
	}
	public void visitAllyShoot(DisparoAliado d) {
		d.vanish();
	}
	public void visitLose(){
		Controller.GetInstance().lose();
	}
}
