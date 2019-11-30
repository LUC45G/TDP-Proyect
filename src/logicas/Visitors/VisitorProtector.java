package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.Enemigos.Enemy;
import gameObjects.Estados.EstadoProtegidoCaminando;
import gameObjects.ObjetosEspeciales.EscudoProtector;

public class VisitorProtector extends Visitor {
	
	private EscudoProtector shield;
	
	public VisitorProtector(EscudoProtector e) {
		shield=e;
	}

	public void visitAlly(Ally a) {
		if(shield.IsVisible()) {
			a.ChangeState(new EstadoProtegidoCaminando(a, a.get_delay(), a.get_strength(), a.get_velocidad()));
			shield.receive_attack(0);
		}
	}
	
	public void visitEnemy(Enemy e) {
		if(shield.IsVisible()) {
			e.ChangeState(new EstadoProtegidoCaminando(e, e.get_delay(), e.get_strength(), e.get_velocidad()));
			shield.receive_attack(0);
		}
	}
}
