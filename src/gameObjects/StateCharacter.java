package gameObjects;

import logicas.VisitorState;

public abstract class StateCharacter {
	
	protected Character miCh;
	protected VisitorState _visitorS;
	protected int		_strength; 
	protected int		_delay;
	protected int		_delta;
	protected int 		_velocidad;
	protected Bank		_bank;
	protected StateCharacter _prev;
	
	public StateCharacter(Character c, int delay, int strength, int speed) {
		 miCh=c;
		_delay = delay;
		_bank = Bank.GetInstance();
		_delta = 0;
		_strength = strength;
		_velocidad = speed;
	}
	
	public boolean equals(StateCharacter sc) {
		return (miCh == sc.miCh) && (_strength == sc._strength) && (_delay == sc._delay) && (_velocidad == sc._velocidad);
	}


	public abstract void update();
	
	/**
	 * @param sc Estado del personaje que se va a asignar
	 * si sc es nulo se setea el estado disparando si no el que se envie por parametro
	 */
	public void ChangeState(StateCharacter sc) {
			miCh.ChangeState(sc);
	}
	
	public Disparo Disparar() {
		Disparo d = miCh.get_shoot().Clone();
		d.set_strength(_strength);
		d.SetY(miCh.GetHitbox().y + (miCh.GetHitbox().height/4 ));
		d.SetX( miCh.GetHitbox().x + ( miCh.GetHitbox().width/2));
		_delta = 0;
		return d;
	}



	public int GetBaseDelay() { return miCh.get_delay(); }
	
	public int GetBaseStrength() { return miCh.get_strength();	}
	
	public int GetBaseVelocidad() { return miCh.get_velocidad();   }

	public int GetDelay() { return _delay; }

	public int GetStrength() { return _strength;	}
	
	public int GetVelocidad() { return _velocidad;   }


	public abstract void GetSprite(Enemy1 enemy1);


	public abstract void GetSprite(EnemyStrong enemyStrong) ;


	public abstract void GetSprite(EnemySlim enemySlim);


	public abstract void GetSprite(EnemyFat enemyFat) ;


	public abstract void GetSprite(EnemyFast enemyFast) ;


	public abstract void GetSprite(EnemyBoss enemyBoss) ;


	public abstract void GetSprite(AllyStrong allyStrong);


	public abstract void GetSprite(AllySlim allySlim);


	public abstract void GetSprite(AllyFat allyFat) ;


	public abstract void GetSprite(AllyFast allyFast);


	public abstract void GetSprite(AllyBase ally1) ;

	public abstract void accept(VisitorState vs) ;
	
	public Character GetCharacter() {
		return miCh;
	}
	public VisitorState GetVisitor(){
		return _visitorS;
	}
	protected void receive_attack(int d) {
		miCh.set_health(miCh.get_health()-d);
	}
}
