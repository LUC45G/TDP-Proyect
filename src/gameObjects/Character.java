package gameObjects;

import java.awt.Rectangle;

import logicas.Controller;
import logicas.Visitor;


/**
 * Modela a los personajes, tanto aliados como enemigos
 *
 */
public abstract class Character extends GameObject implements Cloneable {
	

	protected int 			 _health; 		// Vida actual del personaje, quizas deba ir mas arriba
	protected Disparo   	 _shoot;	
	protected StateCharacter _state;

	protected Character() {	
		_health = 100;
	}
	
	public int get_health() {
		return _health;
	}
	
	public Disparo get_shoot() {
		return _shoot;
	}
	public void set_health(int _health) {
		this._health = _health;
	}
	
	public void setHitBox(int x , int y, int heigth, int width) {
		_hitbox=new Rectangle(x,y,heigth,width);
	}
	
	public void SetPowerUp(int i) {
	
	}
	/**
	 * 
	 * @param s Estado nuevo
	 * cambia efectivamente el estado del personaje
	 */
	public void ChangeState(StateCharacter s) {
		 _state= s;
	}
	/**
	 * 
	 * @param s Estado que se desea setear como nueva
	 * Delega al estado actual la accion de cambiar el estado al que corresponda
	 */
	public void SetState(StateCharacter s) {
		 _state.ChangeState(s);
	}
	public abstract void accept(Visitor v);
	
	public abstract Character Clone();
	
	public StateCharacter GetState() {
		return _state;
	}
	
	public void receive_attack(int d) {
		_state.receive_attack(d);
	}

	public int GetAttackSpeed() {
		return _state.GetDelay();
	}

	public int GetStrength() {
		return _state.GetStrength();
	}
	
	public void Die() {
		Controller.GetInstance().Remove(this);
	}
	
}