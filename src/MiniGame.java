import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MiniGame {
	JLabel reply;
	JButton ready;
	GameBoard game;
	String gameName;
    
    public void loseMiniGame(final String whichGame, final GameBoard game, JPanel gamePanel, String message){
    	this.game = game;
    	gamePanel.setLayout(new BorderLayout());
		gamePanel.removeAll();
		gamePanel.revalidate();	
		
    	reply.setText("<html>" + message + "</html>");
    	ready.setText("Try again?");
		game.history.addEvent("\nTeam lost mini-game.");
		ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                game.hideMiniGame();
                game.displayMiniGame(whichGame);
            }
        });
		
		gamePanel.add(reply);
		gamePanel.add(BorderLayout.SOUTH, ready);
		
    	gamePanel.revalidate();
    }
}
