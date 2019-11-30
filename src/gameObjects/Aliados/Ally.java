package gameObjects.Aliados;

import java.util.ArrayList;

import javax.swing.Icon;

import gameObjects.Character;
import gameObjects.Disparos.DisparoAliado;
import logicas.IObserver;
import logicas.Visitors.Visitor;
import logicas.Visitors.VisitorAlly;
import logicas.Visitors.VisitorRangeAliado;
/**
 * Representa a los aliados del juego
 * @author Pippig,Matias Gonazales, Lucas
 * 
 */
public abstract class Ally extends Character {
	/**
	 * Constructor, crea un disparo, setea costo y rango default, tambien setea los visitors del aliado y del rango
	 */
	protected Ally() {
		//nuevo disparo
		super();
		_shoot = new DisparoAliado(20, 150);
		_cost = 10;
		_range = 300;
		_visitor = new VisitorAlly(this);
		
		// Stats base
		_baseDelay = 25; 
		_baseStrength = 25;
		_baseMovementSpeed = 0; 
		
		//visitor del rango
		_boundingBox= new VisitorRangeAliado(this);
		_observers 	= new ArrayList<IObserver>();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitAlly(this);
	}

	public void set_atributos(Ally c){
		super.set_atributos(c);
		c.set_visitor(new VisitorAlly(c));
	}
	
	public abstract Ally Clone();
	
	/**
	 * Devuelve la cara
	 * @return the face
	 */
	public abstract Icon GetIcon();
	
}
