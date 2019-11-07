package gameObjects;

import logicas.Controller;

public class EstadoDisparando extends StateCharacter {

	public EstadoDisparando(Character c, int delay, int strength, int speed) {
		super(c, delay, strength, speed);
	}

	@Override
	public void update() {
		if(++_delta%_delay==0) 
			Controller.GetInstance().AddDisparo(Disparar());
	}

}
