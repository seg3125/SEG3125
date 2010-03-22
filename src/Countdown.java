import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Countdown {
	String currTime;
	JPanel gamePanel;
	
	public Countdown(JPanel gamePanel){
		this.currTime = "30";
		this.gamePanel = gamePanel;
	}
	
	public Countdown(String time){
		this.currTime = time;
	}
	
	public String toString(){
		return this.currTime;
	}
	
	public void countdown(){	
		int initialDelay = 1000; // start after 1 second
		int period = 1000;    // repeat every 1 second
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				gamePanel.remove(3);
				int curr = Integer.parseInt(currTime);
				curr--;
				currTime = Integer.toString(curr);
				gamePanel.add(new JLabel(currTime));
				gamePanel.validate();
			}
		};
		timer.scheduleAtFixedRate(task, initialDelay, period);
	}
}
