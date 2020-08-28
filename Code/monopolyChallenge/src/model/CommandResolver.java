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
				if (tokens.length > 2) {
					getMoneyFromPlayers(drawer, value, drawableCardID);
				} else {
					receiveMoney(drawer, value);
				}
			}
			break;
		case "PAY":
			if(Character.isDigit(tokens[1].charAt(0))) {
				Integer value = Integer.parseInt(tokens[1]);
				if (tokens.length > 2) {
					if (tokens[2].equals("ALL")) {
						giveAllMoneyFromPlayer(drawer, value, drawableCardID);
					}
				} else {
					if (drawer.getMoney() >= value) {
						drawer.setMoney(drawer.getMoney() - value);
					} else {
						if (drawer.isBot()) {
							System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") has drawn card with ID " + drawableCardID + ", but does not have sufficient funds to pay the bank.");
						} else {
							// TODO No money
							System.out.println("You have drawn card with ID " + drawableCardID + ", but don't have sufficient funds to pay the bank.");
						}
					}
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
					System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") drew the following chance card: " + card.getText());
				} else {
					System.out.println("You drew the following chance card: " + card.getText());
				}
				
				executeCommand(drawer, card.getCommand(), card.getId());
				
				if (card.getCommand().equals("Keep Jail Free")) {
					drawer.pushGetOutOfJailCard(card);
				} else {
					BoardSystem.returnChanceCard(card);
				}
			} else if (tokens[1].equals("COMMUNITY")) {
				DrawableCard card = BoardSystem.drawCommunityChestCard();
				
				if (drawer.isBot()) {
					System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") drew the following community chest card: " + card.getText());
				} else {
					System.out.println("You drew the following community chest card: " + card.getText());
				}
		
				executeCommand(drawer, card.getCommand(), card.getId());
				
				if (card.getCommand().equals("Keep Jail Free")) {
					drawer.pushGetOutOfJailCard(card);
				} else {
					BoardSystem.returnCommunityChestCard(card);
				}
			}
			break;
		case "GO":
			token1 = tokens[1];
			if (tokens[1].equals("ID")) {
				int desiredPosition = Integer.parseInt(tokens[2]);
				int oldPosition = drawer.getPosition();
				int placesToMove;
				
				if (desiredPosition < oldPosition) {
					placesToMove = desiredPosition - oldPosition + BoardSystem.getStaticCards().size();
				} else {
					placesToMove = desiredPosition - oldPosition;
				}

				int newPosition = BoardSystem.movePlayer(drawer, placesToMove);
				String newPositionName = BoardSystem.getStaticCardName(newPosition);
				
				if (drawer.isBot()) {
					System.out.println("Player " + drawer.getName() + "(ID:" + BoardSystem.getWhosTurn().getId() + ") moved to position: " + newPositionName);
				} else {
					System.out.println("You moved to position: " + newPositionName);
				}
			} else if (tokens[1].equals("CLOSEST")) {
				/* The moves are only assumed to be forward */
			
				if (tokens[2].equals("UTILITY")) {
					int currentPosition = drawer.getPosition();
					int desiredPosition = 1;
					
					// Setting utility position that player should move to
					if (currentPosition == 3 || currentPosition == 8 || currentPosition == 34  || currentPosition == 37) {
						desiredPosition = 13;
					} else if (currentPosition == 18 || currentPosition == 23) {
						desiredPosition = 29;
					}
					
					// Calculating places to move
					int placesToMove;
					if (desiredPosition < currentPosition) {
						placesToMove = desiredPosition - currentPosition + BoardSystem.getStaticCards().size();
					} else {
						placesToMove = desiredPosition - currentPosition;
					}
					
					// Moving player
					int newPosition = BoardSystem.movePlayer(drawer, placesToMove);
					String newPositionName = BoardSystem.getStaticCardName(newPosition);
					
					if (drawer.isBot()) {
						System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") moved to position: " + newPositionName);
					} else {
						System.out.println("You moved to position: " + newPositionName);
					}					
				} else if (tokens[2].equals("RAILROAD")) {
					int currentPosition = drawer.getPosition();
					int desiredPosition = 1;
					
					// Setting railroad position that player should move to
					if (currentPosition == 3 || currentPosition == 37) {
						desiredPosition = 6;
					} else if (currentPosition == 8) {
						desiredPosition = 16;
					} else if (currentPosition == 18 || currentPosition == 23) {
						desiredPosition = 26;
					} else if (currentPosition == 34) {
						desiredPosition = 36;
					}
					
					// Calculating places to move
					int placesToMove;
					if (desiredPosition < currentPosition) {
						placesToMove = desiredPosition - currentPosition + BoardSystem.getStaticCards().size();
					} else {
						placesToMove = desiredPosition - currentPosition;
					}
					
					// Moving player
					int newPosition = BoardSystem.movePlayer(drawer, placesToMove);
					String newPositionName = BoardSystem.getStaticCardName(newPosition);
					
					if (drawer.isBot()) {
						System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") moved to position: " + newPositionName);
					} else {
						System.out.println("You moved to position: " + newPositionName);
					}
				}
			} else if (Character.isDigit(tokens[1].charAt(1))) { 
				Integer places = Integer.parseInt(tokens[1]);
				
				// Changing player's position
				// TODO account for pos > 40 and pos < 1
				drawer.setPosition(drawer.getPosition() + places);

				// Getting new position name
				int newPosition = drawer.getPosition();
				String newPositionName = BoardSystem.getStaticCardName(newPosition);
				
				if (drawer.isBot()) {
					System.out.println("Player " + drawer.getName() + "(ID:" + drawer.getId() + ") moved to position: " + newPositionName);
				} else {
					System.out.println("You moved to position: " + newPositionName);
				}
			} else if (tokens[1].equals("JAIL")) {
				drawer.setImprisoned(true);
				drawer.setBannedTurns(3);
				Die.setRolledDouble(false);
				Die.resetTimesRolledDouble();
				
				if (drawer.isBot()) {
					System.out.println("Player " + drawer.getName() + "(ID:" + BoardSystem.getWhosTurn().getId() + ") went to JAIL");
				} else {
					System.out.println("You went to JAIL");
				}
			}
			break;
		case "NO":
			token1 = tokens[1];
			if (tokens[1].equals("ACTION")) {
				
			}
			break;
		case "KEEP":
			if (drawer.isBot()) {
				System.out.println("Player " + drawer.getName() + "(ID:" + BoardSystem.getWhosTurn().getId() + ") received a \"Get Out Of Jail For Free\" card.");
			} else {
				System.out.println("You received a \"Get Out Of Jail For Free\" card. You can use it to break free the next time you are sent to JAIL");
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

		// Need to remove the player who is paying from the ArrayList
		activePlayers.remove(player);
		
		// Calculate player funds needed
		int moneyNeeded = (amountOfActivePlayers - 1) * value;
				
		if (player.getMoney() >= moneyNeeded) {
			player.setMoney(player.getMoney()-value);
			for (Player activePlayer : activePlayers) {
				activePlayer.setMoney(activePlayer.getMoney()+value);
			}
			if (player.isBot()) {
				System.out.println("Player " + player.getName() + "(ID:" + player.getId() + ") has drawn card with ID " + drawableCardID + ". Every player received " + value + " dollars");
			} else {
				System.out.println("You have drawn a card with ID " + drawableCardID + ". You have given " + value + " dollars to every player.");
			}
			
		} else {
			// TODO No money
			if (player.isBot()) {
				System.err.println("Player " + player.getName() + "(ID:" + player.getId() + ") has drawn card with ID " + drawableCardID + " but does not have sufficient funds to complete the transaction.");
			} else {
				System.out.println("You have drawn a card with ID " + drawableCardID + " but do not have sufficient funds to complete the transaction.");
			}
			
		}
		
		// Adding the player who is paying back to the ArrayList
		activePlayers.add(player);
	}
	
	public void getMoneyFromPlayers(Player player, Integer value, Integer drawableCardID) {
		// Getting active players
		ArrayList<Player> activePlayers = BoardSystem.getActivePlayers();
		
		// Need to remove the player who is getting the money from the ArrayList
		activePlayers.remove(player);
		
		// Calculate the money player will get
		int moneyReceived = 0;
		
		for (Player activePlayer: activePlayers) {
			if (activePlayer.getMoney() >= value) {
				activePlayer.setMoney(activePlayer.getMoney()-value);
				moneyReceived += value;
				System.out.println("+" + value + " dollars from player " + activePlayer.getName() + "(ID:" + activePlayer.getId() +").");
			} else {
				// TODO no money
				System.out.println("Player " + activePlayer.getName() + "(ID:" + activePlayer.getId() +") didn't have enough money to pay player " + player.getName() + "(ID:" + player.getId() +").");
			}
		}
		
		if (player.isBot()) {
			System.out.println("Player " + player.getName() + "(ID:" + player.getId() + ") has received " + moneyReceived + " dollars total from other players");
		} else {
			System.out.println("You have received " + moneyReceived + " dollars total from other players");
		}
		
		// Adding the player who is getting money back to the ArrayList
		activePlayers.add(player);
	}
}
