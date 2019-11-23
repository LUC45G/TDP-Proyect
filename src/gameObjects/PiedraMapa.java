package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
/**
 * Piedra que detiene a los personajes y disparos
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class PiedraMapa extends ImmovableObject {
	/**
	 * Constructor que setea imagen y hitbox
	 */
	public PiedraMapa() {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/piedra_mapa.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new PiedraMapa();
	}

}
