package gameObjects;

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
	public ImageIcon GetShootingSprite(Enemy1 e) {
		return null;
	}
	public ImageIcon GetNormalSprite(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1.gif"));
	}
	public ImageIcon GetDeadSpriteSprite(Enemy1 e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(Enemy1 e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(Enemy1 e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(Enemy1 e) {
		return null;
	}
	
	
	
	//enemy boss
	public ImageIcon GetShootingSprite(EnemyBoss e) {
		return null;
	}
	public ImageIcon GetNormalSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyBoss e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(EnemyBoss e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(EnemyBoss e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(EnemyBoss e) {
		return null;
	}
	
	
	// Enemy Fat
	public ImageIcon GetShootingSprite(EnemyFat e) {
		return null;
	}
	public ImageIcon GetNormalSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyFat e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(EnemyFat e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(EnemyFat e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(EnemyFat e) {
		return null;
	}
	
	
	//enemy Fast
	public ImageIcon GetShootingSprite(EnemyFast e) {
		return null;
	}
	public ImageIcon GetNormalSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyFast e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(EnemyFast e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(EnemyFast e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(EnemyFast e) {
		return null;
	}
	
	
	//EnemySlim
	public ImageIcon GetShootingSprite(EnemySlim e) {
		return null;
	}
	public ImageIcon GetNormalSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4.gif"));
	}
	public ImageIcon GetDeadSprite(EnemySlim e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(EnemySlim e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(EnemySlim e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(EnemySlim e) {
		return null;
	}
	
	
	//enemy Strong
	public ImageIcon GetShootingSprite(EnemyStrong e) {
		return null;
	}
	public ImageIcon GetNormalSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5.gif"));
	}
	public ImageIcon GetDeadSprite(EnemyStrong e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(EnemyStrong e) {
		return null;
	}
	public ImageIcon GetProtectedWalking(EnemyStrong e) {
		return null;
	}
	public ImageIcon GetFrozenSprite(EnemyStrong e) {
		return null;
	}
	
	
	/*-----------------------------------------------*/
	
	
	//Ally1
	public ImageIcon GetShootingSprite(Ally1 a) {
		return null;
	}
	public ImageIcon GetNormalSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource(("/img/Ally1.gif")));
	}
	public ImageIcon GetDeadSprite(Ally1 a) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(Ally1 a) {
		return null;
	}
	public ImageIcon GetProtectedWalking(Ally1 a) {
		return null;
	}
	public ImageIcon GetFrozenSprite(Ally1 a) {
		return null;
	}
	
	//AllyFat
	public ImageIcon GetShootingSprite(AllyFat e) {
		return null;
	}
	public ImageIcon GetNormalSprite(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2.gif"));
	}
	public ImageIcon GetDeadSprite(AllyFat e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(AllyFat a) {
		return null;
	}
	public ImageIcon GetProtectedWalking(AllyFat a) {
		return null;
	}
	public ImageIcon GetFrozenSprite(AllyFat a) {
		return null;
	}
	
	//AllyFast
	public ImageIcon GetShootingSprite(AllyFast e) {
		return null;
	}
	public ImageIcon GetNormalSprite(AllyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5.gif"));
	}
	public ImageIcon GetDeadSprite(AllyFast e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(AllyFast a) {
		return null;
	}
	public ImageIcon GetProtectedWalking(AllyFast a) {
		return null;
	}
	public ImageIcon GetFrozenSprite(AllyFast a) {
		return null;
	}
	
	//AllySlim
	public ImageIcon GetShootingSprite(AllySlim e) {
		return null;
	}
	public ImageIcon GetNormalSprite(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3.gif"));
	}
	public ImageIcon GetDeadSprite(AllySlim e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(AllySlim a) {
		return null;
	}
	public ImageIcon GetProtectedWalking(AllySlim a) {
		return null;
	}
	public ImageIcon GetFrozenSprite(AllySlim a) {
		return null;
	}
	
	//Ally Strong
	public ImageIcon GetShootingSprite(AllyStrong e) {
		return null;
	}
	public ImageIcon GetNormalSprite(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4.gif"));
	}
	public ImageIcon GetDeadSprite(AllyStrong e) {
		return null;
	}
	public ImageIcon GetProtectedShootingSprite(AllyStrong a) {
		return null;
	}
	public ImageIcon GetProtectedWalking(AllyStrong a) {
		return null;
	}
	public ImageIcon GetFrozenSprite(AllyStrong a) {
		return null;
	}
}
