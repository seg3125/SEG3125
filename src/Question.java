import javax.swing.ImageIcon;

public class Question {
	String question;
	String correctAnswer;
	String answerB;
	String answerC;
	String type;
	ImageIcon image;
	
	public Question(){
		this.question = "";
		this.correctAnswer = "";
		this.image = new ImageIcon();
	}
	
	public Question(String q, String a, String b, String c, ImageIcon i){
		this.question = q;
		this.correctAnswer = a;
		this.answerB = b;
		this.answerC = c;
		this.image = i;
	}

}
