package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorBarricada;
import logicas.VisitorObserver;
/**
 * Piedra que detiene a los personajes y disparos
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class PiedraMapa extends MapObject {

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
	
	public MapObject Clone() {
		PiedraMapa p = new PiedraMapa();
		set_atributos(p);
		return p;
	}

	@Override
	public void set_atributos(MapObject c){
		super.set_atributos(c);
		for(IObserver o:_observers) {
			c.agregarObservador(o);
		}
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitPiedraMapa(this);
	}
	
	@Override
	public void Update() {}
	
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

}
