package gameObjects;

import java.awt.Rectangle;

/**
 * 
 * @author matia
 *	enemigo con el triple de todo y 10 veces de vida qsy
 */
public class EnemyBoss extends Enemy {
	
	public EnemyBoss(int x,int y) {
		super();
		_baseDelay/=3;
		_baseStrength*=3;
		_baseMovementSpeed*=3;
		_health*=10;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_range=70;
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=20;
	}
	@Override
	public Character Clone() {
		Character a = new EnemyBoss(0, 0);
		set_atributos(a);
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}
