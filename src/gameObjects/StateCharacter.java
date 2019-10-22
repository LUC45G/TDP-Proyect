package gameObjects;

import javax.swing.ImageIcon;

public abstract class StateCharacter {
	protected Bank _bank;
	protected Character miCh;
	protected StateCharacter(Character c) {}
	public abstract ImageIcon GetImage();
}
