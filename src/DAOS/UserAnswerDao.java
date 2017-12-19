package DAOS;

import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.DBConnection;
import DataBaseHandle.Pair;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
        
        public int countAnswers(int qId, String answer)
        {
            java.sql.Connection conn= DBConnection.getActiveConnection();
		 ResultSet rs = null;
                int n=0; 
	 String s= "select * from UserAnswer where answer= '"+answer
                            +"' and questionId='"+qId+"'";
                    
		PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(s);
                 rs=stmt.executeQuery();
		
		try {
			while  (rs.next())
			{
				n++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                
                
            } catch (SQLException ex) {
                Logger.getLogger(UserAnswerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
		return n;
        }
}
