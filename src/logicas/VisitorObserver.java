package logicas;


public class VisitorObserver {

	protected IObserver _observer;
	protected IObserved _observed;
	
	public VisitorObserver(IObserver er, IObserved ed) {
		_observer = er;
		_observed = ed;
	}
	
	
	public void visitAllyObservador(IObserver a) {
		_observed.agregarObservador(a);
	}
	
	public void visitAllyObservado(IObserved a) {
		a.agregarObservador(_observer);
	}
	
}
