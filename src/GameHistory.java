import java.awt.Color;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.text.Document;

public class GameHistory {
	JPanel historyPanel;
	GameBoard game;
	LinkedList<String> events;
	JTextArea eventDisplay;
	
	public GameHistory(GameBoard game){
		this.game = game;
		this.events = new LinkedList<String>();
		this.events.add("Game Started!");
		
		historyPanel = new JPanel();
		historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
		historyPanel.setPreferredSize(GameBoard.historyPanelSize);
		historyPanel.setOpaque(false);
		historyPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		final JLabel HISTORY = new JLabel("History of this game!");
		
		eventDisplay = new JTextArea(this.getLastEvent());	
		eventDisplay.setEditable(false);
		eventDisplay.setBackground(GameBoard.BACKGROUND_COLOR);
		JScrollPane scrollPane = new JScrollPane(eventDisplay);
		
		historyPanel.add(HISTORY);
		historyPanel.add(scrollPane);
	}
	
	public void addEvent(String event){
		this.events.add(event);
		eventDisplay.append(event);
		Document d = eventDisplay.getDocument();
		eventDisplay.select(d.getLength(), d.getLength());
	}
	
	public String getLastEvent(){
		return this.events.get(this.events.size()-1);
	}
}
