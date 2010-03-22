import java.util.*;
import java.util.Timer;
import java.awt.*;

import javax.swing.*;

public class Countdown {
	String currTime;
	JPanel gamePanel;
	
	public Countdown(JPanel gamePanel){
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
		int initialDelay = 1000; // start immediately
		int period = 1000;    // repeat every second
		Timer timer = new Timer();
		TimerTask theCount = new TimerTask() {
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
				}
			}
		};
		timer.scheduleAtFixedRate(theCount, initialDelay, period);
	}
}
