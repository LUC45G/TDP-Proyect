/**
 * 
 */
package gameObjects;

import java.awt.Rectangle;

/**
 * Aliado concreto basico que extiende a Character
 * @author Pippig, Matias Gonzales, Lucas
 * 
 */
public class AllyBase extends Ally {
	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllyBase(int x, int y) {
		super();

		_state = new NormalState(this, 25, 25, 0);
		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new AllyBase(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	
	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}

}
