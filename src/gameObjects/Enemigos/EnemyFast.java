package gameObjects;

import java.awt.Rectangle;

/**
 * 
 * @author matia
 *	enemigo con el triple de velocidad
 */
public class EnemyFast extends Enemy {
	
	public EnemyFast(int x,int y) {
		super();
		_baseMovementSpeed*=3;
		_baseDelay/=3;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());	
		_cost*=4;
	}
	
	@Override
	public Enemy Clone() {
		Enemy a = new EnemyFast(0, 0);
		set_atributos(a);
		return a;
	}

	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}
