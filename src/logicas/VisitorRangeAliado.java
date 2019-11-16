package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.StateCharacter;
import gameObjects.VisitorRange;

public class VisitorRangeAliado extends VisitorRange {
	private Ally miAlly;
	public VisitorRangeAliado(Ally a) {
		miAlly=a;
	}
	public void visitEnemy(Enemy e) { 
		StateCharacter actualState=miAlly.GetState();
		miAlly.SetState(new EstadoDisparando(miAlly,actualState.GetDelay(),actualState.GetStrength(),actualState.GetVelocidad())); 
		}
	
}
