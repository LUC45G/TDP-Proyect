package gameObjects.ObjetosEspeciales;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitors.VisitorBombaAtomica;
/**
 * Bomba que mata a todos los personajes del juego
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public class BombaAtomica extends ImmovableObject {
	/**
	 * Constructor que setea visitor, hitbox, imagen y costo
	 */
	public BombaAtomica() {
		super();
		_visitor = new VisitorBombaAtomica();
		_sprite = new ImageIcon(this.getClass().getResource("/img/moab.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_cost*=6;
		_deathTimer = 40;
	}

	public String toString() {
		return "moab";
	}
	
	@Override
	public ImmovableObject Clone() {
		BombaAtomica ba = new BombaAtomica();
		set_atributos(ba);
		ba.set_visitor(new VisitorBombaAtomica());
		return ba;
	}
	@Override
	public boolean IsAOE() {
		return true;
	}
}
