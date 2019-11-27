package gameObjects;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Bank {
	
	private static Bank INSTANCE;

	private Bank() {  }
	
	public static Bank GetInstance() {
		if(INSTANCE == null)
			INSTANCE = new Bank();
		return INSTANCE;
	}
	
	//enemy 1
	/**
	 * Devuelve la imagen del enemigo base disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo base disparando
	 */
	public ImageIcon GetShootingSprite(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo base idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo base idle
	 */
	public ImageIcon GetNormalSprite(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemyBase e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_freeze.gif"));
	}
	
	
	
	//enemy boss
	/**
	 * Devuelve la imagen del enemigo jefe disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo jefe disparando
	 */
	public ImageIcon GetShootingSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo jefe idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo jefe idle
	 */
	public ImageIcon GetNormalSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_freeze.gif"));
	}
	
	
	// Enemy Fat
	/**
	 * Devuelve la imagen del enemigo gordo disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo gordo disparando
	 */
	public ImageIcon GetShootingSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo gordo idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo gordo idle
	 */
	public ImageIcon GetNormalSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_freeze.gif"));
	}
	
	
	//enemy Fast
	/**
	 * Devuelve la imagen del enemigo rapido disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo rapido disparando
	 */
	public ImageIcon GetShootingSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo rapido idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo rapido idle
	 */
	public ImageIcon GetNormalSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_freeze.gif"));
	}
	
	
	//EnemySlim
	/**
	 * Devuelve la imagen del enemigo flaco disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo flaco disparando
	 */
	public ImageIcon GetShootingSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo flaco idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo flaco idle
	 */
	public ImageIcon GetNormalSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5.gif"));
	}
	public ImageIcon GetDeadSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_freeze.gif"));
	}
	
	
	//enemy Strong
	/**
	 * Devuelve la imagen del enemigo fuerte disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo fuerte disparando
	 */
	public ImageIcon GetShootingSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_punch.gif"));
	}
	/**
	 * Devuelve la imagen del enemigo fuerte idle
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del enemigo fuerte idle
	 */
	public ImageIcon GetNormalSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_freeze.gif"));
	}
	
	
	/*-----------------------------------------------*/
	
	
	//AllyBase
	/**
	 * Devuelve la imagen del aliado base disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del aliado base disparando
	 */
	public ImageIcon GetShootingSprite(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_punch.gif"));
	}
	/**
	 * Devuelve la imagen del aliado base idle
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado base idle
	 */
	public ImageIcon GetNormalSprite(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1.gif"));
	}
	public ImageIcon GetDeadSprite(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_freeze.gif"));
	}
	public Icon GetIcon(AllyBase a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1.png"));
	}
	
	//AllyFat
	/**
	 * Devuelve la imagen del aliado gordo disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del aliado gordo disparando
	 */
	public ImageIcon GetShootingSprite(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_punch.gif"));
	}
	/**
	 * Devuelve la imagen del aliado gordo idle
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado gordo idle
	 */
	public ImageIcon GetNormalSprite(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2.gif"));
	}
	public ImageIcon GetDeadSprite(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(AllyFat a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(AllyFat a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(AllyFat a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_freeze.gif"));
	}
	public Icon GetIcon(AllyFat a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2.png"));
	}
	
	//AllyFast
	/**
	 * Devuelve la imagen del aliado rapido disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del aliado rapido disparando
	 */
	public ImageIcon GetShootingSprite(AllyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_punch.gif"));
	}
	/**
	 * Devuelve la imagen del aliado rapido idle
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado rapido idle
	 */
	public ImageIcon GetNormalSprite(AllyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5.gif"));
	}
	public ImageIcon GetDeadSprite(AllyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(AllyFast a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(AllyFast a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(AllyFast a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_freeze.gif"));
	}
	public Icon GetIcon(AllyFast a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5.png"));
	}
	
	//AllySlim
	/**
	 * Devuelve la imagen del aliado flaco disparando
	 * @param e enemigo al que modificar su imagen
	 * @return Retorna la imagen del aliado flaco disparando
	 */
	public ImageIcon GetShootingSprite(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_punch.gif"));
	}
	/**
	 * Devuelve la imagen del aliado flaco idle
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado flaco idle
	 */
	public ImageIcon GetNormalSprite(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3.gif"));
	}
	public ImageIcon GetDeadSprite(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(AllySlim a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(AllySlim a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(AllySlim a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_freeze.gif"));
	}
	public Icon GetIcon(AllySlim a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3.png"));
	}
	
	//Ally Strong
	/**
	 * Devuelve la imagen del aliado fuerte disparando
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado fuerte disparando
	 */
	public ImageIcon GetShootingSprite(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_punch.gif"));
	}
	/**
	 * Devuelve la imagen del aliado fuerte idle
	 * @param e aliado al que modificar su imagen
	 * @return Retorna la imagen del aliado fuerte idle
	 */
	public ImageIcon GetNormalSprite(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4.gif"));
	}
	public ImageIcon GetDeadSprite(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(AllyStrong a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(AllyStrong a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_shieldWalking.gif"));
	}
	public ImageIcon GetAffectedSprite(AllyStrong a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_freeze.gif"));
	}
	public Icon GetIcon(AllyStrong a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4.png"));
	}
}