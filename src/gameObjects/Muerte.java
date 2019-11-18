package gameObjects;

import javax.swing.ImageIcon;

import logicas.VisitorState;

public class Muerte extends StateCharacter {
	
	protected int _deathTimer;

	public Muerte(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		_deathTimer = 15;
		c.NotVisible();
		c.notificar();
	}

	@Override
	public void update() {
		_deathTimer--;
		
		if(_deathTimer == 0)
			miCh.Die();
			
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
	public ImageIcon GetSprite(AllyBase ally1) {
		return _bank.GetDeadSprite(ally1);
	}

	@Override
	public void ChangeState(StateCharacter sc) {
	}

	@Override
	public void accept(VisitorState vs) {
	}
}
