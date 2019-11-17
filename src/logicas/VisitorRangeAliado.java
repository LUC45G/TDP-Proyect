package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.VisitorRange;

public class VisitorRangeAliado extends VisitorRange {
	private Ally miAlly;
	public VisitorRangeAliado(Ally a) {
		miAlly=a;
	}
	public void visitEnemy(Enemy e) { 
		miAlly.SetState(new EstadoDisparando(miAlly,miAlly.GetAttackSpeed(),miAlly.GetStrength(),miAlly.GetState().GetVelocidad())); 
	}
	
}
