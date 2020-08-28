/**
 * No cents 
 * in the game
 */
package model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Player {
	private String name;
	private int money = 1500;
	private boolean playing;
	private int position = 1;
	private boolean bot;
	private int id;
	private boolean isImprisoned = false;
	private int bannedTurns = 0;
	private Deque<DrawableCard> getOutOfJailCards = new ArrayDeque<>();
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

	public boolean isImprisoned() {
		return isImprisoned;
	}

	public void setImprisoned(boolean isImprisoned) {
		this.isImprisoned = isImprisoned;
	}

	public int getBannedTurns() {
		return bannedTurns;
	}

	public void setBannedTurns(int bannedTurns) {
		this.bannedTurns = bannedTurns;
	}
	
	// Increases the amount of banned turns by 1, and returns the number of banned turns(bannedTurns) after they had been increased.
	public int increaseBannedTurns() {
		return ++bannedTurns;
	}
	
	// Decreases the amount of banned turns by 1, and returns the number of banned turns(bannedTurns) after they had been decreased.
	public int decreaseBannedTurns() {
		return --bannedTurns;
	}

	public Deque<DrawableCard> getGetOutOfJailCards() {
		return getOutOfJailCards;
	}

	public void setGetOutOfJailCards(Deque<DrawableCard> getOutOfJailCards) {
		this.getOutOfJailCards = getOutOfJailCards;
	}
	
	public DrawableCard popGetOutOfJailCard() {
		return getOutOfJailCards.pop();
	}
	
	public void pushGetOutOfJailCard(DrawableCard card) {
		getOutOfJailCards.add(card);
	}

//	public int getAmountOfGetOutOfJailCards() {
//		return amountOfGetOutOfJailCards;
//	}
//
//	public void setAmountOfGetOutOfJailCards(int amountOfGetOutOfJailCards) {
//		this.amountOfGetOutOfJailCards = amountOfGetOutOfJailCards;
//	}
//	
//	public void addGetOutOfJailCard() {
//		amountOfGetOutOfJailCards++;
//	}
//	
//	public void removeGetOutOfJailCard() {
//		amountOfGetOutOfJailCards--;
//	}
}
