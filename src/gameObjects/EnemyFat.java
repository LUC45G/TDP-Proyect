package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	enemigo con 1/3 de velocidad y 5 veces la vida
 */
public class EnemyFat extends Enemy {

	public EnemyFat(int x,int y) {
		super();
		_state = new NormalState(this, 25, 25, 3);
		_health*=5;

		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new EnemyFat(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}
	
}
