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
	private static Player whosTurn;
	private static boolean firstTurn = true;
	
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
		StaticCard staticCard = (StaticCard) sc;
		staticCards.add(staticCard);
	}
	
	public static void addChanceCard(DrawableCard card) {
		chanceCards.add(card);
	}
	
	public static void setChanceCards(ArrayDeque<DrawableCard> newChanceCards) {
		chanceCards = newChanceCards;
	}
	
	public static void setStaticCards(ArrayList<StaticCard> newStaticCards) {
		staticCards = newStaticCards;
	}
	
	public static DrawableCard drawChanceCard() {
		return chanceCards.poll();
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
	
	// TODO This is awful and the whole keeping of the Cards in the SystemBoard 
	// needs a rewrite, this is temporary.
	public static SpecialCard getCardWithID(int id) {
		for (Object staticCard : staticCards) {
			if (staticCard instanceof SpecialCard) {
				SpecialCard sc = (SpecialCard) staticCard;
				if (sc.getBoardPosition() == id) {
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
			if (nextIDTurn == 4) nextIDTurn = 1;	
			
			whosTurn = getPlayerWithID(nextIDTurn);
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

} 