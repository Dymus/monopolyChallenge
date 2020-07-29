/**
 * rent with color set is always doubled
 */
package model;

public class City extends Property {
	private int rent;
	private int with1House;
	private int with2Houses;
	private int with3Houses;
	private int with4Houses;
	private int withHotel;
	private int mortgageValue;
	private int houseCost;
	private int hotelCost;
	
	public City(int id, String name, int buyCost, boolean owned, int rent, int with1House, int with2Houses, int with3Houses, int with4Houses,
			int withHotel, int mortgageValue, int houseCost, int hotelCost) {
		super(id, name, buyCost, owned);
		this.rent = rent;
		this.with1House = with1House;
		this.with2Houses = with2Houses;
		this.with3Houses = with3Houses;
		this.with4Houses = with4Houses;
		this.withHotel = withHotel;
		this.mortgageValue = mortgageValue;
		this.houseCost = houseCost;
		this.hotelCost = hotelCost;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public int getRentWith1House() {
		return with1House;
	}
	
	public void setWith1House(int rent) {
		with1House = rent;
	}
	
	public int getWith2Houses() {
		return with2Houses;
	}
	
	public void setWith2Houses(int rent) {
		with2Houses = rent;
	}
	
	public int getWith3Houses() {
		return with3Houses;
	}
	
	public void setWith3Houses(int rent) {
		with3Houses = rent;
	}
	
	public int getWith4Houses() {
		return with4Houses;
	}
	
	public void setWith4Houses(int rent) {
		with4Houses = rent;
	}
	
	public int getWithHotel() {
		return withHotel;
	}
	
	public void setWithHotel(int rent) {
		withHotel = rent;
	}
	
	public int getMortgageValue() {
		return mortgageValue;
	}
	
	public void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}
	
	public int getHouseCost() {
		return houseCost;
	}
	
	public void setHouseCost(int houseCost) { 
		this.houseCost = houseCost;
	}
	
	public int getHotelCost() {
		return hotelCost;
	}
	
	public void setHotelCost(int hotelCost) { 
		this.hotelCost = houseCost;
	}
}
