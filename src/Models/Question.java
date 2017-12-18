package Models;

import java.util.ArrayList;

public class Question {
	
	private int id ;
	private String type ;
	private String question ;

	ArrayList<Answer> answers;
	
	
	
	
	public Question() {
		super();
	}
	public Question(int id, String type, String question, ArrayList<Answer> answers) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
		this.answers = answers;
	}
        public Question(int id, String type, String question) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
	
	

}
