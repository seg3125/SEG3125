import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Trivia{
	JPanel gamePanel;
	GameBoard game;
	LinkedList<Question> questions;
	
	public Trivia(GameBoard game){
		this.game = game;
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(2, 2));
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(Color.PINK.darker());
		
		questions = new LinkedList<Question>();
		createQuestions();	
		
		Random r = new Random();
		int thisQ = r.nextInt(questions.size());
		Question thisQuestion = questions.get(thisQ);
		
		gamePanel.add(new JLabel(thisQuestion.image));
		gamePanel.add(new JLabel(thisQuestion.question));
		gamePanel.add(new JLabel(thisQuestion.correctAnswer));
		gamePanel.add(new JLabel(thisQuestion.image));
	}
	
	public JPanel getPanel(){
		return this.gamePanel;
	}	
	
	public void createQuestions(){
		// This ought to be done in XML or summat, and only once.
		Question a = new Question("What kind of tree is this?", "Abies fraseri", "Abies flinckii", "Abies balsamea", new ImageIcon("images/firtree.jpg"));
		Question b = new Question("Hexidecimal notation #FF0000 corresponds to what colour?", "Red", "Green", "Blue", new ImageIcon("images/questionmark.png"));
		Question c = new Question("What is the registration number of the original Starship Enterprise?", "NCC 1701", "USS 1701-A", "HMS 4511", new ImageIcon("images/enterprise.jpg"));
		Question d = new Question("What kind of tree is this?", "Abies fraseri", "Abies flinckii", "Abies balsamea", new ImageIcon("images/firtree.jpg"));
		
		questions.add(a);
		questions.add(b);
		questions.add(c);
		questions.add(d);
	}

}
