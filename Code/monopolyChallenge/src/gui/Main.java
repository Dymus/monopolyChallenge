package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import ctr.CardSetManager;
import model.BoardSystem;
import model.City;
import model.CardSet;
import model.CardSetType;
import model.CommandResolver;
import model.Die;
import model.DrawableCard;
import model.DrawableType;
import model.Player;
import model.Property;
import model.SpecialCard;
import model.Tax;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static CommandResolver cr = new CommandResolver();
	private static CardSetManager csM = new CardSetManager();
	
	private static CardSet<City> brown;
	private static CardSet<City> lightBlue;
	private static CardSet<City> pink;
	private static CardSet<City> orange;
	private static CardSet<City> red;
	private static CardSet<City> yellow;
	private static CardSet<City> green;
	private static CardSet<City> darkBlue;
	private static CardSet<Property> railroads;
	private static CardSet<Property> utilities;
			
	public static void initializePlayers() {
		// Test playing
		System.out.println("Please let us know how we should call you below: ");
		String name = sc.nextLine();
		
		// 9999999 money temporarily, 1500 on start by rules
		Player p1 = new Player(name, 1500, true, 1, false); // used to be Craig :)
		Player p2 = new Player("David", 1500, true, 1, true); 
		Player p3 = new Player("Jake", 1500, true, 1, true);
//		Player p4 = new Player("Jonah", 1500, true, 1, true);
		
		// Adding 4 players
		
		BoardSystem.addNewPlayer(p1);
		BoardSystem.addNewPlayer(p2);
		BoardSystem.addNewPlayer(p3);
//		BoardSystem.addNewPlayer(p4);
	}
	
	public static int start() throws InterruptedException {
		/* Starting tracking threads */
		
//		// Start player statistics tracking thread with GUI
//		PlayerStatTracker playerStatTrackerThread = new PlayerStatTracker();
//		new Thread(playerStatTrackerThread).start();
		
		// Start card set tracking thread with GUI
		CardSetTracker cardTrackerThread = new CardSetTracker(csM);
		new Thread(cardTrackerThread).start();
		
//		// Start die tracking thread with GUI
//		DieTracker dieTrackerThread = new DieTracker();
//		new Thread(dieTrackerThread).start();
		
		// Start DrawableCard deques tracking thread with GUI
		DequesMonitor dequesTrackerThread = new DequesMonitor();
		new Thread(dequesTrackerThread).start();
		
		
		System.out.println("| STARTING THE GAME |");
		BoardSystem.nextTurn();
		Player whosTurn = BoardSystem.getWhosTurn();
		System.out.println(whosTurn.getName() + " gets to throw dice first.");
		
		while (true) {
			whosTurn = BoardSystem.getWhosTurn();

			// Checking if player is in jail
			if (checkIfImprisoned(whosTurn)) {
				// Skipping turn (check the method above)
				continue;
			}
			
			// Rolling the dice
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is rolling the dice");
			} else {
				System.out.println("You're rolling the dice");
			}
			Thread.sleep(2000);
			Die.rollTheDice();
			Integer rolled = Die.getResult();
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") got " + Die.getFirstRoll() + " and " + Die.getSecondRoll() + " eyelets on the dice.");
			} else {
				System.out.println("You got " + Die.getFirstRoll() + " and " + Die.getSecondRoll() + " eyelets on the dice.");
			}
			if (Die.isRolledDouble()) {
				System.out.println("That's a double!");
			}
			
			// Check if player got double amount of pips three times in a row
			if (Die.getTimesRolledDouble() == 3 ) {
				// Imprison player
				if (whosTurn.isBot()) {
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") rolled double on the dice three times in a row. It's now skipping this turn and going to jail.");
				} else {
					System.out.println("You rolled double on the dice three times in a row. You're skipping this turn and going to jail.");
				}
				whosTurn.setImprisoned(true);
				whosTurn.setBannedTurns(3);
				whosTurn.setPosition(11);
				
				// Resetting the double counter on Die
				Die.resetTimesRolledDouble();
				Die.setRolledDouble(false);
				
				// Next turn and continue loop
				BoardSystem.nextTurn();
				System.out.println();
				continue;
			}
			
			// Moving the player
//			Thread.sleep(1000);
			int position = BoardSystem.movePlayer(whosTurn, rolled);
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") moved to position " + position + ".");
			} else {
				System.out.println("You moved to position " + position + ".");
			}
//			Thread.sleep(1000);
			Class staticCardClass = BoardSystem.getStaticCardClass(position);
			
			// Execute actions based on the position player has landed (City, Property, Tax, SpecialCard)
			chooseAction(staticCardClass, whosTurn, position, rolled);
			
			// If the player rolled double, it gets to roll the dice again
			if (Die.isRolledDouble() && !whosTurn.isImprisoned()) {
				System.out.println();
				continue;
			}
			
			BoardSystem.nextTurn();
			System.out.println();
		}
	}
	
	public static void init() {
		brown = new CardSet<City>(CardSetType.BROWN);
		lightBlue = new CardSet<City>(CardSetType.LIGHT_BLUE);
		pink = new CardSet<City>(CardSetType.PINK);
		orange = new CardSet<City>(CardSetType.ORANGE);
		red = new CardSet<City>(CardSetType.RED);
		yellow = new CardSet<City>(CardSetType.YELLOW);
		green = new CardSet<City>(CardSetType.GREEN);
		darkBlue = new CardSet<City>(CardSetType.DARK_BLUE);
		railroads = new CardSet<Property>(CardSetType.RAILROADS);
		utilities = new CardSet<Property>(CardSetType.UTILITIES);
//		Deque<DrawableCard> communityChestCards = new ArrayDeque<DrawableCard>();
//		Deque<DrawableCard> chanceCards = new ArrayDeque<DrawableCard>();

		SpecialCard cid1 = new SpecialCard("Go".toUpperCase(), 1, CardSetType.OTHER, "No action"); // Previous command "Collect salary"
		
		// Brown
		City cid2 = new City("Mediterranean Avenue".toUpperCase(), 2, CardSetType.BROWN, 60, false, 2, 10, 30, 90, 160, 250, 30, 50, 50);
		SpecialCard cid3 = new SpecialCard("Community Chest 1".toUpperCase(), 3, CardSetType.COMMUNITY_CHEST, "Draw community chest");
		City cid4 = new City("Baltic Avenue".toUpperCase(), 4, CardSetType.BROWN, 60, false, 4, 20, 60, 180, 320, 450, 30, 50, 50);
		Tax cid5 = new Tax("Income Tax".toUpperCase(), 5, CardSetType.OTHER, 200);
		Property cid6 = new Property("Reading Railroad".toUpperCase(), 6, CardSetType.RAILROADS, 200, false); // Station
		
		// Light Blue
		City cid7 = new City("Oriental Avenue".toUpperCase(), 7, CardSetType.LIGHT_BLUE, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		SpecialCard cid8 = new SpecialCard("Chance Pink".toUpperCase(), 8, CardSetType.CHANCE, "Draw chance");
		City cid9 = new City("Vermont Avenue".toUpperCase(), 9, CardSetType.LIGHT_BLUE, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		City cid10 = new City("Connecticut Avenue".toUpperCase(), 10, CardSetType.LIGHT_BLUE, 120, false, 8, 40, 100, 300, 450, 600, 60, 50, 50);
		SpecialCard cid11 = new SpecialCard("Jail".toUpperCase(), 11, CardSetType.OTHER, "No action");
		
		// Pink
		City cid12 = new City("St.Charles Place".toUpperCase(), 12, CardSetType.PINK, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		Property cid13 = new Property("Electric Company".toUpperCase(), 13, CardSetType.UTILITIES,  150, false); // Utility
		City cid14 = new City("States Avenue".toUpperCase(), 14, CardSetType.PINK, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		City cid15 = new City("Virginia Avenue".toUpperCase(), 15, CardSetType.PINK, 160, false, 12, 60, 180, 500, 700, 900, 80, 100, 100);
		Property cid16 = new Property("Pennsylvania Railroad".toUpperCase(), 16, CardSetType.RAILROADS, 200, false); // Station
		
		// Orange
		City cid17 = new City("St. James Place".toUpperCase(), 17, CardSetType.ORANGE, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		SpecialCard cid18 = new SpecialCard("Community Chest 2".toUpperCase(), 18, CardSetType.COMMUNITY_CHEST, "Draw community chest");
		City cid19 = new City("Tennessee Avenue".toUpperCase(), 19, CardSetType.ORANGE, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		City cid20 = new City("New York Avenue".toUpperCase(), 20, CardSetType.ORANGE, 200, false, 16, 80, 220, 600, 800, 1000, 100, 100, 100);
		SpecialCard cid21 = new SpecialCard("Free Parking".toUpperCase(), 21, CardSetType.OTHER, "No action");
		
		// Red
		City cid22 = new City("Kentucky Avenue".toUpperCase(), 22, CardSetType.RED, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		SpecialCard cid23 = new SpecialCard("Chance Blue".toUpperCase(), 23, CardSetType.CHANCE, "Draw chance");
		City cid24 = new City("Indiana Avenue".toUpperCase(), 24, CardSetType.RED, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		City cid25 = new City("Illinois Avenue".toUpperCase(), 25, CardSetType.RED, 240, false, 20, 100, 300, 750, 925, 1100, 120, 150, 150);
		Property cid26 = new Property("B. & O. Railroad".toUpperCase(), 26, CardSetType.RAILROADS, 200, false); // Station
		
		// Yellow
		City cid27 = new City("Atlantic Avenue".toUpperCase(), 27, CardSetType.YELLOW, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		City cid28 = new City("Ventnor Avenue".toUpperCase(), 28, CardSetType.YELLOW, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		Property cid29 = new Property("Water Works".toUpperCase(), 29, CardSetType.UTILITIES, 150, false); // Utility
		City cid30 = new City("Marvin Gardens".toUpperCase(), 30, CardSetType.YELLOW, 280, false, 24, 120, 360, 850, 1025, 1200, 140, 150, 150);
		SpecialCard cid31 = new SpecialCard("Go To Jail".toUpperCase(), 31, CardSetType.OTHER, "Go Jail");
		
		// Green
		City cid32 = new City("Pacific Avenue".toUpperCase(), 32, CardSetType.GREEN, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		City cid33 = new City("North Carolina Avenue".toUpperCase(), 33, CardSetType.GREEN, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		SpecialCard cid34 = new SpecialCard("Community Chest 3".toUpperCase(), 34, CardSetType.COMMUNITY_CHEST, "Draw Community Chest");
		City cid35 = new City("Pennsylvania Avenue".toUpperCase(), 35, CardSetType.GREEN, 320, false, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200);
		Property cid36 = new Property("Short Line".toUpperCase(), 36, CardSetType.RAILROADS, 200, false); // Station
		SpecialCard cid37 = new SpecialCard("Chance Orange".toUpperCase(), 37, CardSetType.CHANCE, "Draw Chance");
		
		// Dark Blue
		City cid38 = new City("Park Place".toUpperCase(), 38, CardSetType.DARK_BLUE, 350, false, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200);
		Tax cid39 = new Tax("Luxury Tax".toUpperCase(), 39, CardSetType.OTHER, 100);
		City cid40 = new City("Boardwalk".toUpperCase(), 40, CardSetType.DARK_BLUE, 400, false, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200);

		// Community chest cards
		DrawableCard cid41 = new DrawableCard("Advance to Go (Collect $200)", "Go ID 1", DrawableType.COMMUNITY_CHEST); 
		DrawableCard cid42 = new DrawableCard("Bank error in your favor - Collect $200", "Collect 200", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid43 = new DrawableCard("Doctor's fee - Pay $50", "Pay 50", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid44 = new DrawableCard("From sale of stock you get $50", "Get 50", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid45 = new DrawableCard("Get Out of Jail Free", "Keep Jail Free", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid46 = new DrawableCard("Go to Jail - Go directly to jail - Do not pass Go - Do not collect $200", "Go Jail", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid47 = new DrawableCard("Grand Opera Night - Collect $50 from every player for opening night seats", "Get 50 All", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid48 = new DrawableCard("Holiday Fund matures - Receive $100", "Receive 100", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid49 = new DrawableCard("Income tax refund - Collect $20", "Collect 20", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid50 = new DrawableCard("It is your birthday - Collect $10", "Collect 10", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid51 = new DrawableCard("Life insurance matures - Collect $100", "Collect 100", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid52 = new DrawableCard("Pay hospital fees of $100", "Pay 100", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid53 = new DrawableCard("Pay school fees of $150", "Pay 150", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid54 = new DrawableCard("Receive $25 consultancy fee", "Receive 25", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid55 = new DrawableCard("You are assessed for street repairs - $40 per house - $115 per hotel", "Pay 40 Per House, Pay 115 Per Hotel", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid56 = new DrawableCard("You have won second prize in a beauty contest - Collect $10", "Collect 10", DrawableType.COMMUNITY_CHEST);
		DrawableCard cid57 = new DrawableCard("You inherit $100", "Inherit 100", DrawableType.COMMUNITY_CHEST);
		
		// Chance cards
		DrawableCard cid58 = new DrawableCard("Advance to Go (Collect $200)", "Go ID 1", DrawableType.CHANCE);
		DrawableCard cid59 = new DrawableCard("Advance to Illinois Ave - If you pass Go, collect $200", "Go ID 25", DrawableType.CHANCE);
		DrawableCard cid60 = new DrawableCard("Advance to St. Charles Place – If you pass Go, collect $200", "Go ID 12", DrawableType.CHANCE);
		DrawableCard cid61 = new DrawableCard("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", "Go Closest Utility", DrawableType.CHANCE);
		DrawableCard cid62 = new DrawableCard("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", "Go Closest Railroad", DrawableType.CHANCE);
		DrawableCard cid63 = new DrawableCard("Bank pays you dividend of $50", "Get 50", DrawableType.CHANCE);
		DrawableCard cid64 = new DrawableCard("Get Out of Jail Free", "Keep Jail Free", DrawableType.CHANCE);
		DrawableCard cid65 = new DrawableCard("Go Back 3 Spaces", "Go -3", DrawableType.CHANCE);
		DrawableCard cid66 = new DrawableCard("Go to Jail – Go directly to Jail–Do not pass Go, do not collect $200", "Go Jail", DrawableType.CHANCE);
		DrawableCard cid67 = new DrawableCard("Make general repairs on all your property – For each house pay $25 – For each hotel $100", "Pay 25 Per House, Pay 100 Per Hotel", DrawableType.CHANCE);
		DrawableCard cid68 = new DrawableCard("Pay poor tax of $15", "Pay 15", DrawableType.CHANCE);
		DrawableCard cid69 = new DrawableCard("Take a trip to Reading Railroad – If you pass Go, collect $200", "Go ID 6", DrawableType.CHANCE);
		DrawableCard cid70 = new DrawableCard("Take a walk on the Boardwalk – Advance token to Boardwalk", "Go ID 40", DrawableType.CHANCE);
		DrawableCard cid71 = new DrawableCard("You have been elected Chairman of the Board – Pay each player $50", "Pay 50 All", DrawableType.CHANCE);
		DrawableCard cid72 = new DrawableCard("Your building and loan matures — Collect $150", "Collect 150", DrawableType.CHANCE);
		DrawableCard cid73 = new DrawableCard("You have won a crossword competition — Collect $100", "Collect 100", DrawableType.CHANCE);
		

		// LOCAL arrays, lists and what not below this comment, mainly for debugging and testing
		// Adding to groups
		brown.add(cid2, cid4);
		lightBlue.add(cid7,cid9,cid10);
		pink.add(cid12, cid14, cid15);
		orange.add(cid17, cid19, cid20);
		red.add(cid22, cid24, cid25);
		yellow.add(cid27, cid28, cid30);
		green.add(cid32, cid33, cid35);
		darkBlue.add(cid38, cid40);
		railroads.add(cid6, cid16, cid26, cid36);
		utilities.add(cid13, cid29);
		
		csM.addCardSet(brown);
		csM.addCardSet(lightBlue);
		csM.addCardSet(pink);
		csM.addCardSet(orange);
		csM.addCardSet(red);
		csM.addCardSet(yellow);
		csM.addCardSet(green);
		csM.addCardSet(darkBlue);
		csM.addCardSet(railroads);
		csM.addCardSet(utilities);		
		
//		communityChestCards.add(cid41);
//		communityChestCards.add(cid42);
//		communityChestCards.add(cid43);
//		communityChestCards.add(cid44);
//		communityChestCards.add(cid45);
//		communityChestCards.add(cid46);
//		communityChestCards.add(cid47);
//		communityChestCards.add(cid48);
//		communityChestCards.add(cid49);
//		communityChestCards.add(cid50);
//		communityChestCards.add(cid51);
//		communityChestCards.add(cid52);
//		communityChestCards.add(cid53);
//		communityChestCards.add(cid54);
//		communityChestCards.add(cid55);
//		communityChestCards.add(cid56);
//		communityChestCards.add(cid57);
//		
//		chanceCards.add(cid58);
//		chanceCards.add(cid59);
//		chanceCards.add(cid60);
//		chanceCards.add(cid61);
//		chanceCards.add(cid62);
//		chanceCards.add(cid63);
//		chanceCards.add(cid64);
//		chanceCards.add(cid65);
//		chanceCards.add(cid66);
//		chanceCards.add(cid67);
//		chanceCards.add(cid68);
//		chanceCards.add(cid69);
//		chanceCards.add(cid70);
//		chanceCards.add(cid71);
//		chanceCards.add(cid72);
//		chanceCards.add(cid73);
		
		
		// OFFICIAL BOARD SYSTEM
		
		// Adding 40 board cards
		
		BoardSystem.addCard(cid1);
		BoardSystem.addCard(cid2);
		BoardSystem.addCard(cid3);
		BoardSystem.addCard(cid4);
		BoardSystem.addCard(cid5);
		BoardSystem.addCard(cid6);
		BoardSystem.addCard(cid7);
		BoardSystem.addCard(cid8);
		BoardSystem.addCard(cid9);
		BoardSystem.addCard(cid10);
		BoardSystem.addCard(cid11);
		BoardSystem.addCard(cid12);
		BoardSystem.addCard(cid13);
		BoardSystem.addCard(cid14);
		BoardSystem.addCard(cid15);
		BoardSystem.addCard(cid16);
		BoardSystem.addCard(cid17);
		BoardSystem.addCard(cid18);
		BoardSystem.addCard(cid19);
		BoardSystem.addCard(cid20);
		BoardSystem.addCard(cid21);
		BoardSystem.addCard(cid22);
		BoardSystem.addCard(cid23);
		BoardSystem.addCard(cid24);
		BoardSystem.addCard(cid25);
		BoardSystem.addCard(cid26);
		BoardSystem.addCard(cid27);
		BoardSystem.addCard(cid28);
		BoardSystem.addCard(cid29);
		BoardSystem.addCard(cid30);
		BoardSystem.addCard(cid31);
		BoardSystem.addCard(cid32);
		BoardSystem.addCard(cid33);
		BoardSystem.addCard(cid34);
		BoardSystem.addCard(cid35);
		BoardSystem.addCard(cid36);
		BoardSystem.addCard(cid37);
		BoardSystem.addCard(cid38);
		BoardSystem.addCard(cid39);
		BoardSystem.addCard(cid40);
		
		/* Adding DrawableCards to decks */
		
		// Community Chest
		ArrayList<DrawableCard> communityChestCardsRaw = new ArrayList<>();
		communityChestCardsRaw.add(cid41);
		communityChestCardsRaw.add(cid42);
		communityChestCardsRaw.add(cid43);
		communityChestCardsRaw.add(cid44);
		communityChestCardsRaw.add(cid45);
		communityChestCardsRaw.add(cid46);
		communityChestCardsRaw.add(cid47);
		communityChestCardsRaw.add(cid48);
		communityChestCardsRaw.add(cid49);
		communityChestCardsRaw.add(cid50);
		communityChestCardsRaw.add(cid51);
		communityChestCardsRaw.add(cid52);
		communityChestCardsRaw.add(cid53);
		communityChestCardsRaw.add(cid54);
		communityChestCardsRaw.add(cid55);
		communityChestCardsRaw.add(cid56);
		communityChestCardsRaw.add(cid57);
		
		// Shuffling the cards in the ArrayList
		Collections.shuffle(communityChestCardsRaw);
		// Adding community chest cards to the deque
		for (DrawableCard card : communityChestCardsRaw) {
			BoardSystem.addCommunityChestCard(card);
		}
		
		// Chance
		ArrayList<DrawableCard> chanceCardsRaw = new ArrayList<>();
		chanceCardsRaw.add(cid58);
		chanceCardsRaw.add(cid59);
		chanceCardsRaw.add(cid60);
		chanceCardsRaw.add(cid61);
		chanceCardsRaw.add(cid62);
		chanceCardsRaw.add(cid63);
		chanceCardsRaw.add(cid64);
		chanceCardsRaw.add(cid65);
		chanceCardsRaw.add(cid66);
		chanceCardsRaw.add(cid67);
		chanceCardsRaw.add(cid68);
		chanceCardsRaw.add(cid69);
		chanceCardsRaw.add(cid70);
		chanceCardsRaw.add(cid71);
		chanceCardsRaw.add(cid72);
		chanceCardsRaw.add(cid73);
		
		// Shuffling the cards in the ArrayList
		Collections.shuffle(chanceCardsRaw);
		// Adding chance cards to the deque
		for (DrawableCard card : chanceCardsRaw) {
			BoardSystem.addChanceCard(card);
		}
	}
	
	// TODO rewrite to account for isBot
	// continue returns true, otherwise false
	private static boolean checkIfImprisoned(Player whosTurn) {
		if (whosTurn.isImprisoned()) {
			if (whosTurn.getGetOutOfJailCards().size() > 0) {
				if (!whosTurn.isBot()) {
					System.out.println("You happen to have a card that lets you get out of jail for free, do you wish to use it? (Y\\N)");
					String answer = sc.nextLine().toUpperCase();
					if (answer.equals("Y")) {
						
						// Returning the card to appropriate deque
						DrawableCard card = whosTurn.popGetOutOfJailCard();
						if (card.getType() == DrawableType.CHANCE) {
							BoardSystem.addChanceCard(card);
						} else {
							BoardSystem.addCommunityChestCard(card);
						}
						
						whosTurn.setBannedTurns(0);
						whosTurn.setImprisoned(false);
						System.out.println("You're getting out of JAIL");
						return false;
					} else {
						int leftTurns = whosTurn.decreaseBannedTurns();
						if (leftTurns == 0) {
							whosTurn.setImprisoned(false);
						}
						System.out.println("You're in jail, you're skipping the turn. Remaining turns to skip: " + whosTurn.getBannedTurns());
						
						BoardSystem.nextTurn();
						System.out.println();
						return true;
					}
				} else {
					// Returning the card to appropriate deque
					DrawableCard card = whosTurn.popGetOutOfJailCard();
					if (card.getType() == DrawableType.CHANCE) {
						BoardSystem.addChanceCard(card);
					} else {
						BoardSystem.addCommunityChestCard(card);
					}
					
					whosTurn.setBannedTurns(0);
					whosTurn.setImprisoned(false);
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + " is using a card to get out of JAIL");
					return false;
				}
			}
			else if (whosTurn.getBannedTurns() < 2) {
				whosTurn.decreaseBannedTurns();
				whosTurn.setImprisoned(false);
				if (whosTurn.isBot()) {
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is in jail and skipping the turn. In jail for " + whosTurn.getBannedTurns() + " more turns.");
				} else {
					System.out.println("You're in jail, you're skipping the turn. Remaining turns to skip: " + whosTurn.getBannedTurns());
				}			
				
				BoardSystem.nextTurn();
				System.out.println();
				return true;
			} else {
				whosTurn.decreaseBannedTurns();
				if (whosTurn.isBot()) {
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is in jail and skipping the turn. In jail for " + whosTurn.getBannedTurns() + " more turns.");
				} else {
					System.out.println("You're in jail, you're skipping the turn. Remaining turns to skip: " + whosTurn.getBannedTurns());
				}
				
				BoardSystem.nextTurn();
				System.out.println();
				return true;
			}
		} else {
			return false;
		}
	}
	
	private static void actOnProperty(Player whosTurn, int position, int rolled, boolean movedWithCardMovingToNearestUtilityOrRailroad) {
		Property property = BoardSystem.getPropertyCardWithBoardPosition(position);
		if (whosTurn.isBot()) {
			System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at " + property.getName() + ".");
		} else {
			System.out.println("You're standing at " + property.getName() + ".");
		}
		if (!property.isOwned()) {
			if(!whosTurn.isBot()) {
				System.out.println("This utility/railroad is not owned by anyone. Would you wish to buy it for " + property.getBuyCost() + "? (Y\\N)");
				String response = sc.nextLine().toUpperCase();
				if (response.equals("Y")) {
					if (whosTurn.getMoney() >= property.getBuyCost()) {
						whosTurn.setMoney(whosTurn.getMoney() - property.getBuyCost());
						property.setOwned(true);
						property.setOwner(whosTurn);
//						csM.updateCardInCardSet(property, property.getCardSetType());
						System.out.println(property.getName() + " is now yours.");
					} else {
						// TODO no moneys
					}
				} else {
					// TODO AUCTION
				}
			} else {
				if (whosTurn.getMoney() >= property.getBuyCost()) {
					whosTurn.setMoney(whosTurn.getMoney() - property.getBuyCost());
					property.setOwned(true);
					property.setOwner(whosTurn);
//					csM.updateCardInCardSet(property, property.getCardSetType());
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") bought " + property.getName() + ".");
				} else {
					// TODO AUCTION
				}
			}
		} else {
			if (!property.getOwner().equals(whosTurn)) {
				Player owner = property.getOwner();
				System.out.println("This property belongs to player " + owner.getName() + "(ID:" + owner.getId() + ").");
				int amountOwned = 0;
				int rent = 0;
				
				// Calculating rent
				
				// Checking if property is railroad or utility 
				boolean isRailroad = false;
				if (railroads.getCards().contains(property)) {
					isRailroad = true;
				}
				
				// Counting owned properties
				if (isRailroad) {
					for (Property p: railroads.getCards()) {
						if (p.getOwner() == owner) {
							amountOwned++;
						}
					}

					if (amountOwned == 1) {
						rent = 25;
					} else if (amountOwned == 2) {
						rent = 50;
					} else if (amountOwned == 3) {
						rent = 100;
					} else if (amountOwned == 4) {
						rent = 200;
					}
					
					if (movedWithCardMovingToNearestUtilityOrRailroad) {
						rent *= 2;
					}
				} else {
					if (movedWithCardMovingToNearestUtilityOrRailroad) {
						System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() +") will now roll the dice and pay the owner the times the amount thrown.");
						// "Rolling" the dice
						Integer firstDie = (int)(Math.random() * (6 - 1 + 1) + 1);
						Integer secondDie = (int)(Math.random() * (6 - 1 + 1) + 1);
						int amountThrown = firstDie + secondDie;
						rent = amountThrown * 10;
					} else {
						for (Property p: utilities.getCards()) {
							if (p.getOwner() == owner) {
								amountOwned++;
							}
						}
						if (amountOwned == 1) {
							rent = rolled * 4;
						} else if (amountOwned == 2) {
							rent = rolled * 10;
						}
					}
				}
				
				if (whosTurn.getMoney() >= rent) {
					whosTurn.setMoney(whosTurn.getMoney() - rent);
					if (whosTurn.isBot()) {
						System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") payed " + rent + " rent to player " + owner.getName() + "(ID:" + owner.getId() + ").");
					} else {
						System.out.println("You paid " + rent + " rent to player " + owner.getName() + "(ID:" + owner.getId() + ").");
					}
				} else {
					// TODO credits? end game? mortgage options?
					if (whosTurn.isBot()) {
						System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") doesn't have sufficient funds to pay rent!");
					} else {
						System.out.println("You don't have sufficient funds to pay rent!");
					}
				}
			} else {
				if (whosTurn.isBot()) {
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at the property owned by that player.");
				} else {
					System.out.println("You're standing at the property you own.");
				}
			}
		}
	}
	
	private static void actOnCity(Player whosTurn, int position) {
		City city = BoardSystem.getCityCardWithBoardPosition(position);
		if (whosTurn.isBot()) {
			System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at " + city.getName() + ".");
		} else {
			System.out.println("You're standing at " + city.getName() + ".");
		}
		if (!city.isOwned()) {
			if (!whosTurn.isBot()) {
				System.out.println("This city does not belong to anyone. Would you wish to buy it for " + city.getBuyCost() + "? (Y\\N)");
				String response = sc.nextLine().toUpperCase();
				if (response.equals("Y")) {
					if (whosTurn.getMoney() >= city.getBuyCost()) {
						whosTurn.setMoney(whosTurn.getMoney() - city.getBuyCost());
						city.setOwned(true);
						city.setOwner(whosTurn);
//						csM.updateCardInCardSet(city, city.getCardSetType());
						System.out.println(city.getName() + " is now yours.");
					} else {
						// TODO no money
					}
				} else {
					// TODO AUCTION
				}
			} else {
				if (whosTurn.getMoney() >= city.getBuyCost()) {
					whosTurn.setMoney(whosTurn.getMoney() - city.getBuyCost());
					city.setOwned(true);
					city.setOwner(whosTurn);
//					csM.updateCardInCardSet(city, city.getCardSetType());
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") bought " + city.getName() + ".");
				} else {
					// TODO AUCTION
				}
			}
		} else {
			if (!city.getOwner().equals(whosTurn)) {
				Player owner = city.getOwner();
				System.out.println("This city belongs to player " + owner.getName() + "(ID:" + owner.getId() + ").");
				int rent = 0;
				
				// Calculating rent
				
				// Getting cardSetType from the city
				CardSetType cst = city.getCardSetType();
				
				// Checking if lot is unimproved, if it has houses or hotels 
				// and calculating final rent
				if (city.isUnimproved()) {
					if (csM.doesPlayerOwnWholeSet(owner, cst)) {
						rent = city.getRent() * 2;
					} else {
						rent = city.getRent();
					}
				} else {
					int houses = city.getHouses();
					int hotels = city.getHotels();
					if (hotels == 1) {
						rent = city.getWithHotel();
					} else {
						if (houses == 1) rent = city.getRentWith1House();
						else if (houses == 2) rent = city.getWith2Houses();
						else if (houses == 3) rent = city.getWith3Houses();
						else rent = city.getWith4Houses();
					}
				}
				
				// Paying rent
				if (whosTurn.getMoney() >= rent) {
					whosTurn.setMoney(whosTurn.getMoney() - rent);
					if (whosTurn.isBot()) {
						System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") payed " + rent + " rent to player " + owner.getName() + "(ID:" + owner.getId() + ").");
					} else {
						System.out.println("You paid " + rent + " rent to player " + owner.getName() + "(ID:" + owner.getId() + ").");
					}
				} else {
					// TODO credits? end game? mortgage options?
					if (whosTurn.isBot()) {
						System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") doesn't have sufficient funds to pay rent!");
					} else {
						System.out.println("You don't have sufficient funds to pay rent!");
					}
				}
			} else {
				if (whosTurn.isBot()) {
					System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at the city owned by that player.");
				} else {
					System.out.println("You're standing at the city you own.");
				}	
			}
		}
	}
	
	private static void actOnTax(Player whosTurn, int position) {
		Tax tax = BoardSystem.getTaxCardWithBoardPosition(position);
		if (whosTurn.isBot()) {
			System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at " + tax.getName() + ".");
		} else {
			System.out.println("You're standing at " + tax.getName() + ".");
		}
		if (whosTurn.getMoney() >= tax.getValue()) {
			whosTurn.setMoney(whosTurn.getMoney() - tax.getValue());
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") paid " + tax.getValue() + " " + tax.getName().toLowerCase());
			} else {
				System.out.println("You paid " + tax.getValue() + " " + tax.getName().toLowerCase());
			}	
		} else {
			// TODO No money
		}
	}
	
	private static void actOnSpecialCard(Player whosTurn, int position) {
		SpecialCard specialCard = BoardSystem.getSpecialCardWithBoardPosition(position);
		if (specialCard.getName().equals("JAIL")) {
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is visiting " + specialCard.getName() + ".");
			} else {
				System.out.println("You're visiting " + specialCard.getName() + ".");
			}
		} else {
			if (whosTurn.isBot()) {
				System.out.println("Player " + whosTurn.getName() + "(ID:" + whosTurn.getId() + ") is standing at " + specialCard.getName() + ".");
			} else {
				System.out.println("You're standing at " + specialCard.getName() + ".");
			}
		}
		cr.executeCommand(whosTurn, specialCard.getCommand(), specialCard.getId());
	}
	
	
	// EXPERIMENTAL
	private static void chooseAction(Class positionClass, Player whosTurn, int position, int rolled) {		
		switch(positionClass.getSimpleName()) {
		case "Property":
			actOnProperty(whosTurn, position, rolled, false);
			break;
		case "City":
			actOnCity(whosTurn, position);
			break;
		case "Tax":
			actOnTax(whosTurn, position);
			break;
		case "SpecialCard":
			int beginningPosition = whosTurn.getPosition();
			actOnSpecialCard(whosTurn, position);
			
			// Check if the card at the tail of the deck has a command "Go Closest Utility/Railroad"
			// Get the static card (either CHANCE or COMMUNITY CHEST)
			boolean movedWithCardMovingToNearestUtilityOrRailroad = false;
			SpecialCard specialCard = BoardSystem.getSpecialCardWithBoardPosition(position);
			
			if (specialCard.getCardSetType().equals(CardSetType.CHANCE)) {
				DrawableCard lastCardInDeque = BoardSystem.getChanceCards().peekLast();
				if (lastCardInDeque != null) {
					if (lastCardInDeque.getCommand().startsWith("Go Closest")) {
						movedWithCardMovingToNearestUtilityOrRailroad = true;
					}
				}
			} else if (specialCard.getCardSetType().equals(CardSetType.COMMUNITY_CHEST)) {
				DrawableCard lastCardInDeque = BoardSystem.getCommunityChestCards().peekLast();
				if (lastCardInDeque != null) {
					if (lastCardInDeque.getCommand().startsWith("Go Closest")) {
						movedWithCardMovingToNearestUtilityOrRailroad = true;
					}
				}
			}
			
			// If position changed; 
			if (beginningPosition != whosTurn.getPosition() && !whosTurn.isImprisoned()) {
				int newPos = whosTurn.getPosition();
				positionClass = BoardSystem.getStaticCardClass(newPos);
				String cardName = positionClass.getSimpleName();
				if (cardName.equals("Property")) {
					actOnProperty(whosTurn, newPos, rolled, movedWithCardMovingToNearestUtilityOrRailroad);
				} else if (cardName.equals("City")) {
					actOnCity(whosTurn, newPos);
				} else if (cardName.equals("Tax")) {
					actOnTax(whosTurn, newPos);
				} else if (cardName.equals("SpecialCard")) {
					chooseAction(positionClass, whosTurn, newPos, rolled);
				}
			}
			break;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		init();
		initializePlayers();
		System.out.println("Succesfully configured the board. \n");
		start();
	}
}
