/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ehab0
 */
@WebServlet({ "/AddSurveyForm","/ChangePAss","/AddAdmin"})
public class Redirect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= request.getRequestURI().substring(request.getContextPath().length());
		if (url.equalsIgnoreCase("/AddSurveyForm"))
                {  
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/HTML/AddSurvey.html");
                rd.forward(request, response);
 	
		}
                if (url.equalsIgnoreCase("/ChangePAss"))
                {  
                   // System.out.println("hiiiii");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ChangePass.jsp");
                rd.forward(request, response);
 	
		}
                if (url.equalsIgnoreCase("/AddAdmin"))
                {  
                   System.out.println("hiiiii");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAdmin.jsp");
                rd.forward(request, response);
 	
		}
	}
    

}
