package gameObjects;

import logicas.Controller;
import logicas.Visitor;
import logicas.VisitorAlly;
import logicas.VisitorRangeAliado;
/**
 * Representa a los aliados del juego
 * @author Pippig,Matias Gonazales, Lucas
 * 
 */
public abstract class Ally extends Character {
	/**
	 * Constructor, crea un disparo, setea costo y rango default, tambien setea los visitors del aliado y del rango
	 */
	protected Ally() {
		//nuevo disparo
		_shoot = new DisparoAliado(20, 150);
		_cost=10;
		_range=300;
		_visitor=new VisitorAlly(this);
		//visitor del tango
		_boundingBox= new VisitorRangeAliado(this);
	}
	/**
	 * Delega al estado que se actualice si le corresponde
	 */
	public void Update() {
		_state.update();
	}
	/**
	 * Calcula cuanto daño le produce el disparo d y actualiza la vida, si la vida baja de cero el aliado muere
	 * @param d Disparo que impacta al aliado
	 */
	public void receive_attack(Disparo d) {
		_health-=d.get_strength();
		if(_health <= 0 ) {
			Controller.GetInstance().Remove(this);
		}
	}
	@Override
	public void accept(Visitor v) {
		v.visitAlly(this);
	}
	
}
