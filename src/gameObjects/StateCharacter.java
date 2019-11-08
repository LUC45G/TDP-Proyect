package gameObjects;

public abstract class StateCharacter {
	protected Bank _bank;
	protected Character miCh;
	protected int		_strength; 
	protected int		_delay;
	protected int		_delta;
	protected int 		_velocidad;
	
	public StateCharacter(Character c, int delay, int strength, int speed) {
		 miCh=c;
		_delay = delay;
		_delta = 0;
		_strength = strength;
		_velocidad = speed;
	}


	public abstract void update();
	
	public void ChangeState() {};
	
	public Disparo Disparar() {
		Disparo d = miCh.get_shoot().Clone();
		d.set_strength(_strength);
		d.SetY(miCh.GetHitbox().y + (miCh.GetHitbox().height/4 ));
		d.SetX( miCh.GetHitbox().x + ( miCh.GetHitbox().width/2));
		_delta = 0;
		return d;
	}


	protected int GetDelay() { return _delay; }


	protected int GetStrength() {
		return _strength;
	}

}
