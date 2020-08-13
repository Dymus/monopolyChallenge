/**
 * > LUXURY
 * > INCOME
 */
package model;

public class Tax extends StaticCard {
	private int value;
	
	public Tax() {
		
	}
	
	public Tax(String name, int boardPosition, CardSetType cardSetType, int value) {
		super(name, boardPosition, cardSetType);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
