package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorBarricada;
/**
 * Barricada que detiene a los personajes y disparos
 * @author Pippig, Matias Gonzalez, Lucas
 *
 */
public class Barricada extends ImmovableObject {
	
	private int _health;

	private ArrayList<IObserver> _observers;
	
	/**
	 * Constructor que setea imagen,hitbox y costo
	 */
	public Barricada() {
		super();
		_visitor=new VisitorBarricada();
		_sprite = new ImageIcon(this.getClass().getResource("/img/barricada.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_observers = new ArrayList<IObserver>();
		_health = 500;
		_cost*=2;
	}
	
	public void set_health(int _health) {
		this._health = _health;
	}
	
	public void set_observers(ArrayList<IObserver> _observers) {
		this._observers = _observers;
	}

	public String toString() {
		return "caja";
	}
	
	@Override
	public ImmovableObject Clone() {
		Barricada b= new Barricada();
		set_atributos(b);
		b.set_health(_health);
		b.set_visitor(new VisitorBarricada());
		return b;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitBarricada(this);
	}
	
	@Override
	public void receive_attack(int i) {
		_health-=i;
		if(_health<=0) {
			Controller.GetInstance().Remove(this);
			_visible = false;
			notificar();
		}
	}

	@Override
	public void agregarObservador(IObserver observador) {
		_observers.add(observador);
	}

	@Override
	public void eliminarObservador(IObserver observador) {
		_observers.remove(observador);
	}
	
	@Override
	public boolean notificar() {
		for(IObserver o : _observers)
			o.StopShooting();
		
		return false;
	}

	@Override
	public boolean IsAOE() {
		return false;
	}

}
