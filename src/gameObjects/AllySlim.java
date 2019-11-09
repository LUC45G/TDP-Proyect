package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	aliado con el quintuple de velocidad y 1/3 de fuerza
 */
public class AllySlim extends Ally {
	
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