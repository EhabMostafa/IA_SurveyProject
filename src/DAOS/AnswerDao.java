package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.DBConnection;
import DataBaseHandle.Pair;
import Models.Answer;
import Templates.TempSurvey;

public class AnswerDao {
	
	Crud crud ;
	public	AnswerDao()
	{
		crud= new Crud();
	}

	
	public ArrayList<Answer> getAnswersByQuestionId(int questionId)
	{
		ArrayList<Answer>  answers = new ArrayList<>();
		
		
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.AnswerTABLENAME ,DataBaseConstants.AnswerQuestionIdCOLUM ,questionId+"", conn);
		
		try {
			while  (res.next())
			{
				Answer  s =new Answer  
						(res.getInt(DataBaseConstants.AnswerIdCOLU),
						res.getString(DataBaseConstants.AnswerAnswerCOLUM));
				answers.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return answers;
	}

	public void  addNewAnswer (Answer a , int questionId)
	{
		
		
	ArrayList<Pair> values= new ArrayList<>();
		
		values.add(new Pair(DataBaseConstants.AnswerAnswerCOLUM, a.getAnswer()));
		values.add(new Pair(DataBaseConstants.AnswerQuestionIdCOLUM,questionId+""));
		// TODO Auto-generated method stub
		crud.insertRecord(DataBaseConstants.AnswerTABLENAME, values);
		
		
	}
	
	
}
