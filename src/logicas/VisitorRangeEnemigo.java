package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.StateCharacter;
import gameObjects.VisitorRange;

public class VisitorRangeEnemigo extends VisitorRange {
	private Enemy miEnemy;
	public VisitorRangeEnemigo(Enemy a) {
		miEnemy=a;
	}
	public void visitAlly(Ally a) { 
		StateCharacter actualState=miEnemy.GetState();
		miEnemy.SetState(new EstadoDisparando(miEnemy,actualState.GetDelay(),actualState.GetStrength(),actualState.GetVelocidad())); 
	}

}
