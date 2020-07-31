package model;

public class DrawableCard extends Card {
	private String text;
	private String command;
	private DrawableType type;
	
	public DrawableCard(String text, String command) {
		this.text = text;
		this.command = command;
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

	
}
