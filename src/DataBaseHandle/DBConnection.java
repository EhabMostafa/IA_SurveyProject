package DataBaseHandle;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;
	private final static String  serveIp="localhost:3306";
	private final static String  DBname="Survey";
	private final static String  userName="root";
	private final static String  password="";
	
	public static Connection getActiveConnection() {
		try {
  		  String url = "jdbc:mysql://"+serveIp+"/"+DBname;
  		  Class.forName("com.mysql.jdbc.Driver");
  		connection= DriverManager.getConnection(url, userName, password);
  		  return connection;
  	}
	catch (Exception e) {
		e.printStackTrace();
	}
  	return null;
	}
	
	
	public static boolean   closeConnection ()
	{
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}