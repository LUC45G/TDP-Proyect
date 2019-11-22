package gameObjects;

import java.awt.Rectangle;

import logicas.Controller;
import logicas.VisitorVendedor;

public class Vendedor extends ImmovableObject {
	public Vendedor()
	{
		_hitbox = new Rectangle(0, 0, 1, 1);
		_cost=0;
		_visitor=new VisitorVendedor(this);
	}
	@Override
	public void affect(Character c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImmovableObject Clone() {
		return new Vendedor();
	}
	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}
}
