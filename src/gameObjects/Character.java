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
	protected Rectangle 	 _boundingBox; 	// Rectangulo que representa el alcance
	protected int			 _strength;      // Fuerza del personaje
	protected Disparo   	 _shoot;	
	protected StateCharacter _state;
	
	protected Character() {}
	protected Character(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite,hitbox);
		_strength=fuerza;
	}
	public int get_health() {
		return _health;
	}

	public void set_health(int _health) {
		//deberia chequear que se quede en 0???
		this._health = _health;
	}
	
	public int get_strength() {
		return _strength;
	}

	public void set_strength(int _strength) {
		this._strength = _strength;
	}

	public Character(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		_health = 10;
	}
	
	public void SetState(StateCharacter sc) {
		_sprite = sc.GetImage(this);
	}

	public abstract void accept(Visitor v);
	
	public abstract Character Clone();
	
}
