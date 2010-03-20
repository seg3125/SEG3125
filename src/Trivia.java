import java.awt.Color;

import javax.swing.JPanel;

public class Trivia{
	JPanel gamePanel;
	GameBoard game;
	
	public Trivia(GameBoard game){
		this.game = game;
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(Color.BLUE);
	}
	
	public JPanel getPanel(){
		return this.gamePanel;
	}

}
