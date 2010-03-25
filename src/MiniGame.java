import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MiniGame {
	JLabel reply;
	JButton ready;
	GameBoard game;
	String gameName;
    
    public void loseMiniGame(String whichGame, final GameBoard game, JPanel gamePanel, String message){
    	this.game = game;
        gamePanel.removeAll();
        gamePanel.validate();
        gamePanel.revalidate();
    	gamePanel.setLayout(new BorderLayout());
		
    	reply.setText("<html>" + message + "</html>");
    	ready.setText("Continue ->");
		game.history.addEvent("\nTeam lost mini-game.");
		
		gamePanel.add(reply);
		
    	gamePanel.revalidate();
    }

    abstract void removeTimeNumber();
}
