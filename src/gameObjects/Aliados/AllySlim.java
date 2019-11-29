package gameObjects;

import java.awt.Rectangle;

import javax.swing.Icon;

/**
 * Aliado con el quintuple de velocidad y 1/3 de fuerza
 * @author Pippig, Matias Gonzales, Lucas
 */

public class AllySlim extends Ally {

	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllySlim(int x,int y) {
		super();
		_baseDelay /= 5;
		_baseStrength /= 3;
		_cost *= 15;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot  = new DisparoAliado(13, 300);
	}
	@Override
	public Ally Clone() {
		Ally a = new AllySlim(0, 0);
		set_atributos(a);
		return a;
	}
	@Override
	public void ChangeState(StateCharacter s) {
		super.ChangeState(s);
		s.GetSprite(this);
	}

	@Override
	public Icon GetIcon() {
		return Bank.GetInstance().GetIcon(this);
	}

}