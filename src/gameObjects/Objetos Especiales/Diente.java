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
		_cost*=4;
	}
	
	public String toString() {
		return "squan";
	}

	@Override
	public ImmovableObject Clone() {
		Diente d = new Diente();
		set_atributos(d);
		d.set_visitor(new VisitorSquanchy());
		return d;
	}

	@Override
	public boolean IsAOE() {
		return true;
	}

}
