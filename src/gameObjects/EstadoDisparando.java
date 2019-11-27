package gameObjects;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.VisitorDisparando;
import logicas.VisitorState;

public class EstadoDisparando extends StateCharacter {

	public EstadoDisparando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		_visitorS=new VisitorDisparando();
	}

	@Override
	public void update() {
		if(++_delta%(_delay+2)==0) 
			Controller.GetInstance().AddDisparo(Disparar());
	}

	@Override
	public void GetSprite(Enemy1 enemy1) {
		miCh.SetSprite(_bank.GetShootingSprite(enemy1));
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
	public ImageIcon GetSprite(AllyBase ally1) {
		return _bank.GetShootingSprite(ally1);
	}
	
	@Override
	protected void receive_attack(int d) {
		super.receive_attack(d);
		if(miCh.get_health()<=0) {
			miCh.ChangeState(new Muerte(miCh,_delay,_strength,_velocidad));
		}
	}

	@Override
	public void accept(VisitorState vs) {
		vs.visitDisparando(this);
	}
	
}
