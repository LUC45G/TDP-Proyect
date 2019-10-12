package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;
import gameObjects.Ally;

/**
 * DataStorage tendra:
 * 	Aliados, que iran al ritmo del movimiento de enemigos para disparar.
 * 	Cantidad de dinero del jugador
 *
 */
public class DataStorage {
	
	protected static DataStorage		INSTANCE = null;
	protected int 						_currentMoney;
	protected ArrayList<Rectangle>		_allies;
	
	private DataStorage() {
		_currentMoney 	= 0;
		_allies 		= new ArrayList<Rectangle>();
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
	public ArrayList<Rectangle> GetAllies() {
		return _allies;
	}

	/**
	 * Almacena un aliado
	 * @param r Hitbox del aliado a almacenar
	 */
	public void Store(Rectangle r) {
		_allies.add(r);
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
