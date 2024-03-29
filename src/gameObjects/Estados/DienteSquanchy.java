package gameObjects.Estados;

import gameObjects.Character;
import gameObjects.Aliados.AllyBase;
import gameObjects.Aliados.AllyFast;
import gameObjects.Aliados.AllyFat;
import gameObjects.Aliados.AllySlim;
import gameObjects.Aliados.AllyStrong;
import gameObjects.Enemigos.EnemyBase;
import gameObjects.Enemigos.EnemyBoss;
import gameObjects.Enemigos.EnemyFast;
import gameObjects.Enemigos.EnemyFat;
import gameObjects.Enemigos.EnemySlim;
import gameObjects.Enemigos.EnemyStrong;
import logicas.Controller;
import logicas.Visitors.VisitorSquanchyState;
import logicas.Visitors.VisitorState;

public class DienteSquanchy extends StateCharacter {
	
	
	protected int 		_powerUpLife;
	public DienteSquanchy(Character c, StateCharacter prev) {
		super(c, c.GetAttackSpeed()/3, c.GetStrength() * 2, 0);
		_visitorS=new VisitorSquanchyState();
		_prev = prev;
		_powerUpLife = 25;
	}

	@Override
	public void update() {
		_delta++;
		if(_delta%(_delay+1)==0) 
			Controller.GetInstance().AddDisparo(Disparar());
		_powerUpLife--;
		if( _powerUpLife <= 0 )
			miCh.ChangeState(_prev);
		
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

	
	public void ChangeState(StateCharacter sc) {
		if (sc==null) {
			miCh.ChangeState(new NormalState(miCh,_delay,_strength,_velocidad));
		}
		else {
			miCh.ChangeState(sc);
		}
	}
	@Override
	public void receive_attack(int d) {
		super.receive_attack(d);
		if(miCh.get_health()<=0) {
			miCh.ChangeState(new Muerte(miCh,_delay,_strength,_velocidad));
		}
	}

	@Override
	public void accept(VisitorState vs) {
		vs.visitSquanchy(this);
	}
}
