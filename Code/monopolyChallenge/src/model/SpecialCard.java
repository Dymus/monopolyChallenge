/**
 * > GO
 * > JAIL
 * > GO TO JAIL
 * > FREE PARKING
 */
package model;

public class SpecialCard extends StaticCard {
	private String command;
	
	public SpecialCard(int id, String name, String command) {
		super(id, name);
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
}
