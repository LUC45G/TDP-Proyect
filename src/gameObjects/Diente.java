package gameObjects;

import java.awt.Rectangle;

import logicas.VisitorSquanchy;
/**
 * Objeto que activa un power-up a los aliados
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class Diente extends ImmovableObject {
	/**
	 * Constructor que setea visitor, hitbos y costo
	 */
	public Diente() {
		super();
		_visitor = new VisitorSquanchy();
		_hitbox = new Rectangle(0, 0, 0, 0);
		_cost*=20;
	}

	@Override
	public ImmovableObject Clone() {
		return new Diente();
	}

	@Override
	public void affect(Character c) {
		
	}

}
