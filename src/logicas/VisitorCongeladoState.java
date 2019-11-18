package logicas;

import gameObjects.Congelado;
import gameObjects.EstadoDisparando;
import gameObjects.NormalState;

public class VisitorCongeladoState extends VisitorState{
	
	public void visitNormal(NormalState sd) {sd.ChangeState(new Congelado(sd.GetCharacter(),sd.GetCharacter().GetState()));}

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new Congelado(sd.GetCharacter(),sd.GetCharacter().GetState()));}
}
