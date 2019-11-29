package logicas;

public class Pair<T, U> {

	protected T x; 
	protected U y;
	
	public Pair (T t1, U t2) {
		x = t1; 
		y = t2;
	}
	
	public T getX() { return x; }
	public U getY() { return y; }
}
