package gameObjects;

import javax.swing.ImageIcon;

public class Bank {

	public Bank() {
		// TODO Auto-generated constructor stub
	}
	//enemy 1
	public ImageIcon getAngry(Enemy1 e) {
		return null;
	}
	public ImageIcon getPeace(Enemy1 e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy1.gif"));
	}
	public ImageIcon getDead(Enemy1 e) {
		return null;
	}	
	//enemy boss
	public ImageIcon getAngry(EnemyBoss e) {
		return null;
	}
	public ImageIcon getPeace(EnemyBoss e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy2.gif"));
	}
	public ImageIcon getDead(EnemyBoss e) {
		return null;
	}
	public ImageIcon getAngry(EnemyFat e) {
		return null;
	}
	public ImageIcon getPeace(EnemyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
	}
	public ImageIcon getDead(EnemyFat e) {
		return null;
	}
	//enemy Fast
	public ImageIcon getAngry(EnemyFast e) {
		return null;
	}
	public ImageIcon getPeace(EnemyFast e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy3.gif"));
	}
	public ImageIcon getDead(EnemyFast e) {
		return null;
	}
	//EnemySlim
	public ImageIcon getAngry(EnemySlim e) {
		return null;
	}
	public ImageIcon getPeace(EnemySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy4.gif"));
	}
	public ImageIcon getDead(EnemySlim e) {
		return null;
	}
	//enemy Strong
	public ImageIcon getAngry(EnemyStrong e) {
		return null;
	}
	public ImageIcon getPeace(EnemyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Enemy5.gif"));
	}
	public ImageIcon getDead(EnemyStrong e) {
		return null;
	}
	//Ally1
	public ImageIcon getAngry(Ally1 a) {
		return null;
	}
	public ImageIcon getPeace(Ally1 a) {
		return new ImageIcon(("/img/Ally1.gif"));
	}
	public ImageIcon getDead(Ally1 a) {
		return null;
	}
	//AllyFat
	public ImageIcon getAngry(AllyFat e) {
		return null;
	}
	public ImageIcon getPeace(AllyFat e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally2.gif"));
	}
	public ImageIcon getDead(AllyFat e) {
		return null;
	}
	//AllyFast
	public ImageIcon getAngry(AllyFast e) {
		return null;
	}
	public ImageIcon getPeace(AllyFast e) {
		return new ImageIcon("/img/Ally2.gif");
	}
	public ImageIcon getDead(AllyFast e) {
		return null;
	}
	//AllySlim
	public ImageIcon getAngry(AllySlim e) {
		return null;
	}
	public ImageIcon getPeace(AllySlim e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally3.gif"));
	}
	public ImageIcon getDead(AllySlim e) {
		return null;
	}
	//Ally Strong
	public ImageIcon getAngry(AllyStrong e) {
		return null;
	}
	public ImageIcon getPeace(AllyStrong e) {
		return new ImageIcon(this.getClass().getResource("/img/Ally4.gif"));
	}
	public ImageIcon getDead(AllyStrong e) {
		return null;
	}
}
