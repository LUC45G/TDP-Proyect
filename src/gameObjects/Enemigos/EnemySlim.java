package gameObjects.Enemigos;

import java.awt.Rectangle;

import gameObjects.Estados.NormalState;
import gameObjects.Estados.StateCharacter;

/**
 * 
 * @author matia
 *	enemigo con el quintuple de velocidad y 1/3 de fuerza
 */
public class EnemySlim extends Enemy {
	
	public EnemySlim(int x,int y) {
		super();
		_baseDelay/=5;
		_baseStrength/=3;
		_range=100;
		_baseMovementSpeed*=5;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=3;
	}
	@Override
	public Enemy Clone() {
		Enemy a = new EnemySlim(0, 0);
		set_atributos(a);
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}