package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;
import logicas.VisitorEnemy;

/**
 * Clase que modela a los enemigos
 *
 */
public abstract class Enemy extends Character {
	protected StateCharacter situacion;
	
	public Enemy(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox, fuerza);
		//_shoot=new Disparo1(0, 0); //esto esta como el tuje pero lo hice asi no mas
		_health=10;
		_velocidad=7;
									//Bounding box (que onda nunca se setea????
									//shoot como funciona??
		_visitor=new VisitorEnemy(this);
	}
	

	protected Enemy() {
		super();
		_strength=3; //4 disparos para un enemigo comun
		_health=10;
		_velocidad=7;
		_visitor=new VisitorEnemy(this);
	}


	public void receive_attack(Disparo miDisparo) {
		System.out.println("Ally Visitado por: " + miDisparo.hashCode());
		this.set_health(_health-miDisparo.get_strength());	
		
		if(_health <= 0 ) {
			// Remove
			System.out.println(this.hashCode() + " Eliminado ");
		}
			
	}
	
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

			
}

