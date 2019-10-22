package gameObjects;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	 *	estado en el que el personaje esta en conflicto con otros gameObjects
 */
public class StateAngry extends StateCharacter{

	protected StateAngry(Character c) {
		super(c);
	}

	@Override
	public ImageIcon GetImage() {
		
		return _bank.getAngry(miCh);
	
	}

}
