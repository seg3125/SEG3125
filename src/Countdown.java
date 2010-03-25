import java.util.*;
import java.util.Timer;
import java.awt.*;

import javax.swing.*;

public class Countdown {
	String currTime;
	JPanel gamePanel;
	Timer timer;
	TimerTask theCount;
	MiniGame mg;
	GameBoard game;
    int size;
	
	public Countdown(MiniGame t, JPanel gamePanel, GameBoard game, int size){
		this.game = game;
		this.mg = t;
		this.currTime = "31";
		this.gamePanel = gamePanel;
        this.size=size;
	}
	
	public Countdown(String time, JPanel gamePanel, GameBoard game){
		this.game = game;
		this.gamePanel = gamePanel;
		this.currTime = time;
	}
	
	public JLabel toJLabel(String curr){
		JLabel toReturn = new JLabel();
		toReturn.setText(curr);
		toReturn.setFont(new Font("Tahoma", 1, size));
		toReturn.setForeground(new Color(234, 0, 55));
		return toReturn;
	}
	
	public void countdown(){	
		int initialDelay = 0; // start immediately
		int period = 1000;    // repeat every second
		timer = new Timer();
		theCount = new TimerTask() {
			public void run() {
				if(Integer.parseInt(currTime) > 0){
					mg.removeTimeNumber();
					int curr = Integer.parseInt(currTime);
					curr--;
					currTime = Integer.toString(curr);
					gamePanel.add(toJLabel(currTime));
					gamePanel.validate();
				} else {
					cancel();
					resetTimer();
					mg.loseMiniGame(mg.gameName, game, gamePanel, "You're out of time!");
				}
			}
		};
		timer.scheduleAtFixedRate(theCount, initialDelay, period);
	}
	
	public void stopCountdown(){
		this.timer.cancel();
	}
	
	public void resetTimer(){
		this.currTime = "31";
	}
}
