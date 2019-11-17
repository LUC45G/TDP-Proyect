package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.VisitorRange;

public class VisitorRangeEnemigo extends VisitorRange {
	private Enemy miEnemy;
	public VisitorRangeEnemigo(Enemy a) {
		miEnemy=a;
	}
	public void visitAlly(Ally a) { 
		miEnemy.SetState(new EstadoDisparando(miEnemy,miEnemy.GetAttackSpeed(),miEnemy.GetStrength(),miEnemy.GetState().GetVelocidad())); 
	}

}
