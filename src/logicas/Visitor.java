package logicas;

import gameObjects.Ally;
import gameObjects.Barricada;
import gameObjects.Disparo;
import gameObjects.DisparoAliado;
import gameObjects.DisparoEnemigo;
import gameObjects.Enemy;
import gameObjects.ImmovableObject;
import gameObjects.Vendedor;

public abstract class Visitor {
	
	public void visitAlly(Ally a) {}

	public void visitEnemy(Enemy e) {}
	
	public void visitImmovableObject(ImmovableObject i) {}
	
	public void visitShoot(Disparo d) {}

	public void visitAllyShoot(DisparoAliado disparoAliado) {}
	
	public void visitEnemyShoot(DisparoEnemigo disparoAliado) {}
	
	public void visitLose() {}
	
	public void visitBarricada(Barricada b) {}

	public void visitVendedor(Vendedor v) {}

}
