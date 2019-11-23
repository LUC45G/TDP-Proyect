package gameObjects;

import javax.swing.ImageIcon;

import logicas.VisitorProtegidoAtacando;
import logicas.VisitorState;

public class EstadoProtegidoAtacando extends StateCharacter {
	private int ataquesRecibidos;

	public EstadoProtegidoAtacando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		_visitorS=new VisitorProtegidoAtacando();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public int getAtaquesRecibidos() {
		return ataquesRecibidos;
	}
	
	public void setAtaquesRecibidos(int ataquesRecibidos) {
		this.ataquesRecibidos = ataquesRecibidos;
	}
	
	@Override
	public ImageIcon GetSprite(Enemy1 enemy1) {
		return _bank.GetProtectedShootingSprite(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetProtectedShootingSprite(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetProtectedShootingSprite(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetProtectedShootingSprite(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetProtectedShootingSprite(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetProtectedShootingSprite(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetProtectedShootingSprite(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetProtectedShootingSprite(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetProtectedShootingSprite(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetProtectedShootingSprite(allyFast);
	}

	@Override
	public ImageIcon GetSprite(AllyBase ally1) {
		return _bank.GetProtectedShootingSprite(ally1);
	}
	
	@Override
	protected void receive_attack(int d) {
		ataquesRecibidos++;
		if(ataquesRecibidos>=5) {
			ChangeState(new NormalState(miCh,_delay,_strength,_velocidad));
		}
	}

	@Override
	public void accept(VisitorState vs) {
		vs.visitProtegidoDisparando(this);		
	}
}
