package Servltes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAOS.SurveyDao;
import Factory.DaosFactory;
import Factory.ModelFactory;
import Templates.TempSurvey;

/**
 * Servlet implementation class Survey
 */
@WebServlet({ "/Survey", "/getAllSurvies", "/getSurviesByuserId" })
public class Survey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaosFactory daosFactory;
	final Gson gson = new Gson();
	Map result= new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Survey() {
        super();
        daosFactory= new DaosFactory();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/getAllSurvies"))
		{
			getAllSurvies(response);
		}
		if (url.equalsIgnoreCase("/getSurviesByuserId"))
		{
			getSurviesByuserId(request,response);
			
		}
	}

	private void getSurviesByuserId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int  userId=Integer.parseInt( request.getParameter("userId"));
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		ArrayList<TempSurvey> surveys= surveyDao.getSurviesByuserId(userId);
		result.put("result", "true");
		result.put("report", surveys);
		
		String resultInJsonFormat=gson.toJson(result);
		try {
			response.getWriter().append(resultInJsonFormat);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void getAllSurvies(HttpServletResponse response) {
		// TODO Auto-generated method stub
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		ArrayList<TempSurvey> surveys= surveyDao.getAllSurvies();
		result.put("result", "true");
		result.put("report", surveys);
		
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
		doGet(request, response);
	}

}
