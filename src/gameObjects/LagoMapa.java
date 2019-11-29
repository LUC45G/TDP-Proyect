package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorPowerUp;
/**
 * Objeto que no permite que ningun personaje pase por el lugar que ocupe
 * @author Pippig, Matias Gonsalez Lucas
 *
 */
public class LagoMapa extends MapObject {
	private int _deathTimer;

	/**
	 * Constructor que setea Imagen y hitbox
	 */
	public LagoMapa() {
		super();
		_sprite = new ImageIcon(this.getClass().getResource("/img/fuego_lago.gif"));
		_hitbox = new Rectangle(0, 0, _sprite.getIconWidth(), _sprite.getIconHeight());
		_deathTimer=17*12;//agregar un cero
		_observers = new ArrayList<IObserver>();
		_visitor=new VisitorPowerUp();
	}

	public MapObject Clone() {
		LagoMapa lm = new LagoMapa();
		lm.set_deathTimer(_deathTimer);
		return lm;
	}
	public int get_deathTimer() {
		return _deathTimer;
	}

	public void set_deathTimer(int _deathTimer) {
		this._deathTimer = _deathTimer;
	}

	public void Update() {
		--_deathTimer;
		
		if(_deathTimer == 0)
			receive_attack(0);
	}
	@Override
	public void accept(Visitor v) {
		v.visitLagoMapa(this);
	}
}
