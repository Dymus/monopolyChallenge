/**
 * No cents 
 * in the game
 */
package model;

public class Player {
	private String name;
	private int money = 1500;
	private boolean playing;
	private int position = 1;
	private boolean bot;
	private int id;
	private static int idCounter = 1;
	
	public Player() {
		
	}
	
	public Player(String name, int money, boolean playing, int position, boolean isBot) {
		this.name = name;
		this.money = money;
		this.playing = playing;
		this.position = position;
		this.bot = isBot;
		this.setId(idCounter++);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isBot() {
		return bot;
	}

	public void setBot(boolean bot) {
		this.bot = bot;
	}
	
	public static void resetCounter() {
		idCounter = 1;
	}
}
