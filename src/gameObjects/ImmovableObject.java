package gameObjects;

import logicas.Controller;
import logicas.VisitorPowerUp;
/**
 * Objetos inamovibles que pueden aparecer en el juego
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public abstract class ImmovableObject extends GameObject {
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
	 * Devuelve el tiempo restante de vida del objeto
	 * @return vida restante del objeto
	 */
	public int get_deathTimer() {
		return _deathTimer;
	}

	/**
	 * Setea el tiempo restante de vida del objeto
	 * @param _deathTimer nuevo tiempo restante de vida del objeto
	 */
	public void set_deathTimer(int _deathTimer) {
		this._deathTimer = _deathTimer;
	}
	
	/**
	 * Setea los atributos de este objeto del mapa a otro
	 * @param c objeto donde clonar atributos
	 */
	public void set_atributos(ImmovableObject c){
		c.set_range(_range);
		set_deathTimer(_deathTimer);
		if(!_visible)
			c.NotVisible();
	}
	
	/**
	 * Actua en respuesta al recibimiento del daño
	 * @param i daño a recibir
	 */
	public void receive_attack(int i) {
		Controller.GetInstance().Remove(this);
		_visible = false;
	}

	/**
	 * Actualiza el estado o situacion del objeto
	 */
	public void Update() {
		--_deathTimer;
		
		if(_deathTimer == 0)
			receive_attack(0);
	}
	
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
