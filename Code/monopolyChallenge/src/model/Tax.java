/**
 * > LUXURY
 * > INCOME
 */
package model;

public class Tax extends StaticCard {
	private int value;
	
	public Tax(int id, String name, int value) {
		super(id, name);
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
