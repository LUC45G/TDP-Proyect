package logicas;

import gameObjects.Ally;
import gameObjects.Congelado;
import gameObjects.Enemy;
import gameObjects.EstadoProtegidoCaminando;

public class VisitorProtector extends VisitorPowerUp {

	public void visitAlly(Ally e) { e.SetState( new EstadoProtegidoCaminando(e, e.GetAttackSpeed(),e.GetStrength(),0) ); }
}
