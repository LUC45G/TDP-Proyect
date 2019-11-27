package logicas;

import gameObjects.DisparoAliado;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.ImmovableObject;
import gameObjects.LagoMapa;

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
	public void visitLagoMapa(LagoMapa lm) {
		miEnemigo.ChangeState(new EstadoDisparando(miEnemigo, miEnemigo.get_delay(), miEnemigo.get_strength(), miEnemigo.get_velocidad()));
	}
}
