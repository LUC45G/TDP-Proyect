package gameObjects;

import java.awt.Rectangle;

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
		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new EnemyStrong(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		_sprite = s.GetSprite(this);
	}

}
