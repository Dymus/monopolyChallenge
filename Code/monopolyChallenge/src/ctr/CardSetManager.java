package ctr;

import java.util.ArrayList;
import java.util.Iterator;

import model.CardSet;
import model.CardSetType;
import model.City;
import model.Player;
import model.Property;

public class CardSetManager {	
	private static ArrayList<CardSet> cardSets;
	
	public CardSetManager() {
		cardSets = new ArrayList<CardSet>();
	}
	
	public boolean doesPlayerOwnWholeSet(Player player, CardSetType cardSetType) {
		// TODO iterate over card sets
		CardSet cardSet = getCardSetWithCardSetType(cardSetType);
		boolean wholeSetOwned = true;
		
		switch(cardSetType) {
		case BROWN:
		case LIGHT_BLUE:
		case PINK:
		case ORANGE:
		case RED:
		case YELLOW:
		case GREEN:
		case DARK_BLUE:
			ArrayList<City> cityCards = cardSet.getCards();
			Iterator cityIterator = cityCards.iterator();
			City c = new City();
			
			// Going through the cardSet until the end or until wholeSetOwned = false
			while (cityIterator.hasNext() && wholeSetOwned) {
				c = (City) cityIterator.next();
				
				// Checking if city is owned by anyone at all
				if (!c.isOwned()) {
					wholeSetOwned = false;
				} else {
					if (!c.getOwner().equals(player)) wholeSetOwned = false;
				}
			}
			break;
		case RAILROADS:
		case UTILITIES:
			ArrayList<Property> propertyCards = cardSet.getCards();
			Iterator propertyIterator = propertyCards.iterator();
			Property p = new Property();
			
			while (propertyIterator.hasNext() && wholeSetOwned) {
				p = (Property) propertyIterator.next();
				
				// Checking if property is owned by anyone at all
				if (!p.isOwned()) {
					wholeSetOwned = false;
				} else {
					if (!p.getOwner().equals(player)) wholeSetOwned = false;
				}
			}
			break;
		case OTHER:
		default:
			wholeSetOwned = false;
			System.err.println("Fatal Error!");
			break;
		}
		return wholeSetOwned;
	}
	
	public CardSet getCardSetWithCardSetType(CardSetType cardSetType) {
		ArrayList<CardSet> myCardSets = getCardSets();
		Iterator it = myCardSets.iterator();
		boolean found = false;
		CardSet result = new CardSet();
		
		while (it.hasNext() && !found) {
			result = (CardSet) it.next();
			if (result.getCardSetType().equals(cardSetType)) {
				found = true;
			}
		}
		
		if (found) {
			return result;
		} else {
			return (CardSet) null;
		}
	}
	
//	// EXPERIMENTAL
//	public int getCardSetIndexWithCardSetType(CardSetType cardSetType) {
//		
//	}
	
	public void removeCardSet(CardSet cardSet) {
		cardSets.remove(cardSet);
	}
	
	public boolean addCardSet(CardSet cardSet) {
		if (cardSets.add(cardSet)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<CardSet> getCardSets() {
		return cardSets;
	}
	
	public void setCardSets(ArrayList<CardSet> cardSets) {
		this.cardSets = cardSets;
	}
	
//	// !!! needs to be TESTED
//	public boolean updateCardInCardSet(Property card, CardSetType cst) {
//		int cardID = card.getId();
//		CardSet cs = getCardSetWithCardSetType(cst);
//		ArrayList<Property> allCardsInCardSet = cs.getCards();
//		boolean oldRemoved = false;
//		
//		Iterator<Property> it = allCardsInCardSet.iterator();
//		Property property = new Property();
//		
//		while(it.hasNext() && !oldRemoved) {
//			property = it.next();
//			if (it.next().getId() == cardID) {
//				it.remove();
//				oldRemoved = true;
//			}
//		}
//		
//		if (oldRemoved) {
//			// Old card replaced with a new card
//			cs.add(card);
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	// !!! needs to be TESTED
//	public boolean updateCardInCardSet(City card, CardSetType cst) {
//		int cardID = card.getId();
//		CardSet cs = getCardSetWithCardSetType(cst);
//		ArrayList<City> allCardsInCardSet = cs.getCards();
//		boolean oldRemoved = false;
//		
//		Iterator<City> it = allCardsInCardSet.iterator();
//		City city = new City();
//		
//		while(it.hasNext() && !oldRemoved) {
//			if (it.next().getId() == cardID) {
//				it.remove();
//				oldRemoved = true;
//			}
//		}
//		
//		if (oldRemoved) {
//			// Old card replaced with a new card
//			cs.add(card);
//			return true;
//		} else {
//			return false;
//		}
//	}
}
