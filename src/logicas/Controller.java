package logicas;

import gui.Gui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import gameObjects.Ally;
import gameObjects.GameObject;

/**
 * Clase que comunica la gui con la logica de atras del todo
 *
 */
public class Controller {
	
	protected HiloDisparos 				_shoots;		 	// Hilo de los disparos
	protected DataStorage  				_dataStorage;	 	// Donde se guardan los enemigos
	protected Store				   		_store;				// Tienda para comprar aliados
	protected Gui		 		   		_gui;				// GUI
	protected int 		   				_currentIndex;		// Indice para control y realizacion de la compra
	protected EnemyGenerator			_enemyGenerator;	// Genera enemigos
	protected static Controller 		INSTANCE;			// Instancia Singleton
	protected IntersectionController 	_intersecter;		// Controla las intersecciones
	
	protected boolean 					_roundEnded; 		// Controla si termina la ronda
	
	private Controller(Gui gui) {
		_shoots  	 	= new HiloDisparos();
		_dataStorage	= DataStorage.GetInstance();
		_store		 	= new Store();
		_gui 		 	= gui;
		_currentIndex	= -1;
		_enemyGenerator = new EnemyGenerator();
		_roundEnded		= false;
		
		_shoots .start();
	}
	
	public static Controller GetInstance(Gui gui) {
		if (INSTANCE == null)
			INSTANCE = new Controller(gui);
		
		return INSTANCE;
	}
	
	/**
	 * Junta todas las hitboxes que tiene que haber en el mapa
	 * @return Todas las hitboxes
	 */
	public ArrayList<Rectangle> GetHitboxes() {
		ArrayList<Rectangle> aux = _shoots.GetDisparos();
		aux.addAll(_enemyGenerator.GetEnemies());
		aux.addAll(_dataStorage.GetAllies());
		
		return aux;
	}
	
	public void Intersection() {
		int i = 0, j = 0;
		ArrayList<GameObject> all = _dataStorage.GetAllObjects();
		for ( Rectangle source : GetHitboxes() ) {
			for ( Rectangle destiny : GetHitboxes() ) {
				if ( source != destiny ) {
					if ( source.intersects(destiny) ) {
						_intersecter.Intersect(all.get(i), all.get(j));
					}
				}
				j++;
			}
			i++;
		}
		
		
	}

	/**
	 * Consulta si hay algo en el carrio
	 * @return true si el carrito esta vacio
	 */
	public boolean Empty() {
		return _currentIndex == -1;
	}

	/**
	 * Crea un aliado en las coordenadas x e y dadas
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public void InvokeAlly(int x, int y) {
		Ally a = _store.CreateAlly(_currentIndex, x, y);
		_dataStorage.Store(a.GetHitbox());
		_gui.Insertar(a.GetSprite());
		_currentIndex = -1;
	}

	/**
	 * Consulta si puede comprar un personaje en especifico
	 * @param i Indice del boton apretado
	 * @return true si puede comprar, false caso contrario
	 */
	public boolean CanPurchase(int i) {
		return _dataStorage.GetCurrentMoney() >= _store.GetCost(i);
	}

	/**
	 * Pone el carrito en modo "Hay algo disponible"
	 * @param i Indice del personaje a comprar
	 */
	public void Purchase(int i) {
		_currentIndex = i;
	}

	/**
	 * Invoca un enemigo 
	 * @param i indice del enemigo a invocar
	 * @return la imagen del enemigo invocado
	 */
	public void InvokeEnemy(int i) {
		ImageIcon e = _enemyGenerator.GetEnemy(i);
		_gui.Insertar(e);
	}
	
	/**
	 * Spawnea enemigos mientras la ronda no haya terminado
	 */
	private void SpawnEnemies() {
		Random r = new Random();
		int rng;
		
		while(!_roundEnded) {
			
			rng = r.nextInt(10);
			if( rng == 8 ) {
				// Generar enemigo y spawnearlo en la grafica
				// rng = r.nextInt( Cantidad De Enemigos );
				// InvokeEnemy( rng );
				// _gui.Insertar( EnemigoCreado ); 
			}
			
		}
	}
	
	/**
	 * Da inicio a la ronda
	 */
	public void StartRound() {
		_roundEnded = false;
		SpawnEnemies();
	}
	
	/**
	 * Da fin a la ronda
	 */
	public void EndRound() {
		_roundEnded = true;
	}

}
