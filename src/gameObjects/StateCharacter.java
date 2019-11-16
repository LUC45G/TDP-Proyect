package gameObjects;

import javax.swing.ImageIcon;

public abstract class StateCharacter {
	
	protected Character miCh;
	protected int		_strength; 
	protected int		_delay;
	protected int		_delta;
	protected int 		_velocidad;
	protected Bank		_bank;
	
	public StateCharacter(Character c, int delay, int strength, int speed) {
		 miCh=c;
		_delay = delay;
		_bank = Bank.GetInstance();
		_delta = 0;
		_strength = strength;
		_velocidad = speed;
	}


	public abstract void update();
	
	public abstract void ChangeState(StateCharacter sc) ;
	
	public void GoNormal() {
		miCh.SetState(new NormalState(miCh, _delay, _strength, _velocidad));
	}
	
	public Disparo Disparar() {
		Disparo d = miCh.get_shoot().Clone();
		d.set_strength(_strength);
		d.SetY(miCh.GetHitbox().y + (miCh.GetHitbox().height/4 ));
		d.SetX( miCh.GetHitbox().x + ( miCh.GetHitbox().width/2));
		_delta = 0;
		return d;
	}


	public int GetDelay() { return _delay; }


	public int GetStrength() { return _strength;	}
	
	public int GetVelocidad() { return _velocidad;   }


	public abstract ImageIcon GetSprite(Enemy1 enemy1);


	public abstract ImageIcon GetSprite(EnemyStrong enemyStrong) ;


	public abstract ImageIcon GetSprite(EnemySlim enemySlim);


	public abstract ImageIcon GetSprite(EnemyFat enemyFat) ;


	public abstract ImageIcon GetSprite(EnemyFast enemyFast) ;


	public abstract ImageIcon GetSprite(EnemyBoss enemyBoss) ;


	public abstract ImageIcon GetSprite(AllyStrong allyStrong);


	public abstract ImageIcon GetSprite(AllySlim allySlim);


	public abstract ImageIcon GetSprite(AllyFat allyFat) ;


	public abstract ImageIcon GetSprite(AllyFast allyFast);


	public abstract ImageIcon GetSprite(Ally1 ally1) ;


	protected void receive_attack(int d) {
		miCh.set_health(miCh.get_health()-d);
	}
}
