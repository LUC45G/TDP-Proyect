package logicas;

import gameObjects.*;

public class IntersectionController {
	
	private static IntersectionController INSTANCE;

	private IntersectionController() {
		
	}
	
	public IntersectionController GetInstance() {
		if (INSTANCE == null)
			INSTANCE = new IntersectionController();
		
		return INSTANCE;
	}
	
	public void Intersect(GameObject g1, GameObject g2) {
		
		try {
			Ally a1 = (Ally) g1;
			Ally a2 = (Ally) g2;
			Intersects(a1, a2);
		} catch (ClassCastException e) { }
		
		/* Repetir para cada caso, y preguntar si hacer esto es legal */
		/*
		 * para mi seria algo asi el chequeo de colisiones (seria igua para todos)
		 *	if(g1.GetHitbox().intersects(g2.GetHitbox()))
		 *		g1.getVisitor().visit(g2);
		 *
		 */
				
	}
	
	
	private void Intersects(Ally a, Enemy e) {
		
	}
	
	private void Intersects(Ally a1, Ally a2) {
		
	}
	
	private void Intersects(Enemy e1, Enemy e2) {
		
	}
	
	private void Intersects(Disparo d, Ally a) {
		
	}
	
	private void Intersects(Disparo d, Enemy e) {
		
	}
	
	private void Intersects(Disparo d1, Disparo d2) {
		
	}

}
