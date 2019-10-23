package gameObjects;

import javax.swing.ImageIcon;

/**
 * 
 * @author matia
 *	estado en el que el personaje no esta en conflicto con ningun gameObject
 */
public class StatePeace extends StateCharacter {

	public StatePeace(Character c) {
		super(c);
		_bank=new Bank();
		}

	@Override
	public ImageIcon GetImage() {
		// TODO Auto-generated method stub
		return _bank.getPeace(miCh);
	}

}
