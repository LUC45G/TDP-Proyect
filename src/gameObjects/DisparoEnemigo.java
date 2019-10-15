package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.VisitorEnemyShoot;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(ImageIcon sprite, Rectangle hitbox, int fuerza) {
		super(sprite, hitbox, fuerza);
		visitorDisparo=new VisitorEnemyShoot(this);
	}

}
