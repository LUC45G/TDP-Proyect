package logicas;

import gameObjects.Ally;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;

public class VisitorRangeAliado extends VisitorRange {
	private Ally miAlly;
	public VisitorRangeAliado(Ally a) {
		miAlly=a;
	}
	public void visitEnemy(Enemy e) { 
		EstadoDisparando vamoADisparar= new EstadoDisparando(miAlly,miAlly.get_delay(),miAlly.get_strength(),0);
		miAlly.GetState().accept(vamoADisparar.GetVisitor());
	}
	
}
