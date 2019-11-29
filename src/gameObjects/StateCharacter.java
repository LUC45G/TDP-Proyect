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
	
	protected StateCharacter(Character c, int delay, int strength, int speed) {
		 miCh=c;
		_delay = delay;
		_bank = Bank.GetInstance();
		_delta = 0;
		_strength = strength;
		_velocidad = speed;
	}
	


	/**
	 * Actualiza la situacion del pj correspondiente
	 */
	public abstract void update();
	
	/**
	 * @param sc Estado del personaje que se va a asignar
	 * si sc es nulo se setea el estado disparando si no el que se envie por parametro
	 */
	public void ChangeState(StateCharacter sc) {
			miCh.ChangeState(sc);
	}
	
	
	/**
	 * Genera un disparo en la locacion del personaje
	 * @return Disparo generado
	 */
	public Disparo Disparar() {
		Disparo d = miCh.get_shoot().Clone();
		d.set_strength(_strength);
		d.SetY(miCh.get_hitbox().y + (miCh.get_hitbox().height/4 ));
		d.SetX( miCh.get_hitbox().x + ( miCh.get_hitbox().width/2));
		_delta = 0;
		return d;
	}



	/**
	 * Devuelve la velocidad de ataque base
	 * @return velocidad de ataque base
	 */
	public int GetBaseDelay() { return miCh.get_delay(); }
	
	/**
	 * Devuelve la fuerza base
	 * @return fuerza base
	 */
	public int GetBaseStrength() { return miCh.get_strength();	}
	
	/**
	 * Devuelve la velocidad base
	 * @return velocidad base
	 */
	public int GetBaseVelocidad() { return miCh.get_velocidad();   }

	/**
	 * Devuelve la velocidad de ataque actual
	 * @return velocidad de ataque actual
	 */
	public int GetDelay() { return _delay; }

	/**
	 * Devuelve la fuerza actual
	 * @return fuerza actual
	 */
	public int GetStrength() { return _strength;	}
	
	/**
	 * Devuelve la velocidad actual
	 * @return velocidad actual
	 */
	public int GetVelocidad() { return _velocidad;   }


	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemy1 enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemyBase enemy1);

	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemyStrong enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemyStrong enemyStrong) ;

	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemySlim enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemySlim enemySlim);

	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemyFat enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemyFat enemyFat) ;

	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemyFast enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemyFast enemyFast) ;

	/**
	 * Setea el sprite correspondiente a cada estado y enemigo
	 * @param enemyBoss enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(EnemyBoss enemyBoss) ;

	/**
	 * Setea el sprite correspondiente a cada estado y aliado
	 * @param allyStrong enemigo al que cambiar el sprite
	 */
	public abstract void GetSprite(AllyStrong allyStrong);


	/**
	 * Setea el sprite correspondiente a cada estado y aliado
	 * @param allySlim aliado al que cambiar el sprite
	 */
	public abstract void GetSprite(AllySlim allySlim);


	/**
	 * Setea el sprite correspondiente a cada estado y aliado
	 * @param allyFat aliado al que cambiar el sprite
	 */
	public abstract void GetSprite(AllyFat allyFat) ;

	/**
	 * Setea el sprite correspondiente a cada estado y aliado
	 * @param allyFast aliado al que cambiar el sprite
	 */
	public abstract void GetSprite(AllyFast allyFast);

	/**
	 * Setea el sprite correspondiente a cada estado y aliado
	 * @param ally1 aliado al que cambiar el sprite
	 */
	public abstract void GetSprite(AllyBase ally1) ;

	/**
	 * Acepta o no el visitor de estados, segun corresponda
	 * @param vs visitor de estados
	 */
	public abstract void accept(VisitorState vs) ;
	
	/**
	 * Devuelve el personaje asociado al estado
	 * @return character asociado
	 */
	public Character GetCharacter() {
		return miCh;
	}
	
	/**
	 * Devuelve el visitor asociado al estado
	 * @return visitor asociado
	 */
	public VisitorState GetVisitor(){
		return _visitorS;
	}
	
	/**
	 * Efectua el recibimiento del daño
	 * @param d vida a restar
	 */
	protected void receive_attack(int d) {
		miCh.set_health(miCh.get_health()-d);
	}
}
