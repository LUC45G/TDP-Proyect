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
	
	public void Init() {
		_shoot  	= new DisparoEnemigo(15, 150);
		_visitor	= new VisitorEnemy(this);
		_range		= 150;
		_boundingBox= new VisitorRangeEnemigo(this);
	}
	

	protected Enemy() {
		super();
		Init();
	}
	
	@Override
	public void Die() {
		super.Die();
		Controller.GetInstance().EnemyDeath();
	}
	
	@Override
	public void Update() {
		_state.update();	
	}

	public void receive_attack(Disparo miDisparo) {
		_health-=miDisparo.get_strength();	
		
		if(_health <= 0 ) {
			Die();
		}
			
	}
	
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}

			
}

