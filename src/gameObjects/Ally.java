package gameObjects;

import logicas.Controller;
import logicas.Visitor;
import logicas.VisitorAlly;
import logicas.VisitorRangeAliado;

public abstract class Ally extends Character {

	protected Ally() {
		_shoot = new DisparoAliado(20, 150);
		_cost=10;
		_range=300;
		_visitor=new VisitorAlly(this);
		_boundingBox= new VisitorRangeAliado(this);
	}
	
	@Override
	public void Update() {
		_state.update();
	}
	
	public void receive_attack(Disparo d) {
		_health-=d.get_strength();
		if(_health <= 0 ) {
			Controller.GetInstance().Remove(this);
		}
	}
	public void accept(Visitor v) {
		v.visitAlly(this);
	}
	
}
