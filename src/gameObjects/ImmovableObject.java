package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

public class ImmovableObject extends GameObject {

	public ImmovableObject(ImageIcon sprite, Rectangle hitbox) {
		super(sprite, hitbox);
		
	}

	public void affect(Disparo miDisparo) {
		//este metodo debe ser redefinido por cada sub_clase de ImmovableObject
		// miDisparo.vanish(); _health--;
	}
	public void affect(Character c) {
		//este metodo debe ser redefinido por cada sub_clase de ImmovableObject
	}
	public void accept(Visitor v) {
		v.visitImmovableObject(this);
	}

}
