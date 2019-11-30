package logicas.Visitors;

import gameObjects.Estados.Congelado;
import gameObjects.Estados.EstadoDisparando;
import gameObjects.Estados.NormalState;

public class VisitorCongeladoState extends VisitorState{
	
	public void visitNormal(NormalState sd) {sd.ChangeState(new Congelado(sd.GetCharacter(),sd.GetCharacter().GetState()));}

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new Congelado(sd.GetCharacter(),sd.GetCharacter().GetState()));}
}
