package gameObjects;

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
		_powerUpLife--;
		if( _powerUpLife <= 0 ) {
			miCh.ChangeState(_prev);
		}
	}

	@Override
	public void GetSprite(EnemyBase enemy1) {
		enemy1.SetSprite(_bank.GetAffectedSprite(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetAffectedSprite(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetAffectedSprite(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetAffectedSprite(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetAffectedSprite(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetAffectedSprite(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetAffectedSprite(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetAffectedSprite(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetAffectedSprite(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetAffectedSprite(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetAffectedSprite(ally1));
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