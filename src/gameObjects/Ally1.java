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

	public Ally1(int x, int y) {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/Ally1.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot = new DisparoAliado();
		_delay = 7;
	}
	
	public Character Clone() {
		Character a = new Ally1(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

}
