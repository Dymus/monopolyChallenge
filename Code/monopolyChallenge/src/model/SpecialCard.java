/**
 * > GO
 * > JAIL
 * > GO TO JAIL
 * > FREE PARKING
 */
package model;

public class SpecialCard extends StaticCard {
	private String command;
	
	public SpecialCard() {
		
	}
	
	public SpecialCard(String name, int boardPosition, CardSetType cardSetType, String command) {
		super(name, boardPosition, cardSetType);
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
}
