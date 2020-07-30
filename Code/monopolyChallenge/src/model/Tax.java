/**
 * > LUXURY
 * > INCOME
 */
package model;

public class Tax extends StaticCard {
	private int value;
	
	public Tax(String name, int boardPosition, int value) {
		super(name,boardPosition);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
