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
import logicas.Visitors.VisitorProtegidoNormal;
import logicas.Visitors.VisitorState;

public class EstadoProtegidoCaminando extends StateCharacter {
	private int ataquesRecibidos;

	public EstadoProtegidoCaminando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
		ataquesRecibidos=0;
		_visitorS=new VisitorProtegidoNormal();
	}

	@Override
	public void update() {
		miCh.get_hitbox().x -= _velocidad;
	}
	
	public int getAtaquesRecibidos() {
		return ataquesRecibidos;
	}
	
	public void setAtaquesRecibidos(int ataquesRecibidos) {
		this.ataquesRecibidos = ataquesRecibidos;
	}

	@Override
	public void GetSprite(EnemyBase enemy1) {
		enemy1.SetSprite(_bank.GetProtectedWalking(enemy1));
	}

	@Override
	public void GetSprite(EnemyStrong enemyStrong) {
		enemyStrong.SetSprite(_bank.GetProtectedWalking(enemyStrong));
	}

	@Override
	public void GetSprite(EnemySlim enemySlim) {
		enemySlim.SetSprite(_bank.GetProtectedWalking(enemySlim));
	}

	@Override
	public void GetSprite(EnemyFat enemyFat) {
		enemyFat.SetSprite(_bank.GetProtectedWalking(enemyFat));
	}

	@Override
	public void GetSprite(EnemyFast enemyFast) {
		enemyFast.SetSprite(_bank.GetProtectedWalking(enemyFast));
	}

	@Override
	public void GetSprite(EnemyBoss enemyBoss) {
		enemyBoss.SetSprite(_bank.GetProtectedWalking(enemyBoss));
	}

	@Override
	public void GetSprite(AllyStrong allyStrong) {
		allyStrong.SetSprite(_bank.GetProtectedWalking(allyStrong));
	}

	@Override
	public void GetSprite(AllySlim allySlim) {
		allySlim.SetSprite(_bank.GetProtectedWalking(allySlim));
	}

	@Override
	public void GetSprite(AllyFat allyFat) {
		allyFat.SetSprite(_bank.GetProtectedWalking(allyFat)); 
	}

	@Override
	public void GetSprite(AllyFast allyFast) {
		allyFast.SetSprite(_bank.GetProtectedWalking(allyFast));
	}

	@Override
	public void GetSprite(AllyBase ally1) {
		ally1.SetSprite(_bank.GetProtectedWalking(ally1));
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
		vs.visitProtegidoCaminando(this);
	}
	
}
