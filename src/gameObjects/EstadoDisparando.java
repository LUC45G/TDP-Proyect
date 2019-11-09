package gameObjects;

import javax.swing.ImageIcon;

import logicas.Controller;

public class EstadoDisparando extends StateCharacter {

	public EstadoDisparando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
	}

	@Override
	public void update() {
		if(++_delta%_delay==0) 
			Controller.GetInstance().AddDisparo(Disparar());
	}

	@Override
	public ImageIcon GetSprite(Enemy1 enemy1) {
		return _bank.GetShootingSprite(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetShootingSprite(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetShootingSprite(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetShootingSprite(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetShootingSprite(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetShootingSprite(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetShootingSprite(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetShootingSprite(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetShootingSprite(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetShootingSprite(allyFast);
	}

	@Override
	public ImageIcon GetSprite(Ally1 ally1) {
		return _bank.GetShootingSprite(ally1);
	}
}
