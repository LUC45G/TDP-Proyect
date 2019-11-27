package gameObjects;

import logicas.VisitorNormalState;
import logicas.VisitorState;

public class NormalState extends StateCharacter {
	
	public NormalState(Character c, int delay, int fuerza, int velocidad) {
		super(c, delay, fuerza, velocidad);
		_visitorS=new VisitorNormalState();
		
	}
	@Override
	public void update() {
		miCh.GetHitbox().x -= _velocidad;
	}
	
	@Override
	public void GetSprite(Enemy1 enemy1) {
		enemy1.SetSprite(_bank.GetNormalSprite(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetNormalSprite(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetNormalSprite(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetNormalSprite(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetNormalSprite(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetNormalSprite(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetNormalSprite(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetNormalSprite(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetNormalSprite(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetNormalSprite(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetNormalSprite(ally1));
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
		vs.visitNormal(this);
	}
}
