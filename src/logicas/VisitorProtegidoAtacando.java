package logicas;

import gameObjects.EstadoDisparando;
import gameObjects.EstadoProtegidoAtacando;
import gameObjects.EstadoProtegidoCaminando;

public class VisitorProtegidoAtacando extends VisitorState {

	//public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {sd.ChangeState(new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
}
