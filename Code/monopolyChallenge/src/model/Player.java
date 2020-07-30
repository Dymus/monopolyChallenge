/**
 * No cents 
 * in the game
 */
package model;

public class Player {
	private String name;
	private int money;
	private boolean playing;
	private int position;
	
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
