package model;

import java.util.ArrayList;

public class BoardSystem {
	private int maxPlayers; // is it really needed?
//	private int amountOfInitialPlayers;
	private ArrayList<Player> activePlayers;

	public BoardSystem(int maxPlayers) {
		this.maxPlayers = maxPlayers;
//		this.amountOfInitialPlayers = amountOfInitialPlayers;
		this.activePlayers = new ArrayList<Player>();
	}
	
	public BoardSystem(int maxPlayers, ArrayList<Player> activePlayers) {
		this.maxPlayers = maxPlayers;
//		this.amountOfInitialPlayers = amountOfInitialPlayers;
		this.activePlayers = activePlayers;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
//	public int getAmountOfInitialPlayers() {
//		return amountOfInitialPlayers;
//	}
//	
//	public void setAmountOfInitialPlayers(int amountOfInitialPlayers) {
//		this.amountOfInitialPlayers = amountOfInitialPlayers;
//	}
//	
	public ArrayList<Player> getActivePlayers() {
		return activePlayers;
	}
	
	public void setActivePlayers(ArrayList<Player> activePlayers) {
		this.activePlayers = activePlayers;
	}
	
	public int getNumberOfActivePlayers() {
		return activePlayers.size();
	}
} 