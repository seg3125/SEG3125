import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Chat{
	JPanel chatPanel;
	
	public Chat(){	
		chatPanel = new JPanel();	
		chatPanel.setOpaque(false);
		chatPanel.setPreferredSize(GameBoard.chatPanelSize);
		chatPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
}
