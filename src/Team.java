import javax.swing.*;

public class Team {
	String color;
	String teamName;
	String tokenLoc;
	ImageIcon token;
	int x_position;
	int y_position;
	int currSpot;
	
	public Team(String color, String teamName){
		this.color = color;
		this.teamName = teamName;
		tokenLoc = "images/token" + color + ".png";
		this.token = new ImageIcon(tokenLoc);
		this.x_position = 2;
		this.y_position = 2;
		this.currSpot = 0;
	}
	
	public int getX(){
		return this.x_position;
	}
	
	public int getY(){
		return this.y_position;
	}

}
