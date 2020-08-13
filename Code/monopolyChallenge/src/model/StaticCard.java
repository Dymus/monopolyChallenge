package model;

public class StaticCard extends Card {
	private String name;
	private int boardPosition;
	private CardSetType cardSetType;
	
	public StaticCard() {
		
	}
	
	public StaticCard(String name, int boardPosition, CardSetType cardSetType) {
		this.name = name;
		this.boardPosition = boardPosition;
		this.setCardSetType(cardSetType);
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

	public CardSetType getCardSetType() {
		return cardSetType;
	}

	public void setCardSetType(CardSetType cardSetType) {
		this.cardSetType = cardSetType;
	}
}
