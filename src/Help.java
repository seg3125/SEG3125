import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

public class Help implements ActionListener{
	JPanel helpPanel;
	JScrollPane scroll;
	JEditorPane text;
	JButton close;
	GameBoard game;
	
	public Help(GameBoard game){
		this.game = game;
		this.helpPanel = new JPanel();
		helpPanel.setOpaque(false);
		helpPanel.setBorder(BorderFactory.createLineBorder(GameBoard.BACKGROUND_COLOR, 20));
		
		this.text = new JEditorPane();
		text.setContentType("text/html;");
		text.setBackground(GameBoard.MINIGAME_COLOR);
		text.setEditable(false);
		text.setText(getHelpText());
		this.scroll = new JScrollPane(text);
		scroll.setPreferredSize(new Dimension(400, 400));
		text.select(0, 0);

		close = new JButton("Close");
		close.setBackground(new Color(204, 204, 204));
		close.setForeground(GameBoard.ANSWER_BUTTON_BACK_COLOR);
		close.addActionListener(this);
		
		JLabel label = new JLabel("Game Help");
		label.setFont(GameBoard.ANSWER_BUTTON_FONT);
		helpPanel.add(label);
		helpPanel.add(close);
		helpPanel.add(scroll);
	}
	
	public String getHelpText(){
		String toReturn = "";
		
		String lorem = getContents(new File("docs/helptext.txt"));	
		toReturn += lorem;
		
		return toReturn;
	}
	
	/*
	 * From http://www.javapractices.com/topic/TopicAction.do?Id=42
	 */
	static public String getContents(File aFile) {
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; //not declared within while loop
	        while (( line = input.readLine()) != null){
	          contents.append(line);
	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      //ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }
	
	public void actionPerformed(ActionEvent evt) {
		game.hideHelp();		
	}
}
