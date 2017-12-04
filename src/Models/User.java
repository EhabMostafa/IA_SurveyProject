package Models;

public class User {
	
	
	private String userName ;
	private int id ;
	private String email ;
	private String password ; 
	private String gender ;
	private boolean suspend ;
	
	
	
	
	public User(String userName, int id, String email, String password, String gender, boolean suspend) {
		super();
		this.userName = userName;
		this.id = id;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.suspend = suspend;
	}
	
	
	public User() {
		super();
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isSuspend() {
		return suspend;
	}
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}

	
	
	

}
