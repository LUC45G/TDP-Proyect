package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.VisitorBarricada;
/**
 * Barricada que detiene a los personajes y disparos
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public class Barricada extends ImmovableObject {
	/**
	 * Constructor que setea imagen,hitbox y costo
	 */
	private int _health;
	public Barricada() {
		super();
		_visitor=new VisitorBarricada();
		_sprite = new ImageIcon(this.getClass().getResource("/img/barricada.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_health = 100;
		_cost*=2;
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new Barricada();
	}
	
	public void receive_attack(int i) {
		_health-=i;
		if(_health<=0)
			Controller.GetInstance().Remove(this);
	}

}
