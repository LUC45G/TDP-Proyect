package logicas;

import java.util.ArrayList;

import gameObjects.Ally;
import gameObjects.Ally1;
import gameObjects.AllyFast;
import gameObjects.AllyFat;
import gameObjects.AllySlim;
import gameObjects.AllyStrong;
import gameObjects.StateCharacter;
//import gameObjects.StatePeace;

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
		Ally aux = (Ally) _alliesToClone.get(i).Clone();
		_dataStorage.Store(aux);
		aux.SetX(x); aux.SetY((y/90)*90);
		//StateCharacter puto=new StatePeace(aux);
		aux.setPeace();
		return aux;
	}

	public int GetCost(int i) {
		return _alliesToClone.get(i).GetCost();
	}

	
	
}
