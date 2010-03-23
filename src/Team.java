import java.awt.Color;

import javax.swing.ImageIcon;

public class Team {
	Color color;
	ImageIcon token;
	int x_position;
	int y_position;
	int currSpot;
	
	public Team(){
		this.color = new Color(0, 0, 255);
		this.token = new ImageIcon("images/token.png");
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
