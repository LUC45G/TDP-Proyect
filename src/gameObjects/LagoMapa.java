package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
/**
 * Objeto que no permite que ningun personaje pase por el lugar que ocupe
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class LagoMapa extends ImmovableObject {
	/**
	 * Constructor que setea Imagen y hitbox
	 */
	public LagoMapa() {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/fuego_lago.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new LagoMapa();
	}

}
