package gameObjects;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.VisitorSquanchyState;
import logicas.VisitorState;

public class DienteSquanchy extends StateCharacter {
	
	
	protected int 		_powerUpLife;
	public DienteSquanchy(Character c, StateCharacter prev) {
		super(c, c.GetAttackSpeed()/3, c.GetStrength() * 2, 0);
		_visitorS=new VisitorSquanchyState();
		_prev = prev;
		_powerUpLife = 100;
	}

	@Override
	public void update() {
		if(++_delta%(_delay+1)==0) 
			Controller.GetInstance().AddDisparo(Disparar());

		if( --_powerUpLife <= 0 )
			miCh.ChangeState(_prev);
		
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
	
	public void ChangeState(StateCharacter sc) {
		if (sc==null) {
			miCh.ChangeState(new NormalState(miCh,_delay,_strength,_velocidad));
		}
		else {
			miCh.ChangeState(sc);
		}
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
		vs.visitSquanchy(this);
	}
}
