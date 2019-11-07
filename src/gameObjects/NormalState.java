package gameObjects;

public class NormalState extends StateCharacter {
	
	public NormalState(Character c, int delay, int fuerza, int velocidad) {
		super(c, delay, fuerza, velocidad);
		
	}
	@Override
	public void update() {
		miCh.GetHitbox().x -= _velocidad;
		
	}
	
	@Override
	public void ChangeState() {
		miCh.SetState(new EstadoDisparando(miCh, _delay, _strength, _velocidad));
	}

}
