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
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

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
			response=getAllSurvies(response);
                        
                      
		}
		if (url.equalsIgnoreCase("/getSurviesByuserId"))
		{
                 getSurviesByuserId(request,response);   
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/OwnSurveyPage.jsp");
            rd.forward(request, response);
            
			
		}
	}

	private HttpServletRequest getSurviesByuserId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//int  userId=Integer.parseInt( request.getParameter("userId"));
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		ArrayList<TempSurvey> surveys= surveyDao.getSurviesByuserId(1);
		request.setAttribute("own", surveys);
                //result.put("result", "true");
		//result.put("report", surveys);
		
		//String resultInJsonFormat=gson.toJson(result);
		               
                 
		
                
		return request;
		
		
	}

	private HttpServletResponse getAllSurvies(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		ArrayList<TempSurvey> surveys= surveyDao.getAllSurvies();
		//result.put("result", "true");
		//result.put("report", surveys);
		//String resultInJsonFormat=gson.toJson(result);
                PrintWriter out = response.getWriter();
                 for (int i=0;i<surveys.size();i++){
                     String html="<div class='col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item'>"+
                                 "<a href=''>"+
                                 "<img src='Resources/work_1.jpg' class='img-responsive'>"+
                                 "<h3 class='fh5co-work-title'>"+
                                 surveys.get(i).getName()+
                                 "</h3>"+
                                 "<p>"+surveys.get(i).getDescription()+"</p>"+
			         "</a>"+
                                 "</div>";
                                 out.print(html);
                                  }
		
                
		return response;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}