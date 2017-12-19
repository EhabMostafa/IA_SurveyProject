package DataBaseHandle;

import java.net.Authenticator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.jdbc.Statement;

//Crud crud= new Crud();
//ArrayList<Pair> values= new ArrayList<>();
//values.add(new Pair("UserName", "emam11222"));
//values.add(new Pair("email", "emammahmoud@gmail.com"));
//values.add(new Pair("password", "1234567890"));
//System.out.println(crud.insertRecord("Admin", values));
//System.out.println("ujyhtgrfedsz");
public class Crud {
	
	public int  insertRecord (String tableName , ArrayList<Pair> values )
	{
            
		int n = 0 ;
		String colums= "";
		for (int i = 0; i < values.size(); i++) {
			colums+=values.get(i).key;
			if (i+1!=values.size())
			colums+=",";
		}
		String vals= "";
		for (int i = 0; i < values.size(); i++) {
			vals+="\'"+values.get(i).value+"\'";
			if (i+1!=values.size())
			vals+=",";
		}
		String sqlStatment= "insert into  "+tableName+"("+colums+") values ("+ vals+");";
		Connection con=  DBConnection.getActiveConnection();
		 try {
                     System.out.println("hello  "+  sqlStatment);
			PreparedStatement st=  con.prepareStatement(sqlStatment, Statement.RETURN_GENERATED_KEYS);
			n =st.executeUpdate(); 
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()){
			    n=rs.getInt(1);
			}

			System.out.println("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBConnection.closeConnection();
			return -1 ;
		}
		DBConnection.closeConnection();
		return n ;
	}
/*
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition; 
*/
	public boolean  updateRecord (String tableName , ArrayList<Pair> values , String Left,String Right )
	{
		String sqlStatment= "UPDATE "+tableName+" SET ";
		for (int i = 0; i < values.size(); i++) {
			sqlStatment+=values.get(i).key+" = \'"+values.get(i).value+"\'";
			if (i+1!=values.size())
				sqlStatment+=" , ";
		}
		sqlStatment+=" WHERE "+Left+" = \'"+Right+"\' ; ";
		System.out.println(sqlStatment);
		
		//String sqlStatment= "insert into  "+tableName+"("+colums+") values ("+ vals+");";
		Connection con=  DBConnection.getActiveConnection();
		 try {
			PreparedStatement st=  con.prepareStatement(sqlStatment);
			st.executeUpdate(); 
			System.out.println("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBConnection.closeConnection();
			return false ;
		}
		DBConnection.closeConnection();
		System.out.println("success");
		return true ;
	}
	
	
	
	public int delete(String tableName,String colmName,String colmValue) {
	    Connection conn=DBConnection.getActiveConnection();
	    int status=-1;
		String sql="delete  from "+tableName+" where "+colmName+" = \'"+colmValue+"\' ;";
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			 status=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection();
		return status;
		
	}
	
	public ResultSet select(String tableName) {
            Connection conn=DBConnection.getActiveConnection();
	    ResultSet rs = null;
		String sql="select * from "+tableName+";";
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			 rs=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public ResultSet select(String tableName, Connection conn) {
       
    ResultSet rs = null;
	String sql="select * from "+tableName+";";
	try {
		PreparedStatement stmt=conn.prepareStatement(sql);
		 rs=stmt.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return rs;
	
}
	public ResultSet select(String tableName,String colmName,String colmValue) {
	   Connection conn=DBConnection.getActiveConnection();
	    if (conn== null)
	    	System.out.println("la'aaaaaaaaaaaaaaaaa");
	    ResultSet rs = null;
		String sql="select * from "+tableName+" where "+colmName+" = \'"+colmValue+"\' ;";
		System.out.println(sql);
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			 rs=stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
	public ResultSet select(String tableName,String colmName,String colmValue, Connection conn) {
		 
		    if (conn== null)
		    	System.out.println("la'aaaaaaaaaaaaaaaaa");
		    ResultSet rs = null;
			String sql="select * from "+tableName+" where "+colmName+" = \'"+colmValue+"\' ;";
			System.out.println(sql);
			try {
				PreparedStatement stmt=conn.prepareStatement(sql);
				 rs=stmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
			
		}
	
	public static void main(String[] args) {

		
	}

		
		
	

}
