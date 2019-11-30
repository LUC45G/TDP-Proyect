package gameObjects.Aliados;

import java.awt.Rectangle;

import javax.swing.Icon;

import gameObjects.Bank;
import gameObjects.Disparos.DisparoAliado;
import gameObjects.Estados.NormalState;
import gameObjects.Estados.StateCharacter;

/**
 * 
 *Aliado con el triple de vida y fuerza 
 * @author Pippig, Matias Gonzalez,Lucas
 */
public class AllyStrong extends Ally {

	/**
	 * Constructor que inicializa lo mismo que Character y setea el x e y de su hitbox
	 * @param x eje x de la hitbox
	 * @param y eje y de la hitbox
	 */
	public AllyStrong(int x,int y) {
		super();
		_health*=3;
		_baseStrength *= 3;
		_cost *= 10;
		_state = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.GetSprite(this);
		_hitbox = new Rectangle(x, y, _sprite.getIconWidth(), _sprite.getIconHeight());
		_shoot  = new DisparoAliado(25, 150);
	}
	
	@Override
	public Ally Clone() {
		Ally a = new AllyStrong(0, 0);
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
