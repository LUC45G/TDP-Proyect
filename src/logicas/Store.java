package logicas;

import java.util.ArrayList;

import gameObjects.Ally;
import gameObjects.Ally1;

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
		_alliesToClone.add(new Ally1(0, 0));
	}

	/**
	 * Crea y devuelve al aliado ubicado en la posicion i
	 * @param i indice que la posicion
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @return Aliado creado
	 */
	public Ally CreateAlly(int i, int x, int y) {
		Ally aux = (Ally) _alliesToClone.get(i).Clone();
		_dataStorage.Store(aux);
		aux.SetX(x); aux.SetY((y/90)*90);
		return aux;
	}

	public int GetCost(int i) {
		return _alliesToClone.get(i).GetCost();
	}

	
	
}
