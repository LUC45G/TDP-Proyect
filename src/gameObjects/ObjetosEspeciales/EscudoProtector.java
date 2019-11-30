package gameObjects.ObjetosEspeciales;

import java.awt.Rectangle;

import logicas.Controller;
import logicas.Visitors.VisitorProtector;

public class EscudoProtector extends ImmovableObject {

	public EscudoProtector() {
		super();
		_hitbox = new Rectangle(0, 0, 1, 1);
		_visitor = new VisitorProtector(this);
		_deathTimer=17;
		_cost*=2;
	}
	
	public String toString() {
		return "shield";
	}

	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}

	@Override
	public ImmovableObject Clone() {
		EscudoProtector ep = new EscudoProtector();
		set_atributos(ep);
		ep.set_visitor(new VisitorProtector(ep));
		return ep;
	}

	@Override
	public boolean IsAOE() {
		return false;
	}

}
