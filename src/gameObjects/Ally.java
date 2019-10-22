package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;
import logicas.VisitorAlly;

public abstract class Ally extends Character {
	
	protected int _cost;
	protected int _delay;
	protected int _delta;

	protected Ally() {
		_delay=7;
		_velocidad=0;
		_visitor=new VisitorAlly(this);
		_shoot=new DisparoAliado();
		
	}

	protected Ally(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		_visitor=new VisitorAlly(this);
		_strength=3;
		_shoot=new DisparoAliado();
		_velocidad=0;
	}	
	
	protected Ally(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox, fuerza);
		_visitor=new VisitorAlly(this);
		_shoot=new DisparoAliado();
		_velocidad=0;
	}
	
	@Override
	public void Move() {
		if(++_delta%_delay==0)
			_controller.AddDisparo(this.Disparar());
	}
	
	public Disparo Disparar() {
		Disparo d = _shoot.Clone();
		d.SetX(_hitbox.x + (_hitbox.width+1));
		d.SetY(_hitbox.y);
		return d;
	}
	
	
	/**
	 * Consulta y devuelve el costo del aliado
	 * @return costo
	 */
	public int GetCost() {
		return _cost;
	}

	public void receive_attack(Disparo miDisparo) {
		this.set_health(_health-miDisparo.get_strength());
		System.out.println("Ally Visitado por: " + miDisparo.hashCode());
		//este metodo es con fines funcionales no se si es la idea que sea asi
	}
	public void accept(Visitor v) {
		v.visitAlly(this);
	}
}
