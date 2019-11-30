package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.Disparos.DisparoEnemigo;
import gameObjects.ObjetosEspeciales.Vendedor;

public class VisitorAlly extends Visitor {

	private Ally miAliado;
	public VisitorAlly(Ally ally) {	
		miAliado=ally;
	}
	public void visitEnemyShoot(DisparoEnemigo de) {
		de.vanish();
	}
	public void visitVendedor(Vendedor v) {
		miAliado.accept(v.get_visitor());
	}

}
