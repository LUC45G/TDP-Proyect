package logicas;

import java.util.ArrayList;

import gameObjects.GameObject;

/**
 * DataStorage tendra:
 * 	Aliados, que iran al ritmo del movimiento de enemigos para disparar.
 * 	Cantidad de dinero del jugador
 *
 */
public class DataStorage {
	
	protected final int STARTING_MONEY = 500;
	
	protected static DataStorage		INSTANCE = null;
	protected int 						_currentMoney;
	protected ArrayList<GameObject>		_gos;
	private DataStorage() {
		_currentMoney 	= STARTING_MONEY;
		_gos 		= new ArrayList<GameObject>();
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
	 * Almacena un aliado
	 * @param a aliado a almacenar
	 */
	public void Store(GameObject a) {
		_gos.add(a);
	}
	
	/**
	 * Devuelve una lista de todos los gameObjects 
	 * @return lista de todo
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<GameObject> GetAllObjects() {
		return (ArrayList<GameObject>)_gos.clone();
	}
	
	public void Remove(GameObject g) {
		_gos.remove(g);
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

	public void Reset() {
		_currentMoney = STARTING_MONEY;
		
	}
	
	
	

}
