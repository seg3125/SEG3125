import javax.swing.JLabel;

public class Step {
	JLabel label;
	String type;
	int location;
	GameBoard game;
	
	public Step(GameBoard game){
		this.game = game;
		this.label = new JLabel();
		this.type = "";
		this.location = -1;
	}
	
	public Step(JLabel label, String type, int location, GameBoard game){
		this.game = game;
		this.label = label;
		this.type = type;
		this.location = location;
	}
	
	public void setLabel(JLabel toSet){
		this.label = toSet;
	}
	
	public JLabel getLabel(){
		return this.label;
	}
	
	
}
