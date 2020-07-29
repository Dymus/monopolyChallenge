/**
 *  > RED, GREEN etc.
 *	> RAILROADS
 *	> UTILITIES
 */
package model;

import java.util.ArrayList;

public class ColorGroup {
	private String name;
	private ArrayList<Card> cards;
	
	public ColorGroup(String name, ArrayList<Card> cards) {
		this.name = name;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}
