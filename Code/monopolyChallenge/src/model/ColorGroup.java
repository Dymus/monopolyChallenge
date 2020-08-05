/**
 *  > RED, GREEN etc.
 *	> RAILROADS
 *	> UTILITIES
 */
package model;

import java.util.ArrayList;

public class ColorGroup<T> {
	private String name;
	private ArrayList<T> cards;
	
	public ColorGroup(String name) {
		this.name = name;
		cards = new ArrayList<T>();
	}
	
	public ColorGroup(String name, ArrayList<T> cards) {
		this.name = name;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<T> getCards() {
		return cards;
	}

	public void setCards(ArrayList<T> cards) {
		this.cards = cards;
	}
	
	public void add(T card) {
		cards.add(card);
	}
	
	public void add(City ... cards ) {
		for (City card : cards) {
			this.cards.add((T) card);
		}
	}
	
	public void add(Property ... cards ) {
		for (Property card : cards) {
			this.cards.add((T) card);
		}
	}
	
//	@Override
//	public String toString() {
//		for (T card : cards) {
//		}
//	}
}
