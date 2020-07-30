package model;

public abstract class StaticCard extends Card {
	private int boardPosition;
	
	public StaticCard(String name, int boardPosition) {
		super(name);
		this.boardPosition = boardPosition;
	}
	
	public int getBoardPosition() {
		return boardPosition;
	}

	public void setBoardPosition(int boardPosition) {
		this.boardPosition = boardPosition;
	}
}
