package model;

public class Die {
	private static int firstRoll = 0;
	private static int secondRoll = 0;
	private static int result = 0;
	private static boolean rolledDouble = false;
	private static int timesRolledDouble = 0;
	
	public Die() {
		firstRoll = 0;
		secondRoll = 0;
		result = 0;
		rolledDouble = false;	
	}
	
	public static Integer rollTheDie() {
		Integer pips = (int)(Math.random() * (6 - 1 + 1) + 1);
		return pips;
	}
	
	public static void rollTheDice() {
		rolledDouble = false;
//		timesRolledDouble = 0;
		
		firstRoll = rollTheDie();
		secondRoll = rollTheDie();
		
		if (firstRoll == secondRoll) {
			setRolledDouble(true);
			setTimesRolledDouble(getTimesRolledDouble() + 1);
		} else {
			setRolledDouble(false);
			resetTimesRolledDouble();
		}
		
		setResult(firstRoll + secondRoll);
	}

	public static boolean isRolledDouble() {
		return rolledDouble;
	}

	public static void setRolledDouble(boolean rolledDouble) {
		Die.rolledDouble = rolledDouble;
	}

	public static int getFirstRoll() {
		return firstRoll;
	}
	
	public static int getSecondRoll() {
		return secondRoll;
	}	
	
	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		Die.result = result;
	}
	
	public static void resetTimesRolledDouble() {
		setTimesRolledDouble(0);
	}

	public static int getTimesRolledDouble() {
		return timesRolledDouble;
	}

	public static void setTimesRolledDouble(int timesRolledDouble) {
		Die.timesRolledDouble = timesRolledDouble;
	}
}
