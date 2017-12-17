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
import Models.Report;

public class QuestionDao {

	
	Crud crud ;
	public	QuestionDao()
	{
		crud= new Crud();
	}
	
	
	
	public Question getQuestionsBysurvetId(int surveyId)
	{
		Question question= new Question();
		
		
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.QuestionTABLENAME, DataBaseConstants.QuestionsurveyIdCOLUM, surveyId+"", conn);
		
		try {
			if (res.next())
			{
				question.setId(res.getInt(DataBaseConstants.QuestionIdCOLU));
				question.setQuestion(res.getString(DataBaseConstants.QuestionQuestionCOLUM));
				question.setType(res.getString(DataBaseConstants.QuestionTypeCOLUM));
				DaosFactory daosFactory = new DaosFactory();
				AnswerDao answerDao = daosFactory.getAnswerDao();
				question.setAnswers(answerDao.getAnswersByQuestionId(question.getId()));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return question;
	}
	
	public void addQuestion(Question a , int surveyId)
	
	{
		ArrayList<Pair> values= new ArrayList<>();
		
		values.add(new Pair(DataBaseConstants.QuestionQuestionCOLUM, a.getQuestion()));
		values.add(new Pair(DataBaseConstants.QuestionsurveyIdCOLUM,surveyId+""));
		// TODO Auto-generated method stub
		
		
		
		int id=crud.insertRecord(DataBaseConstants.QuestionTABLENAME, values);
		for (int i=0;i < a.getAnswers().size();i++)
		{
			DaosFactory daosFactory = new DaosFactory();
			AnswerDao answerDao = daosFactory.getAnswerDao();
			answerDao.addNewAnswer(a.getAnswers().get(i), id);
		}
		
		
	}
	
	
	
	
	
}
