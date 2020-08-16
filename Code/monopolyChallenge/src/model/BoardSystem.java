package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class BoardSystem {
	private CommandResolver cr;
	private int maxPlayers; // is it really needed?
	private static ArrayList<Player> activePlayers = new ArrayList<Player>();
	private static ArrayList<? super StaticCard> staticCards = new ArrayList<StaticCard>();
	private static Deque<DrawableCard> chanceCards = new ArrayDeque<DrawableCard>();
	private static Deque<DrawableCard> communityChestCards = new ArrayDeque<DrawableCard>();
	private static Player whosTurn;
	private static boolean firstTurn = true;
	private static int turnCounter = 0;
	
	
	public BoardSystem(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		this.activePlayers = new ArrayList<Player>();
		whosTurn = new Player();
	}
	
//	public BoardSystem(int maxPlayers, ArrayList<Player> activePlayers) {
//		this.maxPlayers = maxPlayers;
//		this.activePlayers = activePlayers;
//	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public static ArrayList<Player> getActivePlayers() {
		return activePlayers;
	}
	
	public static void setActivePlayers(ArrayList<Player> listOfActivePlayers) {
		activePlayers = listOfActivePlayers;
	}
	
	public static int getNumberOfActivePlayers() {
		return activePlayers.size();
	}
	
	public static boolean addNewPlayer(Player p) {
		return activePlayers.add(p);
	}
	
	public static void addCard(SpecialCard sc) {
//		StaticCard staticCard = (StaticCard) sc;
		staticCards.add(sc);
	}
	
	public static void addCard(Tax tx) {
		staticCards.add(tx);
	}
	
	public static void addCard(City ct) {
		staticCards.add(ct);
	}
	
	public static void addCard(Property pt) {
		staticCards.add(pt);
	}
	
	public static void setChanceCards(ArrayDeque<DrawableCard> newChanceCards) {
		chanceCards = newChanceCards;
	}
	
	public static void addChanceCard(DrawableCard card) {
		chanceCards.add(card);
	}
	
	// Draw chance card
	public static DrawableCard drawChanceCard() {
		return chanceCards.poll();
	}
	
	// Return chance card
	public static boolean returnChanceCard(DrawableCard card) {
		if (chanceCards.add(card)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void setCommunityChestCards(ArrayDeque<DrawableCard> newCommunityChestCards) {
		communityChestCards = newCommunityChestCards;
	}
	
	public static void addCommunityChestCard(DrawableCard card) {
		communityChestCards.add(card);
	}
	
	// Draw community chest card
	public static DrawableCard drawCommunityChestCard() {
		return communityChestCards.poll();
	}
	
	// Return community chest card
	public static boolean returnCommunityChestCard(DrawableCard card) {
		if (communityChestCards.add(card)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static ArrayList<? super StaticCard> getStaticCards() {
		return staticCards;
	}
	
	public static void setStaticCards(ArrayList<StaticCard> newStaticCards) {
		staticCards = newStaticCards;
	}
	
	public static Player getPlayerWithID(int id) {
		Iterator<Player> it = activePlayers.iterator();
		boolean found = false;
		Player player = new Player();
		while (it.hasNext() && !found) {
			player = it.next();
			
			if (player.getId() == id) {
				found = true;
			}
		}
		
		if (found) {
			return player;
		} else {
			return (Player) null;
		}

	}
	

	
	public static Class getStaticCardClass(int boardPosition) {
		Iterator<? super StaticCard> it = staticCards.iterator();
		boolean found = false;
		StaticCard sc = new StaticCard();
		
		while(it.hasNext() && !found) {
			sc = (StaticCard) it.next();
			if (sc.getBoardPosition() == boardPosition) {
				found = true;
			}
		}
		
		if (found) {
			return sc.getClass();
		} else {
			return (Class) null;
		}
	}
	
	public static Property getPropertyCardWithBoardPosition(int boardPosition) {
		for (Object staticCard : staticCards) {
			if (staticCard instanceof Property) {
				Property pt = (Property) staticCard;
				// DEBUG
//				System.out.println(pt.getName() + ", " + pt.getBoardPosition() + ", " + pt.getBuyCost() + ", " + pt.isOwned());
				// END-DEBUG
				if (pt.getBoardPosition() == boardPosition) {
					return pt;
				}
			}
		}
		return (Property) null;
	}
	
	public static City getCityCardWithBoardPosition(int boardPosition) {
		for (Object staticCard : staticCards) {
			if (staticCard instanceof City) {
				City ct = (City) staticCard;
				// DEBUG
//				System.out.println(ct.getName() + ", " + ct.getBoardPosition() + ", " + ct.getBuyCost() + ", " + ct.isOwned() + ", " + ct.getRent() + ", " + ct.getRentWith1House() + ", " + ct.getWith2Houses() + ", " + ct.getWith3Houses() + ", " + ct.getWith4Houses() + ", " + ct.getWithHotel() + ", " + ct.getMortgageValue() + ", " + ct.getHouseCost() + ", " + ct.getHotelCost());
				// END-DEBUG
				if (ct.getBoardPosition() == boardPosition) {
					return ct;
				}
			}
		}
		return (City) null;
	}
	
	public static Tax getTaxCardWithBoardPosition(int boardPosition) {
		for (Object staticCard : staticCards) {
			if (staticCard instanceof Tax) {
				Tax tx = (Tax) staticCard;
				// DEBUG
//				System.out.println(tx.getName() + ", " + tx.getBoardPosition() + ", " + tx.getValue());
				// END-DEBUG
				if (tx.getBoardPosition() == boardPosition) {
					return tx;
				}
			}
		}
		return (Tax) null;
	}
	
	public static SpecialCard getSpecialCardWithBoardPosition(int boardPosition) {
		for (Object staticCard : staticCards) {
			if (staticCard instanceof SpecialCard) {
				SpecialCard sc = (SpecialCard) staticCard;
				// DEBUG
//				System.out.println(sc.getName() + ", " + sc.getBoardPosition() + ", " + sc.getCommand());
				// END-DEBUG
				if (sc.getBoardPosition() == boardPosition) {
					return sc;
				}
			}
		}
		return (SpecialCard) null;
	}

	// shouldn't this take playerID instead of player?
	public static int movePlayer(Player player, int places) {
		int oldPosition = player.getPosition();
		int newPosition = oldPosition;
		int timesPassedThroughGo = 0;
		for (int i = 0; i < places; i++) {
			newPosition++;
			if (newPosition > staticCards.size()) {
				newPosition = 1;
				timesPassedThroughGo++;
			}
		}
		player.setPosition(newPosition);
		return newPosition;
	}
	
	// should return player? or not?
	public static void nextTurn() {
		if (firstTurn) {
			whosTurn = getPlayerWithID(getIDOfStartingPlayerByRandom());
			firstTurn = false;
		} else {
			int currentTurn = whosTurn.getId();
			int nextIDTurn = (currentTurn + 1);
			if (nextIDTurn == activePlayers.size() + 1) nextIDTurn = 1;	
			
			whosTurn = getPlayerWithID(nextIDTurn);
			turnCounter++;
		}
	}
	
	// TODO differentiate dies to check for doubles
	public static Integer rollTheDice() {
		Integer pips = (int)(Math.random() * (12 - 2 + 1) + 2);
		return pips;
	}
	
	public static int getIDOfStartingPlayerByRandom() {
		int playerID = (int) (Math.random() * (activePlayers.size() - 1 + 1) + 1); 
		return playerID;
	}
	
	public static Player getWhosTurn() {
		return whosTurn;
	}
	
	public static void resetCounters() {
		Player.resetCounter();
		Card.resetCounter();
		firstTurn = true;
	}
	
	public static int getPlayerPosition(int playerID) {
		Player player = getPlayerWithID(playerID);
		return player.getPosition();
	}
	
	public static String getStaticCardName(int id) {
		StaticCard card = getStaticCardWithID(id);
		String name = card.getName();
		
		return name;
	}
	
	public static StaticCard getStaticCardWithID(int id) {
		Iterator<? super StaticCard> it = staticCards.iterator();
		boolean found = false;
		StaticCard sc = new StaticCard();
		
		while (it.hasNext() && !found) {
			sc = (StaticCard) it.next();
			if (sc.getId() == id) {
				found = true;
			}
		}
		
		if (found) {
			return sc;
		} else {
			return (StaticCard) null;
		}
		
	}
	
	public static int getCommunityChestCardDeckSize() {
		return communityChestCards.size();
	}
	
	public static int getChanceCardDeckSize() {
		return chanceCards.size();
	}
	
//	public static DrawableCard getChanceCard(int chanceCardID) {
//		Iterator<DrawableCard> it = chanceCards.iterator();
//		boolean found = false;
//		DrawableCard dc = new DrawableCard();
//		while (it.hasNext() && !found) {
//			dc = it.next();
//			if (dc.getId() == chanceCardID) {
//				found = true;
//			}
//		}
//		
//		if (found) {
//			return dc;
//		} else {
//			return (DrawableCard) null;
//		}
//	}
//	
//	public static DrawableCard getCommunityChestCard(int communityChestCardID) {
//		Iterator<DrawableCard> it = communityChestCards.iterator();
//		boolean found = false;
//		DrawableCard dc = new DrawableCard();
//		while (it.hasNext() && !found) {
//			dc = it.next();
//			if (dc.getId() == communityChestCardID) {
//				found = true;
//			}
//		}
//		
//		if (found) {
//			return dc;
//		} else {
//			return (DrawableCard) null;
//		}
//	}
} 