package gui;

import java.util.ArrayDeque;
import java.util.Deque;

import model.BoardSystem;
import model.City;
import model.ColorGroup;
import model.DrawableCard;
import model.DrawableType;
import model.Player;
import model.Property;
import model.SpecialCard;
import model.Tax;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		init();
		System.out.println("Succesfully configured the board.");
		
		// Test playing
		Player p1 = new Player("David", 1500, true, 1);
		Player p2 = new Player("Craig", 1500, true, 1);
		Player p3 = new Player("Jake", 1500, true, 1);
		Player p4 = new Player("Jonah", 1500, true, 1);
		
		// Adding 4 players
		
		BoardSystem.addNewPlayer(p1);
		BoardSystem.addNewPlayer(p2);
		BoardSystem.addNewPlayer(p3);
		BoardSystem.addNewPlayer(p4);
		
		int position = BoardSystem.movePlayer(p1, BoardSystem.rollTheDice());
		
	}
	
	private static void init() {
		ColorGroup<City> brown = new ColorGroup("Brown");
		ColorGroup<City> lightBlue = new ColorGroup("Light Blue");
		ColorGroup<City> pink = new ColorGroup("Pink");
		ColorGroup<City> orange = new ColorGroup("Orange");
		ColorGroup<City> red = new ColorGroup("Red");
		ColorGroup<City> yellow = new ColorGroup("Yellow");
		ColorGroup<City> green = new ColorGroup("Green");
		ColorGroup<City> darkBlue = new ColorGroup("Dark Blue");
		ColorGroup<Property> stations = new ColorGroup("Stations");
		ColorGroup<Property> utilities = new ColorGroup("Utilities");
		Deque<DrawableCard> communityChestCards = new ArrayDeque<DrawableCard>();
		Deque<DrawableCard> chanceCards = new ArrayDeque<DrawableCard>();

		SpecialCard cid1 = new SpecialCard("Go".toUpperCase(), 1, "Collect salary");
		
		// Brown
		City cid2 = new City("Mediterranean Avenue".toUpperCase(), 2, 60, false, 2, 10, 30, 90, 160, 250, 30, 50, 50);
		SpecialCard cid3 = new SpecialCard("Community Chest 1".toUpperCase(), 3, "Draw community chest");
		City cid4 = new City("Baltic Avenue".toUpperCase(), 4, 60, false, 4, 20, 60, 180, 320, 450, 30, 50, 50);
		Tax cid5 = new Tax("Income Tax".toUpperCase(), 5, 200);
		Property cid6 = new Property("Reading Railroad".toUpperCase(), 6, 200, false); // Station
		
		// Light Blue
		City cid7 = new City("Oriental Avenue".toUpperCase(), 7, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		SpecialCard cid8 = new SpecialCard("Chance Pink".toUpperCase(), 8, "Draw chance");
		City cid9 = new City("Vermont Avenue".toUpperCase(), 9, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		City cid10 = new City("Connecticut Avenue".toUpperCase(), 10, 120, false, 8, 40, 100, 300, 450, 600, 60, 50, 50);
		SpecialCard cid11 = new SpecialCard("Jail".toUpperCase(), 11, "No action");
		
		// Pink
		City cid12 = new City("St.Charles Place".toUpperCase(), 12, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		Property cid13 = new Property("Electric Company".toUpperCase(), 13, 150, false); // Utility
		City cid14 = new City("States Avenue".toUpperCase(), 14, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		City cid15 = new City("Virginia Avenue".toUpperCase(), 15, 160, false, 12, 60, 180, 500, 700, 900, 80, 100, 100);
		Property cid16 = new Property("Pennsylvania Railroad".toUpperCase(), 16, 200, false); // Station
		
		// Orange
		City cid17 = new City("St. James Place".toUpperCase(), 17, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		SpecialCard cid18 = new SpecialCard("Community Chest 2".toUpperCase(), 18, "Draw community chest");
		City cid19 = new City("Tennessee Avenue".toUpperCase(), 19, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		City cid20 = new City("New York Avenue".toUpperCase(), 20, 200, false, 16, 80, 220, 600, 800, 1000, 100, 100, 100);
		SpecialCard cid21 = new SpecialCard("Free Parking".toUpperCase(), 21, "No action");
		
		// Red
		City cid22 = new City("Kentucky Avenue".toUpperCase(), 22, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		SpecialCard cid23 = new SpecialCard("Chance Blue".toUpperCase(), 23, "Draw chance");
		City cid24 = new City("Indiana Avenue".toUpperCase(), 24, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		City cid25 = new City("Illinoi Avenue".toUpperCase(), 25, 240, false, 20, 100, 300, 750, 925, 1100, 120, 150, 150);
		Property cid26 = new Property("B. & O. Railroad".toUpperCase(), 26, 200, false); // Station
		
		// Yellow
		City cid27 = new City("Atlantic Avenue".toUpperCase(), 27, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		City cid28 = new City("Ventnor Avenue".toUpperCase(), 28, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		Property cid29 = new Property("Water Works".toUpperCase(), 29, 150, false); // Utility
		City cid30 = new City("Marvin Gardens".toUpperCase(), 30, 280, false, 24, 120, 360, 850, 1025, 1200, 140, 150, 150);
		SpecialCard cid31 = new SpecialCard("Go To Jail".toUpperCase(), 31, "Go Jail");
		
		// Green
		City cid32 = new City("Pacific Avenue".toUpperCase(), 32, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		City cid33 = new City("North Carolina Avenue".toUpperCase(), 33, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		SpecialCard cid34 = new SpecialCard("Community Chest 3", 34, "Draw Community Chest");
		City cid35 = new City("Pennsylvania Avenue".toUpperCase(), 35, 320, false, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200);
		Property cid36 = new Property("Short Line".toUpperCase(), 36, 200, false); // Station
		SpecialCard cid37 = new SpecialCard("Chance Orange".toUpperCase(), 37, "Draw Chance");
		
		// Dark Blue
		City cid38 = new City("Park Place".toUpperCase(), 38, 350, false, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200);
		Tax cid39 = new Tax("Luxury Tax".toUpperCase(), 39, 100);
		City cid40 = new City("Boardwalk".toUpperCase(), 40, 400, false, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200);

		// Community chest cards
		DrawableCard cid41 = new DrawableCard("Advance to Go (Collect $200)", "Collect 200", DrawableType.COMMUNITY_CHEST);
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
		stations.add(cid6, cid16, cid26, cid36);
		utilities.add(cid13, cid29);
		
		
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
		
		// Adding DrawableCards to decks
		BoardSystem.addCommunityChestCard(cid41);
		BoardSystem.addCommunityChestCard(cid42);
		BoardSystem.addCommunityChestCard(cid43);
		BoardSystem.addCommunityChestCard(cid44);
		BoardSystem.addCommunityChestCard(cid45);
		BoardSystem.addCommunityChestCard(cid46);
		BoardSystem.addCommunityChestCard(cid47);
		BoardSystem.addCommunityChestCard(cid48);
		BoardSystem.addCommunityChestCard(cid49);
		BoardSystem.addCommunityChestCard(cid50);
		BoardSystem.addCommunityChestCard(cid51);
		BoardSystem.addCommunityChestCard(cid52);
		BoardSystem.addCommunityChestCard(cid53);
		BoardSystem.addCommunityChestCard(cid54);
		BoardSystem.addCommunityChestCard(cid55);
		BoardSystem.addCommunityChestCard(cid56);
		BoardSystem.addCommunityChestCard(cid57);
		
		BoardSystem.addChanceCard(cid58);
		BoardSystem.addChanceCard(cid59);
		BoardSystem.addChanceCard(cid60);
		BoardSystem.addChanceCard(cid61);
		BoardSystem.addChanceCard(cid62);
		BoardSystem.addChanceCard(cid63);
		BoardSystem.addChanceCard(cid64);
		BoardSystem.addChanceCard(cid65);
		BoardSystem.addChanceCard(cid66);
		BoardSystem.addChanceCard(cid67);
		BoardSystem.addChanceCard(cid68);
		BoardSystem.addChanceCard(cid69);
		BoardSystem.addChanceCard(cid70);
		BoardSystem.addChanceCard(cid71);
		BoardSystem.addChanceCard(cid72);
		BoardSystem.addChanceCard(cid73);		
	}
}
