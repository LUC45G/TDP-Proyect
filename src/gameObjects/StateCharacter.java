package gameObjects;

import javax.swing.ImageIcon;

public abstract class StateCharacter {
	protected Bank _bank;
	protected Character miCh;
	protected StateCharacter(Character c) {
		_bank=new Bank();
		miCh=c;
	}
	
	public abstract ImageIcon GetImage();
	
	public Character getCharacter() {
		return miCh;
	}
}
