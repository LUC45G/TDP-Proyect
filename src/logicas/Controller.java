package logicas;

import gui.Gui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.GameObject;
import gameObjects.StateCharacter;

/**
 * Clase que comunica la gui con la logica de atras del todo
 *
 */
public class Controller {
	
	protected HiloHordas				_enemies;		 	// Hilo de los disparos
	protected HiloDisparos				_shoots;		 	// Hilo de los disparos
	protected DataStorage  				_dataStorage;	 	// Donde se guardan los enemigos
	protected Store				   		_store;				// Tienda para comprar aliados
	protected Gui		 		   		_gui;				// GUI
	protected int 		   				_currentIndex;		// Indice para control y realizacion de la compra
	protected EnemyGenerator			_enemyGenerator;	// Genera enemigos
	protected static Controller 		INSTANCE;			// Instancia Singleton
	protected int 						_mapWidth; 			// Ancho del mapa para controlar limites
	protected boolean 					_roundEnded; 		// Controla si termina la ronda
	
	private Controller(Gui gui) {
		_shoots			= new HiloDisparos();
		_dataStorage	= DataStorage.GetInstance();
		_store		 	= new Store();
		_gui 		 	= gui;
		_currentIndex	= -1;
		_enemyGenerator = new EnemyGenerator();
		_roundEnded		= false;
		
		_shoots.SetController(this);
	}
	
	/** 
	 * Devuelve la instancia si esta creada
	 * Sino, la crea
	 * @param gui Gui del juego
	 * @return Instancia Controller
	 */
	public static Controller GetInstance(Gui gui) {
		if (INSTANCE == null)
			INSTANCE = new Controller(gui);
		
		return INSTANCE;
	}
	
	/**
	 * Si la instancia esta creada, la devuelve.
	 * @return
	 */
	public static Controller GetInstance() {
		if (INSTANCE != null) 
			return INSTANCE;
		return null;
	}
	
	public void Update() {
		_gui.ActualizarGrafica();
	}
	
	
	/**
	 * Setea el ancho del mapa para controlar limites
	 * @param w ancho
	 */
	public void SetMapWidth(int w) {
		_mapWidth = w;
	}
	
	/**
	 * Junta todas las hitboxes que tiene que haber en el mapa
	 * @return Todas las hitboxes
	 */
	public ArrayList<Rectangle> GetHitboxes() {
		ArrayList<Rectangle> aux = new ArrayList<Rectangle>();
		aux.addAll(_shoots.GetHitboxes());
		aux.addAll(_enemyGenerator.GetHitboxes());
		aux.addAll(_shoots.GetHitboxes());
		
		return aux;
	}
	
	public void ControlBounds() {
		ArrayList<GameObject> auxGo=_dataStorage.GetAllObjects();
		for(GameObject go: auxGo) 
			if(	go.GetHitbox().getX() < -15 || go.GetHitbox().getX() > _mapWidth ) 
				Remove(go);
	}
	
	public int Size() {
		return _dataStorage.GetAllObjects().size();
	}
	
	public Pair<ImageIcon, Rectangle> GetSpriteAndHitbox(int i) {
		return new Pair<ImageIcon, Rectangle>(_dataStorage.GetAllObjects().get(i).GetSprite(), _dataStorage.GetAllObjects().get(i).GetHitbox());
	}
	
	public void Remove(int i) {
		_dataStorage.Remove( _dataStorage.GetAllObjects().get(i) );
	}
	
	public void Remove(GameObject go) {
		_dataStorage.Remove( go );
	}
	
	public void Intersection() {
		ArrayList<GameObject> all = _dataStorage.GetAllObjects();
		//no seria mejor usar los objetos?
		for(GameObject go : all) {
			for(GameObject og:all) {
				if(og!=go) {
					if(og.GetHitbox().intersects(go.GetHitbox()))
						og.accept(go.GetVisitor());
				}
			}
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
		a.SetController(INSTANCE);
		_dataStorage.Store(a.GetHitbox());
		_gui.Insertar(a.GetSprite());
		
		_currentIndex = -1;
	}
	
	/**
	 * Agrega un disparo al mapa
	 * @param d disparo
	 */
	public void AddDisparo(Disparo d) {
		_dataStorage.Store(d);
		_shoots.AgregarDisparo(d);
		_gui.Insertar(d.GetSprite());
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
	 * Da inicio a la ronda de enemigos
	 */
	public void ToggleRound() {
		_enemies = new HiloHordas();
		_enemies.SetController(this);
		_enemies.crearHordas(3);
	}

	public void lose() {
		_enemies.End();
		_gui.showLose();
		for(GameObject go:_dataStorage.GetAllObjects())
			Remove(go);
	}

	public EnemyGenerator getGenerator() {

		return _enemyGenerator;
	}

	public void spawnEnemie(ImageIcon e) {
		_gui.Insertar( e ); 
		
	}

}
