import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroOutro{	  
    javax.swing.JPanel contentPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JButton joinButton;
    public GameBoard game;
    JoinGamePanel p;
    
    /** Creates new form IntroOutro */
    public IntroOutro(GameBoard game) {
         game.frame.getContentPane().setBackground(new Color(192, 244, 0));
         this.game = game;
         initComponents();
    }

    private void initComponents() {
        joinButton = new JButton();
        createButton = new JButton();
        
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(192, 244, 0));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        
        joinButton.setBackground(new Color(192, 244, 0));
        joinButton.setFont(new Font("Tahoma", 1, 14));
        joinButton.setText("Join Game");
        joinButton.setBorder(BorderFactory.createLineBorder(new Color(234, 0, 37), 2));
        
        createButton.setBackground(new java.awt.Color(192, 244, 0));
        createButton.setFont(new Font("Tahoma", 1, 14));
        createButton.setText("Create Game");
        createButton.setActionCommand("jButton1");
        createButton.setBorder(BorderFactory.createLineBorder(new Color(234, 0, 37), 2));

        contentPanel.add(createButton);
        contentPanel.add(joinButton);
    }
}
