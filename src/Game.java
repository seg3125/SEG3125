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
	JLabel[][] steps;
	JPanel gamePanel;
	
	public Game(){	
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		gamePanel.setOpaque(false);
		gamePanel.setPreferredSize(GameBoard.gamePanelSize);
		gamePanel.setMaximumSize(GameBoard.gamePanelSize);
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
			
		steps = setSteps();		
		refreshGame();
	}
	
	public JLabel[][] setSteps(){
		JLabel[][] steps = new JLabel[3][3];
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				steps[i][j] = new JLabel(new ImageIcon(urlAt(i, j)));
			}			
		}
		
		return steps;
	}
	
	/* 
	 * This method is LARGELY adapted from 
	 * http://forums.sun.com/thread.jspa?threadID=505366
	 */
	public void updateSteps(int oldx, int oldy, int i, int j) throws IOException{
		steps[oldx][oldy] = new JLabel(new ImageIcon(urlAt(oldx, oldy)));
		File url = new File(urlAt(i, j));
	    BufferedImage im = ImageIO.read(url);
	    File url2 = new File("images/token.png");
	    BufferedImage im2 = ImageIO.read(url2);
	    Graphics2D g = im.createGraphics();
	    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	    g.drawImage(im2, (im.getWidth()-im2.getWidth())/2, (im.getHeight()-im2.getHeight())/2, null);
	    g.dispose();	        
	    JLabel theLabel = new JLabel(new ImageIcon(im));
	    steps[i][j] = theLabel;
	}
	
	public void refreshGame(){
		gamePanel.removeAll();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.gamePanel.add(getSteps(i, j));
			}			
		}
	}
	
	public JLabel getSteps(int i, int j){
		return this.steps[i][j];
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
