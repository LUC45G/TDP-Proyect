package logicas;

import gameObjects.Ally;
import gameObjects.Barricada;
import gameObjects.Disparo;
import gameObjects.DisparoAliado;
import gameObjects.LagoMapa;
import gameObjects.PiedraMapa;

public class VisitorEnemyShoot extends Visitor {
	
	private Disparo miDisparo;
	
	public VisitorEnemyShoot(Disparo d) {
		super();
		miDisparo = d;    //this is legal??
	}
	
	public void visitAlly(Ally a) {
		a.receive_attack(miDisparo);
	}
	
	public void visitAllyShoot(DisparoAliado da) {
		da.vanish();
	}
	
	public void visitBarricada(Barricada b) {
		b.receive_attack(miDisparo.get_strength());
	}
	
	public void visitPiedraMapa(PiedraMapa v) {
		v.receive_attack(miDisparo.get_strength());
	}
	
	public void visitLagoMapa(LagoMapa v) {
		miDisparo.vanish();
	}
	
}
