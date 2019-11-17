package gameObjects;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import logicas.Visitor;

/**
 * Clase general que modela un objeto que puede estar presente en el juego
 * @author Pippig, Matias Gonzales, Lucas
 *
 */
public abstract class GameObject {
	
	protected int 			_cost;
	protected ImageIcon  	_sprite;
	protected Rectangle  	_hitbox;
	protected Visitor 	 	_visitor;
	protected int 		 	_range;
	protected Visitor 		_boundingBox; 	// Rectangulo que representa el alcance
	protected boolean 	 	_visible;
	protected boolean 	 	_canMove;
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
		_canMove 	= true;
		//visitor del rango
		_boundingBox= new VisitorRange();
	}
	/**
	 * Devuelve el ImageIcon correspondiente al objeto del juego
	 * @return Retorna una imagen repersentativa del objeto
	 */
	public ImageIcon GetSprite() {
		return _sprite;
	}
	/**
	 * Devuelve un rectangulo que representa la zona de contacto del objeto del juego
	 * @return Retorna un rectangulo que representa las dimensiones del objeto
	 */
	public Rectangle GetHitbox() {
		return _hitbox;
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
	 * Devuelve el visitor del objeto del juego
	 * @return Retorna un visitor
	 */
	public Visitor GetVisitor() {
		return _visitor;
	}
	
	/**
	 * Devuelve el visitor del rango que se encarga de vigilar el rango
	 * @return Retorna un visitor de rango
	 */
	public Visitor GetVisitorRange() {
		return _boundingBox;
	}
	
	/**
	 * Consulta y devuelve el costo del objeto del juego
	 * @return Retorna el costo
	 */
	public int GetCost() {
		return _cost;
	}
	
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
	 * Detiene el movimiento del objeto actualizando la variable de movimiento en falso
	 */
	public void StopMoving() {
		_canMove = false;
	}
	
	/**
	 * Habilita el movimiento del objeto actualizando la variable de movimiento en verdadero
	 */
	public void StartMoving() {
		_canMove = true;
	}
	
	/**
	 * Consulta si el objeto se puede mover
	 * @return Retorna verdadero si se puede mover,falso en otro caso
	 */
	public boolean CanMove() {
		return _canMove;
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

	public void startAction() {}

	

}
