package Servltes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOS.UserAnswerDao;
import Factory.DaosFactory;

/**
 * Servlet implementation class UserAnswer
 */
@WebServlet({"/UserAnswer","/addAnswers"})
public class UserAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/addAnswers"))
		{
			
			addAnswers(request,response);
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/FillSurvey.jsp");
	            rd.forward(request, response);
                        
                      
		}
	}

	private void addAnswers(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String a = request.getParameter("answer");
		int qId = Integer.parseInt( request.getParameter("q"));
		HttpSession session = request.getSession();
		int   id = Integer.parseInt( session.getAttribute("UserID").toString());
		DaosFactory daosFactory = new DaosFactory();
		UserAnswerDao answerDao= daosFactory.getUserAnswerDa();
		answerDao.addUserAnswer(a, false, qId, id);
		System.out.println("Donee");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
