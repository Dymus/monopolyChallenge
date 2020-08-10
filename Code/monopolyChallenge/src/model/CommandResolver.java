package model;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandResolver {
	public void executeCommand(Player drawer, String command, Integer drawableCardID) {
		// Tokenizing command
		String[] tokens = command.split(" ");
		
		// Capitalizing every token
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = tokens[i].toUpperCase();
		}

//		// DEBUG 
//		System.out.println("Printing first token : " + tokens[0]);
		
		String token1;
		String token2;
		String token3;
		// Should this be done with complete recursion? switching token after token?
		switch(tokens[0]) {
		case "COLLECT":
		case "GET": 
		case "RECEIVE":
		case "INHERIT":
			if (Character.isDigit(tokens[1].charAt(0))) {
				Integer value = Integer.parseInt(tokens[1]);
				receiveMoney(drawer, value);
			}
			break;
		case "PAY":
			if(Character.isDigit(tokens[1].charAt(0))) {
				Integer value = Integer.parseInt(tokens[1]);
				if (2 < tokens.length) {
					if (tokens[2].equals("ALL")) {
						giveAllMoneyFromPlayer(drawer, value, drawableCardID);
					}
				} else {
					drawer.setMoney(drawer.getMoney() - value);
				}
			} else {
				// ERROR
			}
			break;
		case "DRAW":
			token1 = tokens[1];
			
			if (tokens[1].equals("CHANCE")) {
				DrawableCard card = BoardSystem.drawChanceCard();

				if (drawer.isBot()) {
					System.out.println("Player " + BoardSystem.getWhosTurn().getName() + " drew the following chance card: " + card.getText());
				} else {
					System.out.println("You drew the following chance card: " + card.getText());
				}
				
				executeCommand(drawer, card.getCommand(), card.getId());
			} else if (tokens[1].equals("COMMUNITY")) {
				DrawableCard card = BoardSystem.drawCommunityChestCard();
				
				if (drawer.isBot()) {
					System.out.println("Player " + BoardSystem.getWhosTurn().getName() + " drew the following community chest card: " + card.getText());
				} else {
					System.out.println("You drew the following community chest card: " + card.getText());
				}
		
				executeCommand(drawer, card.getCommand(), card.getId());
			}
			break;
		case "GO":
			token1 = tokens[1];
			if (tokens[1].equals("ID")) {
				int desiredPosition = Integer.parseInt(tokens[2]);
				int oldPosition = drawer.getPosition();
				int placesToMove;
				
				// TODO debug
				if (desiredPosition < oldPosition) {
					placesToMove = BoardSystem.getStaticCards().size() % Math.abs(desiredPosition - oldPosition);
				} else {
					
					placesToMove = desiredPosition - oldPosition;
				}

				int newPosition = BoardSystem.movePlayer(drawer, placesToMove);
				String newPositionName = BoardSystem.getStaticCardName(newPosition);
				
				if (drawer.isBot()) {
					System.out.println("Player " + BoardSystem.getWhosTurn().getName() + " moved to position: " + newPositionName);
				} else {
					System.out.println("You moved to position: " + newPositionName);
				}
			} else if (tokens[1].equals("JAIL")) {
				
			}
			break;
		case "NO":
			token1 = tokens[1];
			if (tokens[1].equals("ACTION")) {
				
			}
			break;
		default:
			System.err.println("Ran into unknown problem!");
		}
	}
	
	public void receiveMoney(Player player, Integer value) {
		player.setMoney(player.getMoney()+value);
	}
	
	public void giveAllMoneyFromPlayer(Player player, Integer value, Integer drawableCardID) {
		// Getting active players
		ArrayList<Player> activePlayers = BoardSystem.getActivePlayers();
		int amountOfActivePlayers = activePlayers.size();
		
		// Need to remove the player who is paying from the arrayList
		activePlayers.remove(player);
		
		// Calculate player funds needed
		int moneyNeeded = amountOfActivePlayers * value;
				
		if (player.getMoney() >= moneyNeeded) {
			player.setMoney(player.getMoney()-value);
			for (Player activePlayer : activePlayers) {
				activePlayer.setMoney(activePlayer.getMoney()+value);
			}
			System.out.println("Player with ID " + player.getId() + " has drawn card with ID " + drawableCardID + ". Every player received " + value + " dollars");
		} else {
			System.err.println("Player with ID " + player.getId() + " has drawn card with ID " + drawableCardID + " but does not have sufficient funds to complete the transaction.");
		}
	}
}
