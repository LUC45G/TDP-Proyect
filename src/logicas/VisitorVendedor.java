package logicas;

import gameObjects.Ally;
import gameObjects.Vendedor;

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
