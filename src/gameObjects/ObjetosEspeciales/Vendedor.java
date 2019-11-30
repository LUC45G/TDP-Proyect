package gameObjects.ObjetosEspeciales;

import java.awt.Rectangle;

import logicas.Controller;
import logicas.Visitors.VisitorVendedor;

public class Vendedor extends ImmovableObject {
	public Vendedor()
	{
		_hitbox = new Rectangle(0, 0, 1, 1);
		_cost = 0;
		_visitor = new VisitorVendedor(this);
		_deathTimer=17;
	}

	@Override
	public ImmovableObject Clone() {
		Vendedor v = new Vendedor();
		set_atributos(v);
		v.set_visitor(new VisitorVendedor(v));
		return v;
	}
	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}
	@Override
	public boolean IsAOE() {
		return false;
	}
}
