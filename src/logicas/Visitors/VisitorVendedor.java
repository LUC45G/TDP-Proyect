package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.ObjetosEspeciales.Vendedor;
import logicas.Controller;

public class VisitorVendedor extends Visitor {
	private Vendedor v;
	public VisitorVendedor(Vendedor ven) {
		v=ven;
	}
	public void visitAlly(Ally a) {
		if(v.IsVisible()) {
			Controller.GetInstance().sellAlly(a);
			v.receive_attack(0);
		}
	}
}
