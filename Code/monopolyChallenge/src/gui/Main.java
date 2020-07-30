package gui;

import model.City;
import model.ColorGroup;
import model.Property;
import model.SpecialCard;
import model.Tax;

public class Main {
	public static void main(String[] args) {
		System.out.print("Hello World!");
	}
	
	private void init() {
		ColorGroup brown = new ColorGroup("Brown");
		ColorGroup lightBlue = new ColorGroup("Light Blue");
		ColorGroup pink = new ColorGroup("Pink");
		ColorGroup orange = new ColorGroup("Orange");
		ColorGroup red = new ColorGroup("Red");
		ColorGroup yellow = new ColorGroup("Yellow");
		ColorGroup green = new ColorGroup("Green");
		ColorGroup darkBlue = new ColorGroup("Dark Blue");
		ColorGroup stations = new ColorGroup("Stations");
		ColorGroup utilities = new ColorGroup("Utilities");		

		SpecialCard cid1 = new SpecialCard("Go".toUpperCase(), 1, "Collect salary");
		
		// Brown
		City cid2 = new City("Mediterranean Avenue".toUpperCase(), 2, 60, false, 2, 10, 30, 90, 160, 250, 30, 50, 50);
		SpecialCard cid3 = new SpecialCard("Community Chest 1".toUpperCase(), 3, "Draw community chest");
		City cid4 = new City("Baltic Avenue".toUpperCase(), 4, 60, false, 4, 20, 60, 180, 320, 450, 30, 50, 50);
		Tax cid5 = new Tax("Income Tax".toUpperCase(), 5, 200);
		Property cid6 = new Property("Reading Railroad".toUpperCase(), 6, 200, false); // Station
		
		// Light Blue
		City cid7 = new City("Oriental Avenue".toUpperCase(), 7, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		SpecialCard cid8 = new SpecialCard("Chance Pink".toUpperCase(), 8, "Draw chance");
		City cid9 = new City("Vermont Avenue".toUpperCase(), 9, 100, false, 6, 30, 90, 270, 400, 550, 50, 50, 50);
		City cid10 = new City("Connecticut Avenue".toUpperCase(), 10, 120, false, 8, 40, 100, 300, 450, 600, 60, 50, 50);
		SpecialCard cid11 = new SpecialCard("Jail".toUpperCase(), 11, "No action");
		
		// Pink
		City cid12 = new City("St.Charles Place".toUpperCase(), 12, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		Property cid13 = new Property("Electric Company".toUpperCase(), 13, 150, false); // Utility
		City cid14 = new City("States Avenue".toUpperCase(), 14, 140, false, 10, 50, 150, 450, 625, 750, 70, 100, 100);
		City cid15 = new City("Virginia Avenue".toUpperCase(), 15, 160, false, 12, 60, 180, 500, 700, 900, 80, 100, 100);
		Property cid16 = new Property("Pennsylvania Railroad".toUpperCase(), 16, 200, false); // Station
		
		// Orange
		City cid17 = new City("St. James Place".toUpperCase(), 17, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		SpecialCard cid18 = new SpecialCard("Community Chest 2".toUpperCase(), 18, "Draw community chest");
		City cid19 = new City("Tennessee Avenue".toUpperCase(), 19, 180, false, 14, 70, 200, 550, 750, 950, 90, 100, 100);
		City cid20 = new City("New York Avenue".toUpperCase(), 20, 200, false, 16, 80, 220, 600, 800, 1000, 100, 100, 100);
		SpecialCard cid21 = new SpecialCard("Free Parking".toUpperCase(), 21, "No action");
		
		// Red
		City cid22 = new City("Kentucky Avenue".toUpperCase(), 22, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		SpecialCard cid23 = new SpecialCard("Chance Blue".toUpperCase(), 23, "Draw chance");
		City cid24 = new City("Indiana Avenue".toUpperCase(), 24, 220, false, 18, 90, 250, 700, 875, 1050, 110, 150, 150);
		City cid25 = new City("Illinoi Avenue".toUpperCase(), 25, 240, false, 20, 100, 300, 750, 925, 1100, 120, 150, 150);
		Property cid26 = new Property("B. & O. Railroad".toUpperCase(), 26, 200, false); // Station
		
		// Yellow
		City cid27 = new City("Atlantic Avenue".toUpperCase(), 27, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		City cid28 = new City("Ventnor Avenue".toUpperCase(), 28, 260, false, 22, 110, 330, 800, 975, 1150, 130, 150, 150);
		Property cid29 = new Property("Water Works".toUpperCase(), 29, 150, false); // Utility
		City cid30 = new City("Marvin Gardens".toUpperCase(), 30, 280, false, 24, 120, 360, 850, 1025, 1200, 140, 150, 150);
		SpecialCard cid31 = new SpecialCard("Go To Jail".toUpperCase(), 31, "Go Jail");
		
		// Green
		City cid32 = new City("Pacific Avenue".toUpperCase(), 32, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		City cid33 = new City("North Carolina Avenue".toUpperCase(), 33, 300, false, 26, 130, 390, 900, 1100, 1275, 150, 200, 200);
		SpecialCard cid34 = new SpecialCard("Community Chest 3", 34, "Draw Community Chest");
		City cid35 = new City("Pennsylvania Avenue".toUpperCase(), 35, 320, false, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200);
		Property cid36 = new Property("Short Line".toUpperCase(), 36, 200, false); // Station
		SpecialCard cid37 = new SpecialCard("Chance Orange".toUpperCase(), 37, "Draw Chance");
		
		// Dark Blue
		City cid38 = new City("Park Place".toUpperCase(), 38, 350, false, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200);
		Tax cid39 = new Tax("Luxury Tax".toUpperCase(), 39, 100);
		City cid40 = new City("Boardwalk".toUpperCase(), 40, 400, false, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200);
		
	}
}
