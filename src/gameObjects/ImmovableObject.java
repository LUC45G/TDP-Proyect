package gameObjects;

import javax.swing.ImageIcon;

import logicas.IObserved;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorPowerUp;
/**
 * Objetos inamovibles que pueden aparecer en el juego
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public abstract class ImmovableObject extends GameObject implements IObserved {
	/**
	 * Constructor de un objeto inamovible con un visitor y costo 100
	 */
	protected ImmovableObject() {
		_visitor = new VisitorPowerUp();
		_cost=100;
	}
	/**
	 * El disparo miDisparo es afectado por este objeto
	 * @param miDisparo Disparo qeuse vera afectado
	 */
	public void affect(Disparo miDisparo) {
	}

	/**
	 * El Personaje c es afectado por este objeto
	 * @param c Personaje que se vera afectado
	 */
	public abstract void affect(Character c);
	
	@Override
	public void accept(Visitor v) {
		v.visitImmovableObject(this);
	}

	@Override
	public void Update() {
		
	}

	/**
	 * Crea una copia del Objeto y la devuleve
	 * @return Retorna una copia del objeto
	 */
	public abstract ImmovableObject Clone();
	
	/**
	 * Devuelve  la imagen relacionada con el objeto inamovible
	 * @return Retorna la imagen del objeto
	 */
	public ImageIcon GetSpriteImmovableObject(){
		return null;
		
	}
	
	public void agregarObservador(IObserver observador) {}
	public void eliminarObservador(IObserver observador) {}
	
	/**
	 * Pregunta si el power up es de area de efecto
	 * @return true si debe afectar en area, false si no
	 */
	public abstract boolean IsAOE();
	
}
