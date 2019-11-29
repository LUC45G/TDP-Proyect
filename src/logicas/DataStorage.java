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
	
	public final int STARTING_MONEY = 1000;
	
	protected static DataStorage		INSTANCE = null;
	protected int 						_currentMoney;
	protected ArrayList<GameObject>		_gos;

	private int _score;

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
	 * Devuelve la puntuacion
	 * @return score
	 */
	public int get_score() {
		return _score;
	}
	
	/**
	 * Setea la puntuacion
	 * @param _score nueva puntuacion
	 */
	public void set_score(int _score) {
		this._score = _score;
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
		_score += q;
	}
	
	/**
	 * Resta la cantidad de dinero por haber comprado
	 * @param q cantidad de dinero a restar
	 */
	public void Buy(int q) {
		_currentMoney -= q;
	}

	/**
	 * Resetea el oro del juego
	 */
	public void Reset() {
		_currentMoney = STARTING_MONEY;
	}

	/**
	 * Suma la cantidad de oro
	 * @param i cantidad a sumar
	 */
	public void Sell(int i) {
		_currentMoney += i;
	}
	
	
	

}
