package logicas.Visitors;

import logicas.IObserved;
import logicas.IObserver;

public class VisitorObserver {

	protected IObserver _observer;
	protected IObserved _observed;
	
	public VisitorObserver(IObserver er, IObserved ed) {
		_observer = er;
		_observed = ed;
	}
	
	public VisitorObserver(IObserved ed) {
		_observed = ed;
	}
	
	
	public void visitAllyObservador(IObserver a) {
		if(_observed != null)
			_observed.agregarObservador(a);
	}
	
	public void visitAllyObservado(IObserved a) {
		if(_observer != null)
			a.agregarObservador(_observer);
	}
	
}
