package logicas.Visitors;

import gameObjects.Enemigos.Enemy;
import gameObjects.Estados.Congelado;

public class VisitorCongelado extends VisitorPowerUp {

	public void visitEnemy(Enemy e) { e.ChangeState( new Congelado(e, e.GetState()) ); }
}
