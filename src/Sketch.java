import java.awt.Color;

import javax.swing.JPanel;

public class Sketch{
	JPanel gamePanel;
	GameBoard game;
	
	public Sketch(GameBoard game){
		this.game = game;
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(Color.RED);
	}
	
	public JPanel getPanel(){
		return this.gamePanel;
	}
	
}
