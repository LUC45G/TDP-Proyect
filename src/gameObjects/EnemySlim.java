package gameObjects;

import java.awt.Rectangle;

/**
 * 
 * @author matia
 *	enemigo con el quintuple de velocidad y 1/3 de fuerza
 */
public class EnemySlim extends Enemy {
	
	public EnemySlim(int x,int y) {
		super();
		_baseDelay/=5;
		_range=100;
		_baseMovementSpeed*=5;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new EnemySlim(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		_sprite = s.GetSprite(this);
	}

}