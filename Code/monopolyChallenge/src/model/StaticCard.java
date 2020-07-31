package model;

public abstract class StaticCard extends Card {
	private String name;
	private int boardPosition;
	
	public StaticCard(String name, int boardPosition) {
		this.name = name;
		this.boardPosition = boardPosition;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBoardPosition() {
		return boardPosition;
	}

	public void setBoardPosition(int boardPosition) {
		this.boardPosition = boardPosition;
	}
}
