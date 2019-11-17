package gameObjects;

import java.awt.Rectangle;

/**
 * 
 *	Aliado rapido con el triple de velocidad de disparo
 * @author Pippig, Matias Gonzales, Lucas
 */
public class AllyFast extends Ally {
	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllyFast(int x,int y) {
		super();
		_state = new NormalState(this, 13, 35, 0);

		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new AllyFast(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}
	
}
