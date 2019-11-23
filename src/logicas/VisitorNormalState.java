package logicas;

import gameObjects.Congelado;
import gameObjects.DienteSquanchy;
import gameObjects.EstadoDisparando;
import gameObjects.EstadoProtegidoCaminando;
import gameObjects.NormalState;

public class VisitorNormalState extends VisitorState{

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitCongelado (Congelado sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitSquanchy(DienteSquanchy sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando sd) {sd.ChangeState(new NormalState(sd.GetCharacter(),sd.GetBaseDelay(),sd.GetBaseStrength(),sd.GetBaseVelocidad()));}
}
