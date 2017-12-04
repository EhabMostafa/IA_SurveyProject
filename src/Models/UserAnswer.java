package Models;

public class UserAnswer {
	
	private int id  ;
	private String answer ;
	private int userId  ;
	private boolean userNameVisibile;
	
	
	
	
	public UserAnswer() {
		super();
	}
	public UserAnswer(int id, String answer, int userId, boolean userNameVisibile) {
		super();
		this.id = id;
		this.answer = answer;
		this.userId = userId;
		this.userNameVisibile = userNameVisibile;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isUserNameVisibile() {
		return userNameVisibile;
	}
	public void setUserNameVisibile(boolean userNameVisibile) {
		this.userNameVisibile = userNameVisibile;
	}
	
	
	
	

}
