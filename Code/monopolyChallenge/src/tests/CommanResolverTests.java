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
import model.CommandResolver;
import model.DrawableCard;
import model.DrawableType;
import model.Player;
import model.SpecialCard;
import model.StaticCard;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommanResolverTests {
	private CommandResolver cr = new CommandResolver();
	private static Player testPlayer1;
	private static Player testPlayer2;
	private static Player testPlayer3;
	
	@BeforeEach
	public void prepareTestEnv() {		
		testPlayer1 = new Player("playerOne", 1500, true, 1);
		testPlayer2 = new Player("playerTwo", 1500, true, 1);
		testPlayer3 = new Player("playerThree", 1500, true, 1);
		
		BoardSystem.addNewPlayer(testPlayer1);
		BoardSystem.addNewPlayer(testPlayer2);
		BoardSystem.addNewPlayer(testPlayer3);
		
		
		SpecialCard cid1 = new SpecialCard("Go".toUpperCase(), 1, "Collect salary");
		SpecialCard cid2 = new SpecialCard("Chance Pink".toUpperCase(), 2, "Draw Chance");
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
	
//	private void setUpBoardOneToForty() {
//		
//	}
	
	@Test
	@Order(1)
	public void testDrawableCardPay50All() {
		DrawableCard cid3 = new DrawableCard("You have been elected Chairman of the Board – Pay each player $50", "Pay 50 All", DrawableType.CHANCE);
		BoardSystem.addChanceCard(cid3);
		int boardPosition = BoardSystem.movePlayer(testPlayer1, 1);
		SpecialCard card = BoardSystem.getCardWithID(boardPosition);
		cr.executeCommand(testPlayer1, card.getCommand(), card.getId());
		Player playerTwo = BoardSystem.getPlayerWithID(2);
		assertEquals(playerTwo.getMoney(), 1550);
	}

}
