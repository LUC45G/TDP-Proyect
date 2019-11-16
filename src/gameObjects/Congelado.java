package gameObjects;

import javax.swing.ImageIcon;

public class Congelado extends StateCharacter {

	private StateCharacter _prev;
	protected int 		_powerUpLife;
	public Congelado(Character c, StateCharacter prev) {
		super(c, 0, 0, 0);
		_prev = prev;
		_powerUpLife = 200;
	}

	@Override
	public void update() {
		if( --_powerUpLife <= 0 ) {
			miCh.SetState(_prev);
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
	public ImageIcon GetSprite(Ally1 ally1) {
		return _bank.GetAffectedSprite(ally1);
	}
	
}