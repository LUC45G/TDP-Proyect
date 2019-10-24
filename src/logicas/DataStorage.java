package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.Enemy;
import gameObjects.GameObject;

/**
 * DataStorage tendra:
 * 	Aliados, que iran al ritmo del movimiento de enemigos para disparar.
 * 	Cantidad de dinero del jugador
 *
 */
public class DataStorage {
	
	protected static DataStorage		INSTANCE = null;
	protected int 						_currentMoney;
	protected ArrayList<Rectangle>		_alliesHitboxes;
	
	protected ArrayList<Ally> 			_allies;
	protected ArrayList<Enemy> 			_enemies;
	protected ArrayList<Disparo> 		_shoots;
	
	private DataStorage() {
		_currentMoney 	= 444444440;
		_alliesHitboxes	= new ArrayList<Rectangle>();
		_allies 		= new ArrayList<Ally>();
		_enemies 		= new ArrayList<Enemy>();
		_shoots 		= new ArrayList<Disparo>();
	}
	
	public static DataStorage GetInstance() {
		if (INSTANCE == null)
			INSTANCE = new DataStorage();
		
		return INSTANCE;
	}
	
	/**
	 * Consulta y devuelve la cantidad de dinero actual
	 * @return cantidad de dinero actual
	 */
	public int GetCurrentMoney() {
		return _currentMoney;
	}
	
	/**
	 * Consulta y devuelve la lista de aliados
	 * @return la lista de aliados
	 */
	public ArrayList<Rectangle> GetHitboxes() {
		return _alliesHitboxes;
	}

	/**
	 * Almacena un aliado
	 * @param r Hitbox del aliado a almacenar
	 */
	public void Store(Rectangle r) {
		_alliesHitboxes.add(r);
	}
	
	/**
	 * Almacena un aliado
	 * @param a aliado a almacenar
	 */
	public void Store(Ally a) {
		_allies.add(a);
	}
	
	/**
	 * Almacena un enemigo
	 * @param e enemigo a almacenar
	 */
	public void Store(Enemy e) {
		_enemies.add(e);
	}
	
	/**
	 * Almacena un disparo
	 * @param d disparo a almacenar
	 */
	public void Store(Disparo d) {
		_shoots.add(d);
	}
	
	/**
	 * Devuelve una lista de todos los gameObjects 
	 * @return lista de todo
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<GameObject> GetAllObjects() {
		ArrayList<GameObject> aux = (ArrayList<GameObject>) _allies.clone();
		aux.addAll(_enemies);
		aux.addAll(_shoots);
		return aux;
	}
	
	public void Remove(GameObject g) {
		if(_allies.remove(g))  return;
		if(_enemies.remove(g)) return;
		if(_shoots.remove(g))  return;
	}
	public void Remove(Disparo d) {
		_shoots.remove(d);
	}
	
	/**
	 * Suma la cantidad de dinero 
	 * @param q cantidad de dinero a sumar
	 */
	public void Store(int q) {
		_currentMoney += q;
	}
	
	/**
	 * Resta la cantidad de dinero por haber comprado
	 * @param q cantidad de dinero a restar
	 */
	public void Buy(int q) {
		_currentMoney -= q;
	}
	
	
	

}
