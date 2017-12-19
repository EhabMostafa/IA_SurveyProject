package DAOS;

import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.Pair;

public class UserAnswerDao {
	Crud crud ;
	public UserAnswerDao()
	{
		crud= new Crud();
	}
	
	
	public void addUserAnswer(String answer,boolean userNameVisibile,int questionId,int UserId )
	{
				ArrayList<Pair> values= new ArrayList<>();
		values.add(new Pair(DataBaseConstants.UserAnswerCOLUManswer, answer));
		values.add(new Pair(DataBaseConstants.UserAnswerCOLUMuserNameVisibile, (userNameVisibile==false) ?"0":"1" +""));
		values.add(new Pair(DataBaseConstants.UserAnswerCOLUMquestionId,questionId+""));
		values.add(new Pair(DataBaseConstants.UserAnswerCOLUMuserId,UserId+""));
		// TODO Auto-generated method stub
		crud.insertRecord(DataBaseConstants.UserAnswerTABLENAME, values);
		
	}
	
}
