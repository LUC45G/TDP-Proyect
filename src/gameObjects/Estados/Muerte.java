package gameObjects;

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
	public void GetSprite(EnemyBase enemy1) {
		enemy1.SetSprite(_bank.GetDeadSprite(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetDeadSprite(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetDeadSprite(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetDeadSprite(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetDeadSprite(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetDeadSprite(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetDeadSprite(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetDeadSprite(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetDeadSprite(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetDeadSprite(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetDeadSprite(ally1));
	}

	@Override
	public void ChangeState(StateCharacter sc) {
	}

	@Override
	public void accept(VisitorState vs) {
	}
}
