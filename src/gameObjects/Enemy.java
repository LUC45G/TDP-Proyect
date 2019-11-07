package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.Visitor;
import logicas.VisitorEnemy;
import logicas.VisitorRangeEnemigo;

/**
 * Clase que modela a los enemigos
 *
 */
public abstract class Enemy extends Character {
	
	
	public Enemy(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		Init();
	}
	
	public void Init() {
		_health		= 10;
		_shoot  	= new DisparoEnemigo(15, 150);
		_visitor	= new VisitorEnemy(this);
		_range		= 150;
		_boundingBox= new VisitorRangeEnemigo();
	}
	

	protected Enemy() {
		super();
		Init();
	}
	
	@Override
	public void Update() {
		_state.update();	
	}

	public void receive_attack(Disparo miDisparo) {
		_health-=miDisparo.get_strength();	
		
		if(_health <= 0 ) {
			Controller.GetInstance().Remove(this);
		}
			
	}
	
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

			
}

