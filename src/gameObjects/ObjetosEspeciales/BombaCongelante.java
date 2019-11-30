package gameObjects.ObjetosEspeciales;

import java.awt.Rectangle;

import logicas.Visitors.VisitorCongelado;
/**
 * Bomba que congela a todos los enemigos del juego
 * @author Pippig, Matias GOnzales, Lucas
 *
 */
public class BombaCongelante extends ImmovableObject {
	/**
	 * Constructor que setea un visitor,una hotbox y el costo 
	 * 
	 */
	public BombaCongelante() {
		super();
		_visitor = new VisitorCongelado();
		_hitbox = new Rectangle(0, 0, 0, 0);
		_cost*=3;
	}
	
	public String toString() {
		return "cong";
	}

	@Override
	public ImmovableObject Clone() {
		BombaCongelante bc = new BombaCongelante();
		set_atributos(bc);
		bc.set_visitor(new VisitorCongelado());
		return bc;
	}

	@Override
	public boolean IsAOE() {
		return true;
	}

}
