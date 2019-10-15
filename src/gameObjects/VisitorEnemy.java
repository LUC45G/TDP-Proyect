package gameObjects;

import logicas.Visitor;

public class VisitorEnemy extends Visitor {
	private Enemy miEnemigo;
	
	public VisitorEnemy(Enemy enemy) {
		miEnemigo=enemy;
	}
	
}
