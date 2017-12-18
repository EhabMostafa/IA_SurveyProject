package Templates;

public class TempSurvey {

	private  int id ;
	private String Name;
        private String Description;
	
	
	public TempSurvey(int id, String name,String description) {
		super();
		this.id = id;
		Name = name;
                Description=description;
	}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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
