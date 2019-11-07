package gameObjects;

public class Congelado extends StateCharacter {

	private StateCharacter _prev;
	protected int 		_powerUpLife;
	public Congelado(Character c, StateCharacter prev) {
		super(c, 0, 0, 0);
		_prev = prev;
		_powerUpLife = 25;
		
		/*
		 * c.SetSprite( Bank.GetFrozen(c) );
		 * 
		 */
	}

	@Override
	public void update() {
		if( --_powerUpLife <= 0 ) {
			miCh.SetState(_prev);
		}
	}
	
	

}
