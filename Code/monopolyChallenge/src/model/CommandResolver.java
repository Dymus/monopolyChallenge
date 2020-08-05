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
		
		
		// Should this be done with complete recursion? switching token after token?
		switch(tokens[0]) {
		case "COLLECT":
		case "GET": 
		case "RECEIVE":
			if (Character.isDigit(tokens[1].charAt(0))) {
				Integer value = Integer.parseInt(tokens[1]);
				receiveMoney(drawer, value);
			}
			break;
		case "PAY":
			if(Character.isDigit(tokens[1].charAt(0))) {
				Integer value = Integer.parseInt(tokens[1]);
				if (tokens[2].equals("ALL")) {
					giveAllMoneyFromPlayer(drawer, value, drawableCardID);
				}
			}
			break;
		case "DRAW":
			String token1 = tokens[1];
//			// DEBUG
//			System.out.println("Printing token1: (" + token1 + ")");
			
			if (tokens[1].equals("CHANCE")) {
//				// DEBUG
//				System.out.println("Got here");
				DrawableCard card = BoardSystem.drawChanceCard();
				executeCommand(drawer, card.getCommand(), card.getId());
			} else if (tokens[1] == "COMMUNITY") {
//				DrawableCard card = BoardSystem.drawChanceCard();
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
			System.out.println("Player with ID "+player.getId()+ " has drawn card with ID " + drawableCardID + ". Every player received " + value + " dollars");
		} else {
			System.err.println("Player with ID "+player.getId()+ " has drawn card with ID " + drawableCardID + " but does not have sufficient funds to complete the transaction.");
		}
	}
}
