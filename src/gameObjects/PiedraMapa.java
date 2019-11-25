package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorBarricada;
import logicas.VisitorObserver;
/**
 * Piedra que detiene a los personajes y disparos
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class PiedraMapa extends ImmovableObject {

	private int _health; //modularizar
	private ArrayList<IObserver> _observers;
	
	/**
	 * Constructor que setea imagen y hitbox
	 */
	public PiedraMapa() {
		super();
		_observers = new ArrayList<IObserver>();
		_visitor = new VisitorBarricada();
		_sprite = new ImageIcon(this.getClass().getResource("/img/piedra_mapa.png"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_health=1500;
	}
	
	@Override
	public void affect(Character c) {
		// Setear _sprite de escudo
	}

	@Override
	public ImmovableObject Clone() {
		return new PiedraMapa();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitPiedraMapa(this);
	}
	
	@Override
	public void Update()
	{}
	
	@Override
	public void receive_attack(int i) {
		_health-=i;
		
		if(_health<=0) {
			Controller.GetInstance().Remove(this);
			_visible = false;
			notificar();
		}
		
	}
	
	public void acceptObserver(VisitorObserver vo) {
		vo.visitAllyObservado(this);
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
