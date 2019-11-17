package gameObjects;

import java.awt.Rectangle;

/**
 * Aliado con el quintuple de velocidad y 1/3 de fuerza
 * @author Pippig, Matias Gonzales, Lucas
 */

public class AllySlim extends Ally {

	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllySlim(int x,int y) {
		super();
		_state = new NormalState(this, 17, 13, 0);

		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot  = new DisparoAliado(13, 300);
	}
	@Override
	public Character Clone() {
		Character a = new AllySlim(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	
	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}

}