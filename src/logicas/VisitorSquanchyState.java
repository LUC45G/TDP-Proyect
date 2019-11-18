package logicas;

import gameObjects.DienteSquanchy;
import gameObjects.EstadoDisparando;
import gameObjects.NormalState;

public class VisitorSquanchyState extends VisitorState {

	public void visitNormal(NormalState sd) {
		sd.ChangeState(new DienteSquanchy(sd.GetCharacter(),sd.GetCharacter().GetState()));
	}

	public void visitDisparando(EstadoDisparando sd) {sd.ChangeState(new DienteSquanchy(sd.GetCharacter(),sd.GetCharacter().GetState()));}
}
