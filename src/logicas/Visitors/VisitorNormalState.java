package logicas.Visitors;

import gameObjects.Estados.Congelado;
import gameObjects.Estados.DienteSquanchy;
import gameObjects.Estados.EstadoDisparando;
import gameObjects.Estados.EstadoProtegidoAtacando;
import gameObjects.Estados.EstadoProtegidoCaminando;
import gameObjects.Estados.NormalState;

public class VisitorNormalState extends VisitorState{

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitCongelado (Congelado sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitSquanchy(DienteSquanchy sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoDisparando(EstadoProtegidoAtacando sd) {sd.ChangeState(new EstadoProtegidoCaminando(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
}
