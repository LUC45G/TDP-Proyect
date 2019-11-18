package gameObjects;

import javax.swing.ImageIcon;

import logicas.VisitorCongeladoState;
import logicas.VisitorState;

public class Congelado extends StateCharacter {

	protected int 		_powerUpLife;
	public Congelado(Character c, StateCharacter prev) {
		super(c,c.GetAttackSpeed(), c.GetStrength(), 0);
		_prev = prev;
		_powerUpLife = 100;
		_visitorS=new VisitorCongeladoState();
	}

	@Override
	public void update() {
		if( --_powerUpLife <= 0 ) {
			miCh.ChangeState(_prev);
		}
	}

	@Override
	public ImageIcon GetSprite(Enemy1 enemy1) {
		return _bank.GetAffectedSprite(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetAffectedSprite(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetAffectedSprite(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetAffectedSprite(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetAffectedSprite(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetAffectedSprite(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetAffectedSprite(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetAffectedSprite(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetAffectedSprite(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetAffectedSprite(allyFast);
	}

	@Override
	public ImageIcon GetSprite(AllyBase ally1) {
		return _bank.GetAffectedSprite(ally1);
	}

	@Override
	public void ChangeState(StateCharacter sc) {
		if (_powerUpLife<=0)
			miCh.ChangeState(sc);
		
	}
	protected void receive_attack(int d) {
		super.receive_attack(d);
		if(miCh.get_health()<=0) {
			miCh.ChangeState(new Muerte(miCh,_delay,_strength,_velocidad));
		}
	}

	@Override
	public void accept(VisitorState vs) {
		vs.visitCongelado(this);
		
	}
}