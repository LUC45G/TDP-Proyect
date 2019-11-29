package logicas;

import gameObjects.EstadoDisparando;
import gameObjects.EstadoProtegidoAtacando;
import gameObjects.EstadoProtegidoCaminando;
import gameObjects.NormalState;

public class VisitorDisparando extends VisitorState {
	
	public void visitNormal(NormalState sd) {sd.ChangeState(new EstadoDisparando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}

	//public void visitProtegidoDisparando(EstadoProtegidoAtacando sd) {sd.ChangeState(new EstadoDisparando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {sd.ChangeState(new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
}
