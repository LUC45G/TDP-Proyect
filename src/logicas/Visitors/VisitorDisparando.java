package logicas.Visitors;

import gameObjects.Estados.EstadoDisparando;
import gameObjects.Estados.EstadoProtegidoAtacando;
import gameObjects.Estados.EstadoProtegidoCaminando;
import gameObjects.Estados.NormalState;

public class VisitorDisparando extends VisitorState {
	
	public void visitNormal(NormalState sd) {sd.ChangeState(new EstadoDisparando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}

	//public void visitProtegidoDisparando(EstadoProtegidoAtacando sd) {sd.ChangeState(new EstadoDisparando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {sd.ChangeState(new EstadoProtegidoAtacando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
}
