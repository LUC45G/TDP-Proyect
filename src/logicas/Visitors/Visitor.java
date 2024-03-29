package logicas.Visitors;

import gameObjects.Aliados.Ally;
import gameObjects.Disparos.Disparo;
import gameObjects.Disparos.DisparoAliado;
import gameObjects.Disparos.DisparoEnemigo;
import gameObjects.Enemigos.Enemy;
import gameObjects.ObjetosDelMapa.LagoMapa;
import gameObjects.ObjetosDelMapa.PiedraMapa;
import gameObjects.ObjetosEspeciales.Barricada;
import gameObjects.ObjetosEspeciales.Vendedor;

public abstract class Visitor {
	
	public void visitAlly(Ally a) {}

	public void visitEnemy(Enemy e) {}
	
	public void visitShoot(Disparo d) {}

	public void visitAllyShoot(DisparoAliado disparoAliado) {}
	
	public void visitEnemyShoot(DisparoEnemigo disparoAliado) {}
	
	public void visitLose() {}
	
	public void visitBarricada(Barricada b) {}

	public void visitVendedor(Vendedor v) {}
	
	public void visitPiedraMapa(PiedraMapa v) {}
	
	public void visitLagoMapa(LagoMapa lm) {}

}
