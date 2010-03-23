import java.awt.*;

import javax.swing.*;

public class Question {
	JLabel question;
	String correctAnswer;
	JButton[] answers;
	String type;
	JLabel image;
	
	public Question(){
		this.question = new JLabel();
		this.correctAnswer = "";
		this.image = new JLabel(new ImageIcon());
	}
	
	public Question(String type, String q, String ca, String a, String b, String c, ImageIcon i){
		this.type = type;
		this.question = new JLabel(q, JLabel.CENTER);	
		this.question.setFont(new Font("Tahoma", 1, 20));
		this.correctAnswer = ca;
		
		this.answers = new JButton[3];
		answers[0] = new JButton(a);
		answers[1] = new JButton(b);
		answers[2] = new JButton(c);
		for(int n = 0; n < answers.length; n++){
			answers[n].setBackground(new Color(152, 0, 35));
			answers[n].setForeground(Color.WHITE);
			answers[n].setMaximumSize(GameBoard.ANSWER_BUTTON_SIZE);
	        answers[n].setFont(GameBoard.ANSWER_BUTTON_FONT);
	        answers[n].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	        answers[n].setActionCommand(answers[n].getText());
		}
		
		this.image = new JLabel(i);
	}

}
