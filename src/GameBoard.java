/**
 * @author Jade Cahoon and Philippe St-Germain
 *
 */

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class GameBoard {	
	static GameBoard gameboard;
	JFrame frame;
	JPanel cards;
	JPanel helpCard;
	CardLayout cl;
	Control control;
	Game game;
	Chat chat;
	GameHistory history;
	Team teamA; 
	Team teamB;
	String whichTurn;
	IntroOutro introOutro;
	
	static final Color BACKGROUND_COLOR = new Color(83, 223, 0);
	static final Color MINIGAME_COLOR = new Color(222, 250, 112);
	static final Color ANSWER_BUTTON_BACK_COLOR = new Color(152, 0, 35);
	static final Color ANSWER_BUTTON_FORE_COLOR = Color.WHITE;
	
	static final Font ANSWER_BUTTON_FONT = new Font("Tahoma", 1, 14);
	static final Font HEADER_FONT = new Font("Tahoma", 1, 72);
	
	static final Dimension gameSize = new Dimension(900, 600);
	static final Dimension controlPanelSize = new Dimension(150, 500);
	static final Dimension gamePanelSize = new Dimension(500, 500);
	static final Dimension chatPanelSize = new Dimension(250, 500);
	static final Dimension historyPanelSize = new Dimension(900, 100);
	static final Dimension ANSWER_BUTTON_SIZE = new Dimension(150, 50);
	
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
		frame.getContentPane().setBackground(BACKGROUND_COLOR);			

		/*
		* Creating the Intro and Outro Panel
        */
        introOutro = new IntroOutro(gameboard);
        frame.getContentPane().add(introOutro.mainPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(gameSize);
		frame.setVisible(true);				
	}
	
	public void updateGameBoard(Team team, int numSpaces) throws IOException{
		int ini_x = team.getX();
		int ini_y = team.getY();
		int iniSpot = team.currSpot;
		boolean moved = false;
		Team otherTeam;
		if(whichTurn.equals("teamA")){
			otherTeam = teamB;
		} else {
			otherTeam = teamB;
		}
		
		if(iniSpot == 8){
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
				team.x_position = coords[0];
				team.y_position = coords[1];
				game.updateSteps(team, ini_x, ini_y, coords[0], coords[1]);
				game.updateSteps(otherTeam, otherTeam.x_position, otherTeam.y_position, otherTeam.x_position, otherTeam.y_position);
				spacesMoved = convertBoardMoves(coords[0], coords[1]) - iniSpot;
				moved = true;
			} else {
				coords = convertBoardMoves(newSpot);
				team.x_position = coords[0];
				team.y_position = coords[1];	
				game.updateSteps(team, ini_x, ini_y, coords[0], coords[1]);
				game.updateSteps(otherTeam, otherTeam.x_position, otherTeam.y_position, otherTeam.x_position, otherTeam.y_position);
				spacesMoved = convertBoardMoves(coords[0], coords[1]) - iniSpot;
				moved = true;
			}
			
			if(moved){
				history.addEvent("\n" + team.teamName + " moved " + spacesMoved + " space(s)."); 
				team.currSpot += spacesMoved;
			}
			
			if(team.currSpot == 8){
				// Winner!
				team.x_position = 1;
				team.y_position = 1;
				game.updateSteps(team, ini_x, ini_y, 1, 1);
				game.updateSteps(otherTeam, otherTeam.x_position, otherTeam.y_position, otherTeam.x_position, otherTeam.y_position);
				history.addEvent("\n" + team.teamName + " moved " + numSpaces + " spaces."); 
				history.addEvent("\n" + team.teamName + " WON!");
				displayGameWon();
			}
			String miniGame = isMiniGame(coords[0], coords[1]);
			if(!miniGame.equals("FALSE")){
				displayMiniGame(miniGame);
			} else {
				updateCurrTurn();
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
		if(xy.equals("20") || xy.equals("00") || xy.equals("02")){
			String[] games = new String[2];
			games[0] = "Trivia";
			games[1] = "Sketch";
			Random r = new Random();
			int rand = r.nextInt(games.length);
			toReturn = games[rand];
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
			cl = (CardLayout)(cards.getLayout());
		    cl.show(cards, "TRIVIA");	
		}
		control.disableDice();
		control.disableHelp();
	}
	
	public void hideMiniGame(){
		cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "GAME");	
		control.enableDice();
		control.enableHelp();
		updateCurrTurn();
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
		
		teamA = new Team("RED", "Team Red");
		teamB = new Team("BLUE", "Team Blue");
		whichTurn = "teamA"; //teamA goes first
		updateGameBoard(teamA, 0);
		updateGameBoard(teamB, 0);
		
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
	
	public void displayHelp() {
		helpCard = new JPanel();
		Help thisHelp = new Help(gameboard);
		helpCard = thisHelp.helpPanel; 
		
		cards.add(helpCard, "HELP");
		cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "HELP");
		control.disableDice();
	}
	
	public void hideHelp(){
		cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "GAME");	
		control.enableDice();		
	}

	@SuppressWarnings("deprecation")
	public void exitGame(){
		JOptionPane pane = new JOptionPane();
		pane.setMessage("Are you sure you want to leave the game?");
		pane.setOptionType(JOptionPane.YES_NO_OPTION);
		JDialog dialog = pane.createDialog(frame, "Are you sure?");
	    dialog.show();
		Object selectedValue = pane.getValue();
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
	
    public void displayGameWon(){
		JOptionPane pane = new JOptionPane();
		pane.setMessage("You have won this game! \nWould you like to play again?");
		pane.setOptionType(JOptionPane.YES_NO_OPTION);
		JDialog dialog = pane.createDialog(frame, "Congratulations!");
	    dialog.show();
		Object selectedValue = pane.getValue();
	    if(selectedValue.equals(JOptionPane.YES_OPTION)){
			frame.getContentPane().removeAll();
			frame.validate();
			introOutro = new IntroOutro(gameboard);
	        frame.getContentPane().add(introOutro.mainPanel);
	        frame.validate();
	    } else {
	    	/*
	    	 * Redirect the user to the website homepage?
	    	 */
	    }
	}
        
    public void updateCurrTurn(){
    	if(whichTurn.equals("teamA")){
    		whichTurn = "teamB";
    	} else {
    		whichTurn = "teamA";
    	}
    }
    
    public Team getTeam(String team){
    	if(team.equals("teamA")){
    		return teamA;
    	} else {
    		return teamB;
    	}
    }
}
