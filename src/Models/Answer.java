package Models;

public class Answer {
	private int id  ;
	private String answer ;
	
	
	
	
	
	public Answer() {
		super();
	}
	public Answer(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
