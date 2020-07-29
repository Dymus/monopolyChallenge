/**
 * No cents 
 * in the game
 */
package model;

public class Player {
	String name;
	int money;
	boolean playing;
	
	public Player(String name, int money, boolean playing) {
		this.name = name;
		this.money = money;
		this.playing = playing;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public boolean isPlaying() {
		return playing;
	}
	
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
}
