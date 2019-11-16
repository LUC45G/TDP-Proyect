package gameObjects;

import javax.swing.ImageIcon;

public class EstadoProtegidoCaminando extends StateCharacter {
	private int ataquesRecibidos;

	public EstadoProtegidoCaminando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		ataquesRecibidos=0;
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
		return _bank.GetProtectedWalking(enemy1);
	}

	@Override
	public ImageIcon GetSprite(EnemyStrong enemyStrong) {
		return _bank.GetProtectedWalking(enemyStrong);
	}

	@Override
	public ImageIcon GetSprite(EnemySlim enemySlim) {
		return _bank.GetProtectedWalking(enemySlim);
	}

	@Override
	public ImageIcon GetSprite(EnemyFat enemyFat) {
		return _bank.GetProtectedWalking(enemyFat);
	}

	@Override
	public ImageIcon GetSprite(EnemyFast enemyFast) {
		return _bank.GetProtectedWalking(enemyFast);
	}

	@Override
	public ImageIcon GetSprite(EnemyBoss enemyBoss) {
		return _bank.GetProtectedWalking(enemyBoss);
	}

	@Override
	public ImageIcon GetSprite(AllyStrong allyStrong) {
		return _bank.GetProtectedWalking(allyStrong);
	}

	@Override
	public ImageIcon GetSprite(AllySlim allySlim) {
		return _bank.GetProtectedWalking(allySlim);
	}

	@Override
	public ImageIcon GetSprite(AllyFat allyFat) {
		return _bank.GetProtectedWalking(allyFat);
	}

	@Override
	public ImageIcon GetSprite(AllyFast allyFast) {
		return _bank.GetProtectedWalking(allyFast);
	}

	@Override
	public ImageIcon GetSprite(Ally1 ally1) {
		return _bank.GetProtectedWalking(ally1);
	}

	@Override
	public void ChangeState(StateCharacter sc) {
		if(sc==null) {
			EstadoProtegidoAtacando estadoNuevo=new EstadoProtegidoAtacando(miCh,_delay,_strength,_velocidad);
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
