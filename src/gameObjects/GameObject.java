package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.IObserved;
import logicas.IObserver;
import logicas.Visitors.Visitor;
import logicas.Visitors.VisitorObserver;
import logicas.Visitors.VisitorRange;

/**
 * Clase general que modela un objeto que puede estar presente en el juego
 * @author Pippig, Matias Gonzales, Lucas
 *
 */
public abstract class GameObject implements Cloneable, IObserved{
	
	protected ImageIcon  	_sprite;
	protected Rectangle  	_hitbox;
	protected Visitor 	 	_visitor;
	protected int 		 	_range;
	protected Visitor 		_boundingBox; 	// Rectangulo que representa el alcance
	protected boolean 	 	_visible;
	
	
	/**
	 * Contructor que llama a init
	 */
	protected GameObject() {
		Init();
	}
	/**
	 * Inicializa las varaibles que son iguales para todos los contructores
	 */
	private void Init() {
		_visible 	= true;
		//visitor del rango
		_boundingBox= new VisitorRange();
	}
	
	/**
	 * Devuelve la hitbox
	 * @return Rectangulo que representa la hitbox
	 */
	public Rectangle get_hitbox() {
		return _hitbox;
	}

	/**
	 * Setea la hitbox
	 * @param _hitbox Rectangulo que representa la hitbox
	 */
	public void set_hitbox(Rectangle _hitbox) {
		this._hitbox = _hitbox;
	}

	public Visitor get_visitor() {
		return _visitor;
	}

	public void set_visitor(Visitor _visitor) {
		this._visitor = _visitor;
	}

	public int get_range() {
		return _range;
	}

	public void set_range(int _range) {
		this._range = _range;
	}

	public Visitor get_boundingBox() {
		return _boundingBox;
	}

	public void set_boundingBox(Visitor _boundingBox) {
		this._boundingBox = _boundingBox;
	}

	
	
	public boolean notificar() {return true;}
	
	/**
	 * Clona el objeto del juego y devuelve la copia creada
	 * @return Retorna una copia del objeto del juego
	 */
	public abstract GameObject Clone();
	
	
	/**
	 * Devuelve el ImageIcon correspondiente al objeto del juego
	 * @return Retorna una imagen repersentativa del objeto
	 */
	public ImageIcon GetSprite() {
		return _sprite;
	}
	/**
	 * Actualiza el valor del eje x de la hitbox con el valor value
	 * @param value valor que va a suplantar el valor actual de x
	 */
	public void SetX(int value) {
		_hitbox.x = value;
	}

	/**
	 * Actualiza el valor del eje y de la hitbox con el valor value
	 * @param value valor que va a suplantar el valor actual de y
	 */
	public void SetY(int value) {
		_hitbox.y = value;
	}
	/**
	 * Devuelve el visitor del rango que se encarga de vigilar el rango
	 * @return Retorna un visitor de rango
	 */
	public Visitor GetVisitorRange() {
		return _boundingBox;
	}
		
	/**
	 * Actualiza el estado del objeto
	 */
	public abstract void Update();
	
	/**
	 * Setea la visibilidad del objeto en falsa
	 */
	public void NotVisible() {
		_visible = false;
	}
	
	/**
	 * Consulta si el objeto es visible
	 * @return Retorna verdadero si el objeto es visible y falso en otro caso
	 */
	public boolean IsVisible() {
		return _visible;
	}
	
	/**
	 * Acepta la visita del visitor v
	 * @param V Visitor que se desea que sea aceptado
	 */
	public void accept(Visitor V) {}
	
	/**
	 * Chequea si otro objeto esta en rango
	 * @param box hitbox del objeto que se quiere detectar
	 * @return Retorna verdadero si box esta en rango , falso en otro caso
	 */
	public boolean inRange(Rectangle box) {
		return ( _hitbox.getY() == box.getY() ) && (Math.abs(_hitbox.getX() - box.getX()) < _range);
	}
	
	public void acceptObserver(VisitorObserver vo) {} 
	public void agregarObservador(IObserver observador) {}
	public void eliminarObservador(IObserver observador) {}

}
