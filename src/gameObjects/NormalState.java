package gameObjects;

import javax.swing.ImageIcon;

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
	public ImageIcon GetSprite(Enemy1 enemy1) {
		return _bank.GetNormalSprite(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetNormalSprite(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetNormalSprite(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetNormalSprite(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetNormalSprite(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetNormalSprite(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetNormalSprite(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetNormalSprite(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetNormalSprite(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetNormalSprite(allyFast);
	}

	@Override
	public ImageIcon GetSprite(AllyBase ally1) {
		return _bank.GetNormalSprite(ally1);
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
