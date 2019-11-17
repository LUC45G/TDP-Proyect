package gameObjects;

import java.awt.Rectangle;

/**
 * 
 * Aliado con 5 veces la vida y 1/3 de velocidad de disparo
 * @author Pippig, Matias Gonzales, Lucas
 */
public class AllyFat extends Ally {

	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllyFat(int x,int y) {
		super();
		_state = new NormalState(this, 40, 20, 0);
		_health*=5;

		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new AllyFat(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	
	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}
}
