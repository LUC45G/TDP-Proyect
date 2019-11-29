package logicas;

import gameObjects.EstadoProtegidoAtacando;
import gameObjects.EstadoProtegidoCaminando;

public class VisitorProtegidoAtacando extends VisitorState {

	//public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {
		EstadoProtegidoAtacando epa=new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad());
		epa.setAtaquesRecibidos(sd.getAtaquesRecibidos());
		sd.ChangeState(epa);
		System.out.println(epa.getAtaquesRecibidos());
	}
}
