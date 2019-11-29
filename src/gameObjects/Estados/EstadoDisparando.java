package gameObjects;

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
		_delta++;
		if(_delta%(_delay+2)==0) 
			Controller.GetInstance().AddDisparo(Disparar());
	}

	@Override
	public void GetSprite(EnemyBase enemy1) {
		enemy1.SetSprite(_bank.GetShootingSprite(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetShootingSprite(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetShootingSprite(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetShootingSprite(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetShootingSprite(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetShootingSprite(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetShootingSprite(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetShootingSprite(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetShootingSprite(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetShootingSprite(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetShootingSprite(ally1));
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
