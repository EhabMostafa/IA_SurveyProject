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
import javax.servlet.http.HttpSession;

//import com.google.gson.Gson;

import DAOS.SurveyDao;
import Factory.DaosFactory;
import Factory.ModelFactory;
import Templates.TempSurvey;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Survey
 */

@WebServlet({ "/Survey", "/getAllSurvies", "/getSurviesByuserId","/addSurvey","/getSurveyById","/addSurvey1" })
public class Survey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaosFactory daosFactory;
//	final Gson gson = new Gson();
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
			
		if (url.equalsIgnoreCase("/addSurvey"))
		{
			addSurvey(request,response);
			
			
		}

      
        
        if (url.equalsIgnoreCase("/addSurvey1"))
		{
        	
        	System.out.println(request.getParameter("SurveyName"));
			addSurvey1(request,response);
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/addQuestion.jsp");
	            rd.forward(request, response);
//			System.out.println("Done");
			
			
		}


                if (url.equalsIgnoreCase("/Survey"))
		{
                    System.out.println("hiiii");
//                    String s=request.getParameter("id");
//                    System.out.println(s);
			
		}
                if (url.equalsIgnoreCase("/getSurveyById"))
		{
			getSurveyById(request,response);
			
			
		}
	}

private void addSurvey1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		
		Models.Survey s = new Models.Survey();
		s.setName(request.getParameter("SurveyName"));
		s.setDescription(request.getParameter("SurveyDescription"));
		HttpSession session = request.getSession();
		int   id = Integer.parseInt( session.getAttribute("UserID").toString());
		int n=  surveyDao.addNewSurvey1(s, id);
		session .setAttribute("sId", n);
	}

private void addSurvey(HttpServletRequest request,  HttpServletResponse response) {
		// TODO Auto-generated method stub
		Models.Survey survey =(Models.Survey) request.getAttribute("lolo");
	
			
		//setup the survey ;
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		surveyDao.addNewSurvey(survey, survey.getUserId());
		
	}
	private HttpServletRequest getSurviesByuserId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//int  userId=Integer.parseInt( request.getParameter("userId"));
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		HttpSession session = request.getSession();
		int   id = Integer.parseInt( session.getAttribute("UserID").toString());
		ArrayList<TempSurvey> surveys= surveyDao.getSurviesByuserId(id);
		request.setAttribute("own", surveys);
                //result.put("result", "true");
		//result.put("report", surveys);
		
		//String resultInJsonFormat=gson.toJson(result);
		               
                 
		
                
		return request;
		
		
	}
private void getSurveyById(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//                System.out.println(request.getParameter("N")+"hi");
		int id  = Integer.parseInt( request.getParameter("id"));
		SurveyDao surveyDao= daosFactory.getSurveyDao();
		Models. Survey survey= surveyDao.getSurveyById( id);
		
		request.setAttribute("fillSurvey", survey);
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/FillSurvey.jsp");
          try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		 PrintWriter out;
//		try {
//			out = response.getWriter();
//			 
//			  String html="<form action=\"getSurveyById\" class=\"col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item\">"+
//                      "<input type=\"submit\">"+
//                      "<img src=\"Resources/work_1.jpg\" class=\"img-responsive\">"+
//                      "<h3 name=\"N\" class=\"fh5co-work-title\">"+
//                      survey.getName()+
//                      "</h3>"+
//                      "<p>"+survey.getDescription()+"</p>"+
//                      
//                      
//	         "</a>"+
//                      "</form>";
//			  
//			  String q="";
//			  for (int i=0;i<survey.getQuestions().size();i++)
//              {
//				 q+= "<p>"+survey.getQuestions().get(i).getQuestion()+"</p>\n";
//				 
//              }
//			  
//                      out.print(html+"\n"+q);
//                      
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
      
           
                          
		
		
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
                     String html="<form action=\"getSurveyById\" class=\"col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item\">"+
                                 "<input type=\"submit\">"+
                                 "<img src=\"Resources/work_1.jpg\" class=\"img-responsive\">"+
                                 "<h3 name=\"N\" class=\"fh5co-work-title\">"+
                                 surveys.get(i).getName()+
                                 "</h3>"+
                                 "<p>"+surveys.get(i).getDescription()+"</p>"+"<p id=\"SID\" name=\"SID\" style=\"visibility: hidden\">"+surveys.get(i).getId()+"</p>"+
			         "</a>"+
                                 "</form>";
                                 out.print(html);
                                  }
		
                
		return response;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("kjlfhuigydufytscatxdfgcvhjfkb"+  request.getParameter("em"));
	}

}
