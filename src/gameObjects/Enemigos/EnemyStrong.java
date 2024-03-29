package gameObjects.Enemigos;

import java.awt.Rectangle;

import gameObjects.Estados.NormalState;
import gameObjects.Estados.StateCharacter;

/**
 * 
 * @author matia
 *	enemigo con el triple de vida/fuerza
 */
public class EnemyStrong extends Enemy {
	
	public EnemyStrong(int x,int y) {
		super();
		_baseStrength*=3;
		_health*=3;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=5;
	}
	@Override
	public Enemy Clone() {
		Enemy a = new EnemyStrong(0, 0);
		set_atributos(a);
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}
