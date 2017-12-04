package Models;

import java.util.ArrayList;

public class Survey {
	
	private int id ;
	private String description  ;
	private String  name ;
	private boolean suspend ;
	private int userId ;
	ArrayList<Question> questions;
	
	
	
	
	
	
	public Survey() {
		super();
	}
	public Survey(int id, String description, String name, boolean suspend, int userId, ArrayList<Question> questions) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.suspend = suspend;
		this.userId = userId;
		this.questions = questions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSuspend() {
		return suspend;
	}
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	
	
	

}
