package gameObjects;

import javax.swing.ImageIcon;

public class Muerte extends StateCharacter {
	
	protected int _deathTimer;

	public Muerte(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		_deathTimer = 30;
	}

	@Override
	public void update() {
		if(--_deathTimer <= 0)
			miCh.receive_attack(1500);
	}
	@Override
	public ImageIcon GetSprite(Enemy1 enemy1) {
		return _bank.GetDeadSprite(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetDeadSprite(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetDeadSprite(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetDeadSprite(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetDeadSprite(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetDeadSprite(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetDeadSprite(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetDeadSprite(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetDeadSprite(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetDeadSprite(allyFast);
	}

	@Override
	public ImageIcon GetSprite(Ally1 ally1) {
		return _bank.GetDeadSprite(ally1);
	}
}
