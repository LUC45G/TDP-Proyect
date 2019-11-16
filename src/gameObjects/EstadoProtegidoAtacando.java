package gameObjects;

import javax.swing.ImageIcon;

public class EstadoProtegidoAtacando extends StateCharacter {
	private int ataquesRecibidos;

	public EstadoProtegidoAtacando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		// TODO Auto-generated constructor stub
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
	public ImageIcon GetSprite(Ally1 ally1) {
		return _bank.GetProtectedShootingSprite(ally1);
	}
	
	@Override
	public void ChangeState(StateCharacter sc) {
		if(sc==null) {
			EstadoProtegidoCaminando estadoNuevo=new EstadoProtegidoCaminando(miCh,_delay,_strength,_velocidad);
			//Actualizo la cantidad de ataques recibidos en ambas clases (se podria abstraer en una clase estadoProtegido pero qsy)  
			estadoNuevo.setAtaquesRecibidos(ataquesRecibidos);
			miCh.ChangeState(estadoNuevo);
		}
		else {
			//deberia cambiar aca?
		}
	}
	
	@Override
	protected void receive_attack(int d) {
		ataquesRecibidos++;
		if(ataquesRecibidos>=5) {
			ChangeState(new NormalState(miCh,_delay,_strength,_velocidad));
		}
	}
}
