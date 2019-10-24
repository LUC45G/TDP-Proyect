package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	Aliado con el triple de vida/fuerza 
 */
public class AllyStrong extends Ally {
	
	public AllyStrong(int x,int y) {
		super();
		_strength*=3;
		_health*=3;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Ally5.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
	}
	@Override
	public Character Clone() {
		Character a = new AllyStrong(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void setPeace() {
		_bank.getPeace(this);
		
	}

	@Override
	public void setAngry() {
		_bank.getAngry(this);
		
	}

}