package logicas;

import gameObjects.Ally;
import gameObjects.Barricada;
import gameObjects.Enemy;
import gameObjects.EstadoDisparando;
import gameObjects.LagoMapa;
import gameObjects.PiedraMapa;

public class VisitorRangeEnemigo extends VisitorRange {
	private Enemy miEnemy;
	
	public VisitorRangeEnemigo(Enemy e) {
		miEnemy = e;
	}
	
	public void visitAlly(Ally a) { 
		EstadoDisparando vamoADisparar = new EstadoDisparando(miEnemy,miEnemy.get_delay(),miEnemy.get_strength(),miEnemy.get_velocidad());
		miEnemy.GetState().accept(vamoADisparar.GetVisitor());
	}
	
	public void visitBarricada(Barricada b){
		EstadoDisparando vamoADisparar = new EstadoDisparando(miEnemy,miEnemy.get_delay(),miEnemy.get_strength(),miEnemy.get_velocidad());
		miEnemy.GetState().accept(vamoADisparar.GetVisitor());
	}
	
	public void visitPiedraMapa(PiedraMapa v) {
		EstadoDisparando vamoADisparar = new EstadoDisparando(miEnemy,miEnemy.get_delay(),miEnemy.get_strength(),miEnemy.get_velocidad());
		miEnemy.GetState().accept(vamoADisparar.GetVisitor());
	}
	
	public void visitLagoMapa(LagoMapa v) {
		EstadoDisparando vamoADisparar = new EstadoDisparando(miEnemy,miEnemy.get_delay(),miEnemy.get_strength(),miEnemy.get_velocidad());
		miEnemy.GetState().accept(vamoADisparar.GetVisitor());
	}
	
}
