package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;


/**
 * Modela a los personajes, tanto aliados como enemigos
 *
 */
public abstract class Character extends GameObject implements Cloneable {
	

	protected int 			 _health; 		// Vida actual del personaje, quizas deba ir mas arriba
	protected Disparo   	 _shoot;	
	protected StateCharacter _state;
	protected Bank			 _bank = Bank.GetInstance();
	
	protected Character() {}
	
	public Character(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		_health = 10;
	}
	
	public int get_health() {
		return _health;
	}
	
	public Disparo get_shoot() {
		return _shoot;
	}
	public void set_health(int _health) {
		//deberia chequear que se quede en 0???
		this._health = _health;
	}
	
	public void setHitBox(int x , int y, int heigth, int width) {
		_hitbox=new Rectangle(x,y,heigth,width);
	}
	
	public void SetPowerUp(int i) {
	}
	
	public void SetState(StateCharacter s) {
		 _state = s;
	}
	public abstract void accept(Visitor v);
	
	public abstract Character Clone();
	
	public StateCharacter GetState() {
		return _state;
	}

	public int GetAttackSpeed() {
		return _state.GetDelay();
	}

	public int GetStrength() {
		return _state.GetStrength();
	}
	
	public void SetSprite(ImageIcon s) {
		_sprite = s;
	}
	
	
	
	
}