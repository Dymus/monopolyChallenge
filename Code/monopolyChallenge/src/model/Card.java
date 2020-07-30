package model;

public abstract class Card {
	private static int idCounter = 1;
	private int id;
	private String name;
	
	public Card(String name) {
		this.id = idCounter++;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
