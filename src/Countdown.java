import java.util.*;
import java.util.Timer;
import java.awt.*;

import javax.swing.*;

public class Countdown {
	String currTime;
	JPanel gamePanel;
	Timer timer;
	TimerTask theCount;
	Trivia trivia;
	
	public Countdown(Trivia t, JPanel gamePanel){
		this.trivia = t;
		this.currTime = "31";
		this.gamePanel = gamePanel;
	}
	
	public Countdown(JPanel gamePanel, String time){
		this.gamePanel = gamePanel;
		this.currTime = time;
	}
	
	public JLabel toJLabel(String curr){
		JLabel toReturn = new JLabel();
		toReturn.setText(curr);
		toReturn.setFont(new Font("Tahoma", 1, 150));
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
					gamePanel.remove(3);
					int curr = Integer.parseInt(currTime);
					curr--;
					currTime = Integer.toString(curr);
					gamePanel.add(toJLabel(currTime));
					gamePanel.validate();
				} else {
					cancel();
					trivia.loseMiniGame("You're out of time!");
				}
			}
		};
		timer.scheduleAtFixedRate(theCount, initialDelay, period);
	}
	
	public void stopCountdown(){
		this.timer.cancel();
	}
}
