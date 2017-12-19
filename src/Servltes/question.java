package Servltes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOS.QuestionDao;
import Factory.DaosFactory;
import Models.Answer;
import Models.Question;

/**
 * Servlet implementation class question
 */
@WebServlet({ "/question", "/addMCQ", "/addTF", "/addFree" })
public class question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public question() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/addMCQ"))
		{
			 Question qq = new Question();
             qq.setType("MCQ");
             qq.setQuestion(request.getParameter("Question"));
             ArrayList<Answer> s = new ArrayList<Answer>();  
            s.add(new Answer( request.getParameter("a1"))); 
            s.add(new Answer( request.getParameter("a2")));
            s.add(new Answer( request.getParameter("a3")));
            s.add(new Answer( request.getParameter("a4")));
            qq.setAnswers(s);
             DaosFactory daosFactory = new DaosFactory();
             QuestionDao dao = daosFactory.getQuestionDao();
             HttpSession session = request.getSession();
     		int   id = Integer.parseInt( session.getAttribute("sId").toString());
             dao.addQuestion(qq, id);   
                      
		}
		if (url.equalsIgnoreCase("/addTF"))
		{
			 Question qq = new Question();
             qq.setType("TF");
             qq.setQuestion(request.getParameter("Question"));
             ArrayList<Answer> s = new ArrayList<Answer>();  
             qq.setAnswers(s);
             DaosFactory daosFactory = new DaosFactory();
             QuestionDao dao = daosFactory.getQuestionDao();
             HttpSession session = request.getSession();
     		int   id = Integer.parseInt( session.getAttribute("sId").toString());
             dao.addQuestion(qq, id);
		}
		if (url.equalsIgnoreCase("/addFree"))
		{
                        
			 Question qq = new Question();
             qq.setType("free");
             qq.setQuestion(request.getParameter("Question"));
             ArrayList<Answer> s = new ArrayList<Answer>();  
             qq.setAnswers(s);
             DaosFactory daosFactory = new DaosFactory();
             QuestionDao dao = daosFactory.getQuestionDao();
             HttpSession session = request.getSession();
     		int   id = Integer.parseInt( session.getAttribute("sId").toString());
             dao.addQuestion(qq, id);    
		}
		
		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP/addQuestion.jsp");
           rd.forward(request, response);
		System.out.println("Done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
