package gameObjects;

import logicas.Controller;

public class DienteSquanchy extends StateCharacter {
	
	
	private StateCharacter _prev;
	protected int 		_powerUpLife;
	public DienteSquanchy(Character c, StateCharacter prev) {
		super(c, c.GetAttackSpeed()/3, c.GetStrength() * 2, 0);
		
		_prev = prev;
		_powerUpLife = 25;

		
		/*
		 * AgregarAtaqueVelocidad;
		 * 
		 */
	}

	@Override
	public void update() {
		if(++_delta%_delay==0) 
			Controller.GetInstance().AddDisparo(Disparar());
		
		if( --_powerUpLife <= 0 ) {
			miCh.SetState(_prev);
		}
	}

	
}
