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
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_punch.gif"));
	}
	public ImageIcon GetNormalSprite(<? extends Enemy1> e {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1.gif"));
	}
	public ImageIcon GetDeadSpriteSprite(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_shieldWalking.gif"));
	}
	public ImageIcon GetFrozenSprite(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1_frezze.gif"));
	}
	
	
	
	//enemy boss
	public ImageIcon GetShootingSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2_freeze.gif"));
	}
	
	
	// Enemy Fat
	public ImageIcon GetShootingSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3_freeze.gif"));
	}
	
	
	//enemy Fast
	public ImageIcon GetShootingSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4_freeze.gif"));
	}
	
	
	//EnemySlim
	public ImageIcon GetShootingSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5_freeze.gif"));
	}
	
	
	//enemy Strong
	public ImageIcon GetShootingSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy6_freeze.gif"));
	}
	
	
	/*-----------------------------------------------*/
	
	
	//Ally1
	public ImageIcon GetShootingSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_punch.gif"));
	}
	public ImageIcon GetNormalSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource(("/img/Ally1.gif")));
	}
	public ImageIcon GetDeadSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_bomb.gif"));
	}
	public ImageIcon GetProtectedShootingSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_shieldAttack.gif"));
	}
	public ImageIcon GetProtectedWalking(Ally1 a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_shieldWalking.gif"));
	}
	public ImageIcon GetFrozenSprite(Ally1 a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally1_freeze.gif"));
	}
	
	//AllyFat
	public ImageIcon GetShootingSprite(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(AllyFat a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2_freeze.gif"));
	}
	
	//AllyFast
	public ImageIcon GetShootingSprite(AllyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(AllyFast a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally5_freeze.gif"));
	}
	
	//AllySlim
	public ImageIcon GetShootingSprite(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(AllySlim a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3_freeze.gif"));
	}
	
	//Ally Strong
	public ImageIcon GetShootingSprite(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_punch.gif"));
	}
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
	public ImageIcon GetFrozenSprite(AllyStrong a) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4_freeze.gif"));
	}
}
