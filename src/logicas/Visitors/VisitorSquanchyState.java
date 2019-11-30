package logicas.Visitors;

import gameObjects.Estados.DienteSquanchy;
import gameObjects.Estados.EstadoDisparando;
import gameObjects.Estados.NormalState;

public class VisitorSquanchyState extends VisitorState {

	public void visitNormal(NormalState sd) {
		sd.ChangeState(new DienteSquanchy(sd.GetCharacter(),sd.GetCharacter().GetState()));
	}

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new DienteSquanchy(sd.GetCharacter(),sd.GetCharacter().GetState()));}
}
