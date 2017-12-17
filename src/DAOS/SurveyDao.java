package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.DBConnection;
import Models.Survey;
import Templates.TempSurvey;

public class SurveyDao {
	
Crud crud ;
	
	public	SurveyDao()
	{
		crud= new Crud();
	}
	
	public ArrayList<TempSurvey>  getAllSurvies() {
		
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.SurveyTABLENAME, conn);
		ArrayList<TempSurvey> surveys= new ArrayList<>(); 
		try {
			while  (res.next())
			{
				TempSurvey s =new TempSurvey (res.getInt(DataBaseConstants.SurveyIdCOLU),
						res.getString(DataBaseConstants.SurveynameCOLUM));
				surveys.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return surveys;
	}

	public ArrayList<TempSurvey>  getSurviesByuserId(int userId) {
		// TODO Auto-generated method stub
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.SurveyTABLENAME,DataBaseConstants.SurveyuserIdCOLUM,userId+"", conn);
		ArrayList<TempSurvey> surveys= new ArrayList<>(); 
		try {
			while  (res.next())
			{
				TempSurvey s =new TempSurvey (res.getInt(DataBaseConstants.SurveyIdCOLU),
						res.getString(DataBaseConstants.SurveynameCOLUM));
				surveys.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return surveys;
		
	}
	
	
	
	void addNewSurvey(Survey survey)
	{
		
	}
	
	
	
	
		


}
