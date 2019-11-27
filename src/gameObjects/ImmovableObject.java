package gameObjects;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.IObserved;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorPowerUp;
/**
 * Objetos inamovibles que pueden aparecer en el juego
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public abstract class ImmovableObject extends GameObject implements IObserved {
	/**
	 * Constructor de un objeto inamovible con un visitor y costo 100
	 */

	protected int _cost;
	protected int _deathTimer;
	protected ImmovableObject() {
		_visitor = new VisitorPowerUp();
		_cost=100;
	}
	/**
	 * El disparo miDisparo es afectado por este objeto
	 * @param miDisparo Disparo qeuse vera afectado
	 */
	public void affect(Disparo miDisparo) {
	}
	
	public int get_deathTimer() {
		return _deathTimer;
	}

	public void set_deathTimer(int _deathTimer) {
		this._deathTimer = _deathTimer;
	}
	
	/**
	 * Setea los atributos de este objeto del mapa a otro
	 */
	public void set_atributos(ImmovableObject c){
		c.set_range(_range);
		c.set_visitor(_visitor);
		c.set_deathTimer(_deathTimer);
		if(!_visible)
			c.NotVisible();
	}
	
	/**
	 * El Personaje c es afectado por este objeto
	 * @param c Personaje que se vera afectado
	 */
	public abstract void affect(Character c);
	
	@Override
	public void accept(Visitor v) {
		v.visitImmovableObject(this);
	}
	
	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}

	public void Update() {
		--_deathTimer;
		
		if(_deathTimer == 0)
			receive_attack(0);
	}
	
	/**
	 * Devuelve  la imagen relacionada con el objeto inamovible
	 * @return Retorna la imagen del objeto
	 */
	public ImageIcon GetSpriteImmovableObject(){
		return null;
		
	}
	
	public void agregarObservador(IObserver observador) {}
	public void eliminarObservador(IObserver observador) {}
	
	/**
	 * Pregunta si el power up es de area de efecto
	 * @return true si debe afectar en area, false si no
	 */
	public abstract boolean IsAOE();
	public int get_cost() {
		return _cost;
	}
	
	@Override
	public abstract ImmovableObject Clone() ;
}
