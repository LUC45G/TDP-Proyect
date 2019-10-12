/**
 * 
 */
package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Primer aliado
 *
 */
public class Ally1 extends Ally {

	/**
	 * 
	 * 
	 */
	public Ally1(int x, int y) {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/s.png"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		
	}

}
