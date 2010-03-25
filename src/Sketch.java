import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Sketch extends MiniGame{
        JPanel gamePanel;
	LinkedList<String> questions;
	Countdown cd;
        JPanel timePanel;
	String thisQuestion;
        
        Boolean isDrawing;
        Boolean isErasing;

        JPanel subGamePanel;
        //Panel in which drawing will occur
        DrawPanel sketchPanel;
        //Panel to house the drawing buttons
        JPanel buttonPanel;
        //Drawing buttons
        JButton draw;
        JButton erase;
        JButton newSheet;
        //Panel to display the game information (time, what to draw, etc.)
        JPanel infoPanel;
        JLabel thisToDraw;
        JLabel thingToDraw;
        JLabel timeLeft;
        Countdown time;


	public Sketch(final GameBoard game){
		this.game = game;
                this.gameName = "Sketch";

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

		questions = new LinkedList<String>();
		createQuestions();

		showTriviaIntro();
	}

	public JPanel getPanel(){
		return this.gamePanel;
	}

	public void createQuestions(){
		questions.add("House");
		questions.add("Car");
        questions.add("Snake");
        questions.add("Dog");
	}

	public void showTriviaIntro(){
		gamePanel.setLayout(new BorderLayout());
		JLabel intro = new JLabel();
		String message = "<html>Are you ready for... Sketchy?";
		message += "<br /><br />Game Info:";
		message += "<br /><br />Be warned: the game will start as soon as you click the \"Start Game\" button!</html>";
		intro.setText(message);
		intro.setOpaque(false);
		intro.setFont(GameBoard.ANSWER_BUTTON_FONT);
		intro.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 25));

                ready = new JButton("Start Game");
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

                //Top level Panel
		gamePanel.setLayout(new BorderLayout());
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setBackground(GameBoard.MINIGAME_COLOR);
		gamePanel.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 10));

                reply = new JLabel();
		reply.setFont(GameBoard.HEADER_FONT);
		reply.setForeground(GameBoard.BACKGROUND_COLOR);
		reply.setBorder(BorderFactory.createLineBorder(GameBoard.MINIGAME_COLOR, 20));

		Random r = new Random();
		int thisQ = r.nextInt(questions.size()-1);
		thisQuestion = questions.get(thisQ);

                subGamePanel = new javax.swing.JPanel();
                subGamePanel.setSize(new Dimension(500, 350));
                subGamePanel.setPreferredSize(new Dimension(500, 350));
                subGamePanel.setMaximumSize(new Dimension(500, 350));
                subGamePanel.setMinimumSize(new Dimension(500, 350));
                subGamePanel.setOpaque(false);
                GridBagLayout g2 = new GridBagLayout();
                subGamePanel.setLayout(g2);
                GridBagConstraints c2 = new GridBagConstraints();

                //drawning Panel
                sketchPanel = new DrawPanel();
                sketchPanel.setSize(new Dimension(350, 350));
                sketchPanel.setPreferredSize(new Dimension(350, 350));
                sketchPanel.setMaximumSize(new Dimension(350, 350));
                sketchPanel.setMinimumSize(new Dimension(350, 350));
                sketchPanel.setBackground(new java.awt.Color(255, 255, 255));

                //**************************************************************************************
                //Implementation of drawing
                //**************************************************************************************
                

                //**************************************************************************************

                //Button Panel
                buttonPanel = new javax.swing.JPanel();
                buttonPanel.setSize(new Dimension(100, 350));
                buttonPanel.setPreferredSize(new Dimension(100, 350));
                buttonPanel.setMaximumSize(new Dimension(100, 350));
                buttonPanel.setMinimumSize(new Dimension(100, 250));
                buttonPanel.setOpaque(false);
                GridBagLayout g1 = new GridBagLayout();
                buttonPanel .setLayout(g1);
                GridBagConstraints c1 = new GridBagConstraints();

                //Creation of the Draw button
                draw = new javax.swing.JButton();

                draw.setCursor(new Cursor(Cursor.HAND_CURSOR));
                draw.setIcon(new javax.swing.ImageIcon("images/pencil.jpg"));
                draw.setDisabledIcon(new javax.swing.ImageIcon("images/pencilPressed.jpg"));
                draw.setPressedIcon(new javax.swing.ImageIcon("images/pencilPressed.jpg"));
                draw.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));


                //Creation of the erase button
                erase = new javax.swing.JButton();
                erase.setCursor(new Cursor(Cursor.HAND_CURSOR));
                erase.setIcon(new javax.swing.ImageIcon("images/eraser.jpg"));
                erase.setDisabledIcon(new javax.swing.ImageIcon("images/eraserPressed.jpg"));
                erase.setPressedIcon(new javax.swing.ImageIcon("images/eraserPressed.jpg"));
                erase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                erase.setMaximumSize(new java.awt.Dimension(20, 133));

                //Creation of the new sheet Icon
                newSheet = new javax.swing.JButton();
                newSheet.setPressedIcon(new javax.swing.ImageIcon("images/newSheetPressed.jpg"));
                newSheet.setCursor(new Cursor(Cursor.HAND_CURSOR));
                newSheet.setIcon(new javax.swing.ImageIcon("images/newSheet.jpg")); //
                newSheet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                //Assembling the buttons into the button panel
                c1.gridx=0;
                c1.gridy=0;
                buttonPanel.add(Box.createRigidArea(new Dimension(0,0)), c1);
                c1.gridx=0;
                c1.gridy=1;
                buttonPanel.add(draw, c1);
                c1.gridx=0;
                c1.gridy=2;
                buttonPanel.add(Box.createRigidArea(new Dimension(0,10)), c1);
                c1.gridx=0;
                c1.gridy=3;
                buttonPanel.add(erase, c1);
                c1.gridx=0;
                c1.gridy=4;
                buttonPanel.add(Box.createRigidArea(new Dimension(0,10)), c1);
                c1.gridx=0;
                c1.gridy=5;
                buttonPanel.add(newSheet, c1);
                c1.gridx=0;
                c1.gridy=6;
                buttonPanel.add(Box.createRigidArea(new Dimension(0,15)), c1);

                //Info Panel
                infoPanel = new javax.swing.JPanel();
                infoPanel.setSize(new Dimension(500, 150));
                infoPanel.setPreferredSize(new Dimension(500, 150));
                infoPanel.setMaximumSize(new Dimension(500, 150));
                infoPanel.setMinimumSize(new Dimension(500, 150));
                infoPanel.setOpaque(false);
                GridBagLayout g3 = new GridBagLayout();
                infoPanel .setLayout(g3);
                GridBagConstraints c3 = new GridBagConstraints();

                thisToDraw = new javax.swing.JLabel();
                thisToDraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                thisToDraw.setText("This is what you need to draw:");

                thingToDraw = new javax.swing.JLabel();
                thingToDraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                thingToDraw.setText(thisQuestion);

                timeLeft = new javax.swing.JLabel();
                timeLeft.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                timeLeft.setText("Time left:");

                //Temporary time Label instead of actual counter
                JLabel tempCounter = new JLabel("30");
                tempCounter.setFont(new java.awt.Font("Tahoma", 1, 30));
                tempCounter.setForeground(Color.red);

                timePanel=new JPanel();
                timePanel.setOpaque(false);
                cd = new Countdown(this, timePanel, game,30);
                timePanel.add(cd.toJLabel("30"));


                //Assembling the Info Panel
                c3.gridx=0;
                c3.gridy=0;
                infoPanel.add(Box.createRigidArea(new Dimension(0,0)), c3);
                c3.gridx=1;
                c3.gridy=0;
                infoPanel.add(thisToDraw, c3);
                c3.gridx=2;
                c3.gridy=0;
                infoPanel.add(Box.createRigidArea(new Dimension(75,0)), c3);
                c3.gridx=3;
                c3.gridy=0;
                infoPanel.add(timeLeft, c3);
                c3.gridx=0;
                c3.gridy=1;
                infoPanel.add(Box.createRigidArea(new Dimension(0,0)), c3);
                c3.gridx=1;
                c3.gridy=1;
                c3.anchor = GridBagConstraints.LINE_START;
                infoPanel.add(thingToDraw, c3);
                c3.gridx=3;
                c3.gridy=1;
                c3.anchor = GridBagConstraints.LINE_START;
                infoPanel.add(timePanel, c3);
                c3.gridx=0;
                c3.gridy=1;
                infoPanel.add(Box.createRigidArea(new Dimension(0,50)), c3);

                //Adding the button panel in the main panel
                c2.gridx=0;
                c2.gridy=0;
                subGamePanel.add(Box.createRigidArea(new Dimension(0,10)), c2);
                c2.gridx=0;
                c2.gridy=1;
                subGamePanel.add(buttonPanel, c2);
                c2.gridx=1;
                c2.gridy=1;
                subGamePanel.add(Box.createRigidArea(new Dimension(10,0)), c2);
                c2.gridx=2;
                c2.gridy=1;
                c2.anchor = GridBagConstraints.PAGE_START;
                subGamePanel.add(sketchPanel, c2);

                gamePanel.add( subGamePanel, BorderLayout.PAGE_START);
                gamePanel.add(infoPanel, BorderLayout.CENTER);
                cd.countdown();


                draw.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        draw.setEnabled(false);
                        erase.setEnabled(true);
                        isDrawing=true;
                        isErasing = false;

                    }
                });

                erase.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        draw.setEnabled(true);
                        erase.setEnabled(false);
                        isDrawing=false;
                        isErasing = true;

                    }
                });

                newSheet.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        draw.setEnabled(true);
                        erase.setEnabled(true);
                        isDrawing=false;
                        isErasing = false;

                    }
                });
	}

	public void finishIntro(ActionEvent event){
		gamePanel.removeAll();
		gamePanel.validate();
		gamePanel.revalidate();
		startGame();
	}

    public void removeTimeNumber(){
        timePanel.remove(0);
        timePanel.repaint();

    }

    //**********************************************************************************************
    //Implemented as if the team would win the the time is up!!!!
    //**********************************************************************************************
    @Override
        public void loseMiniGame(String whichGame, final GameBoard dymmyGame, JPanel dummyGamePanel, String message){

    		gamePanel.setLayout(new BorderLayout());
			gamePanel.removeAll();
			gamePanel.revalidate();

    		reply.setText("<html>That's correct!</html");
    		ready.setText("Continue ->");
    		game.history.addEvent("\n" + game.getTeam(game.whichTurn).teamName + " won Sketch mini-game.");
    		gamePanel.add(reply);
    		gamePanel.add(BorderLayout.SOUTH, ready);
    		ready.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    game.hideMiniGame();
                }
            });
    		cd.resetTimer();
        	gamePanel.revalidate();
    }

}
