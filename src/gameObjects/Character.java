package gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import logicas.Controller;
import logicas.IObserved;
import logicas.IObserver;
import logicas.Visitor;
import logicas.VisitorObserver;


/**
 * Modela a los personajes, tanto aliados como enemigos
 * @author Pippig, Matias Gonzalez, Lucas
 */
public abstract class Character extends GameObject implements Cloneable, IObserver, IObserved {
	
	protected int 			 _health; 		// Vida actual del personaje, quizas deba ir mas arriba
	protected Disparo   	 _shoot;	
	protected StateCharacter _state;
	protected ArrayList<IObserver> _observers;
	
	protected int _baseDelay, _baseMovementSpeed, _baseStrength;
	
	
	/**
	 * Constructor que pone la vida en 100
	 */
	protected Character() {	
		_health = 100;
	}
	
	/**
	 * Devuuelve la vida del personaje
	 * @return Retorna la vida del Personake
	 */
	public int get_health() {
		return _health;
	}
	/**
	 * Devuelve el disparo del personaje
	 * @return Retorna el disparo
	 */
	public Disparo get_shoot() {
		return _shoot;
	}
	/**
	 * Actualiza el valor de la vida del personaje con el valor de _health
	 * @param _health valor que va a reemplazar a la vida actual
	 */
	public void set_health(int _health) {
		this._health = _health;
	}
	
	/**
	 * Modifica el sprite actual por i
	 * @param i Imagen que sera el nuevo sprite
	 */
	public void SetSprite(ImageIcon i) {
		_sprite=i;
	}
	
	/**
	 * Actualiza la hitbox del personaje
	 * @param x valor del eje x
	 * @param y valor del eje y
	 * @param heigth altura de la hitbox
	 * @param width  ancho de la hitbox
	 */
	public void setHitBox(int x , int y, int heigth, int width) {
		_hitbox=new Rectangle(x,y,heigth,width);
	}
	
	/**
	 * Cambia el estado actual por el estado s
	 * @param s Estado nuevo
	 */
	public void ChangeState(StateCharacter s) {
		 _state= s;
	}
	
	@Override
	public abstract void accept(Visitor v);
	
	/**
	 * Clona al personaje y devuelve la copia creada
	 * @return Retorna una copia del personaje
	 */
	public abstract Character Clone();
	
	public StateCharacter GetState() {
		return _state;
	}
	/**
	 * Calcula el daño recibido por el valor d restandolo a la vida actual
	 * @param d valor que va a ser reducido de la vida
	 */
	public void receive_attack(int d) {
		_state.receive_attack(d);
	}
	/**
	 * Delega al estado que retorne la velocidad de ataque
	 * @return Retorna la velocidad de ataque del personaje
	 */
	public int GetAttackSpeed() {
		return _state.GetDelay();
	}
	/**
	 * 
	 * Delega al estado que retorne la fuerza de ataque
	 * @return Retorna la fuerza del ataque del personaje
	 */
	public int GetStrength() {
		return _state.GetStrength();
	}
	
	public void receive_attack(Disparo miDisparo) {
		_state.receive_attack(miDisparo.get_strength());
			
	}
	
	/**
	 * Se destruye el personaje y se remueve del juego
	 */
	public void Die() {
		Controller.GetInstance().Remove(this);
	}
	
	/**
	 * Delega al estado que se actualice si le corresponde
	 */
	public void Update() {
		_state.update();
	}
	
	public boolean notificar() {
		for(IObserver c : _observers)
			c.StopShooting();
		
		return false;
	}
	
	public void StopShooting() {
		NormalState normal = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.accept(normal.GetVisitor());
	}
	
	public void eliminarObservador(IObserver observador) {
		_observers.remove(observador);
	}
	
	public void agregarObservador(IObserver observador) {
		if(!_observers.contains(observador))
			_observers.add(observador);
	}
	
	public void acceptObserver(VisitorObserver vo) {
		vo.visitAllyObservado(this);
		vo.visitAllyObservador(this);
	}
	public int get_delay() {
		
		return _baseDelay;
	}
	public int get_strength() {
		return _baseStrength;
	}
	public int get_velocidad() {
		return _baseMovementSpeed;
	}
	
}