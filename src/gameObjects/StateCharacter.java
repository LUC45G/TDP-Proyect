package gameObjects;

import javax.swing.ImageIcon;

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


	public abstract ImageIcon GetSprite(AllyBase ally1) ;

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
