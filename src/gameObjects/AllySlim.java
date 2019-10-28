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
		_delay+=5;
		_sprite = new ImageIcon(this.getClass().getResource("/img/Ally4.gif"));
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot=new DisparoAliado(_strength/3);
	}
	@Override
	public Character Clone() {
		Character a = new AllySlim(0, 0);
		// Espacio por si hay que setear algun otro valor
		return a;
	}
	@Override
	public void setPeace() {
		_sprite=_bank.getPeace(this);
		
	}

	@Override
	public void setAngry() {
		_sprite=_bank.getAngry(this);
		
	}

}