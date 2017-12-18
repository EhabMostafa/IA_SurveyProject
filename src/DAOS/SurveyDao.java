package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.DBConnection;
import DataBaseHandle.Pair;
import Factory.DaosFactory;
import Models.Question;
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
		ResultSet res= crud.select(DataBaseConstants.SurveyTABLENAME,DataBaseConstants.SurveysuspendCOLUM,Integer.toString(0));
		ArrayList<TempSurvey> surveys= new ArrayList<>(); 
		try {
			while  (res.next())
			{
				TempSurvey s =new TempSurvey (res.getInt(DataBaseConstants.SurveyIdCOLU),
						res.getString(DataBaseConstants.SurveynameCOLUM),
                                res.getString(DataBaseConstants.SurveydescriptionCOLU));
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
						res.getString(DataBaseConstants.SurveynameCOLUM),
                                res.getString(DataBaseConstants.SurveydescriptionCOLU));
				surveys.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection();
		return surveys;
		
	}
	
	
	
	public void addNewSurvey(Models.Survey survey,int id )
	{
		ArrayList<Pair> values= new ArrayList<>();
		values.add(new Pair(DataBaseConstants.SurveynameCOLUM, survey.getName()));
		values.add(new Pair(DataBaseConstants.SurveydescriptionCOLU, survey.getDescription()));
		values.add(new Pair(DataBaseConstants.SurveyuserIdCOLUM,id+""));
		values.add(new Pair(DataBaseConstants.SurveysuspendCOLUM,"false"));
		// TODO Auto-generated method stub
		 int surveyId=crud.insertRecord(DataBaseConstants.SurveyTABLENAME, values);
		DaosFactory daosFactory = new DaosFactory();
		QuestionDao questionDao = daosFactory.getQuestionDao();
		
		
		
	// get id 
		
		for (int i = 0; i < survey.getQuestions().size(); i++) {
			questionDao.addQuestion(survey.getQuestions().get(i), surveyId);	
		} 
		
	}

	public Survey getSurveyById(int surveyId)
	{
		Survey survey = new Survey();
		
		
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.SurveyTABLENAME ,DataBaseConstants.SurveyIdCOLU ,surveyId+"", conn);
		
		try {
			if  (res.next())
			{
				if  (res.next())
				{
					
							survey.setDescription( res.getString(DataBaseConstants.SurveydescriptionCOLU));
							survey.setName( res.getString(DataBaseConstants.SurveynameCOLUM));
							survey.setId(surveyId);
					DaosFactory daosFactory = new DaosFactory();
					
					QuestionDao q = daosFactory .getQuestionDao();
					survey.setQuestions(q.getQuestionsBySurveyId(surveyId));
				
			
			}
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection();
		
		return survey ;
	}


}
