package logicas;

import java.util.ArrayList;

import javax.swing.Icon;

import gameObjects.GameObject;
import gameObjects.Aliados.Ally;
import gameObjects.Aliados.AllyBase;
import gameObjects.Aliados.AllyFast;
import gameObjects.Aliados.AllyFat;
import gameObjects.Aliados.AllySlim;
import gameObjects.Aliados.AllyStrong;
import logicas.Visitors.VisitorObserver;

/**
 * Store permitira al jugador comprar personajes.
 *
 */
public class Store {
	
	private ArrayList<Ally> _alliesToClone;
	private DataStorage		_dataStorage;
	
	public Store() {
		_alliesToClone  = new ArrayList<Ally>();
		_dataStorage 	= DataStorage.GetInstance();
		/*
		 * Inicializar los aliados clonables
		 */
		_alliesToClone.add(new AllyBase(0, 0));
		_alliesToClone.add(new AllyFat(0, 0));
		_alliesToClone.add(new AllyFast(0, 0));
		_alliesToClone.add(new AllySlim(0, 0));
		_alliesToClone.add(new AllyStrong(0, 0));
	}

	/**
	 * Crea y devuelve al aliado ubicado en la posicion i
	 * @param i indice que la posicion
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @return Aliado creado
	 */
	public Ally CreateAlly(int i, int x, int y) {
		Ally aux = _alliesToClone.get(i).Clone();
		
		VisitorObserver vo = new VisitorObserver(aux, aux);
		
		for(GameObject go : _dataStorage.GetAllObjects()) {
			go.acceptObserver(vo);
		}
		
		_dataStorage.Store(aux);
		aux.SetX(x); aux.SetY((y/90)*90);
		return aux;
	}

	public int GetCost(int i) {
		return _alliesToClone.get(i).get_cost();
	}

	public Icon GetIcon(int i) {
		return _alliesToClone.get(i-1).GetIcon();
	}
	
}
