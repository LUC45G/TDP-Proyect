package gameObjects.Estados;

import gameObjects.Aliados.AllyBase;
import gameObjects.Character;
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
import logicas.Visitors.VisitorProtegidoAtacando;
import logicas.Visitors.VisitorState;

public class EstadoProtegidoAtacando extends StateCharacter {
	private int ataquesRecibidos;

	public EstadoProtegidoAtacando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		_visitorS=new VisitorProtegidoAtacando();
	}

	@Override
	public void update() {
		if(++_delta%(_delay+2)==0) 
			Controller.GetInstance().AddDisparo(Disparar());
	}

	/**
	 * Devuelve la cantidad de ataque recibidos restantes
	 * @return cantidad de ataque recibidos restantes
	 */
	public int getAtaquesRecibidos() {
		return ataquesRecibidos;
	}
	
	/**
	 * Setea la cantidad de ataques recibidos restantes
	 * @param ataquesRecibidos nueva cantidad de ataques recibidos restantes
	 */
	public void setAtaquesRecibidos(int ataquesRecibidos) {
		this.ataquesRecibidos = ataquesRecibidos;
	}
	
	@Override
	public void GetSprite(EnemyBase enemy1) {
		enemy1.SetSprite(_bank.GetProtectedShootingSprite(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetProtectedShootingSprite(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetProtectedShootingSprite(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetProtectedShootingSprite(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetProtectedShootingSprite(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetProtectedShootingSprite(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetProtectedShootingSprite(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetProtectedShootingSprite(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetProtectedShootingSprite(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetProtectedShootingSprite(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetProtectedShootingSprite(ally1));
	}

	@Override
	public void receive_attack(int d) {
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
