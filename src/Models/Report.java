package Models;

public class Report {
	
	private int id  ;
	private String report ;
	private int surveyId ;
	private int userId  ;
	
	
	
	public Report() {
		super();
	}
	public Report(int id, String report, int surveyId, int userId) {
		super();
		this.id = id;
		this.report = report;
		this.surveyId = surveyId;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
