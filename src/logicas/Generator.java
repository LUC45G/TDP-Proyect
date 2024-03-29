package logicas;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import gameObjects.GameObject;
import gameObjects.ObjetosEspeciales.ImmovableObject;
import gameObjects.Enemigos.Enemy;
import gameObjects.Enemigos.EnemyBase;
import gameObjects.Enemigos.EnemyBoss;
import gameObjects.Enemigos.EnemyFast;
import gameObjects.Enemigos.EnemyFat;
import gameObjects.Enemigos.EnemySlim;
import gameObjects.Enemigos.EnemyStrong;
import gameObjects.Estados.EstadoProtegidoCaminando;
import gameObjects.ObjetosDelMapa.LagoMapa;
import gameObjects.ObjetosDelMapa.MapObject;
import gameObjects.ObjetosDelMapa.PiedraMapa;
import gameObjects.ObjetosEspeciales.Barricada;
import gameObjects.ObjetosEspeciales.BombaAtomica;
import gameObjects.ObjetosEspeciales.BombaCongelante;
import gameObjects.ObjetosEspeciales.Diente;
import gameObjects.ObjetosEspeciales.EscudoProtector;
import gameObjects.ObjetosEspeciales.Vendedor;
import logicas.Hilos.HiloPrincipal;
import logicas.Visitors.VisitorObserver;

public class Generator {
	
	protected ArrayList<Enemy>  _enemies;		 // Lista de enemigos a clonar
	protected ArrayList<ImmovableObject> _powerUps;
	protected ArrayList<MapObject> _mapItems;
	protected HiloPrincipal 	_mainThread;	 // Hilo principal
	protected DataStorage 		_dataStorage; 	 // Almacenamiento de cosas
	
	public Generator() {
		_enemies 	= new ArrayList<Enemy>();
		_powerUps 	= new ArrayList<ImmovableObject>();
		_dataStorage= DataStorage.GetInstance();
		_mapItems   = new ArrayList<MapObject>();
		
		/* Inicializar la lista de enemigos */
		_enemies.add(new EnemyBase(0, 0));
		_enemies.add(new EnemyBoss(0, 0));
		_enemies.add(new EnemyFast(0, 0));
		_enemies.add(new EnemyFat(0, 0));
		_enemies.add(new EnemySlim(0, 0));
		_enemies.add(new EnemyStrong(0, 0));
		
		/* Inicializar la lista de power ups */
		_powerUps.add(new Barricada());
		_powerUps.add(new EscudoProtector());
		_powerUps.add(new Diente());
		_powerUps.add(new BombaAtomica());
		_powerUps.add(new BombaCongelante());
		_powerUps.add(new Vendedor());
		
		/* Inicializar la lista de objetos del mapa */
		_mapItems.add(new LagoMapa());
		_mapItems.add(new PiedraMapa());
		
		/* Inicializo el hilo */
		_mainThread = new HiloPrincipal();
		_mainThread.start();
	}
	
	public ArrayList<Rectangle> GetHitboxes() {
		ArrayList<Rectangle> tr = new ArrayList<Rectangle>();
		
		for(Enemy e : _enemies) 
			tr.add(e.get_hitbox());
		
		return tr;
	}
	
	/**
	 * Crea un enemigo y devuelve su sprite
	 * @param i Indice del enemigo a crear
	 * @param y Posicion en Y donde spawnear
	 * @return Sprite del enemigo
	 */
	public ImageIcon GetEnemy(int i, int y) {
		Enemy e = _enemies.get(i).Clone();
		Random r = new Random();
		VisitorObserver vo = new VisitorObserver(e, e);
		
		for(GameObject go : _dataStorage.GetAllObjects()) {
			go.acceptObserver(vo);
		}
		
		if(r.nextInt(101) % 4 == 0)
			e.ChangeState(new EstadoProtegidoCaminando(e, e.get_delay(), e.get_strength(), e.get_velocidad()));
		
		
		e.SetX(700); e.SetY(y*90);
		_dataStorage.Store(e);
		return e.GetSprite();
	}
	
	public ImmovableObject GetPowerUp(int i, int x, int y) {
		ImmovableObject aux = _powerUps.get(i).Clone();
		
		VisitorObserver vo = new VisitorObserver(aux);
		
		for(GameObject go : _dataStorage.GetAllObjects())
			go.acceptObserver(vo);
		
		aux.SetX(x); 
		aux.SetY(y*90);
		
		_dataStorage.Store(aux);
		
		return aux;
	}
	
	public String GetPowerUpName(int i) {
		return _powerUps.get(i).toString();
	}
	
	/*public GameObject GetPowerUp(int i) {
		GameObject aux = _powerUps.get(i).Clone();
		return aux;
	}*/
	
	public int GetCost(int i) {
		return _powerUps.get(i).get_cost();
	}

	public MapObject GetMapElement(int index) {
		return _mapItems.get(index).Clone();
	}

	public boolean IsAOE(int index) {
		return _powerUps.get(index).IsAOE();
	}

}
