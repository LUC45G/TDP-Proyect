package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	aliado con 5 veces la vida y 1/3 de velocidad de disparo
 */
public class AllyFat extends Ally {
	
	public AllyFat(int x,int y) {
		super();
		_delay=3;
		_health*=5;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Ally3.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	
	@Override
	public Character Clone() {
		Character a = new AllyFat(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}

}
