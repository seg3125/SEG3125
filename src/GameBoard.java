/**
 * @author Jade Cahoon and Philippe St-Germain
 *
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard {	
	static GameBoard gameboard;
	JFrame frame;
	JPanel cards;
	Control control;
	Game game;
	Chat chat;
	GameHistory history;
	Team team; // Only one for now
	IntroOutro introOutro;
	
	static final Color backgroundColor = new Color(83, 223, 0);
	static final Dimension gameSize = new Dimension(900, 600);
	static final Dimension controlPanelSize = new Dimension(150, 500);
	static final Dimension gamePanelSize = new Dimension(500, 500);
	static final Dimension chatPanelSize = new Dimension(250, 500);
	static final Dimension historyPanelSize = new Dimension(900, 100);
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		gameboard = new GameBoard();
		gameboard.createGameBoard();
	}
	
	public void createGameBoard() throws Exception{
		frame = new JFrame();
		frame.getContentPane().setBackground(backgroundColor);			

		/*
		* Creating the Intro and Outro Panel
        */
        introOutro = new IntroOutro(gameboard);
        frame.getContentPane().add(introOutro.mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gameSize);
		frame.setVisible(true);				
	}
	
	public void updateGameBoard(int numSpaces) throws IOException{
		int ini_x = team.getX();
		int ini_y = team.getY();
		int iniSpot = convertBoardMoves(ini_x, ini_y);
		boolean moved = false;
		
		if(ini_x == 1 && ini_y == 1){
			;
		} else {		
			int newSpot = convertBoardMoves(ini_x, ini_y);
			newSpot += numSpaces;
			
			int[] coords = new int[2];
			coords[0] = ini_x;
			coords[1] = ini_y;
			
			int spacesMoved = 0;
			
			if(numSpaces >= 2){
				coords = getNextMiniGame(ini_x, ini_y);
				game.updateSteps(ini_x, ini_y, coords[0], coords[1]);
				team.x_position = coords[0];
				team.y_position = coords[1];
				spacesMoved = convertBoardMoves(coords[0], coords[1]) - iniSpot;
				moved = true;
			} else if(newSpot >= 9){
				// Winner!
				game.updateSteps(ini_x, ini_y, 1, 1);
				team.x_position = 1;
				team.y_position = 1;
				spacesMoved = 9 - iniSpot;
				history.addEvent("\nTeam moved " + numSpaces + " spaces."); 
				history.addEvent("\nTEAM WON!");
			} else {
				coords = convertBoardMoves(newSpot);
				game.updateSteps(ini_x, ini_y, coords[0], coords[1]);
				team.x_position = coords[0];
				team.y_position = coords[1];	
				spacesMoved = convertBoardMoves(coords[0], coords[1]) - iniSpot;
				moved = true;
			}
			
			String miniGame = isMiniGame(coords[0], coords[1]);
			if(!miniGame.equals("FALSE")){
				displayMiniGame(miniGame);
			}
			
			if(moved){
				history.addEvent("\nTeam moved " + spacesMoved + " spaces."); 
			}
		}
	}
	
	public int convertBoardMoves(int i, int j){
		int toReturn = 0;
		String rep = Integer.toString(i);
		rep += Integer.toString(j);
		
		if(rep.equals("22")){
			toReturn = 0;
		} else if(rep.equals("21")){
			toReturn = 1;
		} else if(rep.equals("20")){
			toReturn = 2;
		} else if(rep.equals("10")){
			toReturn = 3;
		} else if(rep.equals("00")){
			toReturn = 4;
		} else if(rep.equals("01")){
			toReturn = 5;
		} else if(rep.equals("02")){
			toReturn = 6;
		} else if(rep.equals("12")){
			toReturn = 7;
		} else if(rep.equals("11")){
			toReturn = 8;
		} 		
		
		return toReturn;
	}
	
	public int[] convertBoardMoves(int i){
		int[] toReturn = new int[2];
		
		switch (i) { 
	        case 0:  toReturn[0] = 2; toReturn[1] = 2; break; 
	        case 1:  toReturn[0] = 2; toReturn[1] = 1; break;
	        case 2:  toReturn[0] = 2; toReturn[1] = 0; break;
	        case 3:  toReturn[0] = 1; toReturn[1] = 0; break;
	        case 4:  toReturn[0] = 0; toReturn[1] = 0; break;
	        case 5:  toReturn[0] = 0; toReturn[1] = 1; break;
	        case 6:  toReturn[0] = 0; toReturn[1] = 2; break;
	        case 7:  toReturn[0] = 1; toReturn[1] = 2; break;
	        case 8:  toReturn[0] = 1; toReturn[1] = 1; break;   
		}
		
		return toReturn;
	}
	
	public String isMiniGame(int x, int y){
		String xy = Integer.toString(x) + Integer.toString(y);
		String toReturn = "FALSE";
		if(xy.equals("20")){
			toReturn = "Trivia";
		} else if(xy.equals("00")){
			toReturn = "Trivia";
		} else if(xy.equals("02")){
			toReturn = "Trivia";
		}
		return toReturn;
	}
	
	public void displayMiniGame(String theGame){
		if(theGame.equals("Sketch")){
			Sketch thisGame = new Sketch(gameboard);
			JPanel thisGameCard = thisGame.getPanel();
			cards.add(thisGameCard, "SKETCH");
			CardLayout cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, "SKETCH");	
		} else {
			Trivia thisGame = new Trivia(gameboard);
			JPanel thisGameCard = thisGame.getPanel();
			cards.add(thisGameCard, "TRIVIA");
			CardLayout cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, "TRIVIA");	
		}
		control.disableDice();
	}
	
	public void hideMiniGame(){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "GAME");	
	}
	
	public int[] getNextMiniGame(int x, int y){
		int[] toReturn = new int[2];
		
		if(x == 2 && y > 0){
			toReturn[0] = 2;
			toReturn[1] = 0;
		} else if(x == 2 && y == 0){
			toReturn[0] = 0;
			toReturn[1] = 0;
		} else if (x == 1 && y == 0){
			toReturn[0] = 0;
			toReturn[1] = 0;
		} else if(x == 0 && y != 2){
			toReturn[0] = 0;
			toReturn[1] = 2;
		} else if(x == 0 && y == 2 || x == 1 && y == 2){
			toReturn[0] = 1;
			toReturn[1] = 1;
		}
		
		return toReturn;
	}
	
	public void showGame() throws IOException{
		frame.getContentPane().removeAll();
		frame.validate();
		
		control = new Control(gameboard);
		game = new Game(gameboard);
		chat = new Chat();		
		
		history = new GameHistory(gameboard);
		
		team = new Team();
		updateGameBoard(0);
		
		cards = new JPanel(new CardLayout());
		cards.setOpaque(false);
		JPanel gameCard = game.gamePanel;
		cards.add(gameCard, "GAME");

		frame.getContentPane().add(BorderLayout.WEST, control.controlPanel);
		frame.getContentPane().add(BorderLayout.CENTER, cards);
		frame.getContentPane().add(BorderLayout.EAST, chat.chatPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, history.historyPanel);
		frame.validate();
	}
	
	public void displayHelp(){}

	@SuppressWarnings("deprecation")
	public void exitGame(){
		JOptionPane pane = new JOptionPane();
		pane.setMessage("Are you sure you want to leave the game?");
		pane.setOptionType(JOptionPane.YES_NO_OPTION);
		JDialog dialog = pane.createDialog(frame, "Are you sure?");
	    dialog.show();
		Object selectedValue = pane.getValue();
		//If there is an array of option buttons:
	    if(selectedValue.equals(JOptionPane.YES_OPTION)){
			frame.getContentPane().removeAll();
			frame.validate();
			introOutro = new IntroOutro(gameboard);
	        frame.getContentPane().add(introOutro.mainPanel);
	        frame.validate();	
	    } else {
	    	;
	    }	
	}

}
