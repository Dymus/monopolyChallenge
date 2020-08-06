/**
 * Could be railroads 
 * or utilities
 */
package model;

public class Property extends StaticCard {
	private int buyCost;
	private boolean owned = false;
	private Player owner = (Player) null;
	
	public Property() {
		
	}
	
	public Property(String name, int boardPosition, int buyCost, boolean owned) {
		super(name, boardPosition);
		this.buyCost = buyCost;
		this.owned = owned;
	}
	
	public int getBuyCost() {
		return buyCost;
	}
	
	public void setBuyCost(int buyCost) {
		this.buyCost = buyCost;
	}
	
	public boolean isOwned() {
		return owned;
	}
	
	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
