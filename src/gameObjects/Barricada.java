package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.IObserved;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorBarricada;
/**
 * Barricada que detiene a los personajes y disparos
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public class Barricada extends ImmovableObject implements IObserved {
	
	private int _health;
	private ArrayList<IObserver> _observers;
	
	/**
	 * Constructor que setea imagen,hitbox y costo
	 */
	public Barricada() {
		super();
		_visitor=new VisitorBarricada();
		_sprite = new ImageIcon(this.getClass().getResource("/img/barricada.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_observers = new ArrayList<IObserver>();
		_health = 100;
		_cost*=2;
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new Barricada();
	}
	
	@Override
	public void accept(Visitor v) {
		if(_health != 100)
			v.visitBarricada(this);
		
		else
			_health--;
		
		
	}
	
	public void receive_attack(int i) {
		_health-=i;
		if(_health<=0) {
			Controller.GetInstance().Remove(this);
			_visible = false;
			notificar();
		}
	}

	@Override
	public void agregarObservador(IObserver observador) {
		_observers.add(observador);
	}

	@Override
	public void eliminarObservador(IObserver observador) {
		_observers.remove(observador);
	}
	
	@Override
	public boolean notificar() {
		for(IObserver o : _observers)
			o.StopShooting();
		
		return false;
	}

	@Override
	public boolean IsAOE() {
		return false;
	}

}
