package gameObjects.Enemigos;

import java.util.ArrayList;
import gameObjects.Character;
import gameObjects.Disparos.DisparoEnemigo;
import logicas.Controller;
import logicas.IObserver;
import logicas.Visitors.Visitor;
import logicas.Visitors.VisitorEnemy;
import logicas.Visitors.VisitorRangeEnemigo;

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
	
	public abstract Enemy Clone();
	

	protected Enemy() {
		super();
		Init();
	}

	@Override
	public void Die() {
		super.Die();
		Controller.GetInstance().EnemyDeath(this);
	}
	
	public void accept(Visitor v) {
		v.visitEnemy(this);
	}
	/**
	 * Setea los atributos de este personaje a otro
	 * @param c enemigo donde clonar
	 */
	public void set_atributos(Enemy c){
		super.set_atributos(c);
		c.set_visitor(new VisitorEnemy(c));
	}
}

