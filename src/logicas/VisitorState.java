package logicas;

import gameObjects.Congelado;
import gameObjects.DienteSquanchy;
import gameObjects.EstadoDisparando;
import gameObjects.EstadoProtegidoAtacando;
import gameObjects.EstadoProtegidoCaminando;
import gameObjects.NormalState;

public abstract class VisitorState {
	
	public void visitNormal(NormalState ns) {}

	public void visitDisparando(EstadoDisparando sd) {}
	
	public void visitCongelado (Congelado cs) {}
	
	public void visitSquanchy(DienteSquanchy ds) {}

	public void visitProtegidoDisparando(EstadoProtegidoAtacando disparoAliado) {}
	
	public void visitProtegidoCaminando(EstadoProtegidoCaminando disparoAliado) {}
}
