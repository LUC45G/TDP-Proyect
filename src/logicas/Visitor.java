package logicas;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;

public abstract class Visitor {
	
	public void visitAlly(Ally a) {}

	public void visitEnemy(Enemy e) {}
	
	public void visitShoot(Disparo d) {}
	
	public void visitImmovableObject(ImmovableObject i) {}

	public void visitAllyShoot(DisparoAliado disparoAliado) {}
	
	public void visitEnemyShoot(DisparoEnemigo disparoAliado) {}
}
