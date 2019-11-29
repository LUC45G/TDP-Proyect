package logicas;

import gameObjects.DisparoAliado;
import gameObjects.Enemy;

public class VisitorEnemy extends Visitor {
	@SuppressWarnings("unused")
	private Enemy miEnemigo;
	
	public VisitorEnemy(Enemy enemy) {
		miEnemigo=enemy;
	}
	public void visitAllyShoot(DisparoAliado d) {
		d.vanish();
	}
	public void visitLose(){
		Controller.GetInstance().lose();
	}
}
