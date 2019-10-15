package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.VisitorAllyShoot;

public class DisparoAliado extends Disparo{

	public DisparoAliado(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox, fuerza);
		visitorDisparo=new VisitorAllyShoot(this);
	}

}
