package gameObjects;

import java.awt.Rectangle;

/**
 * 
 *Aliado con el triple de vida y fuerza 
 * @author Pippig, Matias Gonzalez,Lucas
 */
public class AllyStrong extends Ally {

	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllyStrong(int x,int y) {
		super();
		_state = new NormalState(this, 25, 25, 0);
		_health*=3;
		_sprite = _state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot  = new DisparoAliado(25, 150);
	}
	
	@Override
	public Character Clone() {
		Character a = new AllyStrong(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	
	@Override
	public void SetState(StateCharacter s) {
		super.SetState(s);
		_sprite = s.GetSprite(this);
	}

}
