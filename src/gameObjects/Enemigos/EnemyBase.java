package gameObjects;

import java.awt.Rectangle;

public class EnemyBase extends Enemy {
	
	public EnemyBase(int x, int y) {
		super();
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);

		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=2;
	}
	
	public Enemy Clone() {
		Enemy a = new EnemyBase(0, 0);
		set_atributos(a);
		return a;
	}
	
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

}
