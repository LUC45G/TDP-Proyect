package logicas;

public class Pair<T1, T2> {

	protected T1 x; 
	protected T2 y;
	
	public Pair (T1 t1, T2 t2) {
		x = t1; 
		y = t2;
	}
	
	public T1 getX() { return x; }
	public T2 getY() { return y; }
}
