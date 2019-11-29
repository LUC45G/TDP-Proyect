package logicas;

import gameObjects.Ally;
import gameObjects.DisparoEnemigo;
import gameObjects.Vendedor;

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
