package logicas;

import gameObjects.Congelado;
import gameObjects.Enemy;

public class VisitorCongelado extends VisitorPowerUp {

	public void visitEnemy(Enemy e) { e.ChangeState( new Congelado(e, e.GetState()) ); }
}
