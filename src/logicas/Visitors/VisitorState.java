package logicas.Visitors;

import gameObjects.Estados.Congelado;
import gameObjects.Estados.DienteSquanchy;
import gameObjects.Estados.EstadoDisparando;
import gameObjects.Estados.EstadoProtegidoAtacando;
import gameObjects.Estados.EstadoProtegidoCaminando;
import gameObjects.Estados.NormalState;

public abstract class VisitorState {
	
	public void visitNormal(NormalState ns) {}

	public void visitDisparando(EstadoDisparando sd) {}
	
	public void visitCongelado (Congelado cs) {}
	
	public void visitSquanchy(DienteSquanchy ds) {}

	public void visitProtegidoDisparando(EstadoProtegidoAtacando disparoAliado) {}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando disparoAliado) {}
}
