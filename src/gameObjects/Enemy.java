package gameObjects;

import java.util.ArrayList;

import logicas.Controller;
import logicas.IObserver;
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
		_observers 	= new ArrayList<IObserver>();
		_boundingBox= new VisitorRangeEnemigo(this);
		_baseDelay = 25;
		_baseStrength=25;
		_baseMovementSpeed=7;
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
	
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}
			
}

