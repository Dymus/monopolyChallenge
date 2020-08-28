package model;

public class DrawableCard extends Card {
	private String text;
	private String command;
	private DrawableType type;
	
	public DrawableCard() {
		
	}
	
	public DrawableCard(String text, String command, DrawableType type) {
		this.text = text;
		this.command = command;
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public DrawableType getType() {
		return type;
	}

	public void setType(DrawableType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[ID= " + String.valueOf(getId()) + ", Txt=" + text.substring(0, 10) + "]";
	}
	
}
