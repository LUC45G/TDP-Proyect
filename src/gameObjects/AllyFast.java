package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	aliado con el triple de velocidad de disparo
 */
public class AllyFast extends Ally {
	
	public AllyFast(int x,int y) {
		super();
		_delay/=3;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Ally2.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new AllyFast(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

}
