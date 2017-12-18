package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Constants.DataBaseConstants;
import DataBaseHandle.Crud;
import DataBaseHandle.DBConnection;
import DataBaseHandle.Pair;
import Models.Report;

public class ReportDao {
	Crud crud ;
	
	public	ReportDao()
	{
		crud= new Crud();
	}

	public void addReport(String report, int surveyId, int userId) {
		
		
		
		ArrayList<Pair> values= new ArrayList<>();
		
		values.add(new Pair(DataBaseConstants.REPORTCOLUMREPORT, report));
		values.add(new Pair(DataBaseConstants.REPORTCOLUMsurvey, surveyId+""));
		values.add(new Pair(DataBaseConstants.REPORTCOLUMUSERID,userId+""));
		// TODO Auto-generated method stub
		crud.insertRecord(DataBaseConstants.REPORTTABLENAME, values);
		
	}

	public void delelteReport(int reportId) {
		// TODO Auto-generated method stub
		crud.delete(DataBaseConstants.REPORTTABLENAME, DataBaseConstants.REPORTCOLUMREPORTID, reportId+"");
		
	}

	public Report getReport(int reportId) {
		// TODO Auto-generated method stub
		Connection conn= DBConnection.getActiveConnection();
		ResultSet res= crud.select(DataBaseConstants.REPORTTABLENAME, DataBaseConstants.REPORTCOLUMREPORTID, reportId+"", conn);
		Report report = new Report();
		try {
			if (res.next())
			{
				report.setReport(res.getString(DataBaseConstants.REPORTCOLUMREPORT));
				report.setSurveyId(res.getInt(DataBaseConstants.REPORTCOLUMsurvey));
				report.setId(reportId);
				report.setUserId(res.getInt(DataBaseConstants.REPORTCOLUMUSERID));
				return report;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}

}
