package gameObjects;

import java.awt.Rectangle;

public class Enemy1 extends Enemy {
	
	public Enemy1(int x, int y) {
		super();
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);

		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	public Character Clone() {
		Character a = new Enemy1(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		_sprite = s.GetSprite(this);
	}

}
