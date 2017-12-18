package Templates;

public class TempSurvey {

	private  int id ;
	private String Name;
	
	
	public TempSurvey(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	
	
	public TempSurvey() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
