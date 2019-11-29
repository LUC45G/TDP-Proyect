package logicas;

import gameObjects.EstadoDisparando;
import gameObjects.EstadoProtegidoAtacando;
import gameObjects.EstadoProtegidoCaminando;
import gameObjects.NormalState;

public class VisitorProtegidoNormal extends VisitorState{
	
	public void visitNormal(NormalState sd) {sd.ChangeState(new EstadoProtegidoCaminando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new EstadoProtegidoCaminando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoDisparando(EstadoProtegidoAtacando sd) {
		EstadoProtegidoCaminando epc=new EstadoProtegidoCaminando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad());
		epc.setAtaquesRecibidos(sd.getAtaquesRecibidos());
		sd.ChangeState(epc);
		System.out.println(epc.getAtaquesRecibidos());
	}
}
