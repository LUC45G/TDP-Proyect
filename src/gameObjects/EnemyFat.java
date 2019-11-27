package gameObjects;

import java.awt.Rectangle;

/**
 * 
 * @author matia
 *	enemigo con 1/3 de velocidad y 5 veces la vida
 */
public class EnemyFat extends Enemy {

	public EnemyFat(int x,int y) {
		super();
		_health*=5;
		_baseDelay*=3;
		_baseMovementSpeed/=3;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new EnemyFat(0, 0);
		set_atributos(a);
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}
