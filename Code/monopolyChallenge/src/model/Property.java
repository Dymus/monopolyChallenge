/**
 * Could be railroads 
 * or utilities
 */
package model;

public class Property extends StaticCard {
	private int buyCost;
	private boolean owned;
	
	public Property(int id, String name, int buyCost, boolean owned) {
		super(id, name);
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
}
