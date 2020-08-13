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
	private int houses = 0;
	private int hotels = 0;
	
	public City() {
		
	}
	
	public City(String name, int boardPosition, CardSetType cardSetType, int buyCost, boolean owned, int rent, int with1House, int with2Houses, int with3Houses, int with4Houses,
			int withHotel, int mortgageValue, int houseCost, int hotelCost) {
		super(name, boardPosition, cardSetType, buyCost, owned);
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

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public int getHotels() {
		return hotels;
	}

	public void setHotels(int hotels) {
		this.hotels = hotels;
	}
	
	public boolean isUnimproved() {
		if (houses == 0 && hotels == 0) {
			return true;
		} else {
			return false;
		}
	}
}
