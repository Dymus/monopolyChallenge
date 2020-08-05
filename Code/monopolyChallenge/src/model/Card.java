package model;

public abstract class Card {
	private static int idCounter = 1;
	private int id;
	
	public Card() {
		this.id = idCounter++;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static void resetCounter() {
		idCounter = 1;
	}
}
