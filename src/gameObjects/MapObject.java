package gameObjects;

import java.util.ArrayList;

import logicas.Controller;
import logicas.IObserver;
import logicas.VisitorObserver;

public abstract class MapObject extends GameObject {

	protected int _health;
	protected ArrayList<IObserver> _observers;
	
	public void receive_attack(int i) {
		_health-=i;
		
		if(_health<=0) {
			Controller.GetInstance().Remove(this);
			_visible = false;
			notificar();
		}
		
	}

	public void acceptObserver(VisitorObserver vo) {
		vo.visitAllyObservado(this);
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
	
	/**
	 * Setea los atributos de este objeto del mapa a otro
	 * @param c objeto donde clonar atributos
	 */
	public void set_atributos(MapObject c){
		c.set_health(_health);
		c.set_boundingBox(_boundingBox);
		c.set_hitbox(_hitbox);
		c.set_range(_range);
		c.set_visitor(_visitor);
		if(!_visible)
			c.NotVisible();
	}

	public int get_health() {
		return _health;
	}

	public void set_health(int _health) {
		this._health = _health;
	}

	@Override
	public abstract MapObject Clone();
	
}
