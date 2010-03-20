import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Control implements ActionListener{
	JPanel controlPanel;
	JButton dice;
	JButton currRoll;
	GameBoard game;
	
	public Control(GameBoard game) throws Exception{
		this.game = game;
		controlPanel = new JPanel();
		controlPanel.setOpaque(false);
		controlPanel.setPreferredSize(GameBoard.controlPanelSize);
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		dice = new JButton("Dice");
		dice.addActionListener(this);
		
		currRoll = new JButton("Nil");
		
		controlPanel.add(dice);
		controlPanel.add(currRoll);
	}
	
	public void actionPerformed(ActionEvent event){
		Random randomGenerator = new Random();
	    int rand = randomGenerator.nextInt(5) + 1;
	    try{
	    	game.updateGameBoard(rand);
	    } catch (Exception ex){
	    	
	    }
	    
		//dice.setText(Integer.toString(rand));
	}
	
}
