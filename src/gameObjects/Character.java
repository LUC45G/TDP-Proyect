package gameObjects;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameObjects.Disparos.Disparo;
import gameObjects.Estados.NormalState;
import gameObjects.Estados.StateCharacter;
import logicas.Controller;
import logicas.IObserver;
import logicas.Visitors.Visitor;
import logicas.Visitors.VisitorObserver;


/**
 * Modela a los personajes, tanto aliados como enemigos
 * @author Pippig, Matias Gonzalez, Lucas
 */
public abstract class Character extends GameObject implements IObserver {

	protected int 			 _cost;
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
		_cost=10;
	}
	/**
	 * Setea los atributos de este personaje a otro
	 * @param c caracter donde clonar atributos
	 */
	public void set_atributos(Character c){
		c.set_health(_health);
		c.set_cost(_cost);
		c.set_shoot(_shoot);
		for(IObserver o: _observers) {
			c.agregarObservador(o);
		}
		c.set_range(_range);
		if(!_visible)
			c.NotVisible();
	}

	public int get_cost() {
		return _cost;
	}
	
	/**
	 * Setea el disparo del personaje
	 * @param _shoot2 nuevo disparo del personaje
	 */
	protected void set_shoot(Disparo _shoot2) {
		_shoot=_shoot2;	
	}
	/**
	 * Setea el costo del personaje
	 * @param cost nuevo costo del personaje
	 */
	protected void set_cost(int cost) {
		_cost=cost;
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
	 * Cambia el estado actual por el estado s
	 * @param s Estado nuevo
	 */
	public void ChangeState(StateCharacter s) {
		 _state= s;
	}
	
	@Override
	public abstract void accept(Visitor v);
	
	/**
	 * Devuelve el estado actual del personaje
	 * @return estado actual del personaje
	 */
	public StateCharacter GetState() {
		return _state;
	}
	
	/**
	 * Calcula el da�o recibido por el valor d restandolo a la vida actual
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
	
	/**
	 * Efectua el recibimiento del ataque
	 * @param miDisparo disparo que golpea al personaje
	 */
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
	
	@Override
	public boolean notificar() {
		for(IObserver c : _observers)
			c.StopShooting();
		
		return false;
	}
	
	@Override
	public void StopShooting() {
		NormalState normal = new NormalState(this, _baseDelay, _baseStrength, _baseMovementSpeed);
		_state.accept(normal.GetVisitor());
	}
	
	@Override
	public void eliminarObservador(IObserver observador) {
		_observers.remove(observador);
	}
	
	@Override
	public void agregarObservador(IObserver observador) {
		if(!_observers.contains(observador))
			_observers.add(observador);
	}
	
	
	/**
	 * Acepta o no el visitante
	 * @param vo Visitor que visita 
	 */
	public void acceptObserver(VisitorObserver vo) {
		vo.visitAllyObservado(this);
		vo.visitAllyObservador(this);
	}
	
	/**
	 * devuelve la velocidad de ataque base
	 * @return velocidad de ataque base
	 */
	public int get_delay() {
		return _baseDelay;
	}
	
	/**
	 * devuelve la fuerza base
	 * @return fuerza base
	 */
	public int get_strength() {
		return _baseStrength;
	}
	
	/**
	 * devuelve la velocidad base
	 * @return velocidad base
	 */
	public int get_velocidad() {
		return _baseMovementSpeed;
	}
	
}