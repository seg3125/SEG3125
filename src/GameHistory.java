import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GameHistory {
	JPanel historyPanel;
	GameBoard game;
	
	public GameHistory(GameBoard game){
		this.game = game;
		historyPanel = new JPanel();
		historyPanel.setPreferredSize(game.historyPanelSize);
		historyPanel.setOpaque(false);
		historyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
