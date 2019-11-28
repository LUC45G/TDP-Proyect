package gameObjects;

import java.util.ArrayList;

import javax.swing.Icon;

import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorAlly;
import logicas.VisitorRangeAliado;
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
	
	/**
	 * Setea los atributos de este personaje a otro
	 */
	public void set_atributos(Ally c){
		super.set_atributos(c);
		if(c.get_visitor()!=null)
			System.out.println("cualquuer cosa");
		//c.set_visitor(new VisitorAlly(c));
	}
	/**
	 * Devuelve la cara
	 * @return the face
	 */
	public abstract Icon GetIcon();
	
	@Override
	public Ally Clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
