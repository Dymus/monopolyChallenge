/**
 *  > RED, GREEN etc.
 *	> RAILROADS
 *	> UTILITIES
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

public class CardSet<T> {
	private CardSetType cardSetType;
	private ArrayList<T> cards;
	
	public CardSet() {
		
	}
	
	public CardSet(CardSetType cardSetType) {
		this.cardSetType = cardSetType;
		cards = new ArrayList<T>();
	}
	
	public CardSet(CardSetType cardSetType, ArrayList<T> cards) {
		this.cardSetType = cardSetType;
		this.cards = cards;
	}

	public CardSetType getCardSetType() {
		return cardSetType;
	}

	public void setCardSetType(CardSetType cardSetType) {
		this.cardSetType = cardSetType;
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
	
	// this is so sketchy
	public T getCardWithBoardPosition(int cardBoardPosition) {
		boolean found = false;
		boolean isCity = false;
		Iterator it = cards.iterator();

		T currentCardAfterCast  = (T) new Object();
		
		while(it.hasNext() && !found) {
			
			T currentCardBeforeCast = (T) it.next();
			
			if (currentCardBeforeCast.getClass().getSimpleName().equals("Property")) {
				currentCardAfterCast = (T) currentCardBeforeCast;
				if (((Property) currentCardAfterCast).getBoardPosition() == cardBoardPosition) found = true;
			} else if (currentCardBeforeCast.getClass().getSimpleName().equals("City")) {	
				currentCardAfterCast = (T) currentCardBeforeCast;
				if (((City) currentCardAfterCast).getBoardPosition() == cardBoardPosition) found = true;
			}
		}

		if (found) {
			return (T) currentCardAfterCast;
		} else {
			return (T) null;
		}
	}
	

//	// TODO accessed from CardSetManager
//	public void updateCard(T card, Class cardClass) {
//		cardClass.getSimpleName();
//		
////		cards.get(card);
//	}
	
//	@Override
//	public String toString() {
//		for (T card : cards) {
//		}
//	}
}
