package Servltes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  com.google.gson.Gson;

import DAOS.ReportDao;
import Factory.DaosFactory;
import Factory.ModelFactory;
import Models.*;

/**
 * Servlet implementation class Report
 */
@WebServlet({"/Report","/addReport","/deleteReport","/getReport"})
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaosFactory daosFactory;
	private ModelFactory modelFactory;
	final Gson gson = new Gson();
	Map result= new HashMap<>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
        super();
        daosFactory= new DaosFactory();
        modelFactory= new ModelFactory();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/getReport"))
		{
			response.getWriter().append("Served at: ").append(request.getContextPath());
			getReport(request,response);
		}
	}

	private void getReport(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int  reportId=Integer.parseInt( request.getParameter("reprortId"));
		ReportDao reportDao = daosFactory.getReportDao();
		Models.Report report =reportDao.getReport(reportId);
		result.put("result", "true");
		result.put("report", report);
		
		String resultInJsonFormat=gson.toJson(result);
		try {
			response.getWriter().append(resultInJsonFormat);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/addReport"))
		{
			
			addReport(request,response);
		}
		else if (url.equalsIgnoreCase("/deleteReport"))
		{
			
			deleteReport(request,response);
		}
	}

	private void deleteReport(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int  reportId=Integer.parseInt( request.getParameter("reprortId"));
		ReportDao reportDao = daosFactory.getReportDao();
		reportDao.delelteReport(reportId);
		
	}

	private void addReport(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String report= request.getParameter("report");
		int  surveyId=Integer.parseInt( request.getParameter("surveyId"));
		int  userId= Integer.parseInt(request.getParameter("userId"));
		
		ReportDao reportDao = daosFactory.getReportDao();
		reportDao.addReport(report,surveyId,userId);
		
		result.put("result", "true");
		String resultInJsonFormat=gson.toJson(result);
		try {
			response.getWriter().append(resultInJsonFormat);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
