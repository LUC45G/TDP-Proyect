package logicas;

import gui.Gui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gameObjects.Ally;
import gameObjects.Disparo;
import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.ImmovableObject;
import gameObjects.Muerte;

/**
 * Clase que comunica la gui con la logica
 * @author Pippig, Matias Gonzales, Lucas
 *
 */
public class Controller {
	
	protected HiloHordas		_enemies;		 	// Hilo de los disparos
	protected DataStorage  		_dataStorage;	 	// Donde se guardan los enemigos
	protected Store				_store;				// Tienda para comprar aliados
	protected Gui		 		_gui;				// GUI
	protected int 		   		_currentIndex;		// Indice para control y realizacion de la compra
	protected int				_currentPowerUp; 	// Indice para control de compra de power up
	protected Generator			_generator;			// Genera enemigos
	protected static Controller INSTANCE;			// Instancia Singleton
	protected int 				_mapWidth; 			// Ancho del mapa para controlar limites
	protected boolean 			_roundEnded; 		// Controla si termina la ronda
	protected boolean			_alreadyStarted;	// Controla si ya empezo la partida
	protected boolean 			_isAOE;				// Controla si el power up debe afectar a mas de uno
	protected int 				_dificultad; 		// dificultad del juego
	
	/**
	 * Constructor que relaciona una interfaz grafica con una logica
	 * @param gui Interfaz Grafica que sera enlazada con la logica
	 */
	private Controller(Gui gui) {
		_dataStorage	= DataStorage.GetInstance();
		_store		 	= new Store();
		_gui 		 	= gui;
		_currentIndex	= -1;
		_currentPowerUp = -1;
		_generator = new Generator();
		_roundEnded		= false;
		_dificultad 	= 2;
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
	 * @return Retorna la instancia si esta creada si no devuelve nulo
	 */
	public static Controller GetInstance() {
		if (INSTANCE != null) 
			return INSTANCE;
		return null;
	}
	
	/**
	 * Dice a la gui que se actualice
	 */
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
		
		for(GameObject g : _dataStorage.GetAllObjects())
			aux.add(g.GetHitbox());
		
		return aux;
	}
	
	/**
	 * Chequea que todos los objetos estan dentro de lo limites, si no los borra
	 */
	public void ControlBounds() {
		ArrayList<GameObject> auxGo = _dataStorage.GetAllObjects();
		GameObject go;
		int size = auxGo.size();
		
		for(int i = size - 1; i >= 0; i--) {
			go = auxGo.get(i);
			if(	go.GetHitbox().getX() < -15 || go.GetHitbox().getX() > _mapWidth ) 
				Remove(go);			
		} 
	}
	
	/**
	 * Retorna la cantidad de objectos que hay en el mapa
	 * @return Retorna cantidad de objetos
	 */
	public int Size() {
		return _dataStorage.GetAllObjects().size();
	}
	
	/**
	 * Retorna la imagen y la hitbox del objeto en la posicion i-esima
	 * @param i posicion del objeto que se desea
	 * @return Retorna un par con una imagen y un rectangulo
	 */
	public Pair<ImageIcon, Rectangle> GetSpriteAndHitbox(int i) {
		return new Pair<ImageIcon, Rectangle>(_dataStorage.GetAllObjects().get(i).GetSprite(), _dataStorage.GetAllObjects().get(i).GetHitbox());
	}
	
	
	/**
	 * Busca el objeto go entre los objetos del mapa, si lo encunetra los remueve 
	 * @param go objeto que se desea remover
	 */
	public void Remove(GameObject go) {
		_dataStorage.Remove( go );
	}
	
	/**
	 * Detecta interseccion y produce visitas entre los objetos que se intersectan cuando sucede
	 */
	public void Intersection() {
		ArrayList<GameObject> all = _dataStorage.GetAllObjects();
		GameObject go, og;
		int size = all.size();
		
		for(int i = size-1; i >= 0; i--) {
			og = all.get(i);
			
			for(int j = size - 1; j >= 0; j--) {
				go = all.get(j);
				
				if( og != go ) {
					
					if(og.GetHitbox().intersects(go.GetHitbox()))
						go.accept(og.GetVisitor());
					
					
					if(og.IsVisible() && go.IsVisible())
						if(og.inRange(go.GetHitbox())) 
							go.accept(og.GetVisitorRange());
					
				}
				
			}
			
		}
	}

	/**
	 * Consulta si hay algo en el carrio
	 * @return true si el carrito esta vacio
	 */
	public boolean Empty() {
		return _currentIndex == -1 && _currentPowerUp == -1;
	}

	/**
	 * Crea lo que haya en las coordenadas x e y dadas
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public void Invoke(int x, int y) {
		
		boolean invoked = false;
		
		if(_currentIndex != -1) {
			Ally a = _store.CreateAlly(_currentIndex, x, y);
			_dataStorage.Buy(a.get_cost());
			invoked = true;
		}
		
		if(!invoked && _currentPowerUp != -1) {
			y = (y/90);
			ImmovableObject p = _generator.GetPowerUp(_currentPowerUp, x, y);
			_isAOE = _generator.IsAOE(_currentPowerUp);
			
			if(_isAOE)
				AddAOEPowerUp(p.GetVisitor());
			
			
			_dataStorage.Buy(p.get_cost());
			invoked = true;
		}
		
		_currentPowerUp = -1;
		_currentIndex = -1;
	}
	
	/**
	 * Agrega un disparo al mapa
	 * @param d disparo
	 */
	public void AddDisparo(Disparo d) {
		_dataStorage.Store(d);
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
	 * Consulta y devuelve el dinero actual
	 * @return current money
	 */
	public String GetCurrentMoney() {
		return ""+_dataStorage.GetCurrentMoney();
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
		
		Random r = new Random();
		
		if(!_alreadyStarted)
			_dataStorage.Reset();
		
		_enemies = new HiloHordas();
		_enemies.SetController(this);
		_alreadyStarted = true;
		
		_enemies.crearHordas(++_dificultad);
		
		_gui.UpdatePanelScore();
		_gui.DisableAllPowerUps();
		
		for(int i = 0; i < _dificultad; i++) {
			_gui.EnablePowerUp(r.nextInt(5));
		}
	}
	
	/**
	 * Actua en respuesta a la muerte de un enemigo
	 */
	public void EnemyDeath(Enemy e) {
		_enemies.SubEnemy();
		_dataStorage.Store(e.get_cost());
		_gui.UpdatePanelScore();
	}

	/**
	 * Actua en respuesta a la derrota
	 */
	public void lose() {
		_enemies.End();
		_dificultad = 2;
		_gui.showLose();
		_alreadyStarted = false;
		for(GameObject go:_dataStorage.GetAllObjects())
			Remove(go);
		_dataStorage.set_score(0);
		_gui.UpdatePanelScore();
		
	}
	
	/**
	 * Actua en respuesta a la victoria
	 */
	public void Win() {
		_enemies.End();

		for(GameObject go:_dataStorage.GetAllObjects())
			Remove(go);
		
		_gui.ShowWin();
		_gui.UpdatePanelScore();
	}

	/**
	 * Devuelve el generador
	 */
	public Generator GetGenerator() {
		return _generator;
	}
	
	public int getScore() {
		return _dataStorage.get_score();
	}
	
	/**
	 * Agrega un power-up que deba afectar a mas de un GameObject
	 * @param v Visitor de dicho power up
	 */
	public void AddAOEPowerUp(Visitor v) {
		ArrayList<GameObject> all = _dataStorage.GetAllObjects();
		int size = all.size();
		
		for(int i = size-1; i >= 0; i--) 
			all.get(i).accept(v);
		
	}
	
	/**
	 * Consulta si puede comprar el power up
	 * @param i indice del boton apretado
	 * @return true si puede, false si no
	 */
	public boolean CanPurchasePowerUp(int i) {
		return _dataStorage.GetCurrentMoney() >= _generator.GetCost(i);
	}

	/**
	 * Compra un power up
	 * @param i indice del boton presionado
	 */
	public void PurchasePowerUp(int i) {
		_currentPowerUp = i;
		
	}
	
	/**
	 * Vende al aliado 
	 * @param a aliado a vender
	 */
	public void sellAlly(Ally a) {
		_dataStorage.Store(a.get_cost()/2);
		a.ChangeState(new Muerte(a, a.get_delay(), a.get_strength(), a.get_velocidad()));
	//	a.notificar();
	}

	/**
	 * Devuelve el icono del aliade
	 * @param i indice del boton
	 * @return imagen del aliade correspondiente
	 */
	public Icon GetIcon(int i) {
		return _store.GetIcon(i);
	}

	/**
	 * Spawnea GO en el mapa, en las coordenadas X e Y dadas
	 * @param x coord x
	 * @param y coor y
	 * @param go gameobject a spawnear
	 */
	public void SpawnInMap(int x, int y, GameObject go) {
		go.SetX(x); go.SetY(y);
		_dataStorage.Store(go);
	}

	/**
	 * Consulta y devuelve el nivel actual
	 * @return nivel
	 */
	public int GetNivel() {
		return  (_enemies != null) ? _enemies.GetNivel() : 1;
	}

	/**
	 * Consulta y devuelve la dificultad actual (stage)
	 * @return dificultad
	 */
	public int GetDificultad() {
		return _dificultad - 2;
	}

	public String GetPowerUpName(int i) {
		return _generator.GetPowerUpName(i);
	}

	public DataStorage GetDataStorage() {
		return _dataStorage;
	}

}
