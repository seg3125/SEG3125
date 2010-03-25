import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Trivia extends MiniGame{
	JPanel gamePanel;
	GameBoard game;
	LinkedList<Question> questions;
	Countdown cd;
	Question thisQuestion;
	
	public Trivia(final GameBoard game){
		this.game = game;
		this.gameName = "Trivia";
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(GameBoard.MINIGAME_COLOR);
		
		reply = new JLabel();
		reply.setFont(GameBoard.HEADER_FONT);
		reply.setForeground(GameBoard.BACKGROUND_COLOR);
		reply.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 20));
		
    	ready = new JButton();
		ready.setPreferredSize(GameBoard.ANSWER_BUTTON_SIZE);
		ready.setBackground(GameBoard.ANSWER_BUTTON_BACK_COLOR);
		ready.setForeground(GameBoard.ANSWER_BUTTON_FORE_COLOR);
		ready.setFont(GameBoard.ANSWER_BUTTON_FONT);
		
		questions = new LinkedList<Question>();
		createQuestions();	
		
		showTriviaIntro();		
	}
	
	public JPanel getPanel(){
		return this.gamePanel;
	}	
	
	public void createQuestions(){
		// This ought to be done in XML or summat, and only once.
		Question a = new Question("Multiple Choice", "<html>What kind of tree is this?</html>", "Abies fraseri", "Abies flinckii", "Abies fraseri", "Abies balsamea", new ImageIcon("images/firtree.jpg"));
		Question b = new Question("Multiple Choice", "<html>Hexidecimal notation #FF0000 corresponds to what colour?</html>", "Red", "Green", "Blue", "Red", new ImageIcon("images/questionmark.png"));
		Question c = new Question("Multiple Choice", "<html>What is the registration number of the original Starship Enterprise?</html>", "NCC 1701", "NCC 1701", "USS 1701-A", "HMS 4511", new ImageIcon("images/enterprise.jpg"));
		Question d = new Question("Multiple Choice", "<html>In what year was the Beatles' <i>White Album</i> released?</html>", "1968", "1967", "1968", "1969", new ImageIcon("images/whitealbum.jpg"));
		Question e = new Question("Multiple Choice", "<html>P = NP?</html>", "Unknown", "True", "False", "Unknown", new ImageIcon("images/questionmark.png"));
		Question f = new Question("Multiple Choice", "<html>Who wrote \"If you have built castles in the air, your work need not be lost; that is where they should be. Now put the foundations under them.\"</html>", "Thoreau", "Rousseau", "Locke", "Thoreau", new ImageIcon("images/questionmark.png"));
		Question g = new Question("Multiple Choice", "<html>How many U's are there in the board game <i>Scrabble</i>?</html>", "4", "4", "5", "6", new ImageIcon("images/questionmark.png"));
		Question h = new Question("Multiple Choice", "<html>How may bones does a typical adult human have?</html>", "206", "204", "205", "206", new ImageIcon("images/skeleton.gif"));
		
		questions.add(a);
		questions.add(b);
		questions.add(c);
		questions.add(d);
		questions.add(e);
		questions.add(f);
		questions.add(g);
		questions.add(h);
	}
	
	public void showTriviaIntro(){
		gamePanel.setLayout(new BorderLayout());
		
		JLabel intro = new JLabel();
		String message = "<html>Are you ready for... TRIVIA?";
		message += "<br /><br />Game Info:";
		message += "<br /><br />Be warned: the game will start as soon as you click the \"Start Game\" button!</html>";
		intro.setText(message);
		intro.setOpaque(false);
		intro.setFont(GameBoard.ANSWER_BUTTON_FONT);
		intro.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 25));
		
		JButton ready = new JButton("Start Game");
		ready.setPreferredSize(GameBoard.ANSWER_BUTTON_SIZE);
		ready.setBackground(GameBoard.ANSWER_BUTTON_BACK_COLOR);
		ready.setForeground(GameBoard.ANSWER_BUTTON_FORE_COLOR);
		ready.setFont(GameBoard.ANSWER_BUTTON_FONT);
		ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishIntro(evt);
            }
        });
		
		gamePanel.add(intro);
		gamePanel.add(BorderLayout.SOUTH, ready);
		gamePanel.revalidate();
	}
	
	public void startGame(){	
		gamePanel.setLayout(new GridLayout(2, 2, 10, 10));	
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(GameBoard.MINIGAME_COLOR);
		gamePanel.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 10));
		
		Random r = new Random();
		int thisQ = r.nextInt(questions.size()-1);
		thisQuestion = questions.get(thisQ);
		
		cd = new Countdown(this, gamePanel, game, 150);
		
		gamePanel.add(thisQuestion.image);
		gamePanel.add(thisQuestion.question);
		JPanel answersPanel = new JPanel();
		answersPanel.setOpaque(false);
		answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
		for(int i = 0; i < thisQuestion.answers.length; i++){
			answersPanel.add(thisQuestion.answers[i]);
			answersPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			thisQuestion.answers[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                checkAnswer(evt);
	            }
	        });
		}
		gamePanel.add(answersPanel);
		gamePanel.add(cd.toJLabel("30"));
		
		cd.countdown();
	}
	
	public void finishIntro(ActionEvent event){
		gamePanel.removeAll();
		gamePanel.validate();
		gamePanel.revalidate();
		startGame();
	}
	
    private void checkAnswer(ActionEvent event) {
        cd.stopCountdown();  
        cd.resetTimer();
		
		if(event.getActionCommand().equals(thisQuestion.correctAnswer)){
			gamePanel.setLayout(new BorderLayout());
			gamePanel.removeAll();
			gamePanel.revalidate();	
			
    		reply.setText("<html>That's correct!</html");
    		ready.setText("Continue ->");
    		game.history.addEvent("\n" + game.getTeam(game.whichTurn).teamName + " won Trivia mini-game!");
    		gamePanel.add(reply);
    		gamePanel.add(BorderLayout.SOUTH, ready);
    		ready.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    game.hideMiniGame();
                }
            });
        	gamePanel.revalidate();
    	} else {
    		loseMiniGame(gameName, game, gamePanel, "That's the wrong answer!");
    	}  
    }
    
    public void removeTimeNumber(){
        gamePanel.remove(3);
    }

}
