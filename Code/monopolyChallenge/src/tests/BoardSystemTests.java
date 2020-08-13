package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.BoardSystem;
import model.CardSetType;
import model.DrawableCard;
import model.Player;
import model.SpecialCard;
import model.StaticCard;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardSystemTests {
	private static Player testPlayer1;
	private static Player testPlayer2;
	private static Player testPlayer3;
	
	@BeforeEach
	public void prepareTestEnv() {		
		testPlayer1 = new Player("playerOne", 1500, true, 1, true);
		testPlayer2 = new Player("playerTwo", 1500, true, 1, true);
		testPlayer3 = new Player("playerThree", 1500, true, 1, true);
		
		BoardSystem.addNewPlayer(testPlayer1);
		BoardSystem.addNewPlayer(testPlayer2);
		BoardSystem.addNewPlayer(testPlayer3);
		
		
		SpecialCard cid1 = new SpecialCard("Go".toUpperCase(), 1, CardSetType.OTHER, "Collect salary");
		SpecialCard cid2 = new SpecialCard("Chance Pink".toUpperCase(), 2, CardSetType.OTHER, "Draw Chance");
		BoardSystem.addCard(cid1);
		BoardSystem.addCard(cid2);
	}
	
	@AfterEach
	public void resetTestEnv() {
		BoardSystem.setActivePlayers(new ArrayList<Player>());
		BoardSystem.setChanceCards(new ArrayDeque<DrawableCard>());
		BoardSystem.setStaticCards(new ArrayList<StaticCard>());
		BoardSystem.resetCounters();
	}
	
	@Test
	@Order(1)
	public void testPlayerMovingSimpleTest() {
		Player playerOne = BoardSystem.getPlayerWithID(1);
		System.out.println("Player's position: " + playerOne.getPosition());
		
		// Check for 10000 moves, each by 1 place
		for (int i = 0; i <= 9999; i++) {
			int randomPlaces = (int) ((Math.random() * 10) + 1);
			System.out.println("Moving by " + randomPlaces + " places.");
			BoardSystem.movePlayer(testPlayer1, randomPlaces);
			playerOne = BoardSystem.getPlayerWithID(1);
			int playerPosition = playerOne.getPosition();
			// DEBUG
			System.out.println("Player's position: " + playerPosition);
			assertTrue(2 >= playerPosition, "Error, player position is outside the bounds ()");
			assertTrue(1 <= playerPosition, "Error, player position kept increasing until it triggered int overflow");
		}
	}
	
	@Test
	@Order(2)
	public void testRollTheDice() {
		// Roll 10000 times
		Integer max = 12;
		Integer min = 2;
		for (int i = 0; i <= 9999; i++) {
			Integer pips = BoardSystem.rollTheDice();
			System.out.println("Rolled " + pips + ".");
			assertTrue(max >= pips, "Error, rolled pips are too high");
			assertTrue(min <= pips, "Error, rolled pips are too low");
		}
	}
	
	@Test
	@Order(3)
	public void testGetIDOfStartingPlayerByRandom() {
		// Draw random player 10000 times
		int activePlayersSize = BoardSystem.getNumberOfActivePlayers();
		assertEquals(activePlayersSize, 3);
		
		for (int i = 0; i <= 9999; i++) {
			int startingPlayerID = BoardSystem.getIDOfStartingPlayerByRandom();
			System.out.println("Random starting player ID is " + startingPlayerID + ".");
			// TODO change 3 and 1 when testing starts with full 40 cards
			assertTrue(3 >= startingPlayerID, "Error, random starting player ID is too high");
			assertTrue(1 <= startingPlayerID, "Error, random starting player ID is too low");
		}
	}
	
	@Test
	@Order(4)
	public void testNextTurn() {
		BoardSystem.nextTurn();
		
		// Test next turn 10000 times
		for (int i = 0; i <= 9999; i++) {
			Player currentTurnPlayer = BoardSystem.getWhosTurn();
			int currentTurnPlayerID = currentTurnPlayer.getId();
			String currentTurnPlayerName = currentTurnPlayer.getName();
			System.out.println("It's player " + currentTurnPlayerName + "'s (" + currentTurnPlayerID + ") turn.");
			System.out.println("Next turn");
			BoardSystem.nextTurn();
			
			Player nextTurnPlayer = BoardSystem.getWhosTurn();
			int nextTurnPlayerID = nextTurnPlayer.getId();
			String nextTurnPlayerName = nextTurnPlayer.getName();
			System.out.println("Now it's player " + nextTurnPlayerName + "'s (" + nextTurnPlayerID + ") turn.\n");
			
			// TODO make assertions that check for increasing numbers 
			// until goes to the max player, then go to first one
		}
	}
}
