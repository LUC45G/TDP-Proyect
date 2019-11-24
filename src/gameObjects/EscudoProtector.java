package gameObjects;

import java.awt.Rectangle;

import logicas.Controller;
import logicas.VisitorProtector;

public class EscudoProtector extends ImmovableObject {

	public EscudoProtector() {
		super();
		_hitbox = new Rectangle(0, 0, 1, 1);
		_visitor = new VisitorProtector(this); //falta implementear
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}
	
	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}

	@Override
	public ImmovableObject Clone() {
		return new EscudoProtector();
	}

	@Override
	public boolean IsAOE() {
		return false;
	}

}
