import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game{
	Step[][] steps;
	JPanel gamePanel;
	GameBoard game;
	
	public Game(GameBoard game){	
		this.game = game;
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		gamePanel.setOpaque(false);
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setMaximumSize(GameBoard.gamePanelSize);
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
			
		steps = setSteps();		
		refreshGame();
	}
	
	public Step[][] setSteps(){
		Step[][] steps = new Step[3][3];
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				Step myStep = new Step(game);
				myStep.label = new JLabel(new ImageIcon(urlAt(i, j)));
				myStep.location = game.convertBoardMoves(i, j);
				myStep.type = game.isMiniGame(i, j);
				steps[i][j] = myStep;
			}			
		}
		
		return steps;
	}
	
	/* 
	 * This method is LARGELY adapted from 
	 * http://forums.sun.com/thread.jspa?threadID=505366
	 */
	public void updateSteps(int oldx, int oldy, int i, int j) throws IOException{
		JLabel theLabel = new JLabel(new ImageIcon(urlAt(oldx, oldy)));
		int theLoc = game.convertBoardMoves(oldx, oldy);
		String theType = game.isMiniGame(oldx, oldy);
		steps[oldx][oldy] = new Step(theLabel, theType, theLoc, game);
		File url = new File(urlAt(i, j));
		BufferedImage im = ImageIO.read(url);
		File url2 = new File("images/token.png");
		BufferedImage im2 = ImageIO.read(url2);
		Graphics2D g = im.createGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawImage(im2, (im.getWidth()-im2.getWidth())/2, (im.getHeight()-im2.getHeight())/2, null);
		g.dispose();	        
		steps[i][j].setLabel(new JLabel(new ImageIcon(im)));
		
		refreshGame();	
	}
	
	public void refreshGame(){
		gamePanel.removeAll();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.gamePanel.add(getSteps(i, j));
			}			
		}
		gamePanel.validate();
	}
	
	public JLabel getSteps(int i, int j){
		return this.steps[i][j].getLabel();
	}
	
	public String urlAt(int i, int j){
		String toReturn = "images/";
		if(i == 0 && j == 0 || i == 0 && j == 2 || i == 2 && j == 0){
			toReturn += "minigame";
		} else if (i == 0 && j == 1){
			toReturn += "right";
		} else if(i == 1 && j == 0){
			toReturn += "up";
		} else if(i == 1 && j == 1){
			toReturn += "finish";
		} else if(i == 1 && j == 2){
			toReturn += "downleft";
		} else if(i == 2 && j == 1){
			toReturn += "left";
		} else if(i == 2 && j == 2){
			toReturn += "start";
		}
		
		toReturn += ".png";
		return toReturn;
	}
	
}
